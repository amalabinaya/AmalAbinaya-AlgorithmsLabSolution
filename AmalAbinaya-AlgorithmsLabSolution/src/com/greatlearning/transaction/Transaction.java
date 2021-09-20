package com.greatlearning.transaction;

import java.util.Scanner;

public class Transaction {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the size of transaction array");
		int size = scanner.nextInt();
		int[] transactionArray = new int[size];
		for (int i = 0; i < size; i++) {
			System.out.println("Enter the value of " + (i + 1) + " transaction");
			transactionArray[i] = scanner.nextInt();
		}
		System.out.println("Enter the total no of targets that needs to be achieved: ");
		int noOfTargets = scanner.nextInt();
		int sum = 0;
		for (int i = 0; i < noOfTargets; i++) {
			System.out.println("Enter the value of Target: ");
			int target = scanner.nextInt();

			for (int j = 0; j < size; j++) {
				sum = sum + transactionArray[i];
				if (sum >= target) {
					System.out.println("Target is achieved after " + (j + 1) + " transactions");
					break;
				}
			}
			if (sum < target) {
				System.out.println("Target not achieved");
			}
		}
		scanner.close();
	}

}


