package kr.or.ddit.basic;

import java.util.Vector;

public class VectorTest {
	
	public static void main(String[] args) {
		//Vector는 자바의 초기부터 지원하는 객체로 동기화 처리가 되어 있다.
		
		//객체생성
		Vector v1 = new Vector();
		System.out.println("처음 크기:"+ v1.size());
		
		//데이터 추가하기1 : add(추가할 데이터)
		//      ==>반환값 : 추가성공(true), 추가실패(false)
		v1.add("aaa");
		
		// 숫자를 객체화 시킨후 저장 (boxing)일반 데이터를 객체화시켜주는 과정
		v1.add(new Integer(111));
		v1.add(Integer.valueOf(200));
		
		//요즘하는 방식 : 굳이 객체화를 안시켜도 된다.
		v1.add(123); //auto boxing  ==> auto unboxing
		v1.add('a');
		v1.add(true);
		
		boolean r = v1.add(3.14);
		System.out.println("반환값 : "+r);
		
		//데이터 추가하기2 : addElement(추가할 데이터) --초기 추가방법이었음
		//    => add랑 똑같은 기능 (지금은 거의 사용 안함)
		
		v1.addElement("ccc");
		
		//출력방법 .toString(); -생략가능
		System.out.println("v =>"+ v1.toString());
		System.out.println("v =>"+ v1);
		
		
		// 데이터 추가하기3 : add(index, 데이터)
		//		==> 'index'번째에 '데이터'를 끼워 넣는다.
		//		==> 'index 는 0부터 시작한다.  ==>반환값은 없다.
		v1.add(1, "KKK");
		System.out.println("v =>"+ v1);
		
		//데이터 꺼내오기 : get(index)
		//		==> 'index'번째의 데이터를 꺼내서 반환한다.
		System.out.println("0번째 데이터 : "+v1.get(0));
		//변수에 저장할 때에는 형변환을 시켜주어야 한다.
		int itemp = (int)v1.get(2);
		System.out.println("2번째 데이터 : "+itemp);
		
		//데이터 수정하기  : set(index, 새로운데이터값)
		//		==> 'index'번째의 데이터를 '새로운 데이터'로 변경한다.
		//		==> 반환값 : 변경되기 전의 원래의 데이터
		String sTemp = (String)v1.set(0, "zzzz");
		System.out.println("v1 : "+v1);
		System.out.println("원래의 데이터 :"+ sTemp);
		
		//데이터 삭제하기1 : remove(index)
		//		==> 'index'번째의 데이터를 삭제한다.
		//		==> 반환값 : 삭제된 데이터
		v1.remove(0);
		System.out.println("v1 =."+v1);
		itemp = (int)v1.remove(2);
		System.out.println("삭제 후 v1 =>"+v1);
		System.out.println("삭제된 데이터 ==>"+itemp);
		System.out.println();
		
		//데이터 삭제하기2 : remove(삭제할 데이터)
		//		==> '삭제할 데이터'를 찾아서 삭제한다.
		//		==> '삭제할 데이터'가 여러개이면 이 중에 제일 첫번째로 검색된 자료가 삭제된다.
		//		==>  반환값 : 삭제성공(true), 삭제실패(false)
		//		==> '삭제할 데이터'가 '정수형'이거나 'char'형 일 경우에는 반드시 객체로 변환 후 사용해야 한다. 
		v1.remove("ccc");
		System.out.println("ccc 삭제 후 v1 =>"+v1);
		
		//v1.remove(123); 오류
		//v1.remove(new Integer(123));   //방법 1==> 1.9버전부터는 사용 불가
		v1.remove(Integer.valueOf(123)); //방법 2==>
		
		System.out.println("123 삭제 후 v1 =>"+v1);
		
		//v1.remove('a'); //값이 저장될때는 a의 코드값으로 저장됨 a=97 -> v1.remove(97); 로 인식함
		v1.remove(Character.valueOf('a'));
		System.out.println("a 삭제 후 v1 =>"+v1);
		
		v1.remove(true);
		v1.remove(3.14);
		System.out.println("삭제 후 v1 =>"+v1);
		
		
		//전체 데이터 삭제하기 : clear();
		v1.clear();
		System.out.println("clear 삭제 후 v1 =>"+ v1);
		System.out.println("-----------------------------------------------");
		
		//----------------------------------------------------------------------
		/*
		 * 제네릭 타입(Generic Type) ==> 클래스 내부에서 사용할 데이터의 타입을 객체를 생성할 때 외부에서 지정
		 *                           객체를 선언 할 때 <>괄호 안에 그 객체의 내부에서 사용할 데이터의 타입
		 *                           을 지정해 주는 것을 말한다.
		 *                           
		 *         - 이런식으로 선언하게 되면 그 지정한 데이터 타입 이외의  다른 종류의 데이터를 저장할 수 없다.
		 *         - 이 때 제네릭으로 선언 될 수 있는 데이터 타입은 '클래스형'으로 지정해야 한다.
		 *           int는 Integer, boolean은 Boolean, char는 character등으로 대체                
		 *         - 제네릭 타입으로 선언하게 되면 데이터를 꺼내올 때 별도의 형변환이 필요 없다.                 
		 */
		
		Vector<Integer> v2 = new Vector<Integer>(); //int형 자료만 저장할 수 있는 Vector
		Vector<String> v3 = new Vector<String>(); //String형 자료만 저장할 수 있는 Vector
		
		v3.add("안녕하세요");
		// v3.add(100); //오류 : 다른 종류의 데이터를 저장할 수 없다.
		
		String sTemp2 = v3.get(0); //형변환을 안해도 됨 
		
		Vector<Vector> vv = new Vector<Vector>();
		System.out.println("---------------------------------------------------");
		//----------------------------------------------------------------------
		
		v3.clear();
		System.out.println(v3);
		
		v3.add("AAA");
		v3.add("BBB");
		v3.add("CCC");
		v3.add("DDD");
		v3.add("EEE");
		
		Vector<String> v4 = new Vector<String>();
		v4.add("BBB");
		v4.add("DDD");
		
		System.out.println("v3 => "+ v3);
		System.out.println("v4 => "+ v4);
		
		//데이터 삭제하기3 : removeALL(Collection객체)
		//		==> Vector의 데이터 중에서 'Collection객체'가 가지고 있는 모든 데이터를
		//		         삭제한다.
		//		==> 반환갑 : 성공(true), 실패(false)
		v3.removeAll(v4);
		System.out.println("v3 => "+ v3);
		System.out.println();
		
		//백터의 데이터 전체를 순서대로 가져와 사용하려면 반복문을 이용한다. (for문)
		v3.clear();
		
		v3.add("AAA");
		v3.add("BBB");
		v3.add("CCC");
		v3.add("DDD");
		v3.add("EEE");
		
		for (int i = 0; i < v3.size(); i++) {
			System.out.println(i+"번째 데이터 : "+v3.get(i));
		}
		System.out.println();
		
		//향상된 for문
		for (String str : v3) {
			System.out.println(str);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
