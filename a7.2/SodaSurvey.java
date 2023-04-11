import java.io.File;
import java.text.DecimalFormat;
import java.util.Scanner;

public class SodaSurvey implements SodaSurveyInterface {
  private int[][] surveyData; // @keyterm two-dimensional array

  public SodaSurvey(String fileName) {
    File surveyDataFile = new File(fileName);
    try (Scanner scanner = new Scanner(surveyDataFile)){
      int rows = scanner.nextInt();
      int columns = scanner.nextInt();
      surveyData = new int[rows][columns];

      for (int i = 0; i < rows; i++) { // @keyterm iterating over 2D array
        for (int j = 0; j < columns; j++) {
          surveyData[i][j] = scanner.nextInt();
        }
      }
    } catch (Exception e) {
      System.out.println(e.getMessage() != null ? e.getMessage() : "Error reading file: " + surveyDataFile.getName());
    }
  }

  @Override
  public double rowAvg(int rowIndex) {

    double sum = 0.0;
    for (int i = 0; i < surveyData[0].length; i++) {
      sum += surveyData[rowIndex][i]; // @keyterm row
    }
    double avg = sum / surveyData[0].length;
    return avg;
  }

  @Override
  public double colAvg(int colIndex) {
    double sum = 0.0;
    for (int i = 0; i < surveyData.length; i++) {
      sum += surveyData[i][colIndex]; // @keyterm column
    }
    double avg = sum / surveyData.length;
    return avg;
  }


  @Override
  public String toString() {
    DecimalFormat df = new DecimalFormat("0.00");
    String toReturn = "";
    for (int i = 0; i < surveyData.length; i++) {
      toReturn += "Person " + i + " Mean: " + df.format(rowAvg(i)) + "\n";
    }
    toReturn += "\n";
    for (int i = 0; i < surveyData[0].length; i++) {
      toReturn += "Soda " + i + " Mean: " + df.format(colAvg(i)) + "\n";
    }
    toReturn += "\n";
    return toReturn;
  }
  
}
