import java.util.Scanner;
//0번째 인덱스 ~ n번째 인덱스까지 0개 이상의 연속된 정수들을 더하여 얻을 수 있는 최댓값 구하기
//0~0, 0~1, 0~2 ... 0~n / 1~1, 1~2 ... 1~n ..... 을 전부 더한 값을 구해
//그 중 최댓값을 maxSum에 대입

public class Code10 {

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
		
		int maxSum = 0;
		//0번째 인덱스 ~ n번째 인덱스까지 0개 이상의 연속된 정수들을 더하여 얻을 수 있는 최댓값 구하기
		//0~0, 0~1, 0~2 ... 0~n / 1~1, 1~2 ... 1~n ..... 을 전부 더한 값을 구해
		//그 중 최댓값을 maxSum에 대입
		for (int i = 0; i<n; i++) {
			for (int j = i; j<n; j++) {
				int sum = 0;
				for(int k=i; k<=j; k++) {
					sum+= data[k];
				}
				if(sum > maxSum) {
					maxSum = sum;
				}
			}
			System.out.println("The max sum is" + maxSum);
		}
	}

}
