package review2;

import java.util.HashMap;
import java.util.Iterator;

public class Test07 {

	public static void main(String[] args) {
		HashMap<String,String> map = new HashMap<String, String>();
		map.put("2020160001", "홍길동");
		map.put("2020160002", "임꺽정");
		
		Iterator<String> it = map.keySet().iterator();
		while(it.hasNext()) {
			String key = it.next();
			String value = map.get(key);
			System.out.println("학번 : " + key + ", 이름 : " + value);
		}
		
	}
	
}
