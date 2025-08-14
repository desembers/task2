package com.example.scedule2.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DayResponseDto {
    private Long id;
    private String title;
    private String content;
    private String username;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}
