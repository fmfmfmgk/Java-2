package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

/*
 *  Vector, Hashtable등의 예전부터 존재하던 Collection객체들은 
 *  내부에 동기화 처리가 되어 있다.
 *  
 *  그런데 새롭게 구성된 Collection들은 동기화 처리가 되어 있지 않다.
 *  그래서 동기화가 필요한 프로그램에서 이런 Collecton들을 사용하려면 동기화 처리를 한 후에 사용해야 한다.
 *  
 *  동기화 처리를 해 주는 메소드
 *   - Collections.SynchronizedList() -> List 동기화 처리
 *   - Collections.SynchronizedMap() -> Map 동기화 처리
 *   - Collections.SynchronizedSet() -> Set 동기화 처리
 *    
 */
public class ThreadTest17 {
	public static Vector<Integer> vec = new Vector<Integer>();
	//동기화 처리가 되지 않은 List
	public static List<Integer> list1 = new ArrayList<Integer>();
	
	//동기화 처리를 한 List
	public static List<Integer> list2 = 
		Collections.synchronizedList(new ArrayList<Integer>());
	
	public static void main(String[] args) {
		
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
//					vec.add(i);
//					list1.add(i);
					list2.add(i);
				}
			}
		};
		//------------------------------------------------------
		Thread[] thArr = new Thread[] {
				new Thread(r), new Thread(r), new Thread(r),
				new Thread(r), new Thread(r), new Thread(r)
		};
		
		for (Thread th : thArr) {
			th.start();
		}
		
		for (Thread th : thArr) {
			try {
				th.join();
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		
//		System.out.println("vec의 개수: " + vec.size());
//		System.out.println("list1의 개수: " + list1.size());
		System.out.println("list2의 개수: " + list2.size());
	}

}