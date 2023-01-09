
public class Code08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1~100000 사이의 모든 소수들을 찾아서 출력하는 프로그램
		for (int n =2; n<=100000; n++) {
			// 2부터 100000까지 1씩 늘리면서 찾기
			boolean isPrime = true;
			for (int i =2; i*i<=n && isPrime; i++) {
				if (n%i==0)
					isPrime = false;
			}
			if(isPrime)
				System.out.println(n);
		}
	}

}
