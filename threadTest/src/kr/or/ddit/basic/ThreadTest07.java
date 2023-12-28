package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

/*
 *  컴퓨터와 가위 바위 보를 진행하는 프로그램을 작성하시오.
 *  
 *  컴퓨터의 가위 바위 보는 난수를 이용해서 구하고
 *  사용자의 입력은 showInputDialog()메소드를 이용해서 입력 받는다.
 *  
 *  입력 시간은 5초로 제한하고 카운트 다운을 한다.
 *  5초안에 입력이 없으면 게임에 진것으로 처리한다.
 *  5초안에 입력이 완료되면 승패를 구해서 출력한다. 
 *  
 *  결과 예시)
 *  1) 5초안에 입력이 없을때 
 *       -- 결 과 --
 *   시간초과로 당신이 졌습니다.
 *   
 *  2) 5초안에 입력을 완료했을 때
 *       -- 결 과 --
 *       컴퓨터: 가위
 *       사용자: 바위
 *   결 과  : 당신이 이겼습니다.
 *       
 *       
 */
public class ThreadTest07 {
	public static void main(String[] args) {
		//난수 발생기
		Random random = new Random();
		int rnum = random.nextInt(3) + 1;
		String go = "";
		if(rnum == 1) go = "가위";
		if(rnum == 2) go = "바위";
		if(rnum == 3) go = "보";

		Thread th1  = new Input();
		Thread th2  = new CountDown();
		th1.start();
		th2.start();
		
		try {
			th1.join();
		} catch (InterruptedException e) {
		}
		
		System.out.println("-- 결 과 --    ");
		System.out.println("   컴퓨터:"+go);
		System.out.println("   사용자:"+Input.me);
		
		if(Input.me.equals(go)) { 
			System.out.println("    비겼습니다.");
		}else if(Input.me.equals("가위")){
			if(go.equals("바위")) System.out.println("결과: 당신이 졌습니다.");
			if(go.equals("보")) System.out.println("결과: 당신이 이겼습니다.");
		}else if(Input.me.equals("바위")){
			if(go.equals("보")) System.out.println("결과: 당신이 졌습니다.");
			if(go.equals("가위")) System.out.println("결과: 당신이 이겼습니다.");
		}else if(Input.me.equals("보")){
			if(go.equals("가위")) System.out.println("결과: 당신이 졌습니다.");
			if(go.equals("바위")) System.out.println("결과: 당신이 이겼습니다.");
		}
	}
}

//데이터를 입력하는 스레드 클래스
class Input extends Thread{
	public static String me;
	public static boolean inputCheck = false;
	@Override
	public void run() {
		while(true) {
			String str = JOptionPane.showInputDialog("가위 바위 보");
			inputCheck = true;
			me = str;
			if(str == null) { 
				System.out.println("입력취소");
				System.exit(0);
			}else if(str.equals("")) {
				System.out.println("입력값 누락.");
				System.exit(0);
			}
		}
	}
}

//카운트 다운
class CountDown extends Thread{
	@Override
	public void run() {
		for(int i=5; i>=1; i--) {
			if(Input.inputCheck == true) return; 
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
		System.out.println("     -- 결 과 --    ");
		System.out.println("시간 초과로 당신이 졌습니다.");
		System.exit(0);
	}
}





