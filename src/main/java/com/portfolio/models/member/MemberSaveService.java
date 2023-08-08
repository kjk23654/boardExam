package com.portfolio.models.member;


import com.portfolio.entity.Member;
import com.portfolio.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.mapping.Join;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * 회원 정보 추가, 수정
 * - 수정은 비밀번호는 값이 있을때만 수정
 */

@Service
@RequiredArgsConstructor
public class MemberSaveService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public void save(JoinForm joinForm) { // 회원 정보를 추가하려면 입력한 값이 있어야함
        Member member = new ModelMapper().map(joinForm, Member.class);
        member.setUserPw(passwordEncoder.encode(joinForm.getUserPw()));

        memberRepository.saveAndFlush(member);
    }
}
