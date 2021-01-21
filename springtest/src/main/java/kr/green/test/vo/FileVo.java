package kr.green.test.vo;

public class FileVo {
	private int num;
	private int boardNum;
	private String oriFilename;
	private String filename;
	private String isDel;
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
	public String getOriFilename() {
		return oriFilename;
	}
	public void setOriFilename(String oriFilename) {
		this.oriFilename = oriFilename;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getIsDel() {
		return isDel;
	}
	public void setIsDel(String isDel) {
		this.isDel = isDel;
	}
	@Override
	public String toString() {
		return "FileVo [num=" + num + ", boardNum=" + boardNum + ", oriFilename=" + oriFilename + ", filename=" + filename
				+ ", isDel=" + isDel + "]";
	}
	
}
