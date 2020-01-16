package Boutiqaat.utills;

import java.io.IOException;
import java.util.Scanner;

public class NameFormate {

	public static void main(String[] args) throws IOException {
		//Scanner sc = new Scanner(System.in);
		byte b[] = new byte[100];
		System.in.read(b);
		String name = new String(b);
		System.out.println("Please enter Name");
		//String str = sc.next();
		//String str1 = new String();
		System.out.print(name.charAt(0));
		int p=0;
		for(int i=1;i<name.length();i++) {
			char ch= name.charAt(i);
			
			if(ch !=' ') 
			{
				System.out.print("."+ name.charAt(i+1));
				p=i+2;
			}
				
			
		}
		for(int j=p;j<name.length();j++)
			System.out.print(name.charAt(j));
				

	}

}
