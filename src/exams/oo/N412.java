package exams.oo;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a program that outputs the string representation of numbers from 1 to n.

But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”. 
For numbers which are multiples of both three and five output “FizzBuzz”.

 * @author jidong
 *
 */
public class N412 {
	public static void main(String[] args) {
		System.out.println(new N412().fizzBuzz(15));
	}

	public List<String> fizzBuzz(int n) {
		List<String> results = new ArrayList<String>();

		for(int i=1; i<=n; i++) {
			boolean d3 = i%3 == 0;
			boolean d5 = i%5 == 0;

			if(d3 && d5) {
				results.add("FizzBuzz");
			} else if(d3) {
				results.add("Fizz");
			} else if(d5) {
				results.add("Buzz");
			} else {
				results.add(String.valueOf(i));
			}
		}

		return results;
	}
}
