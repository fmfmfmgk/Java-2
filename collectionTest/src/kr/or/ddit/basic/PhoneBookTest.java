package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Scanner;

public class PhoneBookTest {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		PhoneBookTest p = new PhoneBookTest();
		HashMap<String, Phone> list = new HashMap<>();
		//
		while(true) {
			p.menu();
			int sel = sc.nextInt();
			switch (sel) {
				case 1:
					Phone a = p.insert(list);
					list.put(a.getName(), a);
					System.out.println("추가가 완료되었습니다.");
					break;
				case 2:
					Phone a1 = p.update(list);
					list.put(a1.getName(), a1);
					System.out.println("수정이 완료되었습니다.");
					break;
				case 3:
					listPrint(list);
					String name = sc.next();
					list.remove(name);
					System.out.println("삭제가 완료되었습니다.");
					break;
				case 4:
					System.out.print("검색할 이름을 입력하세요: ");
					String name1 = sc.next();
					listPrintSh(name1, list);
					break;
				case 5:
					listPrint(list);
					break;
				case 0:
					break;
				default:
					break;
				}
			if(sel == 0) {
			System.out.println("종료되었습니다.");
			break;
			}
		}
	}
	


	private static void listPrintSh(String name1, HashMap<String, Phone> list) {
		int i = 0;
		System.out.println("번호\t이름\t전화번호\t주소");
		System.out.println("--------------------------------------------");
			String name = list.get(name1).getName();
			String tel = list.get(name1).getTel();
			String add = list.get(name1).getAdd();
			i++;
			System.out.println(i+"\t"+name+"\t"+tel+"\t"+add);
		System.out.println("--------------------------------------------");
	}
	
	private Phone update(HashMap<String, Phone> list) {
		System.out.print("수정할이름입력>>");
		String name = sc.next();
		list.remove(name);
		
		System.out.print("수정할이름입력>>");
		String name2 = sc.next();
		System.out.print("지역입력>>");
		String arr = sc.next();
		System.out.print("전화번호입력>>");
		String tel = sc.next();
		Phone a = new Phone(name2, arr, tel);
		return a;
	}
	
	private static void listPrint(HashMap<String, Phone> list) {
		int i = 0;
		System.out.println("번호\t이름\t전화번호\t주소");
		System.out.println("--------------------------------------------");
		for (Phone a : list.values()) {
			String name = a.getName();
			String tel = a.getTel(); 
			String add = a.getAdd();
			i++;
			System.out.println(i+"\t"+name+"\t"+tel+"\t"+add);
		}
		System.out.println("--------------------------------------------");
	}

	
	public Phone insert(HashMap<String, Phone> list) {
		String name1;
		while (true) {
            System.out.print("이름입력>>");
            String name = sc.next();
            if (list.containsKey(name)) {
                System.out.println(name + "은(는) 이미 등록된 사람입니다.");
            } else {
                name1 = name;
                break;
            }
        }
		System.out.print("지역입력>>");
		String arr = sc.next();
		System.out.print("전화번호입력>>");
		String tel = sc.next();
		Phone a = new Phone(name1, arr, tel);
		return a;
	}
	
	public void menu(){
		System.out.println("메뉴");
		System.out.println("1.전화번호 등록");
		System.out.println("2.전화번호 수정");
		System.out.println("3.전화번호 삭제");
		System.out.println("4.전화번호 검색");
		System.out.println("5.전화번호 전체 출력");
		System.out.println("0.프로그램 종료");
		System.out.print("번호입력>>");
	}
}

class Phone{
	private String name;
	private String add;
	private String tel;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdd() {
		return add;
	}
	public void setAdd(String add) {
		this.add = add;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public Phone(String name, String add, String tel) {
		this.name = name;
		this.add = add;
		this.tel = tel;
	}
}