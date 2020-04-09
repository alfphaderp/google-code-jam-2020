package qr.p5.indicium;

import java.util.Scanner;

public class Solution {
	static Scanner in;
	static int T;
	
	int N, K;
	int[][] square;
	
	public static void main(String[] args) {		
		in = new Scanner(System.in);
		T = in.nextInt();
		
		for(int c = 1; c <= T; c++) {
			Solution s = new Solution();
			s.solve(c);
		}
		
		in.close();
	}
	
	void solve(int c) {
		readInput();
		
		boolean found = search();
		if(found) {
			System.out.println("Case #" + c + ": POSSIBLE");
			printSquare();
		} else {
			System.out.println("Case #" + c + ": IMPOSSIBLE");
		}
	}
	
	void printSquare() {
		for(int[] row : square) {
			for(int i = 0; i < N - 1; i++)
				System.out.print(row[i] + " ");
			System.out.print(row[N - 1]);
			System.out.println();
		}
	}
	
	void readInput() {
		N = in.nextInt();
		K = in.nextInt();
		
		square = new int[N][N];
	}
	
	boolean search() {
		int row = -1, col = -1;
		
		find:
		for(int i = 0; i < N; i++)
			for(int j = 0; j < N; j++)
				if(square[i][j] == 0) {
					row = i;
					col = j;
					break find;
				}
		
		if(row == -1 && col == -1)
			return trace() == K;
		
		for(int i = 1; i <= N; i++) {
			if(isSafe(row, col, i)) {
				square[row][col] = i;
				
				if(search())
					return true;
				else
					square[row][col] = 0;
			}
		}
		
		return false;
	}
	
	boolean isSafe(int row, int col, int val) {
		return rowSafe(row, val) && colSafe(col, val);
	}
	
	boolean rowSafe(int row, int val) {
		for(int i = 0; i < N; i++)
			if(square[row][i] == val)
				return false;
		return true;
	}
	
	boolean colSafe(int col, int val) {
		for(int i = 0; i < N; i++)
			if(square[i][col] == val)
				return false;
		return true;
	}
	
	int trace() {
		int trace = 0;
		for(int i = 0; i < N; i++)
			trace += square[i][i];
		return trace;
	}
}
