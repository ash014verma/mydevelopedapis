package com.ashish.java.util;

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
		int mid = -1;
		int low = 0;
		int high = a.length -1;
		while(low <= high) {
			mid = (low + high)/2;
			if(a[mid] == key) {
				return mid;
			}else if(a[mid] < key){
				low = mid + 1;
			}else {
				high = mid -1;
			}
		}
		return mid;
	}
}
