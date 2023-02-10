package com.techpeak.your_openion.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateOpinionDto {
    @NotNull(message = "Content should not be null or empty")
    private String content;

}
