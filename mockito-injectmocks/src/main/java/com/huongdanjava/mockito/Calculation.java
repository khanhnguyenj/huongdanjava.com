package com.huongdanjava.mockito;

import org.springframework.stereotype.Component;

@Component
public class Calculation {

	public int sub(int a, int b) {
		return a - b;
	}

}