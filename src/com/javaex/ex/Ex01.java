package com.javaex.ex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) throws IOException{
		
		List<Person> pList = new ArrayList<Person>();
		
		Reader fr = new FileReader("C:\\javaStudy\\PhoneDB.txt");
		BufferedReader br = new BufferedReader(fr);
		
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		
		System.out.println("******************************************");
		System.out.println("*" + "\t" + "전화번호 관리 프로그램" + "\t\t *");
		System.out.println("******************************************");
		
		while(true) {
			
			String str = br.readLine();
			
			if(str == null) {
				break;
			}
		
			String[] sArray = str.split(",");
			
			String name = sArray[0];
			String hp = sArray[1];
			String company = sArray[2];
			
			Person p = new Person(name, hp, company);
			pList.add(p);

		}

		while(run) {
			System.out.println("");
			System.out.println("1.리스트  2.등록  3.삭제  4.검색  5.종료");
			System.out.println("------------------------------------------");
			System.out.print(">메뉴번호:");
			
			int menuNo = sc.nextInt();
			
			switch(menuNo) {
			
				case 1:
					System.out.println("<1.리스트>");	
					
					for(int i=0; i<pList.size(); i++) {
						System.out.print((i + 1) + "." + "\t"); //문자 앞에 번호넣기
						pList.get(i).showInfo();
					}
					break;
					
				case 2: //등록 완료 시 저장 기능
					System.out.println("<2.등록>");
					sc.nextLine();
					System.out.print(">이름: ");
					String signName = sc.nextLine();
					System.out.print(">휴대전화: ");
					String signHp = sc.nextLine();
					System.out.print(">회사전화: ");
					String signCompany = sc.nextLine();
					System.out.println("[등록되었습니다.]");
					break;
					
				case 3: //입력 번호 정보 삭제 기능
					System.out.println("<3.삭제>");
					System.out.print(">번호: ");
					int deleteNo = sc.nextInt();
					System.out.println("[삭제되었습니다.]");
					break;
					
				case 4: //키워드(이름) 입력시 해당 리스트 출력 기능
					System.out.println("<4.검색>");
					System.out.print(">이름: ");
					String searchName = sc.nextLine();
					break;
					
				case 5:
					System.out.println("");
					System.out.println("******************************************");
					System.out.println("*" + "\t\t" + "감사합니다" + "\t\t" + " *");
					System.out.println("******************************************");
					run = false;
					break;
					
				default:				
					System.out.println("[다시 입력해 주세요.]");
					break;
					
			}//switch
			
		}//while
		
		
		
		sc.close();
		br.close();
	}
	
	
}
