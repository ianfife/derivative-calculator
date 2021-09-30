package derivativeCalculator;

public class Function {
  private String function;
  private String function2;
  private String derivative;
  private String derivative2;

  public Function() {
    this("x^2 + 1");
  }
  
  public Function(String a) {
    function = a;
    for (int i = 0; i < function.length(); i++) {
      if (function.substring(i, i+1).equals(" ")) {
        function2 = function.substring(0, i) + function.substring(i + 1);
      }
    }
  }

  public String toString() {
    return function;
  }

  public String removeConstants() {
    derivative = function2;
    derivative2  = "";

    for (int j = 0; j < derivative.length(); j++) {
      boolean notConstant = false;
      int a = 0;
      //Account for - in the future
      for (int i = j; i < derivative.length() && !derivative.substring(i,i+1).equals("+"); i++) {
        if (derivative.substring(i, i+1).equals("x"))
          notConstant = true;
        if ((i == derivative.length()-1 || derivative.substring(i+1, i+2).equals("+")) && notConstant)
          a = i;
        a++;
      }
      if (notConstant)
        derivative2 = derivative2 + derivative.substring(j, a);
      j += a;
    }
    return derivative2;
  }

}
