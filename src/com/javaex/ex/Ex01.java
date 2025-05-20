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
		
		System.out.println("***********************************");
		System.out.println("*" + "\t" + "전화번호 관리 프로그램" + "\t" + "  *");
		System.out.println("***********************************");
		
		System.out.println("1.리스트  2.등록  3.삭제  4.검색  5.종료");
		System.out.println("------------------------------------------");
		System.out.print(">메뉴번호:");
		int menu = sc.nextInt();
		
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
			
			if(menu == 1) {
				System.out.println("1.리스트");
				
			}
			//System.out.println(str);
		}
		

		
		
		
		
		sc.close();
		br.close();
	}
	
	
}
