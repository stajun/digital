package day13;

import java.util.Scanner;

/* - 모든 학생 정보 출력 기능
 * - 학생 등록 기능
 * - 학생 검색 기능
 * - 수강 등록 기능
 * - 수강 철회 기능
 * */
public interface Program {
	
	void printStudent();
	void insertStudent(Scanner scan);
	void searchStudent(Scanner scan);
	void registerSubject(Scanner scan);
	void deleteSubject(Scanner scan);
	
}
