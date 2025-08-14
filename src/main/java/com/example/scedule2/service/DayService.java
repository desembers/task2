package com.example.scedule2.service;

import com.example.scedule2.dto.DayRequestDto;
import com.example.scedule2.dto.DayResponseDto;
import com.example.scedule2.entity.Day;
import com.example.scedule2.entity.Uesr;
import com.example.scedule2.repository.DaysRepository;
import com.example.scedule2.repository.UesrRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DayService {
    private final DaysRepository daysRepository;
    private final UesrRepository uesrRepository;

    @Transactional
    //생성하기
    public DayResponseDto create(DayRequestDto dto) {
        Uesr user = uesrRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Day day = Day.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .user(user)
                .build();
        return toDto(daysRepository.save(day));
    }

    //조회
    public List<DayResponseDto> getAll() {
        return daysRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    //수정
    @Transactional
    public DayResponseDto update(Long id, DayRequestDto dto) {
        Day day = daysRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo not found"));

        day = day.builder()
                .id(day.getId())
                .title(dto.getTitle())
                .content(dto.getContent())
                .user(day.getUser())
                .build();

        return toDto(daysRepository.save(day));
    }

    @Transactional
    public void delete(Long id) {
        daysRepository.deleteById(id);
    }

    private DayResponseDto toDto(Day day) {
        return DayResponseDto.builder()
                .id(day.getId())
                .title(day.getTitle())
                .content(day.getContent())
                .username(day.getUser().getUsername())
                .createdDate(day.getCreateDate())
                .updatedDate(day.getUpdateDate())
                .build();
    }

}
