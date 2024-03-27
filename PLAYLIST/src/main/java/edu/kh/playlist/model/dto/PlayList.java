package edu.kh.playlist.model.dto;

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
public class PlayList {

	private int playListNo; //플레이리스트 번호
	private String singer; //가수
	private String playListMusic; // 곡
	private String releaseDate; // 가사
	
}
