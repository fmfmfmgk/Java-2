package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

/*
 *  문제) 5명의 사람 이름을 입력 받아 ArrayList에 저장한 후에 
 *       이들 중에서 '김'씨 성의 이름을 모두 출력하시오.
 *       (단, 입력은 Scanner객체를 이용한다.)
 *       
 *  문제2)5명의 별명을 입력받아 ArrayList에 저장하고
 *       이들 중에서 별명의 길이가 제일 긴 별명을 출력하시오.
 *       (단, 각 별명읙 ㅣㄹ이는 모두 다르게 입력한다.)
 *       
 *  문제3)'문제2'에서 입력하는 별명의 길이가 같은 것이 있을 수 있을 때 결과를 출력하시오.     
 *            
 */
public class ArrayListTest02 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		ArrayListTest02 obj = new ArrayListTest02();
		
//		obj.method1();
//		obj.method2();
		obj.선생님풀이1();
		
//		ArrayList<String> list = new ArrayList();
//		
//		String sel1 = sc.next();
//		String sel2 = sc.next();
//		String sel3 = sc.next();
//		String sel4 = sc.next();
//		String sel5 = sc.next();
//		
//		list.add(sel1);
//		list.add(sel2);
//		list.add(sel3);
//		list.add(sel4);
//		list.add(sel5);
//		
//		for (String str : list) {
//			if(str.contains("김")) {
//			System.out.println(str);
//			}
//		}
		
		
	}

		
		

	private void 선생님풀이1() {
		ArrayList<String> nameList = new ArrayList<String>();
		
		System.out.println("5명의 이름을 입력하세요.");
		for (int i = 1; i <=5; i++) {
			System.out.println(i+"번째 이름 : ");
			String name = sc.next();
			nameList.add(name);
		}
		
		System.out.println();
		System.out.println("김씨 성을 가진 사람들...");
		
		for (int i = 0; i < nameList.size(); i++) {
		/////////////////////////////////////////////////////////
			if(nameList.get(i).substring(0,1).equals("김") ) {
				System.out.println(nameList.get(i));
			}
		/////////////////////////////////////////////////////////
			if(nameList.get(i).charAt(0) == '김' ) {
				System.out.println(nameList.get(i));
			}
		/////////////////////////////////////////////////////////
			if(nameList.get(i).startsWith("김") ) {
				System.out.println(nameList.get(i));
			}
		/////////////////////////////////////////////////////////
			if(nameList.get(i).indexOf("김") == 0 ) {
				System.out.println(nameList.get(i));
			}
		}
	}
	
	private void method2() {
		System.out.println("2번째 문제------------------------------");
		
		ArrayList<String> list2 = new ArrayList();
		
		String s1 = sc.next();
		String s2 = sc.next();
		String s3 = sc.next();
		String s4 = sc.next();
		String s5 = sc.next();
		
		list2.add(s1);
		list2.add(s2);
		list2.add(s3);
		list2.add(s4);
		list2.add(s5);
		
		String m = "";
		for (int i=0; i<list2.size(); i++) {
			if(m.length() < list2.get(i).length()) {
				m = list2.get(i);
			}
		}
		System.out.println(m);
	}

	private void method1() {
		System.out.println("3번째 문제------------------------------");

		
		ArrayList<String> list3 = new ArrayList();
		
		String ss1 = sc.next();
		String ss2 = sc.next();
		String ss3 = sc.next();
		String ss4 = sc.next();
		String ss5 = sc.next();
		
		list3.add(ss1);
		list3.add(ss2);
		list3.add(ss3);
		list3.add(ss4);
		list3.add(ss5);
		
		int max = 0;
		String m = "";
		for (int i=0; i<list3.size(); i++) {
			if(m.length() < list3.get(i).length()) {
				m = list3.get(i);
				max = list3.get(i).length();
			}
		}
		for (int i = 0; i < list3.size(); i++) {
			if(max == list3.get(i).length()) {
				System.out.println(list3.get(i));
			}
		}
	}
}
