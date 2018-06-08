package com.example.work1.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.work1.model.MemberModel;
import com.example.work1.repository.MemberRepository;



@RestController
@RequestMapping("/api")
public class MemberController {

	@Autowired
	MemberRepository memberRepository;
	
	//Get
	@GetMapping("/member")
	public @ResponseBody List<MemberModel> getAllMember(){
		return memberRepository.findAll();
	}
	
	//Create
	@PostMapping("/member")
	public  MemberModel createMember (@Valid @RequestBody MemberModel member) {
		return memberRepository.save(member);
	}
	
	//Get Single member
		@GetMapping("/member/{id}")
		public MemberModel getMemberByID(@PathVariable(value="id") Long memberId){
			return memberRepository.findById(memberId);
		}
	
	//Update
	
	
	
}
