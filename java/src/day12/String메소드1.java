package day12;

public class String메소드1 {

	public static void main(String[] args) {
		String str = "Green Computer";
		//charAt(index) : index 번지에 있는 문자를 반환
		System.out.println("----charAt------");
		System.out.println(str.charAt(0));
		//compareTo(str): str문자열과 비교하여 같으면 0, 본인을 기준으로
		//사전순으로 앞이면-1,뒤면 1 
		System.out.println("----compareTo---");
		System.out.println("b".compareTo("b"));
		System.out.println("b".compareTo("a"));
		System.out.println("b".compareTo("c"));
		//concat : 이어 붙이기, +연산자와 같은 기능
		System.out.println("----concat------");
		System.out.println("Hello ".concat("wolrd"));
		System.out.println("Hello " + "wolrd");
		//equals : 두 문자열 같은지 다른지를 확인
		System.out.println("----equals------");
		System.out.println("Hello".equals("Hello"));
		System.out.println("Hello".equals("hello"));
		System.out.println("----indexOf-----");
		String str1 = "Hello world";
		char search1 = 'w';
		int index = str1.indexOf(search1);
		if(index >= 0) {
			System.out.println(str1 + " 문자열에는 " + search1 + "이(가) "+index
					+"번째 위치에 있습니다.");
		}
		String search2 = "world";
		index = str1.indexOf(search2);
		if(index >= 0) {
			System.out.println(str1 + " 문자열에는 " + search2 + "이(가) "+index
					+"번째 위치에 있습니다.");
		}
		index = str1.indexOf(search1,7);
		if(index >= 0) {
			System.out.println(str1 + " 문자열에는 " + search1 + "이(가) "+index
					+"번째 위치에 있습니다.");
		}else {
			System.out.println(str1 + " 문자열에는 " + search1 + "이(가) "+
					"7번째이후로는 찾을 수 없습니다.");
		}
		System.out.println("----replace----");
		System.out.println("Hello World World".replace('W', 'w'));
		System.out.println("Hello world world".replace("world", "java"));
		System.out.println("----split-----");
		String[] arr = "dog,cat,tiger".split(",");
		for(String tmp : arr) {
			System.out.println(tmp);
		}
		System.out.println("----join----");
		System.out.println(String.join(",", arr));
		System.out.println("----substring----");
		String fileName ="String메소드.java";
		int index2 = fileName.lastIndexOf('.');
		String suffix = fileName.substring(index2+1);
		System.out.println(fileName +"의 확장자 : " + suffix);
		System.out.println("----trim---------");
		System.out.println("    Hello    ".trim());
		System.out.println("----valueOf------");
		System.out.println(String.valueOf(1.23));
		String str3 = ""+123;
		int num1 = Integer.parseInt(str3);
		System.out.println(num1);
		int num2 = Integer.valueOf(str3);
		System.out.println(num2);
	}

}
