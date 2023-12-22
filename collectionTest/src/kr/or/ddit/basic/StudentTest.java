package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class StudentTest {

	 /* 문제) 학번, 이름, 국어점수, 영어점수, 수학점수, 총점, 등수를 멤버로 갖는 Student클래스를 만든다.
                           이 Student클래스의 생성자에서는 학번, 이름, 국어점수, 영어점수, 수학점수만 매개변수로 받아서
                           초기화 처리를 한다. (총점은 3과목 점수의 합계로 초기화 한다.)
			
                           이 Student객체는 List에 저장하여 관리한다.
			
            1.List에 저장된 데이터들을 학번의 오름차순으로 정렬할 수 있는 내부 정렬 기준을 구현하고,
            2.총점의 내림차순으로 정렬하는데 
            3.총점이 같으면 이름의 오름차순으로 정렬되는 외부 정렬 기준 클래스를
                           작성하여 정렬된 결과를 출력하시오.
			
            (단, 등수는 List에 전체 데이터가 추가된 후에 저장되도록 한다.)
	 */
	
	public void createRank(ArrayList<Student> sList) { 
		//등수 구하는 메소드
		for(Student std1: sList) {//기준 데이터를 구하기 위한 반복문
			int rank =1; //처음에는 1등으로 초기화해놓고 시작한다.
			for(Student std2: sList) {//비교 대상을 나타네는 반복문
				//기준보다 비교 대상이 크면 등수를 증가시킨다.
				if(std1.getSum() < std2.getSum()) {
					rank++;
				}
			}
			//구해진 등수를 Student객체의 rank변수에 저장한다.
			std1.setRank(rank);
		}
	}
	public static void main(String[] args) {
		ArrayList<Student> sList = new ArrayList<Student>();
		StudentTest test = new StudentTest();
		
		
		sList.add(new Student(1,"홍길동",60,96,98));
		sList.add(new Student(6,"변학도",89,70,68));
		sList.add(new Student(3,"성춘향",67,92,96));
		sList.add(new Student(2,"이순신",99,80,76));
		sList.add(new Student(4,"강감찬",55,83,26));
		sList.add(new Student(5,"일지매",34,99,76));
		
		//List에 데이터가 모두 추가된 후에 등수 구하는 메소드를 호출한다.
//		test.createRank(sList);
		
		Collections.sort(sList, new adadad());
		int rank = 1;
		if (!sList.isEmpty()) {
		    sList.get(0).setRank(rank);
		    System.out.println(sList.get(0));
		}
		for (int i = 1; i < sList.size(); i++) {
			if(sList.get(i).getSum() == sList.get(i-1).getSum()) {
				sList.get(i).setRank(rank);
			}else {
				rank++;
				sList.get(i).setRank(rank);
			}
		System.out.println(sList.get(i));
		}
	}
}

class Student implements Comparable<Student>{
	private int num;
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int sum;
	private int rank;
	private int avg;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	
	public Student(int num, String name, int kor, int eng, int math) {
		this.num = num;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.sum = kor+eng+math;
	}
	
	public int getAvg() {
		return avg;
	}
	public void setAvg(int avg) {
		this.avg = avg;
	}
	@Override
	public String toString() {
		return "Student [학번=" + num + ", 이름=" + name + ", 국어=" + kor + ", 영어=" + eng + ", 수학=" + math + ", 총점="
				+ sum + ", 등수=" + rank + "]";
	}
	
	//학번기준으로하는 내부정렬 (오름차순)
	@Override
	public int compareTo(Student s) {
		
		// compara()메소드의 반환값의 의미
		// 0은 두 값이 같다.
		// 양수는 앞, 뒤의 순서를 바꾼다.
		// 음수는 앞, 뒤의 순서를 바꾸지 않는다.
		
		if(this.getNum() > s.getNum()) {
			return 1;
		}else if(this.getNum() < s.getNum()) {
			return -1;
		}else {
			return 0;
		}
	}
}



class adadad implements Comparator<Student>{

	@Override
	public int compare(Student s1, Student s2) {
		if(s1.getSum() > s2.getSum()) {
			return -1;
		}else if(s1.getSum() < s2.getSum()){
			return 1;
		}else if(s1.getSum() == s2.getSum()){
			return s1.getName().compareTo(s2.getName());
		}else {
			return 0;
		}
	}
}
	
	


