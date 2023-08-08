package com.portfolio.entity;


import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter @Setter
@MappedSuperclass // 공통 속성으로 사용할 상위 클래스임을 알려주는 애노테이션
@EntityListeners(AuditingEntityListener.class) // 상태변화를 감지하는 역할
public class BaseEntity { // 공통 속성으로 사용할 멤버

    @CreatedDate // @CreationTimestamp와 달리 상태변화를 감지하여 추가된 시간을 자동 저장
    @Column(updatable = false) // 수정 불가능
    private LocalDateTime createdAt;

    @LastModifiedDate // @UpdateTimestamp와 달리 상태변화를 감지하여 수정된 시간 자동 저장
    @Column(insertable = false) // 추가 불가능
    private LocalDateTime modifiedAt;
}
