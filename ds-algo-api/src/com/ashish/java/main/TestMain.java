package com.ashish.java.main;

import com.ashish.java.util.ArraysUtil;

public class TestMain {

	public static void main(String[] args) {
		int a[] = {1, 2, 3, 4, 5};
		int[] b = ArraysUtil.rotate(a, 2, 4);
		for(int i=0; i< 4; i++) {
		 	System.out.print(b[i] + " ");
		}
		System.out.println("\n");
		/*int[] c = ArraysUtil.cyclicRotateByOne(a);
		for(int i=0; i< c.length; i++) {
		 	System.out.print(c[i] + " ");
		}*/
		int key = 1;
		System.out.println(ArraysUtil.searchInSortedRotatedArray(b, key));
	}

}
