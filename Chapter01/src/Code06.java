import java.util.Scanner;

public class Code06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		System.out.print("How many numbers to input? : ");
		int n = kb.nextInt();
		int [] data = new int [n];
		
		for (int i = 0; i<n; i++) {
			System.out.print((i+1) + " : ");
			data[i] = kb.nextInt();
		}
		kb.close();
		
		int sum = 0, max = data[0];
		for (int i = 0; i<n; i++ ) {
			sum +=data[i];
			if(data[i] > max) max = data[i];
		}
		
		System.out.println("The sum is "+ sum + " and the maximum is "+ max);
	}

}
