package com.portfolio.models.member;

import com.portfolio.commons.validators.MobileValidator;
import com.portfolio.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class JoinValidator implements Validator, MobileValidator {

    private final MemberRepository memberRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return JoinForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        /**
         * 1. 아이디 중복 여부
         * 2. 비밀번호 복잡성 체크(알파벳(대문자, 소문자), 숫자, 특수문자)
         * 3. 비밀번호와 비밀번호 확인 일치
         * 4. 휴대전화번호 - 입력된 경우 형식을 체크
         * 5. 휴대전화번호가 입력된 경우 숫자만 추출해서 다시 커맨드객체에 저장
         * 6. 필수 약관 동의 체크
         */

        JoinForm joinForm = (JoinForm) target;
        String userId = joinForm.getUserId();
        String userPw = joinForm.getUserPw();
        String userPwRe = joinForm.getUserPwRe();
        String mobile = joinForm.getMobile();
        boolean[] agrees = joinForm.getAgrees();

        // 1. 아이디 중복 여부
        if(userId != null && !userId.isBlank() && memberRepository.exists(userId)) {
            errors.rejectValue("userId", "Validation.duplicate.userId");
        }

        // 3. 비밀번호와 비밀번호 확인 일치
        if(userPw != null && !userPw.isBlank()
                && userPwRe != null && !userPwRe.isBlank() && !userPw.equals(userPwRe)) {
            errors.rejectValue("userPwRe", "Validation.incorrect.userPwRe");
        }

        // 5. 휴대전화번호가 입력된 경우 숫자만 추출해서 다시 커맨드객체에 저장
        if(mobile != null && !mobile.isBlank()) {
            if(!mobileCheck(mobile)) {
                errors.rejectValue("mobile", "Validation.mobile");
            }

            mobile = mobile.replaceAll("\\D", "");
            joinForm.setMobile(mobile);
        }

        // 6. 필수 약관 동의 체크
        if (agrees != null && agrees.length >0) {
            for(boolean agree : agrees) {
                if(!agree) {
                    errors.reject("Validation.joinForm.agree");
                    break;
                }
            }
        }
    }

}
