package com.skbr.arrays;

public class MajorityElementInArray {
	
	public static int majority1(int arr[]) {
		
		for(int i = 0; i < arr.length - 1 ; ++i) {
			int majority = arr[i];
			int count = 1;
			for(int j = i+1; j <arr.length; ++j ) {
				if(arr[j] == majority) {
					++count;
				}
			}
			
			if(count > arr.length/2) 
				return majority;
		}
		
		return -1;
	}
	
	public static int majority2(int arr[]) {

		/*
		 * This is Moor's voting algo. 
		 * 
		 * 	- Assume that the first element is the majority one
		 * 	- Traverse and check the remaining elements in the array
		 * 	- In case of a match , increment the count
		 * 	- In case of mismatch, decrement the count
		 * 	- If the count hits 0, then the assumed element is not the majority
		 * 	- Select a new element as majority and then reset count to 1
		 */
		int majority = findPotentialMajorityCandidate(arr);
		
		/*
		 * 	- After fetching potential element as majority, actually count the number of 
		 * 	  times it occurs
		 * 	- If greater than n/2, then this is a majority element
		 */
		int count = 0;
		for(int i = 0; i<arr.length ; ++i) {
			if(arr[i] == majority) {
				++count;
			}
			
			if(count > arr.length/2) {
				return majority;
			}
		}
		return -1;
	}

	private static int findPotentialMajorityCandidate(int arr[]) {
		int majority = arr[0];
		int count = 1;
		
		for(int i = 1; i < arr.length; ++i) {
			
			if(arr[i] == majority) {
				++count;
			} else {
				--count;
			}
			
			if(count ==0) {
				majority = arr[i];
				count = 1;
			}
		}
		
		return majority;

	}
	public static void main(String[] args) {
		
		int arr[] = new int[] {1,2,2};
		
		System.out.println("Majority: " + majority1(arr));
		System.out.println("Majority: " + majority2(arr));

	}

}
