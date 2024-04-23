package utils;

public class OS {
  public static String OS;

  public static boolean isAndroid() {
    return "Android".equalsIgnoreCase(OS);
  }

  public static boolean isiOS() {
    return "iOS".equalsIgnoreCase(OS);
  }
}
