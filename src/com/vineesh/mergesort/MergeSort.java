package com.vineesh.mergesort;

public class MergeSort {
	
	private static Comparable[] aux;
	
	private static boolean less (Comparable a, Comparable b) {
		return a.compareTo(b) < 0;
	}
	
	public static void merge (Comparable[] array, int lo, int mid, int hi) {
		int i = lo;
		int m = mid+1;
		for (int l = lo; l <= hi; l++) {
			aux[l] = array[l]; 
		}
		
		for (int j = lo; j <= hi; j++) {
			if (lo > mid) {
				array[j] = aux[m++];				
			}
			else if (m > hi) {
				array[j] = aux[i++];
			}
			else if (less (aux[m], aux[lo])) {
				array[j] = aux [m++];
			}
			else {
				array [j] = aux [i++];
			}
		}
	}
	
	public static void sort(Comparable[] array, int lo, int hi) {
		if (hi <= lo)
			return;
		int mid = lo + (hi - lo)/2;
		sort (array, lo, mid);
		sort (array, mid + 1, hi);
		merge (array, lo, mid, hi);
	}
	
	public static void sort(Comparable[] array) {
		aux= new Comparable[array.length];
		sort (array, 0, array.length - 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Comparable[] array = {9, 8, 7, 6, 5, 4, 3};
			System.out.println("Array to sort : ");
			for (int i = 0; i < array.length; i++) {
				System.out.print(" "  + array [i]);
			}
			sort(array);
			System.out.println("\nSorted Array : ");
			for (int i = 0; i < array.length; i++) {
				System.out.print(" "  + array [i]);
			}
	}

}
