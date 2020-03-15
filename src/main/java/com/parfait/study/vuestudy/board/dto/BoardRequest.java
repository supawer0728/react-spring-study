package com.parfait.study.vuestudy.board.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;

public class BoardRequest {
    @Data
    public static class Command {
        public interface Creation{}
        public interface Modification {}

        @NotBlank(groups = {Creation.class, Modification.class})
        private String title;
        @NotBlank(groups = {Creation.class, Modification.class})
        private String content;
        @NotBlank(groups = Creation.class)
        private String writer;
        @NotBlank(groups = Modification.class)
        private String editor;
    }
}
