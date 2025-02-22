package anagram;

import java.util.HashMap;

public class AnagramCheck {	
	public static boolean anagramTest(String a, String b) {		
		//cast both to lower case to ignore case of anagram
		a.toLowerCase();
		b.toLowerCase();
		
		//putting String b into a Hashmap represented by letter as key and number of occurence as value
		HashMap<Character, Integer> bHash = new HashMap<Character, Integer>();
		for(int i=0; i<b.length(); i++) {
			char temp = b.charAt(i);
			if(bHash.containsKey(temp) == true) {
				bHash.replace(temp, bHash.get(temp) + 1);
			}
			else {
				bHash.put(temp, 1);
			}
		}		
		//iterating through string a by decrementing value of each key for every letter match
		//then testing if all values of the hashmap are 0 at the end of string a iteration
		for(int i=0; i<a.length(); i++) {
			char letter = a.charAt(i);			
			if(bHash.containsKey(letter) == true) {
				if(bHash.get(letter) > 0) {
					bHash.replace(letter, bHash.get(letter) - 1);
				}
				else return false;
				
			}
			else return false;
		}		
		//create flag boolean as true, iterate over value set to check if any remaining letters in string b
		//if there are, set flag to false, if not, do nothing then return flag will return true
		boolean flag = true;
		for(int values: bHash.values()) {
			if(values > 0) {
				flag = false;
			}
		}
		return flag;	
	}
}
