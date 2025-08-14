package com.example.scedule2.controller;

import com.example.scedule2.dto.DayRequestDto;
import com.example.scedule2.dto.DayResponseDto;
import com.example.scedule2.entity.Day;
import com.example.scedule2.service.DayService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Days")
@RequiredArgsConstructor
public class DaysContoller {

    private final DayService dayService;

    @PostMapping
    public ResponseEntity<DayResponseDto> create(@RequestBody DayRequestDto dto) {
        return ResponseEntity.ok(dayService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<DayResponseDto>> getAll() {
        return ResponseEntity.ok(dayService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<DayResponseDto> update(@PathVariable Long id, @RequestBody DayRequestDto dto) {
        return ResponseEntity.ok(dayService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        dayService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
