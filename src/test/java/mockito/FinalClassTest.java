package mockito;

import org.junit.Test;

import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FinalClassTest {
  // https://github.com/mockito/mockito/wiki/What's-new-in-Mockito-2#mock-the-unmockable-opt-in-mocking-of-final-classesmethods

  @Test
  public void finalMethod() throws Exception {
    FinalClass concrete = new FinalClass();
    FinalClass finalClass = mock(FinalClass.class);

    when(finalClass.finalMethod()).thenReturn("not anymore");

    assertNotEquals(finalClass.finalMethod(), concrete.finalMethod());
  }

}