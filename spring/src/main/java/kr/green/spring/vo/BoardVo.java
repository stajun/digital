package kr.green.spring.vo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BoardVo {
	private int num;
	private String title;
	private String content;
	private String writer;
	private String isDel;
	private Date registerDate;
	private int views;
	
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getIsDel() {
		return isDel;
	}
	public void setIsDel(String isDel) {
		this.isDel = isDel;
	}
	public String getRegisterDate() {
		SimpleDateFormat simpleFormat 
			= new SimpleDateFormat("yyyy-MM-dd");
		String dateString = simpleFormat.format(registerDate);
		return dateString;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	public void setRegisterDate(String registerDate) throws ParseException {
		SimpleDateFormat simpleFormat2
			= new SimpleDateFormat("yyyy-MM-dd");
		Date date2 = simpleFormat2.parse(registerDate);

		this.registerDate = date2;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	@Override
	public String toString() {
		return "BoardVo [num=" + num + ", title=" + title + ", content=" + content + ", writer=" + writer + ", isDel="
				+ isDel + ", registerDate=" + registerDate + ", views=" + views + "]";
	}
	
}
