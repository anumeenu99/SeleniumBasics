package Inheritance;

public class Child1 extends Child2 {   //child1-class extends parent-class
	String Dep="ECE";

	public void sample2() {
		System.out.println("Dep = " +Dep);
		System.out.println(Child2.c);
	}

}
