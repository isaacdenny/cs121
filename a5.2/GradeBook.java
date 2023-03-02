import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.xml.catalog.Catalog;

/**
 * Lesson 13: Activity - GradeBook
 *
 * @author CS121 Instructors
 * @version [semester]
 * @author [your name]
 */
public class GradeBook {

  public static void main(String[] args) {
    ArrayList<Student> gradebook = new ArrayList<Student>();
    File gradebookFile = new File("gradebook.csv");

    try (Scanner fileScanner = new Scanner(gradebookFile);) {
      while (fileScanner.hasNext()) {
        String scannedLine = fileScanner.nextLine(); // @keyterm scanner
        System.out.println(
          "DEBUG: Processing student record -> " + scannedLine
        );
        try (Scanner studentScanner = new Scanner(scannedLine);) {
          studentScanner.useDelimiter(","); // @keyterm delimiter
          String lastName = studentScanner.next();
          String firstName = studentScanner.next(); // @keyterm token
          int id = Integer.parseInt(studentScanner.next());
          int grade = Integer.parseInt(studentScanner.next()); // @keyterm parsing

          Student student = new Student(lastName, firstName, id);
          student.setGrade(grade);

          gradebook.add(student);
        } catch (Exception e) { // @keyterm catching an exception
          System.out.println(
            e.getMessage() != null
              ? e.getMessage()
              : "Cannot read line: " + scannedLine
          );
        }
      }
      for (Student student : gradebook) {
        System.out.println(student.toString());
      }
    } catch (FileNotFoundException e) {
      System.out.println(e.getMessage());
    } catch (Exception e) {
      System.out.println(
        e.getMessage() != null ? e.getMessage() : "Unknown error"
      );
    }
  }
}
