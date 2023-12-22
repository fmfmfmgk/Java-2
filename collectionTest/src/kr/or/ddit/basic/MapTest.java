package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class MapTest {
	public static void main(String[] args) {
		/*
		 *  - Map =>key값과, value값을 한 쌍으로 관리하는 객체
		 *  - key값은 중복을 허용하지 않고 순서도 없다. ==> Set의 특징을 갖는다.
		 *  - value값은 중복을 허용한다.
		 */
		
		HashMap<String,String> map = new HashMap<String, String>();
		
		//자료 추가 ==> put(key값, value값)
		map.put("name", "홍길동");
		map.put("addr", "대전");
		map.put("tel", "010-1234-5678");
		
		System.out.println("map =>" + map);
	
		
		//자료 수정 ==> 데이터를 추가할때 key값이 같으면 나중에 추가한 내용이 저장된다.
		map.put("addr", "서울");
		System.out.println("map =>" + map);
	
		//자료 삭제 => remove(key값) ==> key값이 같은 자료를 찾아서 삭제한다.
		//		=> 반환값: 삭제된 자료의 value값
		
//		String removeTel = map.remove("tel");
//		System.out.println("map =>" + map);
//		System.out.println(removeTel);
		
		//자료읽기 => get(key값)
		//		=> 반환값: 주어진 'key값'가 짝이 되는 value값을 반환한다.
		//		주어진 'key값'이 없으면 null값을 반환.
		System.out.println("이름: "+ map.get("name"));
		
		//key값이 존재하는지 여부를 나타내는 메소드 => containskey(key값)
		//		=> 해당 키값이 있으면 true, 없으면 false 반환
		
		System.out.println("tel의 존재여부: "+ map.containsKey("tel"));
		System.out.println("age의 존재여부: "+ map.containsKey("age"));
		
		//map에 저장된 모든 데이터를 차례로 읽어와 사용하는 방법
		
		//1. 모든 key값을 읽어와 처리하기 => keySet()메소드 이용하기
		// keySet()메소드 => Map의 모든 Key값들을 읽어와 Set형으로 반환한다.
		
		Set<String> keySet = map.keySet();
		
		//방법1
		Iterator<String> it = keySet.iterator();
		while(it.hasNext()) {
			String key = it.next();// key값 구하기
			String value = map.get(key);
			System.out.println(key+" ==> "+ value);
		}
		System.out.println("-------------------------------------------");
		
		//방법2
		for (String key : keySet) {
			String value = map.get(key);
			System.out.println(key+" : "+value);
		}
		System.out.println("-------------------------------------------");
		
		//방법3. 모든 value값들만 읽어와 처리하기 ==> values()메소드 이용
		for (String value : map.values()) {
			System.out.println(value);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}	
}	
