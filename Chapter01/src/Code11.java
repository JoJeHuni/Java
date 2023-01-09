import java.util.Scanner;
//val값에 따른 배열 속에서 연속되는 인덱스끼리 이어붙인 숫자가 소수인지 아닌지 알아보는 코드
public class Code11 {

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
		
		int maxPrime = 0;
		// i는 0부터 n-1번째까지 반복
		for (int i =0; i<n; i++) {
			// j는 i부터 n-1번째까지 반복
			for (int j=i; j<n; j++) {
				
				int val = 0;
				// k는 i번째부터 j번째까지 반복
				for(int k=i; k<=j;k++)
					val = val * 10 * data[k];
				//val값에 따른 배열 속에서 연속되는 인덱스끼리 이어붙인 숫자가 소수인지 아닌지 알아보는 코드
				// 소수라면 최대 소수는 maxPrime에 대입
				boolean isPrime = true;
				for(int p =2; p<val/2 && isPrime; p++) {
					if (val %p ==0) isPrime = false;
				}
				if(isPrime && val > 1 && val > maxPrime)
					maxPrime = val;
			}
		}
		if(maxPrime >0)
			System.out.println("The max prime number is " + maxPrime);
		else
			System.out.println("No prime number exists.");
	}

}
