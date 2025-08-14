package com.example.scedule2.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UesrRquestDto {
    @NotBlank(message = "유저명은 필수 입니다.")
    @Size(max=4, message="유저명은 4글자 이내로 작성해주세요.")
    private String name;

    @Email(message = "이메일 형식이 올바르지 않습니다.")
    @NotBlank(message = "이메일은 필수 입니다ㅣ.")
    private String email;

    @NotBlank(message = "비밀번호는 필수 입니다")
    @Size(min=6, message="비밀번호는 최소 6글자 이상입니다.")
    private String password;
}
