package org.johnnei;

import java.util.ArrayList;

public class StringUtil {
	
	public static void printArray(ArrayList<?> arr) {
		System.out.print("{");
		for(int i = 0; i < arr.size(); i++) {
			System.out.print(arr.get(i));
			if(i + 1 < arr.size()) {
				System.out.print(", ");
			}
		}
		System.out.println("}");
	}
	
	public static void printArray(Object[] arr) {
		System.out.print("{");
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ,");
		}
		System.out.println("}");
	}
	
	public static void printArray(int[] arr, int begin, int length) {
		System.out.print("{");
		for(int i = begin; i < length; i++) {
			System.out.print(arr[i]);
			if(i + 1 < length) {
				System.out.print(", ");
			}
		}
		System.out.println("}");
	}
	
	public static void printArray(int[] arr) {
		printArray(arr, 0, arr.length);
	}

}
