package Section3;
// 강의에서는 sample.txt라고 있는데 난 없어서 일단 코드는 수업들으면서 짰음
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

// txt 파일에 있는 단어에서 특정 단어가 몇 개 있는지 알아보는 코드

public class Code22 {
	
	static String [] words = new String [100000];
	static int [] count = new int [100000]; 		// 단어의 등장 개수
	static int n = 0; 								//단어의 개수를 저장하는 변수
	
	public static void main(String[] args) {
		
		Scanner kb = new Scanner(System.in);
		// 처음에는 while문에서 언제 반복이 끝나는지 모르기 때문에 true로 만들어준다
		while (true) { 
			
			System.out.print("$ ");
			String command = kb.next();
			
			if (command.equals("read")) { //read면 파일 이름을 Scanner 처리 받아야 함
				String fileName = kb.next(); 
				makeIndex(fileName);
			}
			else if (command.equals("find")) {
				String keyword = kb.next();
				int index = findWord(keyword);
				if (index != -1)
					System.out.println("The word " + keyword + " appears " + count[index] + " times");
				else
					System.out.println("The word " + keyword + " doesn't appear.");
			}
			else if (command.equals("saveas")) {
				String fileName = kb.next();
				saveAs(fileName);
			}
			else if (command.equals("exit")) {
				break;
			}
		}
		
		kb.close();
		
		for (int i=0; i<n; i++) {
			System.out.println(words[i] + " " + count[i]);
		}
	}

	static void makeIndex(String fileName) {
		try {
			Scanner inFile = new Scanner(new File(fileName));
			while (inFile.hasNext()) { 		//inFile의 처음부터 끝까지 반복 hasNext가 True일 때까지 반복
				String str = inFile.next();	// str이 처음 나타난건지, 2번째 이상 나타난건지에 따라 저장할지 말지에 대한 함수를 만들면 깔끔해보인다.
				addWord(str); 				// addWord라는 함수를 통해 str을 저장해준다.
			}
			
			inFile.close();
		} catch (FileNotFoundException e) {
			System.out.println("NO File");
			return;
		}
	}
	
	static void addWord(String str) {
		int index = findWord(str); 			// 이미 안에 포함되어있는 단어인지 아닌지 찾는 함수 findWord
		// 만약 단어를 찾지 못한다면 index에 return -1을 이용해 값을 넣어준다.
		if(index != -1) { 					// words[index] == str이면
			count[index]++; 				// count index에 있는 int형을 +1해준다.
		}
		else { // not found
			words[n] = str; 				//words n번째에 str을 넣어주고
			count[n] = 1; 					// n번째 count를 1로 지정해준다.
			n++; 							//다음 자리로 이동
		}
	}
	
	static int findWord(String str) {
		for (int i=0; i<n; i++) {
			if (words[i].equals(str))
				return i;
		}
		return -1;
	}
	
	static void saveAs(String fileName) {
		try {
			PrintWriter out = new PrintWriter(new FileWriter(fileName));
			for (int i=0; i<n; i++) {
				out.println(words[i] + " " + count[i]);
			}
			
			out.close();
		} catch (IOException e) {
			System.out.println("Save failed");
			return;
		}
	}
}
