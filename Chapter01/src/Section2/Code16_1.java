package Section2;
// 오름차순 정렬하는걸 함수로 나눠서 코드짜기
import java.util.Scanner;

public class Code16_1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int [] data = new int [n];
		
		for (int i = 0; i<n; i++) {
			data[i] = kb.nextInt();
		}
		kb.close();
		
		bubbleSort(n, data);
		
		System.out.println("Sored data : ");
		for (int i = 0; i<n; i++) {
			System.out.println(data[i]);
		}
	}
	
	static void bubbleSort(int n, int [] array) {
		// i는 뒤에서부터 앞으로 반복하고
		for (int i = n-1; i>0; i--) {
			// j는 앞에서 i까지 반복하면서 맨뒤부터 가장 큰 수를 배정시킨다
			for (int j = 0; j<i; j++){
				if (array[j] > array[j+1]) {
					int tmp = array[j];
					array[j] = array[j+1];
					array[j+1] = tmp;
				}
			}
		}
	}
}
