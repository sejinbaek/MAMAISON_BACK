package com.shop.furniture.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shop.furniture.dto.Member;
import com.shop.furniture.service.MemberService;

@RestController
@CrossOrigin("http://192.168.0.16:5500/")
public class MemberController {
	@Autowired
	MemberService memberService;
	
	@PostMapping("insertMember")
	public String insertMember(@RequestBody Member m) {
		System.out.println(m);
		try {
			memberService.insertMember(m);
			return "ok";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "존재하는 아이디와 이메일입니다.";
		}
	}
	
	@PostMapping("login")
	public Map<String, String> login(@RequestBody Member m) {
		System.out.println(m);
		Map<String, String> responseMap = new HashMap<>();
		try {
			m = memberService.login(m);
			String name = m.getName();
			if(m != null && name != null && !name.trim().isEmpty()) {
				responseMap.put("name", name);
				responseMap.put("msg", "ok");
			} else {
				responseMap.put("msg", "다시 로그인 해주세요");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			responseMap.put("msg", "다시 로그인 해주세요");
		}
		return responseMap;
	}
}
