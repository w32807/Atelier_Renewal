package com.atelier.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Criteria {
	// Criteria는 검색의 기준이라는 뜻
    private int pageNum; // 페이지 번호
    private int amount;// 1페이지에 몇개의 데이터를 보여줄 건지
    
    private String type; // 검색타입
    private String keyword; // 키워드
    // 페이지 생성 시, 1페이지에 10개 씩 보여줌
    public Criteria() {this(1, 10);}
    
    public Criteria(int pageNum, int amount) {
    	this.pageNum = pageNum;
    	this.amount = amount;
	}
    // 검색조건 가져오기
    public String[] getTypeArr() {
    	return type == null ? new String[] {} : type.split("");
    }
}
