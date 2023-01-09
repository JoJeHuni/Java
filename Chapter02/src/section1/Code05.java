package section1;

import java.util.Scanner;

public class Code05 {

	static Polynomial [] polys = new Polynomial [100]; // ★
	static int n = 0;
	
	public static void main(String[] args) {
		
		Scanner kb = new Scanner(System.in);
		while (true) {
			System.out.print("$ ");
			String command = kb.next();
			if (command.equals("create")) {
				char name = kb.next().charAt(0);
				
				polys[n] = new Polynomial(); // ★
				polys[n].name = name;
				polys[n].terms = new Term [100]; // ★
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
					addTerm( polys[index], c, e);
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
					int result = calcPolynomial( polys[index] , x);
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
					printPolynomial(polys[index]);
				}
			}
			else if (command.equals("exit")) {
				break;
			}
			
		}
		
		kb.close();
		
	}

	private static int calcPolynomial(Polynomial p, int x) {
		int result = 0;
		for(int i = 0; i<p.nTerms; i++) {
			result += calcTerm(p.terms[i], x);
		}
		return result;
		
	}

	private static int calcTerm(Term term, int x) {
		
		return (int) (term.coef * Math.pow(x,term.exp));
	}

	private static void printPolynomial(Polynomial p) {
		for (int i = 0; i < p.nTerms; i++) {
			printTerm(p.terms[i]);
			System.out.print(" + ");
		}
		System.out.println();
	}

	private static void printTerm(Term term) {
		System.out.print(term.coef + "x^" + term.exp);
		
	}

	private static void addTerm(Polynomial p, int c, int e) {
		int index = findTerm( p,e);
		if (index != -1) {
			p.terms[index].coef += c; // index번째 계수에 c를 더해주면 된다. 
		}
		else { 
			int i = p.nTerms-1;
			while (i >=0 && p.terms[i].exp < 3) {
				p.terms[i+1] = p.terms[i];
				i--;
			}
			p.terms[i+1] = new Term();
			p.terms[i+1].coef = c;
			p.terms[i+1].exp = e;
			p.nTerms++;
		}
	}

	private static int findTerm(Polynomial p, int e) {
		for( int i = 0; i< p.nTerms && p.terms[i].exp >= e; i++) {
			if(p.terms[i].exp == e)
				return i;
		}
		return -1;
	}

	private static int find(char name) {
		for (int i = 0; i<n; i++) {
			if (polys[i].name == name)
				return i;
		}
		return -1;
	}

}
