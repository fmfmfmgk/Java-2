package kr.or.ddit.basic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackQueueTest {
	public static void main(String[] args) {
	/*
	 * - Stack ==> FILO(선입후출), LIFO(후입선출)의 자료 구조
	 *   1.자료입력 : push(입력값)
	 *   2.자료출렵 : pop()  ==>자료를 꺼내온 후 꺼내온 자료를 Stack에서 삭제한다.
	 *             peek() ==>삭제없이 자료를 꺼내온다.
	 */
		Stack<String> stack = new Stack<String>(); //Stack클래스를 이용하기
//		LinkedList<String> stack2 = new LinkedList<String>();
		
		stack.push("홍길동");
		stack.push("일지매");
		stack.push("변학도");
		stack.push("강감찬");
		
		
		System.out.println("stack ==> "+ stack);
		
		String data = stack.pop();
		System.out.println(data);
		System.out.println("stack ==> "+ stack.pop());
		System.out.println("stack ==> "+ stack);
		
		stack.push("성춘향");
		System.out.println(stack);
		System.out.println("꺼내온 값 ==> "+ stack.pop());
		System.out.println("stack ==> "+ stack);
		
		System.out.println("삭제없이 꺼내온 값 : "+ stack.peek());
		System.out.println("stack ==> "+ stack);
		System.out.println("------------------------------------------------");
		
		
		/*
		 * - Queue ==> FIFO(선입선출)의 자료구조
		 *   1.자료 입력: offer(입력값)
		 *   2.지료 출력: poll()  => 자료를 꺼내오고 꺼내온 자료를 Queue에서 삭제한다.
		 *             peek()  => 삭제없이 자료를 꺼내온다.
		 */
		Queue<String> queue = new LinkedList<String>();
		
		queue.offer("홍길동");
		queue.offer("일지매");
		queue.offer("변학도");
		queue.offer("강감찬");
		
		System.out.println("Queue ==> "+ queue);
		
		String temp = queue.poll();
		System.out.println("꺼내온 값 : "+ temp);
		System.out.println("꺼내온 값 : "+ queue.poll());
		
		System.out.println("Queue ==> "+ queue);
		
		queue.offer("성춘향");
		System.out.println("Queue ==> "+ queue);
		
		System.out.println("꺼내온 값 : "+ queue.poll());
		System.out.println("Queue ==> "+ queue);
		
		System.out.println("삭제없이 꺼내온 값 : "+ queue.peek());
		System.out.println("Queue ==> "+ queue);
		System.out.println("---------------------------------------------------");
		
		
		// isEmpty() ==> Collection에 자료가 없으면 true, 있으면 false 반환
		stack.clear();
		System.out.println("스택이 비었는지 여부 : "+stack.isEmpty());
		queue.clear();
		System.out.println("큐가 비었는지 여부 : "+queue.isEmpty());
		
		
		
		
		
		
		
		
	}
}
