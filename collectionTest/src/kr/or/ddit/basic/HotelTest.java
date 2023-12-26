package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class HotelTest {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		HotelTest obj = new HotelTest();
		HashMap<Integer,Room> list = new HashMap<Integer, Room>();
		
		//방 생성 메소드
		obj.inset(list);
		
		while(true) {
			obj.print();
			int sel = sc.nextInt();
			switch (sel) {
			case 1:
				obj.checkin(list);
				break;
			case 2:
				obj.checkout(list);
				break;
			case 3:
				List<Integer> setList = new ArrayList(list.keySet());
				Collections.sort(setList);
				obj.printlist(list, setList);
				break;
			case 4:
				System.out.println("안녕히 가십시오.");
				break;
			default:
				break;
			}
		if(sel == 4)  break;
		}
	}
	
	private void checkout(HashMap<Integer, Room> list) {
		System.out.println("체크아웃 할 방 번호를 입력하세요.");
		System.out.print("방번호 입력>>");
		int sel = sc.nextInt();
		if (!list.get(sel).getName().equals("-")) {
			String type = list.get(sel).getType();
			String name = list.get(sel).getName();
			list.put(sel, new Room(sel, type, "-"));
			System.out.println(sel+"호 객실의 "+name+"님 체크아웃이 완료되었습니다. ");
		} else {
			System.out.println(sel + "호 객실은 체크인 한 사람이 없습니다.");
		}
	}

	private void checkin(HashMap<Integer, Room> list) {
		System.out.println("----------------------------------------------");
		System.out.println("   체크인 작업");
		System.out.println("----------------------------------------------");
		System.out.println(" * 201~209 : 싱글룸");
		System.out.println(" * 301~309 : 더블룸");
		System.out.println(" * 401~409 : 스위트룸");
		System.out.println("----------------------------------------------");
		System.out.println("방 번호 입력>>");
		int sel = sc.nextInt();
		if (list.containsKey(sel)) {
			if (list.get(sel).getName().equals("-")) {
				System.out.print("이름입력>>");
				String n = sc.next();
				list.put(sel, new Room(sel,list.get(sel).getType(), n));
			} else {
				System.out.println(sel + "호 객실은 이미 손님이 있습니다.");
			}
		}else {
			System.out.println("해당 호실은 존재하지 않는 호실입니다.");
		}
	}

	private void print() {
		System.out.println("*********************************************\r\n" + 
				"       호텔문을 열었습니다. 어서오십시요.\r\n" + 
				"*********************************************");
		System.out.println("----------------------------------------------");
		System.out.println("어떤 업무를 하시겠습니까?");
		System.out.println("1.체크인\t\t2.체크아웃\t\t3.객실상태\t\t4.업무종료");
		System.out.println("----------------------------------------------");
		System.out.println("선택>>");
	}

	private void printlist(HashMap<Integer, Room> list, List<Integer> setList) {
		System.out.println("--------------------------------------------");
		System.out.println("방 번호\t방 종류\t투숙객 이름");
		System.out.println("--------------------------------------------");
		for (int i = 0; i < list.size(); i++) {
			Room s = list.get(setList.get(i));
			String name = s.getName();
			String type = s.getType();
			int no = s.getNo();
			System.out.println(no+"\t"+type+"\t"+name);
		}
		System.out.println("--------------------------------------------");
	}

	private void inset(HashMap<Integer, Room> list) {
		//방 생성 메소드
		int s = 200;
		for (int i = 1; i <= 9; i++) {
			list.put(s+i, new Room(s+i,"싱글룸","-"));
		}
		int d = 300;
		for (int i = 1; i <= 9; i++) {
			list.put(d+i, new Room(d+i,"더블룸","-"));
		}
		int ss = 400;
		for (int i = 1; i <= 9; i++) {
			list.put(ss+i, new Room(ss+i,"스위트","-"));
		}
	}
}

class Room{
	private int no;
	private String type;
	private String name;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Room(int no, String type, String name) {
		this.no = no;
		this.type = type;
		this.name = name;
	}
}