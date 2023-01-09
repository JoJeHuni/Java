package section2;
// 하나의 다항식을 표현하기 위한 클래스
public class Polynomial2 {
	public char name; 		//다항식의 이름
	public int nTerms = 0;			//다항식을 구성하는 항의 개수
	public Term2 [] terms;	//다항식을 구성하는 항들을 저장할 배열
	
	public void addTerm(int c, int e) {
		int index = findTerm(e);
		if (index != -1) {
			terms[index].coef += c; // index번째 계수에 c를 더해주면 된다. 
		}
		else { 
			int i = nTerms-1;
			while (i >=0 && terms[i].exp < 3) {
				terms[i+1] = terms[i];
				i--;
			}
			terms[i+1] = new Term2();
			terms[i+1].coef = c;
			terms[i+1].exp = e;
			nTerms++;
		}
	}

	public int findTerm(int e) {
		for( int i = 0; i< nTerms && terms[i].exp >= e; i++) {
			if(terms[i].exp == e)
				return i;
		}
		return -1;
	}
	
	public int calcPolynomial(int x) {
		int result = 0;
		for(int i = 0; i<nTerms; i++) {
			result += terms[i].calcTerm(x);
		}
		return result;
		
	}
	
	public void printPolynomial() {
		for (int i = 0; i < nTerms; i++) {
			terms[i].printTerm();
			System.out.print(" + ");
		}
		System.out.println();
	}

}
