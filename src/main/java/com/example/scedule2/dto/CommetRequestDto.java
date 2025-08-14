package com.example.scedule2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommetRequestDto {
      private String content;
      private Long userId;
      private Long dayId;
}
