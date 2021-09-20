package com.greatlearning.denominations;

import java.util.Scanner;

public class Denomination {

	public static void mergeSort(int array[], int first, int last) {

		if (first < last) {

			int mid = (first + last) / 2;
			mergeSort(array, first, mid);
			mergeSort(array, mid + 1, last);
			merge(array, first, mid, last);
		}
	}

	private static void merge(int[] array, int first, int mid, int last) {
		int n1 = mid - first + 1;
		int n2 = last - mid;
		int left[] = new int[n1]; 
		int right[] = new int[n2]; 

		for (int i = 0; i < n1; i++) {
			left[i] = array[first + i];
		}
		for (int i = 0; i < n2; i++) {
			right[i] = array[mid + 1 + i];
		}

		int i = 0, j = 0, k = first;

		while (i < n1 && j < n2) {
			if (left[i] >= right[j]) {
				array[k] = left[i];
				i++;
			} else {
				array[k] = right[j];
				j++;
			}
			k++;
		}
		while (i < n1) {
			array[k] = left[i];
			i++;
			k++;
		}
		while (j < n2) {
			array[k] = right[j];
			j++;
			k++;
		}

	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number of denominations : ");
		int NoOfDen = scanner.nextInt();
		int[] denArray = new int[NoOfDen];
		System.out.println("Enter the currency denominations value : ");
		for (int i = 0; i < NoOfDen; i++) {
			denArray[i] = scanner.nextInt();
		}
		mergeSort(denArray, 0, denArray.length - 1);
		System.out.println("Enter the amount you want to pay : ");
		int amount = scanner.nextInt();
		System.out.println("Your payment approach in order to give min no of notes will be : ");
		for (int i = 0; i < denArray.length; i++) {
			if (amount >= denArray[i]) {
				int notes = amount / denArray[i];
				System.out.println(denArray[i] + " : " + notes);
				amount = amount % denArray[i];
			}
		}
		if (amount > 0)
			System.out.println("Remaining Amount : " + amount);

		scanner.close();
	}
}
