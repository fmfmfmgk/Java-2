package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreadTest13 {
	public static void main(String[] args) {
		Horse[] horseArr = new Horse[] {
				new Horse("01번말"),new Horse("02번말"),
				new Horse("03번말"),new Horse("04번말"),
				new Horse("05번말"),new Horse("06번말"),
				new Horse("07번말"),new Horse("08번말"),
				new Horse("09번말"),new Horse("10번말")
		};
		
		GameState gs = new GameState(horseArr);
		
		for (Horse h : horseArr) {
			h.start();
		}
		
		gs.start();
		
		for (Horse h : horseArr) {
			try {
				h.join();
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
	    
		try {
			gs.join();
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		
		System.out.println();
		System.out.println("경기 종료....");
		System.out.println();
		
		//등수의 오름차순으로 정렬하기
		//배열 정렬하기 -> Arrays.sort()메소드를 사용한다.
		Arrays.sort(horseArr);
		
		//경기 결과 출력하기...
		for (Horse h : horseArr) {
			System.out.println(h);
		}
		
	}
}

class Horse extends Thread implements Comparable<Horse>{
	
	public static int currentRank = 0; //말의 현재 등수를 구하는 변수
	
	private String horsename;
	private int location;
	private int rank;
	
	//생성자
	public Horse(String horsename) {
		this.horsename = horsename;
	}
	
	public String getHorsename() {
		return horsename;
	}
	public void setHorsename(String horsename) {
		this.horsename = horsename;
	}
	public int getLocation() {
		return location;
	}
	public void setLocation(int location) {
		this.location = location;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "경주마" + horsename +"은(는)" + rank + "등 입니다.";
	}

	//등수의 오름차순 정렬 기준 만들기
	@Override
	public int compareTo(Horse horse) {
		return Integer.compare(this.rank, horse.getRank());
	}
	
	@Override
	public void run() {
		for(int i=1; i<=50; i++) {
			location = i;	//말의 현재 위치 저장하기
			try {
				Thread.sleep((int)(Math.random() * 500));
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		
		//한 마리의 말이 경주가 끝나면 등수를 구해서 저장한다.
		currentRank++;
		rank = currentRank;
	}
}

class GameState extends Thread{
	private Horse[] horseArr; //경주에 참가하는 말들이 저장될 배열
	
	public GameState(Horse[] horseArr) {
		this.horseArr = horseArr;
	}
	
	@Override
	public void run() {
		while(true) {
			//모든 말의 경주가 끝났는지 여부 검사
			if(Horse.currentRank == horseArr.length) {
				break;
			}
			for (int i = 0; i < 5; i++) {
				System.out.println(" ");
			}
			
			//배열의 개수만큼 반복
			for (int i = 0; i < horseArr.length; i++) {
				System.out.print(horseArr[i].getHorsename());
				for (int j = 1; j <= 50; j++) {
					if(j==horseArr[i].getLocation()) {
						System.out.print(">");
					}else {
						System.out.print("-");
					}
				}
				System.out.println();// 줄바꿈
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
	}
}











