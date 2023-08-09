package com.portfolio.repository;

import com.portfolio.entity.Member;
import com.portfolio.entity.QMember;
import com.portfolio.models.member.JoinForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.Querydsl;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface MemberRepository extends JpaRepository<Member, Long>, QuerydslPredicateExecutor<Member> {

    Member findByUserId(String userId); // 쿼리 메서드

    default boolean exists(String userId) {
        QMember member = QMember.member;

        return exists(member.userId.eq(userId));
    }

}
