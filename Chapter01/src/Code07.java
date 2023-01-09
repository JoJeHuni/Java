import java.util.Scanner;

public class Code07 {
	// n개의 정수를 입력받아 순서대로 배열의 저장하고, 모든 정수들을 오른쪽으로 shift.
	// 마지막 정수는 배열의 첫 칸으로 이동시키기
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.print("How many numbers to input? : ");
		int n = kb.nextInt();
		int [] data = new int [n];
		
		for (int i = 0; i<n; i++) {
			System.out.print((i+1) + " : ");
			data[i] = kb.nextInt();
		}
		kb.close();
		
		// 맨 마지막에 넣었던 것을 tmp에 저장해준 뒤
		int tmp = data[n-1];
		for (int i = n-2; i>=0; i--) {
			// n-2 인덱스부터 0번째까지 쭉 오른쪽을 shift
			data[i+1] = data[i];
		}
		//tmp에 저장해놨던 값을 맨 앞자리에 넣어주기
		data[0] = tmp;
		
		for(int i = 0; i<n; i++)
			System.out.println(data[i]);
	}
}
