package Boutiqaat.utills;

import java.util.Scanner;

public class StringValidation {
public boolean StringVal(String str) {
	str = str.toLowerCase();
	char[] chr = str.toCharArray();
	for(int i=0;i<chr.length;i++)
	{
		char ch=chr[i];
		if(!(ch>='a' && ch<='z'))
		{
			return false;
		}
	}
	return true;
	
	
}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the String value");
		String str = sc.next();
		StringValidation obj =new StringValidation();
		boolean bool =obj.StringVal(str);
		if (!bool) {
			System.out.println("Given String is Invalid");
		}
		else {
			System.out.println("Given String is Vlaid");
		}
		
		

	}

}
