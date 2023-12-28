package kr.or.ddit.basic;

/*
 * 
 * Thread의 stop()메소드를 호출하면 스레드가 즉시 멈춘다.
 * 이 때 사용하던 자원을 정리하지못하고 스레드가 종료되어 다른 프로그램이나스레드에 영향을 줄 수 있다.
 * 그래서 stop()메소드는 비추천을 되어 있다.
 */

public class ThreadTest11 {

	public static void main(String[] args) {
		
//		ThreadStopTest01 th1 = new ThreadStopTest01();
//		th1.start();
//		
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO: handle exception
//		}
//		th1.stop();
//		//th1.setStop(true);
		
		//interrupt()메소드를 이용한 스레드 멈추기
		ThreadStopTest02 th2 = new ThreadStopTest02();
		th2.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		th2.interrupt();
	}

}
// interrupt()메소드를 이용하여 스레드를 멈추게하는 연습용 스레드
class ThreadStopTest02 extends Thread{
	@Override
	public void run() {
		//방법1 -> interrupt()메소드와 sleep()메소드를 이용하는 방법
//		try {
//			int a = 1;
//			while(true) {
//				System.out.println("실행 중......"+a);
//				a++;
//				Thread.sleep(1); //일시 정지 상태에서 interrupt()메소드라 호출되면
//				                 //InterruptedException이 발생한다.
//			}
//		} catch (InterruptedException e) {
//			// TODO: handle exception
//		}
		System.out.println("자원 정리...");
		System.out.println("스레드 종료...");
		
		//방법2
		while(true) {
			System.out.println("Thread 실행 중....");
			
			//intertupt()메소드가 호출되었는지 검사한다.
			
			//검사 방법1 -> Thread의 인스턴스 메소드인 isInterrupted()메소드를 이용한다.
			//        -> isInterrupted()메소드는 interrupt()메소드가  호출되면
			//        -> true를 반환한다.
//			if(this.isInterrupted()) {
//				break;
//			}
			
			//검사 방법2 -> Thread의 정적 메소드인 interrupted()메소드를 이용한다.
			//	      -> interrtupted()메소드도 interrupt()메소드가 호출되면
			//        -> true를 반환한다.
			if(Thread.interrupted()) {
				break;
			}
		}
		System.out.println("자원 정리...");
		System.out.println("스레드 종료...");
	}
}







// 스레드를 멈추게하는 연습용 스레드
class ThreadStopTest01 extends Thread{
	private boolean stop;
	public void setStop(boolean stop) {
		this.stop = stop;
	}
	
	@Override
	public void run() {
		while(!stop) {
			System.out.println("스레드 실행중.....");
		}
		System.out.println("자원 정리...");
		System.out.println("스레드 종료...");
	}
}