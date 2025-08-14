package com.example.scedule2.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UesrResponseDto {
    private Long id;
    private String name;
    private String email;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}
