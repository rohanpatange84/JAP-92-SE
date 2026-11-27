package p3;

@FunctionalInterface
interface Sayable {

	int sayHello();
}

class Hello implements Sayable {

	@Override
	public int sayHello() {
		System.out.println("Hello Hello");
		return 10;
	}
}

public class App {

	public static void main(String[] args) {

		Sayable s1 = new Hello();

		System.out.println(s1.sayHello());

		Sayable s2 = new Sayable() {
			@Override
			public int sayHello() {
				return 20;
			}
		};
		System.out.println("------------------");

		System.out.println(s2.sayHello());
		System.out.println("------------------");

		Sayable s3 = () -> {
			return 30;
		};

		System.out.println(s3.sayHello());

		Sayable s4 = () -> 40;
		System.out.println("---------------");

		System.out.println(s4.sayHello());
	}

}
