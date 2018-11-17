package com.huongdanjava.mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ApplicationTest {

	@Mock
	private Calculation calculation;

	@InjectMocks
	private Application application;

	@Test
	public void testCheck() {
		Mockito.when(calculation.sub(2, 12)).thenReturn(-10);

		int a = 2;
		int b = 12;

		boolean c = application.check(a, b);

		assertEquals(false, c);
	}

}