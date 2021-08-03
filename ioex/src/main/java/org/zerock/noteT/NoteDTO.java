package org.zerock.noteT;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public class NoteDTO {

        private Integer no;
        private String who,whom;
        private String content;


}
