import java.util.*;

public class Main {
	// Printing the Dash board
	public static void createBoard(char[][] board) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}

	public static char hasWon(char[][] board) {

		// row check
		for (int i = 0; i < 3; i++) {
			if (board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
				return board[i][0];
			}
		}
		// column check
		for (int j = 0; j < 3; j++) {
			if (board[0][j] == board[1][j] && board[1][j] == board[2][j]) {
				return board[0][j];
			}
		}

		// Diagonal check
		if (board[0][0] == board[1][1] && board[1][1] == board[2][2])

		{
			return board[0][0];
		}
		if (board[2][0] == board[1][1] && board[1][1] == board[0][2]) {
			return board[1][1];
		}
		return '-';
	}

	// for Tie check
	public static boolean hadTied(char[][] board) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] == '-') {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// fetching the players names from user input
		System.out.println("Player 1. Please enter your Name: ");
		String player1 = input.nextLine();
		System.out.println("Player 2. please enter your Name: ");
		String player2 = input.nextLine();

		// Assigning the das board
		char[][] board = new char[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = '-';
			}
		}

		boolean isplayer1 = true;

		boolean gameEnded = false;

		while (!gameEnded) {

			createBoard(board);
			// Assign the symbols for the players
			char symbol = ' ';
			if (isplayer1) {
				symbol = 'x';
			} else {
				symbol = 'o';
			}
			// printout the players turn
			if (isplayer1)
				System.out.println(player1 + "'s turn(X)");
			else
				System.out.println(player2 + "'s turn(O)");

			// Initialize the row and column
			int row = 0;
			int col = 0;
			// check the pre-conditions before starting the game
			while (true) {
				System.out.println("Please enter the row: 0 or 1 or 2");
				row = input.nextInt();
				System.out.println("Please enter the col: 0 or 1 or 2");
				col = input.nextInt();

				if (row < 0 || col < 0 || row > 2 || col > 2) {
					System.out.println("Invalid row or column as they are out of board.!");
				} else if (board[row][col] != '-') {
					System.out.println("Already someone has made the move.!");
				} else {
					break;
				}
			}
			// assigning the sign to the position given by the user
			board[row][col] = symbol;
			// check if player1 has won by calling the method
			if (hasWon(board) == 'x') {
				System.out.println(player1 + " Has Won..!!");
				gameEnded = true;
			}
			// check if player2 has won
			if (hasWon(board) == 'o') {
				System.out.println(player2 + " Has Won..!!");
				gameEnded = true;
			} else {
				// check if there is any tie
				if (hadTied(board)) {
					System.out.println("Tied..!!");
					gameEnded = true;
				} else {
					// changing the players turn
					isplayer1 = !isplayer1;
				}
			}
		}
		// call the final dash board to see the results.!
		createBoard(board);

	}

}
