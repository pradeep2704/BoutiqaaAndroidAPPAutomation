package Boutiqaat.utills;

import java.io.IOException;

import org.testng.annotations.Test;

public class StringTest {
	
	@Test
	public void stringReverse() throws IOException
	{
		System.out.println("Please enter Name");
		byte[] b = new byte[100];
		System.in.read(b);
		//System.out.println(b);
		String rev ="";
		String name  = new String(b);
		for(int i=name.length()-1; i >= 0; i--)
		{
			rev = rev+name.charAt(i);
		}
		System.out.println(rev);
	}
	
}
