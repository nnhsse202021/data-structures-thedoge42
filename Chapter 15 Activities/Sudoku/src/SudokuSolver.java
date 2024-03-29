import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class SudokuSolver {
	private final int M = 3;
	private final int N = M * M;
	private int[][] grid;
	private ArrayList<Set<Integer>> rows;
	private ArrayList<Set<Integer>> cols;
	private ArrayList<Set<Integer>> squares;
	private Set<Integer> nums;

	public SudokuSolver(String fileName) {
		// read the puzzle file
		try (Scanner in = new Scanner(new File(fileName))) {
			this.grid = new int[N][N];

			for (int row = 0; row < N; row++) {
				String line = in.next();

				for (int col = 0; col < N; col++) {
					String strVal = line.substring(col, col + 1);
					int number;
					if (strVal.equals("x")) {
						number = 0;
					} else {
						number = Integer.parseInt(strVal);
					}
					this.grid[row][col] = number;
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("Cannot open: " + fileName);
		}

		rows = new ArrayList<>();
		cols = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			Set<Integer> rowSet = new HashSet<>();
			Set<Integer> colSet = new HashSet<>();
			for (int j = 0; j < N; j++) {
				if (this.grid[i][j] != 0) rowSet.add(this.grid[i][j]);
				if (this.grid[j][i] != 0) colSet.add(this.grid[j][i]);
			}
			this.rows.add(rowSet);
			this.cols.add(colSet);
		}

		squares = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			Set<Integer> squareSet = new HashSet<>();
			for (int j = M * (i / M); j < M * (i / M) + M; j++) {
				for (int k = M * (i % M); k < M * (i % M) + M; k++) {
					if (this.grid[j][k] != 0)
						squareSet.add(this.grid[j][k]);
				}
			}
			this.squares.add(squareSet);
		}

		this.nums = new HashSet<>();
		for (int i = 1; i <= N; i++) this.nums.add(i);

		// visually inspect that all the sets are correct
		for (int row = 0; row < N; row++) {
			System.out.println("row " + row + ": " + this.rows.get(row));
		}
		for (int col = 0; col < N; col++) {
			System.out.println("col " + col + ": " + this.cols.get(col));
		}
		for (int square = 0; square < N; square++) {
			System.out.println("square " + square + ": " + this.squares.get(square));
		}
		System.out.println(this.nums);
	}

	public boolean solve() {
		boolean finished = true;

		// find an empty location, if any
		int nextRow = -1;
		int nextCol = -1;
		for (int row = 0; row < N && finished; row++) {
			for (int col = 0; col < N && finished; col++) {
				if (this.grid[row][col] == 0) {
					finished = false;
					nextRow = row;
					nextCol = col;
				}
			}
		}

		// the board is complete; we solved it
		if (finished) {
			return true;
		}

		// get all possible numbers for the row and column we are trying to populate
		Set<Integer> possibleNums = new HashSet<Integer>(this.nums);
		
		/*
		 * Create a new set based on the this.nums and remove all elements in the sets
		 * corresponding to nextRow, nextCol, and the corresponding square.
		 */
		possibleNums.removeAll(this.rows.get(nextRow));
		possibleNums.removeAll(this.cols.get(nextCol));
		int nextSquare = M * (nextRow / M) + (nextCol / M);
		possibleNums.removeAll(this.squares.get(nextSquare));

		// if there are no possible numbers, we cannot solve the board in its current state
		if (possibleNums.isEmpty()) {
			return false;
		}

		// try each possible number
		for (Integer possibleNum : possibleNums) {
			// update the grid and all three corresponding sets with possibleNum
			grid[nextRow][nextCol] = possibleNum;
			this.rows.get(nextRow).add(possibleNum);
			this.cols.get(nextCol).add(possibleNum);
			this.squares.get(nextSquare).add(possibleNum);

			// recursively solve the board
			if (this.solve()) {
				return true; // the board is solved!
			} else {
				/*
				 * Undo the move before trying another possible number by setting the
				 * corresponding element in the grid back to 0 and removing possibleNum from all
				 * three corresponding sets.
				 */
				grid[nextRow][nextCol] = 0;
				this.rows.get(nextRow).remove(possibleNum);
				this.cols.get(nextCol).remove(possibleNum);
				this.squares.get(nextSquare).remove(possibleNum);
			}
		}

		return false; //after trying all possibilites, we cannot solve the puzzle in its current state
	}

	public String toString() {
		String str = "";
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				str += this.grid[i][j] + (j % 3 == 2 ? "  " : " ");
			}
			str += i % 3 == 2 ? "\n\n" : "\n";
		}

		str = str.substring(0, str.length() - 1); //remove extra newline character

		return str;
	}

	public static void main(String[] args) {
		String fileName = "src/puzzle1.txt";

		SudokuSolver solver = new SudokuSolver(fileName);
		System.out.println(solver);
		if (solver.solve()) {
			System.out.println("Solved!");
			System.out.println(solver);
		} else {
			System.out.println("Unsolveable...");
		}
	}
}