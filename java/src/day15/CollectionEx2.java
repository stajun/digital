package day15;

import java.util.ArrayList;

public class CollectionEx2 {

	public static void main(String[] args) {
		ArrayList<Point> list = new ArrayList<Point>();
		list.add(new Point(1,1));
		list.add(new Point(1,2));
		list.add(new Point(1,3));
		list.add(new Point(2,3));
		list.add(new Point(3,3));
		list.remove(new Point(1,1));
		printList(list);
		System.out.println(list.indexOf(new Point(3,3)));
	}
	public static void printList(ArrayList list) {
		for(Object tmp : list) {
			System.out.println(tmp);
		}
	}
}

class Point{
	int x,y;
	
	public Point(int x, int y) {
		this.x=x;
		this.y=y;
	}
	public String toString() {
		return "("+x+","+y+")";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	
}
