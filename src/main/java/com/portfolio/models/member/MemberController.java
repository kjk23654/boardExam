package com.portfolio.models.member;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member") // 공통 경로
@RequiredArgsConstructor // @Autowired 대신 상수로 바로 적용하기 위함
public class MemberController {

    private final MemberSaveService memberSaveService;


    @GetMapping("/join")
    public String join(@ModelAttribute JoinForm joinForm, Model model) {



        return "member/join";
    }

    @PostMapping("/join")
    public String joinPs(@Valid JoinForm joinForm, Errors errors) {
        // @Valid는 jakarta 의존성 안에 들어있는 글로벌 Valiator의 검증을 받음


        if(errors.hasErrors()) {
            return "member/join";
        }

        memberSaveService.save(joinForm);

        return "redirect:/member/join";
    }
}

// 같은 경로를 설정했지만, 다르게 사용됨.
