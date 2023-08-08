package com.portfolio.models.member;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
public class JoinForm {

    // Validation 의존성에 들어가 있는 애노테이션이며, 검증 부분을 알려줌.

    @NotBlank // 빈칸인지 아닌지 검증
    @Size(min = 6, max = 20) // 최소 6글자 최대 20글자
    private String userId; // 아이디

    @NotBlank // 필수데이터
    @Size(min = 8)
    private String userPw; // 비밀번호

    @NotBlank
    private String userPwRe; // 비밀번호 확인

    @NotBlank
    private String userNm; // 회원명

    @NotBlank
    @Email // 이메일 형식인지 검증
    private String email; // 이메일

    private String mobile; // 휴대폰번호

    private boolean[] agrees; // 약관
}
