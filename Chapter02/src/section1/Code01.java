package section1;

public class Code01 {

	public static void main(String[] args) {
		
		Person1 first = new Person1(); // Person1도 하나의 타입이 될 수 있다. first는 Person1 클래스의 객체인 것이다.
		
		first.name = "John";
		first.number = "01064895465";
		
		//테스트
		System.out.println("Name: " + first.name + ", Number: " + first.number);
		
		Person1 [] members = new Person1 [100]; // Person1 타입의 배열도 만들 수 있다.
		members[0] = first; 					// 0번째인덱스에 first를 저장해주고, 1번째 인덱스에는 새로운 Person1을 초기화 시켜준다.
		members[1] = new Person1();
		
		members[1].name = "David";
		members[1].number = "13456489798";
		
		System.out.println("Name: " + members[1].name + ", Number: " + members[1].number);
		
		// 클래스 타입의 변수는 보통 변수(변수 자체에 값이 저장되는 변수)가 아닌, "참조 변수이다.(그 객체의 주소를 저장하고 있는 변수)"
	}

}
