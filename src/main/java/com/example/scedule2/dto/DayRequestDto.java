package com.example.scedule2.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DayRequestDto {
    @NotBlank(message = "유저명은 필수입니다")
    @Size(max = 10, message = "제목은 10글자 이내로 입력해주세요")
    private String title;
    private String content;
    @NotNull(message = "작성자ID는 필수입니다.")
    private Long userId;;
}
