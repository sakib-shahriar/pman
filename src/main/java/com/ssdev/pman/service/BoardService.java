package com.ssdev.pman.service;

import com.ssdev.pman.constant.Entity;
import com.ssdev.pman.dto.response.BoardResponse;
import com.ssdev.pman.entity.Board;
import com.ssdev.pman.execption.ResourceNotFoundException;
import com.ssdev.pman.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    private BoardRepository boardRepository;

    @Autowired
    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public ResponseEntity<List<BoardResponse>> getBoards() {
        return getList(null);
    }

    public ResponseEntity<List<BoardResponse>> getBoard(Long id) {
        return getList(id);
    }

    private ResponseEntity<List<BoardResponse>> getList(Long id) {
        if (id == null) {
            return new ResponseEntity<>(boardRepository.findAllResponse(), HttpStatus.OK);
        }
        BoardResponse response = boardRepository.findBoardByIdResponse(id);
        if (response == null) {
            throw new ResourceNotFoundException(Entity.Board);
        }
        return new ResponseEntity<>(List.of(response), HttpStatus.OK);
    }

    public ResponseEntity<BoardResponse> delete(Long id) {
       BoardResponse boardResponse = boardRepository.findBoardByIdResponse(id);
       if (boardResponse == null) {
           throw new ResourceNotFoundException(Entity.Board);
       }
       boardRepository.deleteById(id);
       return new ResponseEntity<>(boardResponse, HttpStatus.OK);
    }
}
