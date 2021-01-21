package review4;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Board {
	private int num;
	private static int count;
	private String title;
	private String contents;
	private String writer;
	private Date registerDate;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getRegisterDate() {
		SimpleDateFormat simpleFormat 
			= new SimpleDateFormat("yyyy-MM-dd");
		return simpleFormat.format(registerDate);
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	public Board() {
		++count;
		num = count;
		registerDate = new Date();
	}
	public Board(String title, String contents, String writer) {
		this();
		this.title = title;
		this.contents = contents;
		this.writer = writer;
	}
	public Board(Board board) {
		this.num = board.num;
		this.registerDate = board.registerDate;
		this.title = board.title;
		this.contents = board.contents;
		this.writer = board.writer;
	}
	public Board(int num) {
		this.num = num;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + num;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		//하나의 객체를 다른 두 참조변수가 공유
		if (this == obj)
			return true;
		//참조변수 obj가 객체와 연결이 안된 상태, 비교 대상이 없는 경우
		if (obj == null)
			return false;
		//generate hashCode() and equals()를 이용하면
		//기본적으로 클래스가 다르면 다르다고 판별하지만, Board클래스에서는
		//게시글 번호를 이용하여 같다 다를다를 판단하기 때문에
		//클래스가 Integer인 경우는 비교가 가능하도록 수정
		
		if (getClass() != obj.getClass()) {
			if(obj instanceof Integer) {
				if(num == (Integer)obj) {
					return true;
				}
			}else {
				return false;
			}
		}
			
		Board other = (Board) obj;
		if (num != other.num)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "게시글 [번호:" + num + ", 제목:" + title + 
				", 작성자:" + writer+ ", 등록일:" + getRegisterDate() + "]";
	}
	public void print() {
		System.out.println("------------------------");
		System.out.println("번호 : " + getNum());
		System.out.println("제목 : " + getTitle());
		System.out.println("작성자: " + getWriter());
		System.out.println("작성일: " + getRegisterDate());
		System.out.println("내용");
		System.out.println(getContents());
		System.out.println("------------------------");
	}
	public boolean equalsByOption(String str, String option) {
		//수정 제목
		if(option.equals("제목")) {
			/*if(title.indexOf(str)!=-1) {
				return true;
			}else {
				return false;
			}*/
			return title.indexOf(str) != -1 ? true : false;
		}else if(option.equals("내용")) {
			return contents.indexOf(str) != -1 ? true : false;
		}else if(option.equals("작성자")) {
			return writer.indexOf(str) != -1 ? true : false;
		}else {
			return false;	
		}
	}
}





