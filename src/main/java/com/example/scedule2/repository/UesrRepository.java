package com.example.scedule2.repository;

import com.example.scedule2.entity.Uesr;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UesrRepository extends JpaRepository<Uesr, Long> {
    Optional<Uesr> findByEmail(String email);
}
