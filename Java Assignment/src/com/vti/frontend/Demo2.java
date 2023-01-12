package com.vti.frontend;

public class Demo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// if else
		int a = 2;
		// condition => boollean => true or false
		if (a == 1) {
			System.out.println("bạn vừa nhập vào số 1");
		} else {
			System.out.println("bạn vừa nhập vào số khac 1");
		}
		int b = 3;
		// condition => boollean => true or false
		if (b == 3) {
			System.out.println("bạn vừa nhập vào số 1");
		} else if (b == 2) {
			System.out.println("bạn vừa nhập vào số 2");
		} else {
			System.out.println("bạn vừa nhập vào số khac 1");
		}
		// Toán tử tenary, toán tử 3 ngôi ==> cách viết tắt khi sử dụng if else
		System.out.println("----------------tenary----------------");
		System.out.println(b == 3 ? "bạn vừa nhập vào số 3" : "bạn vừa nhập vào số khac 3");
		// vong lap while
		int i = 1;
		while (i <= 10) {
			System.out.println(i);
			i = i + 1;
		}

//		
	}
}
