package derivativeCalculator;

import java.io.IOException;
import java.util.Scanner;

class FunctionModifier {
  public static void main(String[] args) throws IOException {
    Scanner scan = new Scanner(System.in);
    System.out.println("Enter function (Ex: x^2 + 1)");
    String func = scan.nextLine().toLowerCase();
    scan.close();

    Function func1 = new Function(func);
    System.out.println(func1.removeConstants());
    System.out.println(func1);
  }
}
