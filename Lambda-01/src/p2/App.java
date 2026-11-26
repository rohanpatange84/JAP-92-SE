package p2;

@FunctionalInterface
interface Sayable{
	
	String SayHello();
}

class Hello implements Sayable{
	
	@Override
	public String SayHello(){
		System.out.println("Hello Hello");
		return "its cool";
	}
}


public class App {
	
	public static void main(String[] args) {
		
		Hello hello = new Hello();
		
		System.out.println(hello.SayHello());
		
		Sayable sb = new Hello();
		
		System.out.println(sb.SayHello());
		
		
		Sayable s2 = ()->{
			return "its a nice";
		};
		
	
		System.out.println("---------------");
		System.out.println(s2.SayHello());
	}
	

}
