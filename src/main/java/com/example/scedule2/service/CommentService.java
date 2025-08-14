package com.example.scedule2.service;

import com.example.scedule2.dto.CommentResponseDto;
import com.example.scedule2.dto.CommetRequestDto;
import com.example.scedule2.entity.Comment;
import com.example.scedule2.entity.Day;
import com.example.scedule2.entity.Uesr;
import com.example.scedule2.repository.CommentRepository;
import com.example.scedule2.repository.DaysRepository;
import com.example.scedule2.repository.UesrRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final UesrRepository userRepository;
    private final DaysRepository daysRepository;

    public CommentResponseDto createComment(CommetRequestDto requestDto) {
        Uesr user = userRepository.findById(requestDto.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        Day day = daysRepository.findById(requestDto.getDayId())
                .orElseThrow(() -> new IllegalArgumentException("Day not found"));

        Comment comment = Comment.builder()
                .content(requestDto.getContent())
                .user(user)
                .day(day)
                .build();

        Comment saved = commentRepository.save(comment);
        return toDto(saved);
    }

    public List<CommentResponseDto> getCommentsBySchedule(Long dayId) {
        return commentRepository.findByDayId(dayId)
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public CommentResponseDto updateComment(Long commentId, String newContent) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new IllegalArgumentException("Comment not found"));
        comment.setContent(newContent);
        return toDto(commentRepository.save(comment));
    }

    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }

    private CommentResponseDto toDto(Comment comment) {
        return CommentResponseDto.builder()
                .id(comment.getId())
                .content(comment.getContent())
                .createdDate(comment.getCreatedDate())
                .updatedDate(comment.getUpdatedDate())
                .userId(comment.getUser().getId())
                .dayId(comment.getDay().getId())
                .build();
    }
}
