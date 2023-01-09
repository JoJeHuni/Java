package Section2;
// 1~100000 사이의 소수를 찾아 출력하기
public class Code15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int n = 2; n<=100000; n++) {
			if(isPrime(n))
				System.out.println(n);
		}
	}
	
	static boolean isPrime(int k) {
		if(k<2)
			return false;
		
		for(int i =2;i*i<=k; i++) {
			if (k % i == 0)
				return false;
		}
		return true;
	}

}
