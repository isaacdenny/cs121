public class Tester {

  public static void main(String[] args) {
    TicTacToe game = new TicTacToeGame();
    game.choose(TicTacToe.BoardChoice.O, 1, 0);
    game.choose(TicTacToe.BoardChoice.X, 0, 2);
    game.choose(TicTacToe.BoardChoice.O, 2, 2);
    game.choose(TicTacToe.BoardChoice.X, 2, 0);
    game.choose(TicTacToe.BoardChoice.O, 0, 0);
    game.choose(TicTacToe.BoardChoice.X, 1, 2);
    game.choose(TicTacToe.BoardChoice.O, 0, 1);
    game.choose(TicTacToe.BoardChoice.X, 2, 1);
    game.choose(TicTacToe.BoardChoice.O, 1, 1);

    TicTacToe.BoardChoice[][] board = game.getGameGrid();
    for (int i = 0; i < board.length; i++) {
      System.out.print("Row " + i + ": ");
      for (int j = 0; j < board[i].length; j++) {
        System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }
    System.out.println(game.gameOver());
    System.out.println(game.getGameState());
  }
}
