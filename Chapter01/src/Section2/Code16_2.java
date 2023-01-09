package Section2;
// 오름차순 정렬하는걸 bubblesort와 swap함수로 나눠서 코드짜기
// 코드에는 문제가 없으나 출력창에서 정렬이 안 되는 것을 알 수 있다.
import java.util.Scanner;

public class Code16_2 {
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
					// swap data[j] and data[j+1]
					swap(array[j], array[j+1]);
				}
			}
		}
	}
	
	// 값에 의한 호출에 대해 알아야 한다.
	// bubbleSort 메소드 안에 있는 swap 메서드를 호출하는 순간 data[j]와 data[j+1]의 값이
	// a,b에 복사되는데, 완전히 별개의 변수인 것이다. a,b를 swap해도 data[j], data[j+1]은 변화 X
	static void swap(int a, int b) {
		int tmp = a;
		a = b;
		b = tmp;
	}
	// 그럼 16_1 코드는 왜 되는가? 아직은 배우지 않았다.
	// 배열의 값은 호출된 메서드에서 변경하면 호출한 쪽에서도 변경된다는 것만 알아두자.
}
