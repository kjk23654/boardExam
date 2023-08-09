package com.portfolio.commons.validators;

public interface MobileValidator {

    default boolean mobileCheck(String mobile) {
        /**
         *
         * 1. 형식의 통일화 - 숫자가 아닌 문자를 전부 제거하여 숫자로
         * 2. 패턴 생성 체크(복잡한 패턴일 때 단순화)
         */

        mobile = mobile.replaceAll("\\D", "");
        // \\D : 숫자만 true로 반환
        String pattern = "^01[016]\\d{3,4}\\d{4}";

        return mobile.matches(pattern);

    }
}
