package Section2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// source 폴더와 input.txt 는 같은 위치에 있다
// 데이터 파일을 읽을 때도 Scanner 사용
public class Code17 {
	public static void main(String[] args) {
		
		Scanner infile;
		// File을 Scanner로 불러올 때는 new File("파일이름") 이 필수다.
		// 또는 String Filename = "input.txt"를 정의해준 뒤 파일 이름에 넣어도 된다.
		
		String [] name = new String[100];
		String [] number = new String[100];
		int n = 0;
		
		// 추가로 Java에서는 file not found exception 이라는 예외가 있을 때의 오류를 바로잡아야 한다.
		// 그것을 try catch 예외처리문으로 바로잡은 것이다.
		try {
			infile = new Scanner( new File("input.txt"));
			
			while (infile.hasNext()) { // 파일의 끝에 도달했는지에 따른 while문
				name[n] = infile.next();
				number[n] = infile.next();
				
				n++;
			}
			infile.close();
		} catch (FileNotFoundException e) {
			System.out.println("No File");
			System.exit(0);
		}
		
		for(int i = 0; i<n; i++)
			System.out.println(name[i] + ": " + number[i]);
		
	}
}
