package section1;
// data.txt 와 정렬이 잘 되었는지 확인해봐라
// data.txt에서 앞 열 2개는 시작점 좌표, 뒷 열 2개는 가로, 세로로 넓이의 크기 오름차순으로 정렬한 것이다.
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Code04 {

	static MyRectangle1 [] rects = new MyRectangle1 [100]; //객체를 만들어주는 것이 중요하다
	static int n = 0; // 사각형의 개수를 받는 n
	
	public static void main(String[] args) {
		
		try {
			Scanner in = new Scanner(new File("data.txt"));
			while (in.hasNext()) {
				rects[n] = new MyRectangle1(); // 이것과
				rects[n].lu = new MyPoint1(); // 이것 2개가 중요하다
				
				int x = in.nextInt();
				int y = in.nextInt();
				int w = in.nextInt();
				int h = in.nextInt();
				
				rects[n].lu.x = x;
				rects[n].lu.y = y;
				rects[n].width = w;
				rects[n].height = h;
				
				n++;
			}
			
			in.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("No data file.");
			System.exit(1);
		}
		
		bubbleSort();
		
		for (int i=0; i<n; i++) {
			System.out.println(rects[i].lu.x + " " + rects[i].lu.y + " " + rects[i].width + " " + rects[i].height);
		}
	}

	
	private static void bubbleSort() {
		for(int i=n-1; i>0; i--) {
			for (int j=0; j<i; j++) {
				if (calcArea(rects[j]) > calcArea(rects[j+1])) {
					MyRectangle1 tmp = rects[j];
					rects[j] = rects[j+1];
					rects[j+1] = tmp;
				}
			}
		}
	}
	
	public static int calcArea( MyRectangle1 r) {
		return r.width * r.height;
	}
}
