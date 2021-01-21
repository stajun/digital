package day16;

import java.util.ArrayList;
import java.util.Iterator;

public class ListEx3 {

	public static void main(String[] args) {
		ArrayList<Point3D> list = new ArrayList<Point3D>();
		Point3D p = new Point3D(0,0,0);
		list.add(p);
		//p.x = 1;
		p = new Point3D(1,0,0);
		list.add(p);
		
		Iterator<Point3D> it = list.iterator();
		while(it.hasNext()) {
			Point3D tmp = it.next();
			System.out.println(tmp);
		}
	}
}

class Point3D{
	int x,y,z;

	@Override
	public String toString() {
		return "Point3D [x=" + x + ", y=" + y + ", z=" + z + "]";
	}

	public Point3D(int x, int y, int z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
}