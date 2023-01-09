package section1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Code02 {

	static Person1 [] members = new Person1 [100]; // 전역변수에 members의 배열을 정의해주는 것이 중요하고
	static int n = 0;
	
	public static void main(String[] args) {
		
		try {
			Scanner in = new Scanner(new File("input.txt"));
			while(in.hasNext()) {
				String str1 = in.next();
				String str2 = in.next();
				
				members[n] = new Person1(); // Person1 타입의 객체를 만들어줘야한다.
				members[n].name = str1;
				members[n].number = str2;
				n++;
			}
			
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		for (int i =0; i<n; i++)
			System.out.println(members[i].name + " " + members[i].number);

	}

}
