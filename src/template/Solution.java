package template;
import java.util.Scanner;

public class Solution {
	static Scanner in;
	static int T;
	
	
	public static void main(String[] args) {
		in = new Scanner(System.in);
		T = in.nextInt();
		
		for(int c = 1; c <= T; c++) {
			readInput();
			
			System.out.println("Case #" + c + ": ");
		}
		
		in.close();
	}
	
	public static void readInput() {
	}
}
