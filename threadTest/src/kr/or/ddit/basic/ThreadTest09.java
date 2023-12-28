package kr.or.ddit.basic;

//스레드의 상태를 출력하는 예제


public class ThreadTest09 {

	public static void main(String[] args) {
		TargetThread target = new TargetThread();
		StatePrintThread th = new StatePrintThread(target);
		th.start();

	}

}
// 검사 대상이 되는 스레드(TargetThread)의 상태를 출력하는 스레드
class StatePrintThread extends Thread{
	private TargetThread target;
	
	public StatePrintThread(TargetThread taget) {
		this.target = taget;
	}
	
	@Override
	public void run() {
		while(true) {
			//스레드의 상태값 구하기 ==> getState()메소드 이용
			Thread.State state = target.getState();
			System.out.println("TargetThread의 상태값: "+ state);
		
			// TargetThread의 상태가 NEW상태 이면...
			if(state == Thread.State.NEW) {
				target.start(); //TargetThread를 실행한다.
			}
			
			//TargetThread의 상태가 종료(TERMINATED) 상태이면
			if(state == Thread.State.TERMINATED) {
				break; //반복문을 빠져나간다.
			}
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
	}
}

// 스레드 상태의 검사 대상이 되는 스레드
class TargetThread extends Thread{
	@Override
	public void run() {
		for (long i = 1L; i < 20_000_000_000L; i++) {
			// 스레드가 처리하는 영역
			long sum = i + 1;
		}
		
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		
		for (long i = 1L; i < 20_000_000_000L; i++) {
			// 스레드가 처리하는 영역
			long sum = i + 1;
		}
		
	}
}