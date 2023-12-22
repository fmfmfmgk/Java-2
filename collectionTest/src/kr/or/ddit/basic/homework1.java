package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class homework1 {
	static Scanner sc = new Scanner(System.in);
	
	public void lotto(int no) { 
		//로또번호 생성 메소드
		int g = no%1000;
		int qty = no/1000;
		
		HashSet<Integer> ren = new HashSet<Integer>();
		
		for(int i=1; i<qty+1; i++) {
			while(ren.size()<6) {
				int rendom = (int)(Math.random()*(45-1+1)+1);
				ren.add(rendom);
			}
			ArrayList<Integer> bb = new ArrayList<Integer>(ren);
			Collections.sort(bb);
		System.out.println("로또번호"+i+": "+bb);
		ren.clear();
		}
		System.out.println("받은 금액은 "+no+"원이고 거스름돈은 "+g+"원 입니다.");
	}
	
	public static void main(String[] args) {
		homework1 h = new homework1();
		while(true) {
			System.out.println("==========================\r\n" + 
				           "    Lotto 프로그램\r\n" + 
				           "--------------------------\r\n" + 
				           "    1. Lotto 구입\r\n" + 
				           "    2. 프로그램 종료\r\n" + 
				           "==========================	");
		
			int sel = sc.nextInt();
			switch (sel) {
				case 1:
					System.out.println(" 구입시작");
					System.out.println("(1000원에 로또번호 하나입니다.)");
					System.out.print("금액입력>>");
					int qty = sc.nextInt();
					if (qty > 100000) {
						System.out.println("입력 금액이 너무 많습니다.");
						break;
					} else if (qty < 1000) {
						System.out.println("입력 금액에 너무 적습니다.");
						break;
					}                                      
					h.lotto(qty);                          
					break;                                 
				case 2:                                    
					System.out.println("프로그램 종료.");  
					break;                                 
				default:                                   
					break;                                 
			}                                              
			if (sel == 2) {                                
				break;                                     
			}
		}
	}
}
