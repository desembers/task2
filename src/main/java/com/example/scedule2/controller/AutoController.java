package com.example.scedule2.controller;

import com.example.scedule2.dto.LoginRequestDto;
import com.example.scedule2.dto.SignupRequestDto;
import com.example.scedule2.entity.Uesr;
import com.example.scedule2.service.UesrService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AutoController {

    private final UesrService userService;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody SignupRequestDto dto) {
        userService.signup(dto);
        return ResponseEntity.ok("회원가입 완료");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequestDto dto,
                                        HttpServletRequest request) {
        try {
            Uesr user = userService.login(dto.getEmail(), dto.getPassword());

            HttpSession session = request.getSession(true);
            session.setAttribute("userId", user.getId());

            return ResponseEntity.ok("로그인 성공");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }
}
