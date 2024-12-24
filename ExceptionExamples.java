public class ExceptionExamples {
  public static void main(String[] args) {
      // int answer = readInt();
      // System.out.println("the number read is " + answer);
      int answer1 = readInt3();
      System.out.println("the number read is " + answer1);
  }

  /**
   * Tries to read an integer through the standard input
   * If an illegal argument is entered, returns 0
   */
  public static int readInt() {
    In in = new In();
    int ans = 0;
    StdOut.println("Please enter a number.");
    try {
        String s = in.readString();
        s = s.charAt(-1) + s;
        ans = Integer.parseInt(s);
        ans = 1 / ans;
        System.out.println("Reached end of try");
    } catch (NumberFormatException e) {
        System.out.println("Reached catch 1");
        ans = 0;
    } catch (ArithmeticException e) {
        System.out.println("Reached catch 2");
        ans = 0;
    }
      // } catch (StringIndexOutOfBoundsException e) {
      // System.out.println("Reached catch 3");
      // }  
    return ans;
  }

  /**
   * Tries to read an integer through the standard input
   * Keeps prompting the user to enter a valid argument
   */
  public static int readInt2() {
    int ans = 0;
    boolean legal = false;
    StdOut.println("Please enter a number.");
    In in = new In();
    while (!legal) {
      try {
        String s = in.readString();
        ans = Integer.parseInt(s);
        legal = true;
      } catch (NumberFormatException e) {
        StdOut.println("Invalid argument, try again.");
      }
    }
    return ans;
  }

  /**
   * Tries to read an integer through the standard input
   * If an illegal argument is entered, returns 0
   */
  public static int readInt3() {
    int ans = 0;
    StdOut.println("Please enter a number.");
    In in = new In();
    try {
      String s = in.readString();
      System.out.println("started try");
      ans = Integer.parseInt(s);
      System.out.println("Reached end of try");
    } catch (NumberFormatException e) {
      System.out.println("Reached catch");
      ans = 0;
    } finally {
      System.out.println("Reached finally");
      // will execute always.
    }
    return ans;

  }

}
