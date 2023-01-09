package Section2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// 2차원 배열에서 소수 찾기
// n*n 개의 음이 아닌 한 자리 정수를 주어준 뒤, 가로 세로 대각선 8방향으로 연속된 숫자를 이어붙여서 만들 수 있는 모든 소수를 찾아서 나열하는 프로그램
// 중복된 수를 출력해도 상관없다.

// code19example.txt에서
// 4*4 배열일 때 
// 3line에 있는 1과, 2line에 있는 8, 1line에 있는 3 대각선으로 183, 381
// 3line에 있는 654, 456 식으로 묶여진다는 뜻
public class Code19 {

	static int n;
	static int [][]grid;
	
	public static void main(String[] args) {
		try {
			Scanner inFile = new Scanner(new File("code19example.txt"));
			n = inFile.nextInt();
			grid = new int[n][n];
			for(int i = 0; i<n; i++) {
				for (int j =0; j<n; j++) {
					grid[i][j] = inFile.nextInt();
				}
			}
			inFile.close();
			
			for(int x = 0; x<n; x++) {
				for (int y =0; y<n; y++) {
					for (int dir = 0; dir<8; dir++) {
						for(int len=1; len<= n; len++) {
							int val = computeValue(x,y,dir,len);
							if(val != -1 && isPrime(val))
								System.out.println(val);
						}
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static int computeValue(int x, int y, int dir, int len) {
		int value = 0;
		//시작위치(x,y)에서 dir 방향으로 i칸 떨어진 자리에 있는 digit을 반환한다. 만약 그런 자리가 존재하지 않으면 -1을 반환한다.
		for(int i = 0; i<len; i++) {
			int digit = getDigit(x,y,dir,i);
			if(digit == -1)
				return -1;
			value = value*10+digit;
		}
		return value;
	}
	
	public static int getDigit(int x, int y, int dir, int k) {
		int newX = x, newY = y;
		switch (dir) {
		// 0은 북쪽, 1은 동북쪽, 2는 동쪽 3은 동남쪽... 7까지 8방향.
		case 0: newY -= k; break;
		case 1: newX += k; newY -= k; break;
		case 2: newX += k; break;
		case 3: newX += k; newY += k; break;
		case 4: newY += k; break;
		case 5: newX -= k; newY += k; break;
		case 6: newX -= k; break;
		case 7: newX -= k; newY -= k; break;
		}
		if (newX < 0 || newX >= n || newY <0 || newY >= n)
			return -1;
		return grid[newX][newY];
	}
	
	public static boolean isPrime(int k) {
		if(k<2)
			return false;
		
		for(int i =2;i*i<=k; i++) {
			if (k % i == 0)
				return false;
		}
		return true;
	}
}
