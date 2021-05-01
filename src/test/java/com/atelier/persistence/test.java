package com.atelier.persistence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

public class test {

	@Test
	public void test() {
		HashMap<String, String> tmpMap = new HashMap<String, String>();
		List<HashMap<String,String>> list = new ArrayList<HashMap<String,String>>();
		for(int i = 0; i < 5; i++) {
			tmpMap.put(i + "번째", String.valueOf(i));
			list.add(tmpMap);
		}
		if(list.get(0).equals(list.get(1)))
			System.out.println("다른 리스트 인덱스인데 Map은 같음");
		System.out.println("List의 길이는 >> " + list.size());
	}
}
