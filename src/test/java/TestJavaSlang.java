import javaslang.collection.List;
import javaslang.control.Either;
import org.junit.Test;

import static javaslang.control.Either.right;
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
}
