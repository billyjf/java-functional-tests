import javaslang.Function1;
import javaslang.collection.List;
import javaslang.control.Either;
import javaslang.control.Option;
import org.junit.Test;

import static javaslang.control.Either.left;
import static javaslang.control.Either.right;
import static javaslang.control.Option.none;
import static javaslang.control.Option.some;
import static org.junit.Assert.*;

public class JavaSlangTest {
  @Test
  public void either() throws Exception {
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

    assertEquals(List.of("pear"),
        fruits.filter(incoming -> incoming.contains("pear")));
  }

  @Test
  public void getOrElse() {
    assertEquals("foo",
        Option.of("foo").getOrElse("bar"));
    assertEquals("bar",
        Option.of(null).getOrElse("bar"));
    assertNotEquals(none(),
        Option.of(null).getOrElse("bar"));
    assertEquals(none(),
        Option.of(none()).getOrElse(none()));
  }

  @Test
  public void eitherLeftVsRight() {
    Function1<String, Either<String, String>> validateName =
        (String name) -> (name.isEmpty()) ? left("Name cannot be empty.") : right(name);
    Either<String, String> invalidResult = validateName.apply("");
    Either<String, String> validResult = validateName.apply("billy");

    assertTrue(invalidResult.isLeft());
    assertTrue(validResult.isRight());

    assertEquals("BILLY", validResult.map(String::toUpperCase).get());
  }
}
