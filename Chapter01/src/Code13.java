import java.util.Scanner;
// n개의 정수를 입력받고 정수를 하나 입력할 때마다 현재까지 입력된 정수들을 오름차순으로 정렬해 출력한다.
public class Code13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int [] data = new int [n];
		
		for(int i = 0; i<n; i++) {
			int tmp = kb.nextInt();
			int j = i - 1;
			// 1번째는 i가 0이고 j는 -1이므로 바로 data[j+1] = tmp;가 되지만
			// 2번째부터 오름차순으로 바로 자리를 바꿔주면서 출력시킨다.
			while (j>=0 && data[j] > tmp) {
				data[j+1] = data[j];
				j--;
			}
			data [j+1] = tmp;
			
			for(int k =0; k<=i; k++)
				System.out.print(data[k] + " ");
			System.out.println();
		}
		kb.close();
	}

}
