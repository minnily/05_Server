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
public class Members {

	private int no; //회원번호
	private String id; //회원아이디
	private String pw; //회원 비밀번호
	private String nickName; // 회원 닉네임
	private String gender; //성별
	private String enrollDate; // 가입일
}
