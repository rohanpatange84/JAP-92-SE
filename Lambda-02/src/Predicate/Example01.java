package Predicate;

import java.util.function.Predicate;

/*


🔹 Predicate<T> (input → boolean)
Check if a number is prime.


Check if a number is palindrome.


Check if a number is even.


Check if a number is odd.


Check if a year is a leap year.


Check if a character is a vowel.


Check if a character is in the alphabet.


Check if a character is uppercase.



 */

public class Example01 {
	public static void main(String[] args) {

		Predicate<Integer> p1 = (num) -> String.valueOf(num).contains(new StringBuilder(String.valueOf(num)).reverse());

		System.out.println("is Palindrome: " + p1.test(121));
		System.out.println("-------------------------");

		Predicate<Integer> p2 = (num) -> (num % 2 == 0) ? true : false;

		System.out.println("is Even: " + p2.test(121));
		System.out.println("-------------------------");

		Predicate<Integer> p3 = (num) -> (num % 4 == 0) ? true : false;

		System.out.println("is leep year: " + p3.test(2020));
		System.out.println("-------------------------");

		Predicate<Character> p4 = (ch) -> (ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U' || ch == 'a'
				|| ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') ? true : false;

		System.out.println("is vovel : " + p4.test('a'));
		System.out.println("-------------------------");

		Predicate<Character> p5 = (
				ch) -> (String.valueOf(ch).codePointAt(0) >= 65 && String.valueOf(ch).codePointAt(0) <= 90
						|| String.valueOf(ch).codePointAt(0) >= 97 && String.valueOf(ch).codePointAt(0) <= 122) ? true
								: false;

		System.out.println("is alphabet : " + p5.test('!'));
		System.out.println("-------------------------");

		Predicate<Character> p6 = (
				ch) -> (String.valueOf(ch).codePointAt(0) >= 65 && String.valueOf(ch).codePointAt(0) <= 90) ? true
						: false;

		System.out.println("is in uppercase : " + p6.test('A'));
		System.out.println("-------------------------");

		Predicate<Integer> p7 = (num) -> {
			boolean light = true;
			for (int i = 2; i < num/2; i++) {
				if (num % i == 0) {
					light = false;
					break;
				}

			}
			return light;
		};

		System.out.println("is prime_no : " + p7.test(7));
		System.out.println("-------------------------");

	}

}
