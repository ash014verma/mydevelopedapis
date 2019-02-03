package com.ashish.java.util;

import java.util.Arrays;

/**
 * @author ashish verma
 *
 */

public final class ArraysUtil {

	// Suppresses default constructor, ensuring non-instantiability.
	private ArraysUtil() {}
	/*rotates the array a of size n by d elements*/

	/**
	 * rotates the array <b>a of size <b>n by <b>d elements
	 * @param a
	 * @param d
	 * @param n
	 */
	public static int[] rotate(int[] a, int d, int n) {
		int[] b = new int[n];
		for(int i= 0, j= d; i< n- d && j< a.length; i++, j++) {
			b[i]= a[j];
		}
		for(int i= n- d, j = 0; i< a.length && j< d; i++, j++) {
			b[i]= a[j];
		}
		return b;
	}
	/*cyclically rotate the array a clockwise by one*/

	/**
	 * cyclically rotate the array <b>a clockwise by one
	 * @param a
	 * @return
	 */
	public static int[] cyclicRotateByOne(int[] a) {
		int[] c = new int[a.length];
		for(int i= 0; i< a.length-1; i++) {
			c[i+1]= a[i];
		}
		c[0] = a[a.length -1];
		return c;
	}
	public static int searchInSortedRotatedArray(int[] a, int key) {
		int pivot = getThePivotInSortedRotatedArray(a);
		int index = binarySearch(a, 0, pivot, key);
		if(index == -1){
			int partSecIndex = (partSecIndex = binarySearch(a, pivot + 1, a.length -1, key) ) != -1 ? index = partSecIndex + pivot : -1;
		}
		return index;
	}

	public static int binarySearch(int[] a, int key) {
		return binarySearch(a, 0, a.length -1, key);
	}
	public static int binarySearch(int[] a, int startIndex, int endIndex, int key) {
		checkRange(a.length, startIndex, endIndex);
		int low = startIndex;
		int high = endIndex;
		while(low <= high) {
			int mid = (low + high)/2;
			if(a[mid] > key) {
				high = mid -1;
			}else if(a[mid] < key){
				low = mid + 1;
			}else {
				return mid;
			}
		}
		return -1;
	}
	private static void checkRange(int arrLength, int startIndex, int endIndex) {
		if(startIndex > endIndex) {
			throw new IllegalArgumentException("startIndex(" + startIndex + ") > endIndex(" + endIndex + ")");
		}
		if(startIndex < 0) {
			throw new ArrayIndexOutOfBoundsException(startIndex);
		}
		if(endIndex > arrLength) {
			throw new ArrayIndexOutOfBoundsException(endIndex);
		}
	}

	private static int getThePivotInSortedRotatedArray(int[] a) {
		int max= a[0];
		int k = 0;
		for(int i = 0 ; i< a.length ; i++ ) {
			if(max < a[i]) {
				max = a[i];
				k = i;
			}
		}
		return k ;
	}
}
