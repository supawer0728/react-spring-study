package com.parfait.study.vuestudy.board;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parfait.study.vuestudy.board.domain.Board;
import com.parfait.study.vuestudy.board.domain.BoardRepository;
import com.parfait.study.vuestudy.board.dto.BoardRequest;
import com.parfait.study.vuestudy.board.dto.BoardRequest.Command.Creation;
import com.parfait.study.vuestudy.board.dto.BoardRequest.Command.Modification;
import com.parfait.study.vuestudy.board.service.BoardService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/api/boards")
@RestController
public class BoardController {
    private final BoardService boardService;
    private final BoardRepository boardRepository;

    @GetMapping
    public Page<Board> boards(@PageableDefault Pageable pageable) {
        return boardRepository.findAll(pageable);
    }

    @GetMapping("/{id}")
    public Board board(@PathVariable Long id) {
        return boardRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public Board create(@Validated(Creation.class) BoardRequest.Command command) {
        return boardService.create(command);
    }

    @PutMapping("/{id}")
    @PostMapping
    public Board modify(@PathVariable Long id, @Validated(Modification.class) BoardRequest.Command command) {
        return boardService.modify(id, command);
    }
}
