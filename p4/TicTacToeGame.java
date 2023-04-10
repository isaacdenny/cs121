import java.awt.Point;

public class TicTacToeGame implements TicTacToe {
  private BoardChoice[][] board;
  private Point[] moves;
  private GameState gameState;

  public TicTacToeGame() {
    // init board
    this.board = new BoardChoice[3][3];
    this.moves = new Point[1000];
    this.gameState = GameState.IN_PROGRESS;

    for (int i = 0; i < this.board.length; i++) {
      for (int j = 0; j < this.board[i].length; j++) {
        this.board[i][j] = BoardChoice.OPEN;
      }
    }
  }

  @Override
  public void newGame() {
    this.board = new BoardChoice[3][3];
    this.moves = new Point[1000];
    this.gameState = GameState.IN_PROGRESS;

    for (int i = 0; i < this.board.length; i++) {
      for (int j = 0; j < this.board[i].length; j++) {
        this.board[i][j] = BoardChoice.OPEN;
      }
    }
  }

  @Override
  public boolean choose(TicTacToe.BoardChoice player, int row, int col) {
    if (this.gameState != GameState.IN_PROGRESS) {
      return false;
    }
    else if (gameOver()) {
      return false;
    }
    else if (row > this.board.length - 1 || col > this.board[0].length - 1) {
      return false;
    }
    else if (this.board[row][col] != BoardChoice.OPEN) {
      return false;
    }

    this.board[row][col] = player;
    return true;
  }

  @Override
  public boolean gameOver() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'gameOver'");
  }

  @Override
  public TicTacToe.GameState getGameState() {
    return gameState;
  }

  @Override
  public TicTacToe.BoardChoice[][] getGameGrid() {
    BoardChoice[][] boardCopy = new BoardChoice[3][3];
    for (int i = 0; i < this.board.length; i++) {
      for (int j = 0; j < this.board[i].length; j++) {
        boardCopy[i][j] = board[i][j];
      }
    }
    return boardCopy;
  }

  @Override
  public Point[] getMoves() {
    Point[] movesCopy = new Point[1000];
    for (int i = 0; i < moves.length; i++) {
      movesCopy[i] = moves[i];
    }
    return movesCopy;
  }
  
}