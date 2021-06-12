package com.atelier.utils;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

import com.google.common.base.Joiner;

public class GuavaTests {

	@Test
	public void joinerTest() {
		String cmPhone1 = "     010 ";
		String cmPhone2 = "      1234 ";
		String cmPhone3 = "    5678";
		String result = Joiner.on("-").join(Arrays.asList(cmPhone1.trim(), cmPhone2.trim(), cmPhone3.trim()));
		assertEquals(result, "010-1234-5678");
	}
}
