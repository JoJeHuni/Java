import java.util.Scanner;
// 사용자로 부터 n개의 정수를 입력받아 배열에 넣은 후
// 오름차순으로 정렬하여 출력하는 코드
public class Code12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int [] data = new int [n];
		
		for (int i = 0; i<n; i++) {
			data[i] = kb.nextInt();
		}
		kb.close();
		
		// i는 뒤에서부터 앞으로 반복하고
		for (int i = n-1; i>0; i--) {
			// j는 앞에서 i까지 반복하면서 맨뒤부터 가장 큰 수를 배정시킨다
			for (int j = 0; j<i; j++){
				if (data[j] > data[j+1]) {
					int tmp = data[j];
					data[j] = data[j+1];
					data[j+1] = tmp;
				}
			}
			
		}
		System.out.println("Sored data : ");
		for (int i = 0; i<n; i++) {
			System.out.println(data[i]);
		}
	}

}
