package kr.or.ddit.basic.homework;

import java.util.Arrays;

public class CTest01 {
	public static void main(String[] args) {
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2,5,3},{4,4,1},{1,7,3}};
		int[] a1 = new int [3];
		int[] a2 = new int [3];
		int[] a3 = new int [3];
		
		
		for (int i = 0; i < commands.length; i++) {
			for (int j = 0; j < commands.length; j++) {
				System.out.println(commands[i][j]);
				a1 = new int [j];
			}
		}
		System.out.println(a1[2]);
	}
}
