package com.kh.busan.api.model.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.kh.busan.api.model.mapper.CommentMapper;
import com.kh.busan.api.model.vo.CommentDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BusanServiceImpl implements BusanService {
	
	private final CommentMapper mapper;

	@Override
	public String getBusan(int page) {

		String requestUrl = "http://apis.data.go.kr/6260000/FoodService/getFoodKr";
			   requestUrl += "?serviceKey=rLUqNnUbI4GCnrviVkaBCrWotodsN1CKcxmhdtyVLVUggoHUwU%2FGvbjzdi80ODvdq4JpQve26aZub0zA29yezA%3D%3D";
			   requestUrl += "&numOfRows=6";
			   requestUrl += "&pageNo="+page;
			   requestUrl += "&resultType=json";
		URI uri = null;
		
		try {
			uri = new URI(requestUrl);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		
		RestTemplate restTemplate = new RestTemplate();
		String response = restTemplate.getForObject(uri, String.class);
			return response;
		}

	@Override
	public String getBusanDetail(int pk) {
		String requestUrl = "http://apis.data.go.kr/6260000/FoodService/getFoodKr";
			requestUrl += "?serviceKey=rLUqNnUbI4GCnrviVkaBCrWotodsN1CKcxmhdtyVLVUggoHUwU%2FGvbjzdi80ODvdq4JpQve26aZub0zA29yezA%3D%3D";
			requestUrl += "&numOfRows=10";
			requestUrl += "&pageNo="+1;
			requestUrl += "&resultType=json";
			requestUrl += "&UC_SEQ="+pk;
			
	
		URI uri = null;
		
		try {
			uri = new URI(requestUrl);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		
		RestTemplate restTemplate = new RestTemplate();
		String response = restTemplate.getForObject(uri, String.class);
		return response;
	}

	@Override
	public void save(CommentDTO comment) {
		// 유효성 검증을 하지 않았다.
		// comment, writer 컬럼이 NOT NULL인데 빈문자열이 넘어오면
		// 에러 발생
		
		if(comment.getWriter().equals("") || comment.getContent().equals("")) {
			System.out.println("예외가 발생했어야함");
		}
		mapper.save(comment);
		
	}

	@Override
	public List<CommentDTO> getComments(Long foodNo) {

		return mapper.getComment(foodNo);
		
	}

}
