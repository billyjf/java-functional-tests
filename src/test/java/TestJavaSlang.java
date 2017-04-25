import javaslang.collection.List;
import javaslang.control.Either;
import javaslang.control.Option;
import org.junit.Test;

import static javaslang.control.Either.right;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by bfish3 on 4/13/17.
 */
public class TestJavaSlang {
  @Test
  public void testEither() throws Exception {
    //assertThat(new Either<Exception, String>());
    List<Integer> list = List.of(1,2,3);

    Either<Exception, Integer> result = right(list.get());

    assertTrue(result.isRight());
  }

  @Test
  public void optionOf() throws Exception {
    Option<String> noneOption = Option.of(null);
    Option<String> someOption = Option.of("val");

    assertEquals("None", noneOption.toString());
    assertEquals("Some(val)", someOption.toString());
  }
}
