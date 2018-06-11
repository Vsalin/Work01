package com.example.work1.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.work1.excepion.ResourceNotFoundException;
import com.example.work1.model.MemberModel;
import com.example.work1.repository.MemberRepository;

@RestController
@RequestMapping("/api")
public class MemberController {
	
	static Class<Logger> log = Logger.class;
	@Autowired
	MemberRepository memberRepository;

	// Get
	@GetMapping("/member")
	public @ResponseBody List<MemberModel> getAllMember() {
		return memberRepository.findAll();
	}

	// Create
	@PostMapping("/member")
	public MemberModel createMember(@Valid @RequestBody MemberModel member) {
		return memberRepository.save(member);
	}

	// Get Single member
	@GetMapping("/member/{id}")
	public MemberModel getMemberById(@PathVariable(value ="id") Long id) {
		MemberModel member = memberRepository.findById(id).orElseThrow(
				()-> new ResourceNotFoundException("Member", "id", id)
			);
		

		System.out.println(member.getUsername() +" And "+ member.getPassword());
		
		return memberRepository.findById(id).orElseThrow(
					()-> new ResourceNotFoundException("Member", "id", id)
				);
	}
	// Update
	
	 @PutMapping("/member/{id}") public MemberModel
	 MemberUpdate(@PathVariable(value="id") Long memberId,@Valid @RequestBody MemberModel memberDetails) { 
		 MemberModel member = memberRepository.findById(memberId).orElseThrow(
			 () -> new ResourceNotFoundException("Member", "id", memberId)
				 ); 
	 
	  member.setFirstname(memberDetails.getFirstname());
	  member.setLastname(memberDetails.getLastname());
	  member.setUsername(member.getUsername());
	  member.setPassword(member.getPassword());
	  
	  MemberModel updateMember = memberRepository.save(member);
	 
	  return updateMember;
	  
	  }
	  
	  //Delete 
	 @DeleteMapping("/member/{id}")
	 public ResponseEntity<?> deleteMember(@PathVariable(value="id") Long memberId){ 
		 
	  MemberModel member = memberRepository.findById(memberId).orElseThrow(
				()-> new ResourceNotFoundException("Member", "id", memberId)
			);
	  memberRepository.delete(member);
	  return ResponseEntity.ok().build();
	  }

	 

}
