package derivativeCalculator;

public class Function {
  //String input
  private final String function;
  //function with any whitespace removed
  private String noSpaces = "";

  public Function() {
    this("x^2 + 1");
  }
  
  public Function(String a) {
    function = a;
    //Check for spaces, if none, set noSpaces and skip whitespace removal
    if (!function.contains(" ")) {
      noSpaces = function;
    }
    else {
      //Remove whitespace from string
      for (int i = 0; i < function.length(); i++) {
        if (function.charAt(i) != ' ') {
          noSpaces = noSpaces + function.charAt(i);
        }
      }
    }
  }

  public String toString() {
    return function;
  }

  public String removeConstants() {
    //noSpaces without constants
    String derivative = noSpaces;
    //Parsed derivative
    String derivativeParsed = "";

    for (int j = 0; j < derivative.length(); j++) {
      boolean notConstant = false;
      int a = 0;
      //Account for - in the future
      for (int i = j; i < derivative.length() && (derivative.charAt(i) != '+' || derivative.charAt(i) != '-'); i++) {
        if (derivative.charAt(i) == 'x') {
          notConstant = true;
        }
        if ((i == derivative.length()-1 || derivative.charAt(i + 1) == '+'|| derivative.charAt(i + 1) == '-') && notConstant) {
          a = i;
        }
        a++;
      }
      if (notConstant) {
        derivativeParsed = derivativeParsed + derivative.substring(j, a);
      }
      j += a;
    }
    return derivativeParsed.toString();
  }

}
