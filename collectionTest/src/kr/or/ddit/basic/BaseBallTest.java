package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/*
     문제) Set을 이용하여 숫자 야구 게임 프로그램을 작성하시오.
                컴퓨터의 숫자는 난수를 이용하여 구한다.
       (스트라이크는 S, 볼은 B로 출력한다.)
   
   
      예) 컴퓨터의 난수 ==> 9 5 7
   
      실행예시)
      숫자입력 >> 3 5 6
   3 5 6 ==> 1S 0B
      숫자입력>> 7 8 9
   7 8 9 ==> 0S 2B
      숫자입력>> 9 7 5
   9 7 5 ==> 1S 2B
      숫자입력>> 9 5 7
   9 5 7 ==> 3S 0B
   
   4번만에 맞췄습니다....
*/
public class BaseBallTest {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		//시작값부터 종료값 사이의 정수형 난수 만들기
		//(int)(math.random()*(종료값-시작값+1)+시작값)
		
		HashSet<Integer> ren = new HashSet<Integer>();
		while(ren.size()<3) {
			int rendom = (int)(Math.random()*(9-1+1)+1);
			ren.add(rendom);
		}
		ArrayList<Integer> bb = new ArrayList<Integer>(ren);
		ArrayList<Integer> list = new ArrayList<Integer>();
		System.out.println(bb);
		int c = 0;
		while(true) {
			System.out.println("숫자 3개 입력>>");
			list.add(sc.nextInt());
			list.add(sc.nextInt());
			list.add(sc.nextInt());
			int s = 0;
			int b = 0;
			c++;
			for (int i = 0; i < list.size(); i++) {
				if(bb.get(i) == list.get(i)) s++;
				for (int j = 0; j < list.size(); j++) {
					if(bb.get(i) == list.get(j) && bb.get(i) != list.get(i)) b++;
				}
			}
			System.out.println(s+"s"+" "+b+"B");
			if(s == 3) {
				System.out.println("정답!!!  시도횟수: "+c);
				break;
			}
			list.clear();
		}
	}
}
