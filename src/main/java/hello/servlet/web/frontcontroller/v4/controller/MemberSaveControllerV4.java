package hello.servlet.web.frontcontroller.v4.controller;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;
import hello.servlet.web.frontcontroller.v4.ControllerV4;

import java.util.Map;

public class MemberSaveControllerV4 implements ControllerV4 {
    private MemberRepository memberRepository = MemberRepository.getInstance();
    @Override
    // 여기 Map<String, Object> model 추가 되고 public ModelView 가 아니라 String
    public String process(Map<String, String> paramMap, Map<String, Object> model){
        String username = paramMap.get("username");
        int age = Integer.parseInt(paramMap.get("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);

        //ModelView mv = new ModelView("save-result");
        //mv.getModel().put("member", member);
        //return mv;

        model.put("member", member);
        return "save-result";
    }
}
