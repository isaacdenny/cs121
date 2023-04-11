public class SodaSurveyDriver {
  public static void main(String[] args) {
    if (args.length == 0) {
      System.out.println("Usage: java SodaSurveyDriver [filename]");
      return;
    }
    String filename = args[0];
    SodaSurvey ss = new SodaSurvey(filename);

    System.out.println("Testing rowAvg(0): " + ss.rowAvg(0));
    System.out.println("Testing rowAvg(1): " + ss.rowAvg(1));
    System.out.println("Testing colAvg(0): " + ss.colAvg(0));
    System.out.println("Testing colAvg(1): " + ss.colAvg(1));
    System.out.println();
    System.out.println(ss.toString());
  }
}
