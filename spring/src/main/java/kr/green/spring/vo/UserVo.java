package kr.green.spring.vo;

public class UserVo {
	private String id;
	private String pw;
	private String pw2;
	private String email;
	private String home;
	private String name;
	private Integer age;
	private int author;
	
	
	
	public int getAuthor() {
		return author;
	}
	public void setAuthor(int author) {
		this.author = author;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getPw2() {
		return pw2;
	}
	public void setPw2(String pw2) {
		this.pw2 = pw2;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getHome() {
		return home;
	}
	public void setHome(String home) {
		this.home = home;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "UserVo [id=" + id + ", pw=" + pw + ", pw2=" + pw2 + ", email=" + email + ", home=" + home + ", name=" + name
				+ ", age=" + age + ", author=" + author + "]";
	}
	public String getTest() {
		return "테스트입니다";
	}
}
