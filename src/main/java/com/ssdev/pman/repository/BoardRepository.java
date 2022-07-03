package com.ssdev.pman.repository;

import com.ssdev.pman.dto.response.BoardResponse;
import com.ssdev.pman.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
    @Query("select new com.ssdev.pman.dto.response.BoardResponse(b.id, b.name) from Board b")
    List<BoardResponse> findAllResponse();

    @Query("select new com.ssdev.pman.dto.response.BoardResponse(b.id, b.name) from Board  b where b.id = ?1")
    BoardResponse findBoardByIdResponse(Long id);
}
