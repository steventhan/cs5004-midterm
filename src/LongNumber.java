import java.util.LinkedList;
import java.util.List;

/**
 * Created by steven on 01/06/2017.
 */
public class LongNumber implements ILongNumber {
  List<Integer> number;

  public static void main(String[] args) {
    LongNumber num1 = new LongNumber("1234");
    LongNumber num2 = new LongNumber("1234");
    System.out.println(num1.add(num2));
  }

  public LongNumber(String numberStr) {
    this.number = new LinkedList<>();
    for (int i = 0; i < numberStr.length(); i++) {
      this.number.add(Character.getNumericValue(numberStr.charAt(i)));
    }
  }

  public String trimZeroes() {
    String thisNum = this.toString();
    char[] strArr = thisNum.toCharArray();
    int i = 0;

    while (i < strArr.length) {
      if (strArr[i] != '0') {
        break;
      }
      i++;
    }
    return thisNum.substring(i);
  }

  private static boolean isStringPermutation(String num1, String num2) {
    for (char c : num1.toCharArray()) {
      if (num2.indexOf(c) < 0 && !(countChar(num1, c) == countChar(num2, c))) {
        return false;
      }
    }
    return true;
  }

  private static int countChar(String num, char chr) {
    int count = 0;
    for (char c : num.toCharArray()) {
      if (c == chr) {
        count++;
      }
    }
    return count;
  }

  public boolean isPermutation(LongNumber other) {
    String thisNum = this.trimZeroes();
    String otherNum = other.trimZeroes();

    return thisNum.length() == otherNum.length()
            && isStringPermutation(thisNum, otherNum);
  }

  public LongNumber add(LongNumber other) {
    String thisNum = this.trimZeroes();
    String otherNum = other.trimZeroes();
    String result = "";
    int i = thisNum.length() - 1;
    int j = otherNum.length() - 1;
    int rem = 0;

    while (i >= 0 && j >= 0) {
      int a = Character.getNumericValue(thisNum.charAt(i));
      int b = Character.getNumericValue(otherNum.charAt(j));
      if (a + b + rem >= 10) {
        result = String.format("%d%s", ((a + b + rem) - 10), result);
        rem = 1;
      } else {
        result = String.format("%d%s", (a + b + rem), result);
        rem = 0;
      }
      i--;
      j--;
    }

    while (i >= 0) {
      int a = Character.getNumericValue(thisNum.charAt(i));
      if (a + rem >= 10) {
        result = String.format("%d%s", ((a + rem) - 10), result);
        rem = 1;
      } else {
        result = String.format("%d%s", (a + rem), result);
        rem = 0;
      }
      i--;
    }

    while (j >= 0) {
      int b = Character.getNumericValue(thisNum.charAt(j));
      if (b + rem >= 10) {
        result = String.format("%d%s", ((b + rem) - 10), result);
        rem = 1;
      } else {
        result = String.format("%d%s", (b + rem), result);
        rem = 0;
      }
      j--;
    }

    return new LongNumber(result);
  }

  @Override
  public String toString() {
    String s = "";

    for (Integer n : this.number) {
      s += n;
    }
    return s;
  }
}
