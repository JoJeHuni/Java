package section2;
// section1에서의 코드5를 main에 메소드를 적은 것이 아닌
// 각 Polynomial과 Term 클래스 안에 메소드를 적어서 불러오는 방법으로  만든 것임
import java.util.Scanner;

public class Code06 {

	static Polynomial2 [] polys = new Polynomial2 [100]; // ★
	static int n = 0;
	
	public static void main(String[] args) {
		
		Scanner kb = new Scanner(System.in);
		while (true) {
			System.out.print("$ ");
			String command = kb.next();
			if (command.equals("create")) {
				char name = kb.next().charAt(0);
				
				polys[n] = new Polynomial2(); // ★
				polys[n].name = name;
				polys[n].terms = new Term2 [100]; // ★
				polys[n].nTerms = 0;
				n++;
			}
			else if (command.equals("add")) {		// add f 2 3
				char name = kb.next().charAt(0);
				int index = find(name);
				if (index == -1) {
					System.out.println("No such Polynomial exists.");
				}
				else {
					int c = kb.nextInt();	//게수
					int e = kb.nextInt(); 	//차수
					polys[index].addTerm(c, e);
				}
			}
			else if (command.equals("calc")) {
				char name = kb.next().charAt(0);
				int index = find(name);
				if (index == -1) {
					System.out.println("No such Polynomial exists.");
				}
				else {
					int x = kb.nextInt();
					int result = polys[index].calcPolynomial(x);
					System.out.println(result);
				}
			}
			else if (command.equals("print")) {
				char name = kb.next().charAt(0);
				int index = find(name);
				if (index == -1) {
					System.out.println("No such Polynomial exists.");
				}
				else {
					polys[index].printPolynomial();
				}
			}
			else if (command.equals("exit")) {
				break;
			}
			
		}
		
		kb.close();
		
	}

	private static int find(char name) {
		for (int i = 0; i<n; i++) {
			if (polys[i].name == name)
				return i;
		}
		return -1;
	}

}
