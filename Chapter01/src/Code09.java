import java.util.Scanner;

public class Code09 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner kb = new Scanner(System.in);
		// 사용자로부터 정수의 개수 n을 입력받는다. 
		int n = kb.nextInt();
		int [] data = new int [n];
		//이어서 n개의 정수를 입력받아 순서대로 배열에 저장한다.
		for (int i = 0; i<n; i++)
			data[i] = kb.nextInt();
		kb.close();
		
		// 중복된 정수쌍의 개수를 카운트하여 출력하기
		// n=6이고 입력된 정수들이 2,4,2,4,5,2면 중복된 정수쌍은
		//(2,2),(2,2),(2,2),(4,4) 4쌍이다
		int count = 0;
		for(int i =0; i<n-1; i++) {
			for (int j=i+1; j<n; j++) {
				if(data[i] == data[j])
					count++;
			}
		}
		System.out.println(count);
	}

}
