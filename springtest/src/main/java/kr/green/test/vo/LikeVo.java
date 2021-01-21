package kr.green.test.vo;

public class LikeVo {
	private int num;
	private int boardNum;
	private String id;
	private int up;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getUp() {
		return up;
	}
	public void setUp(int up) {
		this.up = up;
	}
	@Override
	public String toString() {
		return "LikeVo [num=" + num + ", boardNum=" + boardNum + ", id=" + id + ", up=" + up + "]";
	}
}
