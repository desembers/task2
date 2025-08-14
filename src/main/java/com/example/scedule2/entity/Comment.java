package com.example.scedule2.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
//JPA엔터티 클래스 붙여서 자동 생성일과 자동수정일을 관리하는 에노테이션
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime updatedDate;

    @ManyToOne(fetch = FetchType.LAZY)
    //LAZY (지연 로딩): 이 user 필드를 실제로 사용할 때(comment.getUser() 등)까지
    //DB에서 로딩하지 않음.
    //EAGER (즉시 로딩): Comment 객체를 조회할 때 User도 즉시 함께 로딩.
    //다대일 자연로딩 하도록 지정(N:1)
    //연관된 디테일(Uesr, Secedule등) 실제로 사용할대 까지 DB조회를 미루는 것
    //Comment(다수) : 대상(Uesr)
    @JoinColumn(name = "user_id")
    private Uesr user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Day_id")
    private Day day;


}
