import java.util.Scanner;

public class Code03_2 {

	public static void main(String[] args) {
		String str = "Hello world";
		
		String input = null;
		
		Scanner kb = new Scanner(System.in); // 입력받고 싶을 때 Scanner가 필요함
		System.out.print("Please enter an string: ");
		
		input = kb.next();
		
		if(input == str) {
		//if(str.equals(input)) { 로 해야한다.
			System.out.println("Strings match! :-)");
		}
		else {
			System.out.println("Strings do not match! :-(");
		}
		
		kb.close();
	}

}

// str과 같은 문자열(Hello world)을 input 해도 do not match가 뜬다. 왜?
// next() 함수는 공백 기준으로 잘리게 되어 Hello만 입력이 된다.
// 그래서 str을 Hello로 바꾸고 Hello를 하면? -> 또 do no match가 뜬다. 왜?
// string형은 프리미티브 타입이 아니기 때문에 int 와는 달리 ==가 되지 않는다.
// 고로 line 16에서 보이듯이 equals를 사용해줘야 한다.