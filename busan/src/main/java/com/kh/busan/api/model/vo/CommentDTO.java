package com.kh.busan.api.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Setter
@Getter
@ToString
@AllArgsConstructor
@Builder
// 원래 VO는 세터가 있을 필요가 없고 DTO에는 setter가 있어도 된다.
// VO에는 toString이랑 hash가 있어야되고
// VO의 극단적으로 서비스 로직이 들어가면 도메인 객체로 불린다(MVC패턴은 아니다)
public class CommentDTO{
	private Long foodNo;
	private String writer;
	private String content;
	
}