package exam01;

public class VariableDefineLocation {
	String title = "hello";
	
	public void method1() {
		String title = "hello";
	}
	
	public void method2() {
		System.out.println(title);
	}

	public static void main(String[] args) {
		VariableDefineLocation ls = new VariableDefineLocation();
		ls.method2();
	}
}