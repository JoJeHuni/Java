
public class Code02 {
	
	static int num; //전역변수 (클래스 바깥에는 선언 불가능)
	
	public static void main(String[] args) {
		
		int anotherNum = 5; //지역변수
		num = 2;
		
		System.out.println(num + anotherNum); // 정수형 + 정수형은 2개의 정수의 합
		System.out.println("Num : " + num); // 문자열 + 정수형이므로 문자열을 합치는 것으로 판단
		System.out.println("anontherNum : " + anotherNum);

	}

}
