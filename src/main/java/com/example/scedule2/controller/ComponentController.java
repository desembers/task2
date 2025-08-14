//package com.example.scedule2.controller;

import com.example.scedule2.dto.CommentResponseDto;
import com.example.scedule2.dto.CommetRequestDto;
import com.example.scedule2.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

private CommentService commentService;

@PostMapping
public ResponseEntity<CommentResponseDto> create(@RequestBody CommetRequestDto dto) {
    return ResponseEntity.ok(commentService.createComment(dto));
}

@GetMapping("/schedule/{scheduleId}")
public ResponseEntity<List<CommentResponseDto>> getBySchedule(@PathVariable Long scheduleId) {
    return ResponseEntity.ok(commentService.getCommentsBySchedule(scheduleId));
}

@PutMapping("/{commentId}")
public ResponseEntity<CommentResponseDto> update(@PathVariable Long commentId,
                                                 @RequestBody Map<String, String> body) {
    return ResponseEntity.ok(commentService.updateComment(commentId, body.get("content")));
}

@DeleteMapping("/{commentId}")
public ResponseEntity<Void> delete(@PathVariable Long commentId) {
    commentService.deleteComment(commentId);
    return ResponseEntity.noContent().build();
}

void main() {
}


