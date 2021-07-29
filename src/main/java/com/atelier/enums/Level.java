package com.atelier.enums;

// 회원 점수를 로그인 할 때마다 1점씩 오른다.
// 각 회원등급에는 점수구간이 있다.
// 회원 점수를 입력받아서, Level객체를 반환한다.
// 회원 dto 쪽에서, 로그인 전의 level과 후의 level을 비교하여 레벨업여부를 체크!
public enum Level {
	BRONZE, SILVER, GOLD, DIAMOND, SUPER
}
