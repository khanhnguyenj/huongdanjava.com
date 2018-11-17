package com.huongdanjava.mockito;

public class Application {

	private Calculation calculation;

	public boolean check(int a, int b) {
		int result = calculation.sub(a, b);

		return result > 0;
	}

	public Calculation getCalculation() {
		return calculation;
	}

	public void setCalculation(Calculation calculation) {
		this.calculation = calculation;
	}

	public static void main(String[] args) {
		Application a = new Application();
		a.setCalculation(new Calculation());

		if (a.check(2, 4)) {
			System.out.println("Positive");
		} else {
			System.out.println("Negative");
		}
	}

}
