package Section2;

import java.util.Scanner;

// 입력으로 두 정수 a b를 받아 a의 b승을 계산한다.
// b는 음이 아닌 정수
public class Code14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		int a = kb.nextInt();
		int b = kb.nextInt();
		
		int result = power(a, b);
		
		System.out.println(result);
		
		kb.close();
	}

	static int power(int a, int b) {
		int prod = 1;
		for (int i = 0; i<b; i++) {
			prod = prod * a;
		}
		
		return prod;
	}
}
