package kr.or.ddit.basic;

//은행의 입출금을 스레드로 처리하는 예제(동기와 처리 예제)
public class ThreadTest16 {
	private int balance; //잔액이 저장될 변수
	
	public int getBalance() {
		return balance;
	}
	
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	
	//입금을 처리하는 메소드
	public void deposit(int money) {
		balance += money;
	}
	
	//출금을 처리하는 메소드(출금 성공: true, 출금 실패: false)
	public boolean withdraw(int money) {
		synchronized (this) {
			if (balance >= money) {
				for (int i = 0; i <= 1_000_000_000; i++) {// 시간 지연용 반복문
					int k = i;
				}
				balance -= money;
				System.out.println("메소드 안에서 balance: " + getBalance());
				return true;
			} else {
				return false;
			}
		}
	}
	
	
	public static void main(String[] args) {
		ThreadTest16 acount = new ThreadTest16();
		acount.setBalance(10000); //잔액을 10000으로 설정
		
		//익명 구현체로 스레드 구현
		Runnable test = new Runnable() {
			@Override
			public void run() {
				boolean result = acount.withdraw(6000);
				System.out.println("스레드에서 result= " + result
				                      +", balance= "+acount.getBalance());
			}
		};
		//---------------------------------------------------
		Thread th1 = new Thread(test);
		Thread th2 = new Thread(test);
				
		th1.start();
		th2.start();
		
		
	}

}
