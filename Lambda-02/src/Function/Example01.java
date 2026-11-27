package Function;

import java.util.function.Function;

/*
🔹 Function<T,R> (input → output)
Return the last digit of a number.


Return the second-last digit of a number.


Return the first digit of a number.


Return sum of digits of a number.


Return average of digits of a number.


Return reverse of a number.


Return factorial of a number.

 */

public class Example01 {
	public static void main(String[] args) {

		Function<Integer, Integer> f1 = (num) -> {

			num = num / 10;
			return num % 10;
		};

		System.out.println(f1.apply(1235));
		
		System.out.println("------------------------------------");
		
		Function<Integer, Integer> f2= (num) -> {

			while(num>10) {
				num=num/10;
			}
			return num;
		};

		System.out.println(f2.apply(1235));
		System.out.println("------------------------------------");
		
		Function<Integer, Integer> f3= (num) -> {
			int sum=0;
			while(num>10) {
				sum=sum+num%10;
				num=num/10;
			}
			return sum;
		};

		System.out.println("sum "+f3.apply(1235));
		System.out.println("------------------------------------");
		
		Function<Integer, Double> f4= (num) -> {
			int sum=0;
			int cnt=0;
			while(num>10) {
				cnt++;
				sum=sum+num%10;
				num=num/10;
			}
			return (double) (sum/cnt) ;
			
		};

		System.out.println("Average "+f4.apply(1235));
		System.out.println("------------------------------------");
	}

}
