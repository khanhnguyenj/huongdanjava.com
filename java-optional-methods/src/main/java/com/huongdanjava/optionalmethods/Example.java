package com.huongdanjava.optionalmethods;

import java.util.Optional;

public class Example {

	public Optional<String> findName() {
		// Do something
		return Optional.empty();
	}
	
	public static void main(String[] args) {
		Example e = new Example();
		Optional<Example> opt = Optional.ofNullable(e);
		System.out.println(opt.flatMap(x -> x.findName()).toString());
		
//		String s = new String("Khanh");
//		
//		Optional<String> opt = Optional.ofNullable(s);
//		opt.map(x -> x.trim())
//			.filter(x -> x.contains("K"))
//			.ifPresent(x -> System.out.println("Name: " + x));
		
//		String s = new String("Khanh");
//		
//		Optional<String> opt = Optional.ofNullable(s);
//		opt.ifPresent(x -> System.out.println(x));
		
//		String s = new String("Khanh");
//		
//		Optional<String> opt = Optional.ofNullable(s);
//		System.out.println(opt.isPresent());
	}
}
