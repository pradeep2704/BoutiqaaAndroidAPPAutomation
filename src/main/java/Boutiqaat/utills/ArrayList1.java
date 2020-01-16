package Boutiqaat.utills;

import java.util.ArrayList;

public class ArrayList1 {
	public void Test1() {
		ArrayList<String>list = new ArrayList<String>();
		list.add("test");
		list.add("seem");
		list.add("geeta");
		
		System.out.println(list);
		list.remove(1);
		System.out.println(list);
	}
	public void Test2() {
		ArrayList<Integer>list1 = new ArrayList<Integer>();
		list1.add(2);
		list1.add(10);
		list1.add(2);
		
		System.out.println(list1);
		list1.remove(1);
		System.out.println(list1);
		
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList1 ar = new ArrayList1();
		ar.Test1();
		ar.Test2();
		

	}

}
