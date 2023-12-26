package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class codingTest {
	public static void main(String[] args) {
		
		int[] numbers = {6,10,2};
	}
	
	public String solution(int[] numbers) {
        ArrayList<String> num = new ArrayList<String>();
		
		for (int i = 0; i < numbers.length; i++) {
			num.add(String.valueOf(numbers[i]));
		}

		Collections.sort(num, new eeee());
		String answer = "";
		for (String string : num) {
			answer += string;
		}
		System.out.println(answer);
        return answer;
    }
}
class eeee implements Comparator<String>{

	@Override
	public int compare(String str1, String str2) {
		return str2.compareTo(str1);
	}
}
