package com.javaex.ex;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) throws IOException{
		
		List<Person> pList = new ArrayList<Person>();
		
		//학원 컴퓨터 경로 "C:\\javaStudy\\PhoneDB.txt"
		//mac 경로 "/Users/kangsubin/Desktop/javaStudy/PhoneDB.txt"
		Reader fr = new FileReader("C:\\javaStudy\\PhoneDB.txt");
		BufferedReader br = new BufferedReader(fr);
		
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

		Scanner sc = new Scanner(System.in);
		boolean run = true;
		
		while(run) {
			System.out.println("");
			System.out.println("1.리스트  2.등록  3.삭제  4.검색  5.종료");
			System.out.println("------------------------------------------");
			System.out.print(">메뉴번호:");
			
			int menuNo = sc.nextInt();
			
			switch(menuNo) {
			
				case 1: //리스트 출력 => 등록, 삭제 할 때마다 없데이트 돼서 출력 돼야함
					System.out.println("<1.리스트>");	
					
					for(int i=0; i<pList.size(); i++) {
						System.out.print((i + 1) + "." + "\t"); //문자 앞에 번호넣기
						pList.get(i).showInfo();
					}
					break;
					
					
				case 2: //등록 => 완료 시 저장 기능
					System.out.println("<2.등록>");
					sc.nextLine();
					System.out.print(">이름: ");
					String signName = sc.nextLine();
					System.out.print(">휴대전화: ");
					String signHp = sc.nextLine();
					System.out.print(">회사전화: ");
					String signCompany = sc.nextLine();
					
					//리스트 추가///////////////////////////////////
					Person newP = new Person(signName, signHp, signCompany);
					pList.add(newP);
					
					//파일에 저장///////////////////////////////////
					Writer fw = new FileWriter("C:\\javaStudy\\PhoneDB.txt");
					BufferedWriter bw = new BufferedWriter(fw);
					
					for(Person p : pList) {

						bw.write(p.getName() + "," + p.getHp() + "," + p.getCompany());
						bw.newLine();
						bw.flush();
					}
					
					System.out.println("[등록되었습니다.]");
					
					bw.close();
					break;
					
					
				case 3: //삭제 => 입력 번호 정보 삭제 기능
					System.out.println("<3.삭제>");
					System.out.print(">번호: ");
					int deleteNo = sc.nextInt(); //삭제할 번호 입력 
					
					// remove 
					if(deleteNo > 0 && deleteNo <= pList.size()) { // 삭제 입력 가능 번호 => 1 ~ pList.size()
					//방은 0부터인데,,,, 흠
					//deleteNo=i --> 1=0 2=1 3=2 4=3 1씩 차이남
						pList.remove(deleteNo - 1); //유레카
						System.out.println("[삭제되었습니다.]");
			
					}else { // 번호 잘못 입력했을 때 
						System.out.println("[번호를 다시 입력해 주세요.]");
					}

					// 파일 전체 저장 
					Writer removefw = new FileWriter("C:\\javaStudy\\PhoneDB.txt");
					BufferedWriter removebw = new BufferedWriter(removefw);
					
					for(Person p : pList) {

						removebw.write(p.getName() + "," + p.getHp() + "," + p.getCompany());
						removebw.newLine();
						removebw.flush();
					}
					
					removebw.close();
					break;
					
					
				case 4: //검색 => 키워드(이름) 입력시 해당 리스트 출력 기능
					//trip => 문자열 양쪽 끝 공백 생략
					//replace => 문자열 특정 문자 다른 문자로 변경
					// chatAt => 문자열 특정 위치 한 글자 (출력)
					System.out.println("<4.검색>");
				    sc.nextLine(); 
					System.out.print(">이름: ");
					String searchName = sc.nextLine().trim(); //공백 생략
					
					//////////////////////////////////////////////////////
				    boolean found = false; // 검색 결과 존재 여부

				    for (int i = 0; i < pList.size(); i++) {
				        Person p = pList.get(i);
				        if (p.getName().contains(searchName)) { // 부분 일치 검색
				            System.out.print((i + 1) + ".\t");
				            p.showInfo();
				            found = true;
				        }
				    }

				    if (!found) {
				        System.out.println("[검색 결과가 없습니다.]");
				    }
				    //////////////////////////////////////////////////////
				    
					break;
					
					
				case 5: //종료
					System.out.println("");
					System.out.println("******************************************");
					System.out.println("*" + "\t\t" + "감사합니다" + "\t\t\t" + " *");
					System.out.println("******************************************");
					run = false;
					break;
					
				default: // 다른 번호 입력 시 재입력 
					System.out.println("[다시 입력해 주세요.]");
					break;
					
			}//switch
			
		}//while
		
		
		
		sc.close();
		br.close();
	}
	
	
}
