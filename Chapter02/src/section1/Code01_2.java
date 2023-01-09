package section1;

public class Code01_2 {

	public static void main(String[] args) {
		
		Person1 first = new Person1(); // Person1도 하나의 타입이 될 수 있다. first는 Person1 클래스의 객체인 것이다.
		
		first.name = "John";
		first.number = "01064895465";
		
		Person1 second = first;
		second.name = "Tom";
		
		Person1 [] members = new Person1 [100]; 
		members[0] = first; 					// 0번째인덱스에 first를 저장
		members[1] = second;
		
		System.out.println("Name: " + members[0].name + ", Number: " + members[0].number);
		System.out.println("Name: " + members[1].name + ", Number: " + members[1].number);
		
		// 클래스 타입의 변수는 보통 변수(변수 자체에 값이 저장되는 변수)가 아닌, "참조 변수이다.(그 객체의 주소를 저장하고 있는 변수)"
		// first의 참조 변수(객체의 주소)가 second의 참조 변수에 저장하기 때문에 동일한 객체를 참조하고 있다는 것이다.
		// 고로 second.name 을 바꾸면 first도 마찬가지로 바뀌는 것이다.
		
		// ★★★ Person1 타입에서 members[2].name = ""; 형태로 바로 저장할 수 없다. ★★★
		// 왜냐하면 members는 배열의 이름이므로 참조 변수이고, 배열의 각 칸은 Person1 타입으로 각 칸도 참조 변수이기 때문에
		// members[2]에는 어느 객체의 주소를 넣어준 적이 없기 때문에 (=참조하고 있지 않다) 고로 nullpointerExcetption 오류가 뜨게 된다.
		// 해결책은 members[2] = new Person1(); 이라는 것으로 새로운 객체를 생성해준 뒤 사용하면 가능하다.
	}

}
