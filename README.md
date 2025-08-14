Entity명세서 
Day 클래스
고유식별자 id
제목(최대30글자)
내용
생성날짜
수정날짜

User 클래스
고유식별자 Id(기본키)
사용자명 (최대100글자)
이메일 (중복금지)
생성날짜
수정날짜 

HTTP 메서드 
Day 컨트롤러 
POSET ->  + /Days  일정확인
GET -> + /Days/id 단건조회
GET -> + /Days 전체조회
UPDATE -> /Days/id 일정단건 수정
DELETE -> /Days/id 일정삭제 

사용언어 : SprongBoot
의존성 주입 (DI) : JPA, 제약조건, 템플릿, 롬복 

다이어그램 앤티티 관계도 표시
연관관계 표시 사용자(User) 댓글(Comment) 표시 
N:1관계 많은댓글(Comment)이 하나의 회원유저(User)표시 
N:1관계 많은댓글(Comment)이 하나의 회원유저(User)표시


<img width="1265" height="1295" alt="image" src="https://github.com/user-attachments/assets/01111e1f-747b-4287-96b8-dbce3c6cc5cf" />
