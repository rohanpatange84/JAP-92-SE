package Consumer;

import java.util.function.Consumer;

class Triangle {
	int x;
	int y;
	int z;

	public Triangle() {
		// TODO Auto-generated constructor stub
	}

	public Triangle(int x, int y, int z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

}

/*
 * Print whether a number is even or odd.
 * 
 * 
 * Print multiplication table of a given number.
 * 
 * 
 * Print ASCII value of each character in a string.
 * 
 * 
 * Print sum of digits of a number.
 * 
 * 
 * Print factorial of a number.
 * 
 * 
 * Print whether a triangle is valid (angles sum = 180).
 * 
 */

public class Example01 {
	public static void main(String[] args) {

		Consumer<Integer> c1 = (n) -> {
			if (n % 2 == 0)
				System.out.println("Even");
			else
				System.out.println("Odd");

		};

		c1.accept(5);

		System.out.println("-----------------");

		Consumer<Integer> c2 = (n2) -> {
			for (int i = 1; i <= 10; i++) {
				System.out.println(n2 * 1);
			}
		};

		c2.accept(2);

		System.out.println("------------------");

		Consumer<String> c3 = (str) -> {
			for (int i = 0; i < str.length(); i++) {
				System.out.println(str.charAt(i) + "  " + str.codePointAt(i));
			}
		};

		c3.accept("Ravi");

		System.out.println("--------------------");

		Consumer<Integer> c4 = (num) -> {

			int sum = 0;
			while (num > 0) {
				sum += num % 10;
				num = num / 10;
			}

			System.out.println("Sum of number of is " + sum);

		};

		c4.accept(1234);
		System.out.println("--------------------");

		Consumer<Integer> c5 = (n5) -> {

			int fact = 1;

			for (int i = 1; i <= n5; i++) {
				fact = fact * i;
			}
			System.out.println("Factorial of num is " + fact);

		};

		c5.accept(5);

		System.out.println("---------------------------");

		Triangle t1 = new Triangle(90, 80, 50);

		Consumer<Triangle> c6 = (t) -> {

			int add = t1.getX() + t1.getY() + t1.getZ();

			if (add >= 180)
				System.out.println("Valid Triangle");
			else
				System.out.println("Invalid Triangle");

		};

		c6.accept(t1);

	}
}
