package com.example.scedule2.repository;

import com.example.scedule2.entity.Day;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DaysRepository extends JpaRepository<Day, Long> {
}
