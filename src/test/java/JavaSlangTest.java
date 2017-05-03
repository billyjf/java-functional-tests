import javaslang.collection.List;
import javaslang.control.Either;
import javaslang.control.Option;
import org.junit.Test;

import static javaslang.control.Either.right;
import static javaslang.control.Option.none;
import static javaslang.control.Option.some;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class JavaSlangTest {
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
    assertFalse(noneOption.isDefined());
    assertTrue(someOption.isDefined());
  }

  @Test
  public void someVsOptionOf() throws Exception {
    assertNotEquals(Option.of(null), some(null));
    assertEquals(Option.of(null), none());
    assertNotEquals(some(null), some(none()));
    assertEquals(some(Option.of(null)), some(none()));
  }

  @Test
  public void basicFilter() {
    List<String> fruits = List.of("apple",
        "pear",
        "guava",
        "watermelon",
        "pineapple",
        "kiwi",
        "banana");

    String beforeFilter = fruits.toString();
    String afterFilter = fruits.filter(
        incoming -> incoming.contains("pear"))
        .toString();

    assertThat(beforeFilter,
        is("List(apple, pear, guava, watermelon, pineapple, kiwi, banana)"));
    assertThat(afterFilter,
        is("List(pear)"));
  }
}
