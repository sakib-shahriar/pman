package com.ssdev.pman.controller;

import com.ssdev.pman.dto.response.BoardResponse;
import com.ssdev.pman.service.BoardService;
import com.ssdev.pman.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/boards")
public class BoardController {
    private BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<BoardResponse>> list() {
        return boardService.getBoards();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<BoardResponse>> getBoard(@PathVariable Long id) {
        return boardService.getBoard(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<BoardResponse> delete(@PathVariable Long id) {
        return boardService.delete(id);
    }
}
