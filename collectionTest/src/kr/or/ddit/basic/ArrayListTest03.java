package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListTest03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		ArrayList<String> list = new ArrayList<String>();
		
		System.out.println("서로 다른 길이의 별명을 입력하세요.");
		for (int i = 1; i <=5; i++) {
			System.out.println(i+"번째 별명 : ");
			String name = sc.nextLine();
			list.add(name);
		}
		
		//제일 긴 별명이 저장될 변수를 선언하고, List의 첫번째 데이터로 초기화 한다.
		String maxlist = list.get(0);
		
		for (int i = 1; i < list.size(); i++) {
			if(maxlist.length() < list.get(i).length()) {
				maxlist = list.get(i);
			}
		}
		System.out.println("제일 긴 별명: "+maxlist);
		
		
		
		
	}

}
