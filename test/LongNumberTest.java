import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by steven on 01/06/2017.
 */
public class LongNumberTest {
  private LongNumber num1;
  private LongNumber num2;
  private LongNumber num3;

  @Before
  public void setUp() throws Exception {
    this.num1 = new LongNumber("12345555");
    this.num2 = new LongNumber("0004555321");
    this.num3 = new LongNumber("455532100");
  }

  @Test
  public void testTrimZeroes() throws Exception {
    assertEquals("4555321", this.num2.trimZeroes());
    assertEquals("455532100", this.num3.trimZeroes());
  }

  @Test
  public void testIsPermutation() throws Exception {
    assertTrue(this.num1.isPermutation(new LongNumber("32145555")));
    assertFalse(this.num1.isPermutation(new LongNumber("3214555")));
    assertTrue(this.num1.isPermutation(new LongNumber("12435555")));
  }

}