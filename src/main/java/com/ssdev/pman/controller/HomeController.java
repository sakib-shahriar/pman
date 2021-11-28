package com.ssdev.pman.controller;

import com.ssdev.pman.authentication.JwtUtil;
import com.ssdev.pman.dto.request.AuthenticationRequest;
import com.ssdev.pman.dto.response.AuthenticationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class HomeController {
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;

    @Autowired
    public HomeController(AuthenticationManager authenticationManager, UserDetailsService userDetailsService, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtUtil = jwtUtil;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Map<String, String> index() {
        Map<String, String> map = new HashMap<>();
        map.put("application", "ok");
        return map;
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> authenticate(@RequestBody AuthenticationRequest request) throws Exception{
        try {
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(request.getUserName(), request.getPassword());
            authenticationManager.authenticate(authenticationToken);
        }
        catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password");
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUserName());
        String jwt = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}
