import java.util.Scanner; // Scanner를 사용하기 위해
//라이브러리에 포함된 기능들을 사용할 수 있게 해준다.
//이것을 import 해주는 것을 까먹었을 때 일단 코드 작성 후, ctrl + shift + O 를 누르면 자동 추가

public class Code03_1 {

	public static void main(String[] args) {
		int number = 123;
		
		Scanner keyboard = new Scanner(System.in); // 입력받고 싶을 때 Scanner가 필요함
		System.out.print("Please enter an integer: ");
		
		int input = keyboard.nextInt(); //scanf("%d", &input);과 같은 의미
		// next()라면 scanf("%s", ...);과 같다
		
		if(input == number) {
			System.out.println("Numbers match! :-)");
		}
		else {
			System.out.println("Numbers do not match! :-(");
		}
		
		keyboard.close();
	}

}
