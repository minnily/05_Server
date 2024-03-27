package edu.kh.members.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class members {

	private int memberNo; //회원번호
	private String memberId; //회원아이디
	private String memberPw; //회원 비밀번호
	private String memberNickname; // 회원 닉네임
	private char gender; //성별
	private String enrollDate; // 가입일
}
