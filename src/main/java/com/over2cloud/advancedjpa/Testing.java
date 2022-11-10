/**
 * 
 */
package com.over2cloud.advancedjpa;

/**
 * @author Suraj.Singh
 *
 */
public class Testing {
	
	public static void main(String[] args) {
		// is prime or not 
		System.out.println(isprime(3));// True
		System.out.println(isprime(2));// false
		
	}
	
	public static boolean isprime(int input) {
		
		if(input==0 || input==1) {
			
			return false;
		}
		if(input == 2) {
			return true;
		}
		for (int i = 2; i < input/2; i++) {
			
			if(input%i==0) {
				return false;
			}
		}
		return true;
	}

}
