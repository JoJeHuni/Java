package Section2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// code17의 코드를 복사해오지만 변수를 전역변수로 바꾸고, bubblesort로 알파벳 순으로 정렬한 뒤 출력하는 코드를 만들어 본다.
// compareTo 라는 함수로 string의 알파벳순 정렬을 알아본다.
public class Code18 {
	
	// main 함수 바깥으로 전역변수로 만들면서 static으로 만들어줘야 한다.
	// 아직 클래스와 객체를 배우기 전이기 때문에 편법이라고 보면 된다.
	static String [] name;
	static String [] number;
	static int n = 0;
	
	public static void main(String[] args) {
		
		name = new String[100];
		number = new String[100];
		
		try {
			Scanner infile = new Scanner( new File("input.txt"));
			
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
		
		bubbleSort();
		
		for(int i = 0; i<n; i++)
			System.out.println(name[i] + ": " + number[i]);
		
	}
	
	static private void bubbleSort() {
		for (int i = n-1; i>0; i--) {
			for (int j =0; j<i; j++ ) {
				
				if(name[j].compareTo(name[j+1]) > 0) { // name 데이터 값은 숫자가 아니기 때문에 string 값은 str1 == str2 으로 쓰면 안 된다는 것을 이용
					// compareTo 의 리턴값이 0보다 크면 name[j+1]이 name[j] 보다 알파벳순으로 더 앞쪽이라는 뜻이다.
					// swap data[j] and data[j+1]
					String tmp = name[j];
					name[j] = name[j+1];
					name[j+1] = tmp;
					
					String tmp2 = number[j];
					number[j] = number[j+1];
					number[j+1] = tmp2;
					
				}
			}
		}
	}
}
