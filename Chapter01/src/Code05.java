
public class Code05 {

	public static void main(String[] args) {
		// declare the array
		int [] grades; // java에서 배열 선언 방법
		
		// allocate memory for 5 indices
		grades = new int[5]; // 배열의 크기를 지정
		
		// assign some values to the array
		grades[0] = 100;
		grades[1] = 76;
		grades[2] = 92;
		grades[3] = 95;
		grades[4] = 14;
		
		// print out each value
		for (int i = 0; i< grades.length; i++) {
			System.out.println("Grades " + (i+1) + " : " + grades[i]);
		}
	}
}
