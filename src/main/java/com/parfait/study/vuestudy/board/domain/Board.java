package com.parfait.study.vuestudy.board.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.util.StringUtils;

import com.parfait.study.vuestudy.board.dto.BoardRequest.Command;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "board")
@Entity
public class Board {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String writer;

    @Column(nullable = false)
    private String editor;

    public static Board create(Command request) {
        Board board = new Board();
        board.setContent(request.getContent());
        board.setTitle(request.getTitle());
        board.setWriter(request.getWriter());
        board.setEditor(request.getWriter());
        return board;
    }

    private void setTitle(String title) {
        if (StringUtils.isEmpty(title)) {
            throw new IllegalArgumentException("title is required");
        }
        this.title = title;
    }

    private void setContent(String content) {
        if (StringUtils.isEmpty(content)) {
            throw new IllegalArgumentException(("content is required"));
        }
        this.content = content;
    }

    private void setWriter(String writer) {
        if (StringUtils.isEmpty(writer)) {
            throw new IllegalArgumentException("writer is required");
        }
        this.writer = writer;
    }

    private void setEditor(String editor) {
        if (StringUtils.isEmpty(editor)) {
            throw new IllegalArgumentException("editor is required");
        }
        this.editor = editor;
    }

    public Board modify(Command request) {
        setTitle(request.getTitle());
        setContent(request.getContent());
        setEditor(request.getEditor());
        return this;
    }
}
