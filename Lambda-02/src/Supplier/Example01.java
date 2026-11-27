package Supplier;

import java.util.function.Supplier;

/*
 Supply a fixed circle area (radius = 5).


Create a Supplier<String> that returns your name.


Create a Supplier<Long> that returns current time using:System.currentTimeMillis()


Create a Supplier<Integer> that returns a random number.

 */

import java.util.Random;
public class Example01 {
	public static void main(String[] args) {
		
		Random rand = new Random();

		
		Supplier<Integer> s1 = ()-> 5;
		
		System.out.println(s1.get());
		
		System.out.println("-------------------");
		
		Supplier<String> s2 =()-> "Rohan";
		
		System.out.println(s2.get());
		
		System.out.println("-------------------");
		
		Supplier<Long> s3 =()-> System.currentTimeMillis();
		
		System.out.println(s3.get());
		
		System.out.println("--------------------------");
		
		Supplier<Integer> s4= ()-> rand.nextInt(1000);
		
		System.out.println(s4.get());
		
		
		
	}

}
