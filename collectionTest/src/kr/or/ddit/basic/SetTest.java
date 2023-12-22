package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class SetTest {
	public static void main(String[] args) {
		/*
		 * List와 Set의 차이점
		 * 
		 * List
		 *  - 저장되는 데이터의 순서(index)가 있다 
		 *  - 중복되는 데이터를 저장할 수 있다.
		 *  
		 * Set
		 *  - 데이터의 순서(index)가 없다.
		 *  - 중복되는 데이터를 저장할 수 없다.
		 */

		HashSet hs1 = new HashSet();
		
		//Set에 데이터를 추가할 때도 add()메소드를 이용한다.
		hs1.add("DD");
		hs1.add("AA");
		hs1.add(2);
		hs1.add("CC");
		hs1.add("BB");
		hs1.add(1);
		hs1.add(3);
		
		System.out.println("Set의 개수: "+ hs1.size());
		System.out.println("Set의 데이터: "+ hs1);
		
		//Set에 중복되는 데이터를 추가하면 false를 반환하고 데이터는 추가되지 않는다.
		
		System.out.println(hs1.add(2));
		
		//Set 데이터 수정
		//	=>Set에는 수정하는 명령이 따로 없기 때문에 수정하려는 데이터를 삭제한 후 새로 추가해 주는 방법으로 처리
		
		//데이터 삭제 remove(삭제할 자료);
		//전체 삭제  clear() 전체삭제
		
		System.out.println("삭제 반환값(3): "+hs1.remove(3));
		System.out.println("Set의 데이터: "+ hs1);
		
//		hs1.clear();
		
		/*
		  Set의 데이터들은 순서(index)가 없기 때문에 List처럼 index로 데이터를 하나씩 불러올 수 없다.
		     그래서 데이터를 하나씩 얻기 위해서는 Iterrator형의 객체로 반환해야 한다.
		     
		     
		  - Set형의 데이터들을 Iterator형의 객체로 변환하는 메소드 => iterator()   
		*/
		
		Iterator it = hs1.iterator();
		
		// Iterator의 hasNext()메소드
		// 		==> Iterator의 포인터가 가리키는 곳의 다음번째에 데이터가 있는지 검사한다.
		//			데이터가 있으면 true, 데이터가 없으면false를 반환한다.
		
		// Iterator의 next()메소드
		// 		==> Iterator의 포인터를 다음번째 위치로 이동한 후 이동한 위치에 있는 데이터를읽어서 반환한다.
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		//---------------------------------------------------------------------
		
		//우리반 학생들 중 번호를 이용하여 추첨하는 프로그램을 작성해 보자.
		//번호는 1번부터 16번까지 있고 추첨할 인원은 3명이다.
		//당첨자 번호를 출력하시오.
		
		//시작값부터 종료값 사이의 정수형 난수 만들기
		//(int)(math.random()*(종료값-시작값+1)+시작값)
//		int ren = (int)(Math.random()*(84-55+1)+55);
		
		HashSet<Integer> testSet = new HashSet<Integer>();
		while(testSet.size() < 3) {
			testSet.add((int)(Math.random()*(16-1+1)+1));
		}
		System.out.println("당첨자 번호: "+testSet);
		
		//Set유형의 자료를 List형으로 변환하기
		
		ArrayList<Integer> testList = new ArrayList<Integer>(testSet);
		System.out.println("List 데이터 출력하기...");
		for (int i = 0; i < testList.size(); i++) {
			System.out.println(i+ "번째 데이터: "+ testList.get(i));
		}
		
		//향상된 for문을 이용하여 처리하기
		for (Integer num : testSet) {
			System.out.println(num);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
