package day16;

public class GenericsEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Array<Integer> arr = new Array<Integer>(new Integer[10]);
		arr.set(0, 10);
		System.out.println(arr.get(0));
		Array<Character> arr2 = new Array<Character>(new Character[10]);
		arr2.set(0, 'a');
		System.out.println(arr2.get(0));
	}

}

class Array<T>{
	T arr[];
	public Array(T[] arr) {
		this.arr = arr;
	}
	public Array() {}
	public T get(int i) {
		if(arr.length > i)
			return arr[i];
		else 
			return null;
	}
	public void set(int index , T value) {
		if(arr.length > index)
			arr[index] = value;
	}
}
