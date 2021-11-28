package _00_Intro_To_ArrayLists;

import java.util.ArrayList;

public class _01_IntroToArrayLists {
	public static void main(String[] args) {
		// 1. Create an array list of Strings
		// Don't forget to import the ArrayList class
		ArrayList<String> names = new ArrayList<String>();
		// 2. Add five Strings to your list
		names.add("Jack");
		names.add("Jeff");
		names.add("Bob");
		names.add("Dan");
		names.add("Logan");
		// 3. Print all the Strings using a standard for-loop
		 for(int i = 0; i < names.size(); i++){
	            String s = names.get(i);
	            System.out.println(s);
		 }
		 System.out.print("\n");
		// 4. Print all the Strings using a for-each loop
		  for(String s : names){
	            System.out.println(s);
	        }
		  System.out.print("\n");
		// 5. Print only the even numbered elements in the list.
		  for(int i = 0; i < names.size(); i++){
	            String s = names.get(i);
	            if(i%2 == 0) {
	            System.out.println(s);
	            }
		 }
		  System.out.print("\n");
		// 6. Print all the Strings in reverse order.
		  for(int i = names.size()-1; i>=0; i--){
	            String s = names.get(i);
	            System.out.println(s);
		 }
		  System.out.print("\n"); 
		// 7. Print only the Strings that have the letter 'e' in them.
		  for(int i = 0; i < names.size(); i++){
	            String s = names.get(i);
	            if(s.contains("e")) {
	            System.out.println(s);
	            }
		 }
	}
}
