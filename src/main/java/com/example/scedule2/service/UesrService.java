package com.example.scedule2.service;

import com.example.scedule2.dto.SignupRequestDto;
import com.example.scedule2.dto.UesrResponseDto;
import com.example.scedule2.dto.UesrRquestDto;
import com.example.scedule2.encoder.PasswordEncoder;
import com.example.scedule2.entity.Uesr;
import com.example.scedule2.repository.UesrRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UesrService {
    private final UesrRepository uesrRepository;
    //private final PasswordEncoder passwordEncoder;

    @Transactional
    public UesrResponseDto create(UesrRquestDto requestdto) {
        Uesr user = Uesr.builder()
                .username(requestdto.getName())
                .email(requestdto.getEmail())
                .build();
        return toDto(uesrRepository.save(user));
    }

    public List<UesrResponseDto> getAll() {
        return uesrRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    private UesrResponseDto toDto(Uesr user) {
        return UesrResponseDto.builder()
                .id(user.getId())
                .name(user.getUsername())
                .email(user.getEmail())
                .createdDate(user.getCreatedDate())
                .updatedDate(user.getUpdatedDate())
                .build();
    }

    @Transactional
    public void signup(SignupRequestDto dto) {
        if (uesrRepository.findByEmail(dto.getEmail()).isPresent()) {
            throw new RuntimeException("이미 가입된 이메일 입니다.");
        }

        Uesr user = Uesr.builder()
                .username(dto.getUsername())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .build();
        uesrRepository.save(user);
    }

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    public Uesr login(String email, String password) {
        Uesr user = uesrRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 이메일입니다."));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("이메일 또는 비밀번호가 일치하지 않습니다.");
        }

        return user;
    }
}
