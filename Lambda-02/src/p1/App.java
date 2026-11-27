package p1;

@FunctionalInterface
interface WelcomeMessage {
	void show();
}

@FunctionalInterface
interface SquareOperation {
	int square(int number);
}

@FunctionalInterface
interface AdditionOperation {
	int add(int a, int b);
}

@FunctionalInterface
interface MultiplacationOperation {
	int multiply(int a, int b);
}

public class App {
	public static void main(String[] args) {

		WelcomeMessage wm = () -> {
			System.out.println("Hello Welcone");
		};

		wm.show();
		System.out.println("-----------------");

		SquareOperation so = n -> n * n;

		System.out.println(so.square(5));

		System.out.println("-------------------");

		AdditionOperation ao = (a, b) -> a + b;

		System.out.println(ao.add(5, 6));

		System.out.println("-----------------");

		MultiplacationOperation mo = (x, y) -> x * y;

		System.out.println(mo.multiply(9, 6));

	}

}
