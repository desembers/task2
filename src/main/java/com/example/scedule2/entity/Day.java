package com.example.scedule2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Day {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY) //기본키
     private Long id;

     @Column(length = 30)
     private String title;

     @Lob
     private String content;

     //만든 날짜
     @CreatedDate
     private LocalDateTime createDate;

     //수정 날짜
     @LastModifiedDate
     private LocalDateTime updateDate;

    //연관관계 매핑
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Uesr user;

    public Day(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
