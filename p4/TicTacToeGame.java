import java.awt.Point;

/**
 * Provides the back-end logic for the TicTacToe application including all the functionality needed to play.
 * @author Isaac Denny
 */
public class TicTacToeGame implements TicTacToe {

  private BoardChoice[][] board;
  private Point[] moves;
  private int movesCount;
  private GameState gameState;
  private BoardChoice lastPlayer;

  /**
   * Constructs a TicTacToeGame object and starts a game
   */
  public TicTacToeGame() {
    this.board = new BoardChoice[3][3];
    this.moves = new Point[9];
    this.movesCount = 0;
    this.gameState = GameState.IN_PROGRESS;
    lastPlayer = null;

    for (int i = 0; i < this.board.length; i++) {
      for (int j = 0; j < this.board[i].length; j++) {
        this.board[i][j] = BoardChoice.OPEN;
      }
    }
  }

  @Override
  public void newGame() {
    this.board = new BoardChoice[3][3];
    this.moves = new Point[9];
    this.movesCount = 0;
    this.gameState = GameState.IN_PROGRESS;
    lastPlayer = null;

    for (int i = 0; i < this.board.length; i++) {
      for (int j = 0; j < this.board[i].length; j++) {
        this.board[i][j] = BoardChoice.OPEN;
      }
    }
  }

  @Override
  public boolean choose(TicTacToe.BoardChoice player, int row, int col) {
    if (lastPlayer == player) {
      return false;
    } else if (gameOver()) {
      System.out.println("Game Over");
      return false;
    } else if (gameState != GameState.IN_PROGRESS) {
      return false;
    } else if (row > this.board.length - 1 || col > this.board[0].length - 1) {
      System.out.println("Out of bounds");
      return false;
    } else if (this.board[row][col] != BoardChoice.OPEN) {
      System.out.println("Spot taken: " + row + ", " + col);
      return false;
    }

    this.board[row][col] = player;
    moves[movesCount] = new Point(row, col);
    movesCount++;
    lastPlayer = player;
    gameOver();
    return true;
  }

  @Override
  public boolean gameOver() {
    if (checkDiagWin() || checkRowWin() || checkColWin() || checkFull()) {
      return true;
    }
    gameState = GameState.IN_PROGRESS;
    return false;
  }

  /**
   * Checks the whole board to see if it is full
   * @return true if full and false if there are any open spaces
   */
  private boolean checkFull() {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] == BoardChoice.OPEN) {
          return false;
        }
      }
    }
    gameState = GameState.TIE;
    return true;
  }

  /**
   * Checks both diagonals to see if there is a winning side
   * @return true if diagonal win, false if not
   */
  private boolean checkDiagWin() {
    int oPoints = 0;
    int xPoints = 0;
    // top left - bottom right diagonal
    for (int i = 0; i < board.length; i++) {
      if (board[i][i] == BoardChoice.O) {
        oPoints++;
      } else if (board[i][i] == BoardChoice.X) {
        xPoints++;
      }
    }
    if (oPoints == 3) {
      this.gameState = GameState.O_WON;
      return true;
    } else if (xPoints == 3) {
      this.gameState = GameState.X_WON;
      return true;
    } else {
      oPoints = 0;
      xPoints = 0;
    }

    // bottom left - top right diagonal
    for (int i = board.length - 1; i >= 0; i--) {
      if (board[i][board.length - 1 - i] == BoardChoice.O) {
        oPoints++;
      } else if (board[i][board.length - 1 - i] == BoardChoice.X) {
        xPoints++;
      }
    }
    if (oPoints == 3) {
      this.gameState = GameState.O_WON;
      return true;
    } else if (xPoints == 3) {
      this.gameState = GameState.X_WON;
      return true;
    }

    return false;
  }

  /**
   * Checks all rows to see if there is a win
   * @return true if there is a win, false if not
   */
  private boolean checkRowWin() {
    int oPoints = 0;
    int xPoints = 0;
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] == BoardChoice.O) {
          oPoints++;
        } else if (board[i][j] == BoardChoice.X) {
          xPoints++;
        }
      }
      if (oPoints == 3) {
        this.gameState = GameState.O_WON;
        return true;
      } else if (xPoints == 3) {
        this.gameState = GameState.X_WON;
        return true;
      } else {
        oPoints = 0;
        xPoints = 0;
      }
    }
    return false;
  }

  /**
   * Checks all columns to see if there is a win
   * @return true if there is a win, false if not
   */
  private boolean checkColWin() {
    int oPoints = 0;
    int xPoints = 0;
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[j][i] == BoardChoice.O) {
          oPoints++;
        } else if (board[j][i] == BoardChoice.X) {
          xPoints++;
        }
      }
      if (oPoints == 3) {
        this.gameState = GameState.O_WON;
        return true;
      } else if (xPoints == 3) {
        this.gameState = GameState.X_WON;
        return true;
      } else {
        oPoints = 0;
        xPoints = 0;
      }
    }
    return false;
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
    Point[] movesCopy = new Point[movesCount];
    for (int i = 0; i < this.movesCount; i++) {
      movesCopy[i] = this.moves[i];
    }
    return movesCopy;
  }
}
