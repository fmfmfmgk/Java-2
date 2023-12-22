package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListTest04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		ArrayList<String> list = new ArrayList<String>();
		
		System.out.println("별명을 5번 입력하세요.");
		for (int i = 1; i <=5; i++) {
			System.out.println(i+"번째 별명 : ");
			String name = sc.nextLine();
			list.add(name);
		}
		
		// 제일 긴 별명의 길이가 저장될 변수를 선언하고, 첫번째 데이터의 길이로 초기화 한다.
		int maxlength = list.get(0).length();
		
		for (int i = 1; i < list.size(); i++) {
			if(maxlength < list.get(i).length()) {
				maxlength = list.get(i).length();
			}
		}
		
		System.out.println("제일 긴 별명들...");
		for (String alias : list) {
			if(alias.length() == maxlength) {
				System.out.println(alias);
			}
		}
		
		
		
		
		
		
		
		
		
	}

}
