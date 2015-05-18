package de.scravy.pair;

import org.junit.Assert;
import org.junit.Test;

public class PairsTest {

  @Test
  public void compareEqualValues() {
    Assert.assertEquals(0, Pairs.compare(1, 1, 1, 1));
  }

  @Test
  public void compareEqualNullValues() {
    Assert.assertEquals(0, Pairs.compare(null, null, null, null));
  }
  
  @Test
  public void compareLesserInFirstComponent() {
    Assert.assertTrue(Pairs.compare(1, 0, 1, 1) < 0);
  }

  @Test
  public void compareGreaterInFirstComponent() {
    Assert.assertTrue(Pairs.compare(1, 1, 1, 0) > 0);
  }
  
  @Test
  public void compareLesserInSecondComponent() {
    Assert.assertTrue(Pairs.compare(1, 0, 1, 1) < 0);
  }

  @Test
  public void compareGreaterInSecondComponent() {
    Assert.assertTrue(Pairs.compare(1, 1, 1, 0) > 0);
  }
}
