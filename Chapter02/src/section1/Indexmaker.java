package section1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Indexmaker {

	//static String [] words = new String [100000];
	//static int [] count = new int [100000];
	static Item [] items = new Item [100000];		
	static int n = 0; 								
	
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
					System.out.println("The word " + items[index].word + " appears " + items[index].count + " times");
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
			System.out.println(items[i].word + " " +  items[i].count);
		}
	}

	static void makeIndex(String fileName) {
		try {
			Scanner inFile = new Scanner(new File(fileName));
			while (inFile.hasNext()) { 		//inFile의 처음부터 끝까지 반복 hasNext가 True일 때까지 반복
				String str = inFile.next();	// str이 처음 나타난건지, 2번째 이상 나타난건지에 따라 저장할지 말지에 대한 함수를 만들면 깔끔해보인다.
				
				String trimmed = trimming(str);
				if(trimmed != null)
					addWord(str);
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
		
		if(index != -1) { 					// words[index] == str이면 (= 이미 존재한다면)
			items[index].count++; 				// count index에 있는 int형을 +1해준다.
		}
		else { // not found
			int i = n-1;
			for (i=n-1; i>=0 && items[i].word.compareToIgnoreCase(str)>0; i--) {
				items[i+1] = items[i];
				//words[i+1] = words[i];
				//count[i+1] = count[i];
				i--;
			}
			items[i+1] = new Item();
			items[i+1].word = str; 				//words n번째에 str을 넣어주고
			items[i+1].count = 1; 					// n번째 count를 1로 지정해준다.
			n++; 							//다음 자리로 이동
		}
	}
	
	static int findWord(String str) {
		for (int i=0; i<n; i++) {
			if (items[i].word.equals(str))
				return i;
		}
		return -1;
	}
	
	static void saveAs(String fileName) {
		try {
			PrintWriter out = new PrintWriter(new FileWriter(fileName));
			for (int i=0; i<n; i++) {
				out.println(items[i].word + " " +  items[i].count);
			}
			
			out.close();
		} catch (IOException e) {
			System.out.println("Save failed");
			return;
		}
	}
	
	static String trimming(String str) {
		if(str==null || str.length()<=0)
			return null;
		int i = 0, j = str.length()-1;
		while(i <str.length() && !Character.isLetter(str.charAt(i))) // while i번째 character 가 letter가 아닌 동안 반복
			i++;
		while(j>=0 && !Character.isLetter(str.charAt(j)))
			j--;
		if(i>j) //여기서 단어에 알파벳이 없고 특수문자만 있을 때 i와 j 값이 옳지 않게 돼 오류가 발생한다. 고로 위에 if문을 추가해준다.
			return null;
		return str.substring(i+j+1);// i부터 j까지기 때문에 substring에서 개구간인 부분을 +1해줘야한다. i<= ... < j+1
	}
}
