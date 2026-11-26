package p3;

@FunctionalInterface
interface Sayable {

	int SayHello();
}

class Hello implements Sayable {

	@Override
	public int SayHello() {
		System.out.println("Hello Hello");
		return 45;
	}
}

public class App {

	public static void main(String[] args) {

		Hello hello = new Hello();

		System.out.println(hello.SayHello());

		Sayable sb = new Hello();

		System.out.println(sb.SayHello());

		Sayable s2 = () -> {
			return 78;
		};

		System.out.println("---------------");
		System.out.println(s2.SayHello());
	}

}
