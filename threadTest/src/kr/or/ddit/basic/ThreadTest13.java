package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.List;

public class ThreadTest13 {
	public static List<Horse> list = new ArrayList();
	public static void main(String[] args) {
		HorseSpace s = new HorseSpace();
		
		for (int i = 1; i <=10; i++) {
			list.add(new Horse(i+"번말"));
		}
		
		for (int i = 0; i < 9; i++) {
			
		}
		
		s.start();
		
	}
}

class Horse extends Thread{
	// 출력한 순서대로 스레드 이름이 저장될 변수
	public static int strRank = 0;
	private String name;
	private int hsw = 0;

	public Horse(String name) {
		this.name = name;
	}
	@Override
	public void run() {
	}
}


//중간 중간 말들 위치를 나타내는 스레드
class HorseSpace extends Thread{
	@Override
	public void run() {
		int a = 49;
		ThreadTest13.list.get(0).getName();
		for (int i = 0; i <= 49; i++) {
			System.out.print("-");
			try {
				Thread.sleep((int)(Math.random()*500));
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
	}
}













