package com.portfolio.entity;

import jakarta.persistence.*;

@Entity // 클래스를 엔티티 클래스로 사용할 때 사용
public class Member {

    @Id @GeneratedValue // 테이블과 달리 엔티티 클래스에는 기본키가 있어야함
    private Long userNo;

    @Column(length = 40, nullable = false, unique = true)
    // 열길이 = 40, 필수데이터, unique 제약 조건 추가
    private String userId;

    @Column(length = 65, nullable = false)
    private String userPw;

    @Column(length = 40, nullable = false)
    private String userNm;

    @Column(length = 100, nullable = false)
    private String email;

    @Column(length = 11)
    private String mobile;

    @Lob // 큰 데이터를 사용할 때
    private String termsAgree;
}
