package com.portfolio.commons.validators;

public interface PasswordValidator {

    /**
     * 2. 비밀번호 복잡성 체크 - 알파벳 체크
     *
     * @Param password
     * @Param casIncentive
     *              false : 소문자 + 대문자가 반드시 있어야함
     *              true : 대소문자 상관없이 포함되는 패턴
     */

    default boolean alphabetCheck(String password, boolean caseIncentive) {
        if(caseIncentive) { // caseIncentive == true(대소문자 구분없이 체크)
            return password.matches("[a-zA-Z]+");
        }

        // 대문자, 소문자 각각 체크
        return password.matches("[a-z]+") && password.matches("[A-Z]+");
    }

    /**
     * 숫자가 포함되는 패턴
     *
     * @Param password
     *
     */

    default boolean numberCheck(String password) {

        return password.matches("\\d+");
    }

    /**
     * 특수문자가 포함된 패턴인지 체크
     * @Param password
     */
}
