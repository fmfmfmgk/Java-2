package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class codingTest {
	public static void main(String[] args) {
		
		int[] numbers = {6,10,2};
		//1.String타입으로 바꾸기
		ArrayList<Integer> num = new ArrayList<Integer>();
		
		for (int i = 0; i < numbers.length; i++) {
			num.add(numbers[i]);
		}
		List<String> snum = new ArrayList(num);
		
		//2.내부 정렬기준으로 내림차순순 정의하기
		Collections.sort(snum, new eeee());
		for (String string : snum) {
			System.out.println(string);
		}
	
	}
	
//	public String solution(int[] numbers) {
//        String answer = "";
//        
//        //1.String 
//        List<String> num = new 
//        
//        return answer;
//    }
}
class eeee implements Comparator<String>{

	@Override
	public int compare(String str1, String str2) {
		return str2.compareTo(str1);
	}
}
