package com.example.scedule2.controller;

import com.example.scedule2.dto.UesrResponseDto;
import com.example.scedule2.dto.UesrRquestDto;
import com.example.scedule2.entity.Uesr;

import com.example.scedule2.service.UesrService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UesrController {
    private final UesrService uesrService;

    @PostMapping
    public ResponseEntity<UesrResponseDto> create(@RequestBody UesrRquestDto dto) {
        return ResponseEntity.ok(uesrService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<UesrResponseDto>> getAll() {
        return ResponseEntity.ok(uesrService.getAll());
    }

    @PostMapping("/signup")
    public ResponseEntity<UesrResponseDto> signup(@Validated @RequestBody UesrRquestDto dto) {
        return ResponseEntity.ok(uesrService.create(dto));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String email, @RequestParam String password) {
        Uesr user = uesrService.login(email, password);
        return ResponseEntity.ok("로그인 성공: " + user.getUsername());
    }

}
