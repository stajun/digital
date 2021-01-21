package day13;

/* 학생(Student) 클래스를 생성하세요. 단, 클래스는 새로 만들기를 이용하여 만드세요.
 *  - 학생클래스의 필요한 멤버 변수/메소드를 생성하세요.
 *  - 학생 클래스 	: 학생 1명의 정보를 나타내는 클래스 
 *  - 멤버 변수  	: 학생이름, 주민번호, 학번, 학부, 학과, 수강과목들, 
 *  						  학기(현재학생이 수료한 학기)	 
 *  - 멤버 메소드 	: 
 *    - getter/setter
 *    - print() 
 *    - 수강 과목 추가
 *    - 수강 과목 삭제
 *    - 수강 과목 복사(private) : 수강 과목 추가시 배열이 다 차있으면 배열의 크기를 늘림
 *    - equals() : 오버라이딩
 *  - 생성자 
 * */
public class Student {
	private String name;
	private String residentNum;
	private String studentNum;
	private String faculty;
	private String major;
	private Subject[] subjectList;
	private int term;
	private int subjectCount;
	
	public void insertSubject(Subject subject) {
		//현재 수강한 과목의 개수를 모를 때 
		/*
		for(int i = 0; i<subjectList.length; i++) {
			if(subjectList[i] == null) {
				subjectList[i] = subject;
				break;
			}
		}*/
		//배열이 꽉찬 경우
		if(subjectCount == subjectList.length) {
			//배열을 늘려주고 복사하는 작업
			Subject [] tmp = new Subject[subjectCount+20];
			System.arraycopy(subjectList, 0, tmp, 0, subjectList.length);
			subjectList = tmp;
		}
	
		subjectList[subjectCount] = subject;
		subjectCount++;
	
	}
	public void deleteSubject(String subjectTitle) {
		int index = -1;//삭제할 과목이 있는 배열의 위치
		if(subjectTitle == null) {
			return ;
		}
		for(int i = 0 ; i<subjectCount; i++) {
			if(subjectTitle.equals(subjectList[i].getSubjectTitle())) {
				index = i;
				break;
			}
		}
		if(index == -1)
			return ;
		for(int i=index; i<subjectCount-1; i++) {
			subjectList[i] = subjectList[i+1]; 
		}
		subjectList[subjectCount-1] = null;
		subjectCount--;
	}
	public void print() {
		if(subjectCount == 0)
			System.out.println("--수강한 과목이 없습니다.--");
		for(int i = 0; i<subjectCount; i++) {
			System.out.println(subjectList[i]);
		}
	}
	public Student(String name, String residentNum, String studentNum, String faculty, String major, int term) {
		super();
		this.name = name;
		this.residentNum = residentNum;
		this.studentNum = studentNum;
		this.faculty = faculty;
		this.major = major;
		this.term = term;
		subjectList = new Subject[2];
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getResidentNum() {
		return residentNum;
	}
	public void setResidentNum(String residentNum) {
		this.residentNum = residentNum;
	}
	public String getStudentNum() {
		return studentNum;
	}
	public void setStudentNum(String studentNum) {
		this.studentNum = studentNum;
	}
	public String getFaculty() {
		return faculty;
	}
	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public Subject[] getSubjectList() {
		return subjectList;
	}
	public void setSubjectList(Subject[] subjectList) {
		this.subjectList = subjectList;
	}
	public int getTerm() {
		return term;
	}
	public void setTerm(int term) {
		this.term = term;
	}
	@Override
	public String toString() {
		return "이름 : " + name + "\n주민번호 : " + residentNum 
				+ "\n학번 : " + studentNum + "\n학부 : "
				+ faculty + "\n전공 : " + major + "\n학기 : " 
				+ term + "\n수강과목수 : " + subjectCount + "";
	}
	
}
