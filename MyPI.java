public class MyPI {
  private static String PI_STR;
  private static long PI_INT;
  
  public static String getPIString() {
    return PI_STR;
  }
  
  public static long getPIInt() {
    return PI_INT;
  }
  
  public static void setPIString(String PI_STR_) {
    PI_STR = PI_STR_;
  }
  
  public static void setPIInt(long PI_INT_) {
    PI_INT = PI_INT_;
  }
  
  public static String[] getSubstrings(String s_) {
    String[] substrings = new String[s_.length()];
    for (int i = 0; i < s_.length(); i++) {
      substrings[i] = s_.substring(0, i + 1);
    }
    return substrings;
  }

  

  public static boolean findInPI(String in_) {
    String[] substrings = getSubstrings(in_);

    for (String substring : substrings) {
      int iterations = PI_STR.length() - substring.length() - 1; // prevent out of bounds
      for (int i = 0; i < iterations; i++) {
          if (PI_STR.substring(i, i + substring.length()).equals(substring)) {
             System.out.println("Found: " + substring + " at index: " + i);
             if (substring.length() == in_.length()) {
               System.out.println(in_ + " Found in Pi! At index: " + i);
               return true;
             }
          }
      }
    }

    System.out.println(in_ + " Not Found in Pi!");
    return false;
  }
}
