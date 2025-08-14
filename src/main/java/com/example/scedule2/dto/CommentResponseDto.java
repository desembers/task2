package com.example.scedule2.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentResponseDto {
    private Long id;
    private String content;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private Long userId;
    private Long dayId;
}
