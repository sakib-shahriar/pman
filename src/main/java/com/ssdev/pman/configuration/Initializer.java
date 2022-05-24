package com.ssdev.pman.configuration;

import com.ssdev.pman.service.SystemService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Initializer implements InitializingBean {
    @Autowired
    private SystemService systemService;

    @Override
    public void afterPropertiesSet() throws Exception {
        systemService.initializeUser();
    }
}
