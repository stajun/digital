package review4;

import java.util.*;

public class BoardMain2 {
	private static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		ArrayList<Board> list = new ArrayList<Board>();
		int menu = 6;
		
		do {
			printMenu();
			menu = scan.nextInt();
			int num , subMenu;
			switch(menu) {
			case 1:
				addBoard(list);
				break;
			case 2:
				System.out.println("-------------------------");
				System.out.println("1. 번호 조회");
				System.out.println("2. 제목 조회");
				System.out.println("3. 내용 조회");
				System.out.println("4. 작성자 조회");
				System.out.println("-------------------------");
				System.out.print("조회 종류 선택 : ");
				subMenu = scan.nextInt();

				switch(subMenu) {
				case 1:
					printString("조회하려는 게시글 번호를 입력하세요");
					System.out.print("번호 : ");
					num = scan.nextInt();
					//입력한 번호에 맞는 게시글이 있는지 리스트에서 확인
					printBoardByNum(list, num);
					break;
				case 2:
					printBoard(list,"제목");
					break;
				case 3:
					printBoard(list,"내용");
					break;
				case 4:
					printBoard(list,"작성자");
					break;
				default:
					printString("잘못된 조회 방법입니다.");
					break;
				}
				break;
			case 3:
				printString("수정하려는 게시글 번호를 입력하세요");
				System.out.print("번호 : ");
				num = scan.nextInt();
				modifyBoardByNum(list, num);
				break;
			case 4:
				printString("삭제하려는 게시글 번호를 입력하세요");
				System.out.print("번호 : ");
				num = scan.nextInt();
				deleteBoardByNum(list, num);
				break;
			case 5:
				for(Board tmp : list) {
					System.out.println(tmp);
				}
				if(list.size() == 0) {
					printString("등록된 게시물이 없습니다.");
				}
				break;
			case 6:
				break;
			default:
				printString("잘못된 메뉴입니다.");
			}
		}while(menu != 6);
		scan.close();
	}
	
	public static void printMenu() {
		System.out.println("---------------");
		System.out.println("1. 게시글 등록");
		System.out.println("2. 게시글 조회");
		System.out.println("3. 게시글 수정");
		System.out.println("4. 게시글 삭제");
		System.out.println("5. 게시글 목록");
		System.out.println("6. 프로그램 종료");
		System.out.println("---------------");
		System.out.print("메뉴 선택 (1~6) : ");
	}
	
	public static void addBoard(ArrayList<Board> list){
		if(list == null) {
			throw 
			new NullPointerException("게시글 리스트가 생성되지 않았습니다");
		}
		printString("새로운 게시글 정보를 입력하세요");
		System.out.print("제목 : ");
		scan.nextLine();
		String title = scan.nextLine();
		System.out.print("내용 : ");
		String contents = scan.nextLine();
		System.out.print("작성자 : ");
		String writer = scan.next();
		Board tmpBoard = new Board(title,contents, writer);
		System.out.println(tmpBoard);
		list.add(tmpBoard);
	}
	
	public static void printBoardByNum(ArrayList<Board>list, int num){
		int index = list.indexOf(new Board(num)); 
		if(index != -1) {
			Board tmpBoard = list.get(index);
			tmpBoard.print();
			
		}else {
			printString("해당 번호와 일치하는 게시글이 없습니다.");
		}
	}
	
	public static void deleteBoardByNum(ArrayList<Board>list,int num) {
		int index = list.indexOf(new Board(num));
		if(index != -1) {
			list.remove(index);
			printString("게시글이 삭제되었습니다.");
		}
		else {
			printString("해당 번호와 일치하는 게시글이 없습니다.");
		}
	}
	
	public static void modifyBoardByNum(ArrayList<Board> list, int num) {
		int index = list.indexOf(new Board(num));
		if(index != -1) {
			printString("수정할 게시글 정보를 입력하세요");
			System.out.print("제목 : ");
			scan.nextLine();//엔터처리
			String title = scan.nextLine();
			System.out.print("내용 : ");
			String contents = scan.nextLine();
			Board tmpBoard = list.get(index);
			tmpBoard.setTitle(title);
			tmpBoard.setContents(contents);
		}
		else {
			printString("해당 번호와 일치하는 게시글이 없습니다.");
		}
	}
	
	public static void printBoard(ArrayList<Board>list, String option) {
		printString("조회하려는 게시글 "+option+"을 입력하세요");
		System.out.print(option+" : ");
		scan.nextLine();//서브메뉴 입력 후 엔터 처리
		String str = scan.nextLine();
		int count = 0;
		for(Board tmp : list) {
			if(tmp.equalsByOption(str, option)) {
				System.out.println(tmp);
				count++;
			}
		}
		if(count == 0) {
			printString("일치하는 게시물이 없습니다.");
		}
	}
	public static void printString(String str) {
		int length = str.length();
		length = length % 10 == 0 ? length / 10 : length / 10  + 1;
		length *= 10;
		for(int i = 0; i<length; i++)
			System.out.print('-');
		System.out.println();
		System.out.println(str);
		for(int i = 0; i<length; i++)
			System.out.print('-');
		System.out.println();
	}
}














