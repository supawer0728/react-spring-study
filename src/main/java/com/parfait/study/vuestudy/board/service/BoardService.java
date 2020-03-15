package com.parfait.study.vuestudy.board.service;

import org.springframework.stereotype.Service;

import com.parfait.study.vuestudy.board.domain.Board;
import com.parfait.study.vuestudy.board.domain.BoardRepository;
import com.parfait.study.vuestudy.board.dto.BoardRequest.Command;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;
    public Board create(Command request) {
        Board board = Board.create(request);
        return boardRepository.save(board);
    }

    public Board modify(Long id, Command command) {
        return boardRepository.findById(id)
                              .map(board -> board.modify(command))
                              .orElseThrow();
    }
}
