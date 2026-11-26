package p5;

interface Sayable {
	int SayHello(String name);
}

class Hello implements Sayable {

	@Override
	public int SayHello(String name) {

		return name.length();
	}
}

public class App {
	public static void main(String[] args) {

		Sayable s1 = new Hello();

		System.out.println(s1.SayHello("Tony"));
		System.out.println("------------------------");

		Sayable s2 = new Sayable() {

			@Override
			public int SayHello(String name) {

				return name.codePointAt(0);
			}

		};
		
		System.out.println(s2.SayHello("ABCD"));
		
		System.out.println("------------------------");
		
		Sayable s3 = (String name)->{
			return name.codePointAt(1);
		};
		
		System.out.println(s3.SayHello("ABCD"));
		System.out.println("------------------------");
		
		Sayable s4 = (name)->{
			
			return name.codePointAt(2);
		};
		
		System.out.println(s4.SayHello("ABCD"));
		
		System.out.println("------------------------");
		
		Sayable s5 = name ->{
			return name.codePointAt(3);
		};
		
		System.out.println(s5.SayHello("ABCD"));
		System.out.println("------------------------");
		
		Sayable s6 = name-> name.length();
		
		System.out.println(s6.SayHello("Ram"));
		
		
		
		
		
		
		
		
		
		
		
		
		

	}
}