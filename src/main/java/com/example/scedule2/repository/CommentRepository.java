package com.example.scedule2.repository;

import com.example.scedule2.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CommentRepository extends JpaRepository {
    List<Comment> findByDayId(Long dayId);
}
