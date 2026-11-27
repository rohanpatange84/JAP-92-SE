package p4;

@FunctionalInterface
interface Sayable {

	void SayHello(String name);
}

class Hello implements Sayable {

	@Override
	public void SayHello(String name) {
		System.out.println("Hello Hello "+name);

	}
}

public class App {

	public static void main(String[] args) {

		Hello hello = new Hello();

		hello.SayHello("Ravi");

		Sayable sb = new Hello();

		sb.SayHello("sham");

		Sayable s2 = (String name) -> {
			System.out.println("Welcome " + name);
		};

		System.out.println("---------------");
		s2.SayHello("pawan");

		Sayable s3 = (name1) -> {
			System.out.println("Welcome " + name1);

		};

		System.out.println("---------------------");
		s3.SayHello("Vishal");

		Sayable s4 = n -> {
			System.out.println("Welcome " + n);
		};

		System.out.println("------------------");
		s4.SayHello("Atharv");
	}

}
