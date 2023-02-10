package com.techpeak.your_openion.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class OpinionDto {
    private Long id;
    private String content;
    private Boolean isOpened;

//    private LocalDate createdAt;
}
