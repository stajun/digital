package day16;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class ListEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Point> list = new ArrayList<Point>();
		list.add(new Point(0,0));
		list.add(new Point(1,0));
		list.add(new Point(1,1));
		list.add(new Point(1,2));
		list.add(new Point(2,2));
		list.add(new Point(2,1));
		list.add(new Point(2,0));
		list.add(new Point(1,0));
		list.add(new Point(0,0));
		
		list.sort(new Point(0,0));
		
		Iterator<Point> it = list.iterator();
		while(it.hasNext()) {
			Point tmp = it.next();
			System.out.println(tmp);
		}
	}

}

class Point implements Comparator<Point>{
	int x, y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
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

	@Override
	public int compare(Point o1, Point o2) {
		if(o1.x > o2.x)
			return 1;
		if(o1.x < o2.x)
			return -1;
		if(o1.y > o2.y)
			return 1;
		if(o1.y < o2.y)
			return -1;
		return 0;
	}

	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}
	
	
}