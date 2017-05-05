import com.google.common.collect.ImmutableMap;
import javaslang.Function1;
import javaslang.Tuple2;
import javaslang.collection.HashMap;
import javaslang.collection.List;
import javaslang.control.Either;
import javaslang.control.Option;
import org.junit.Test;

import java.util.Map;
import java.util.function.Consumer;

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

  @Test
  public void mapStringToUpperCaseOverList() {
    List<String> veggies = List.of("cucumber",
        "spinach",
        "kale",
        "broccoli");

    assertEquals(List.of("CUCUMBER",
        "SPINACH",
        "KALE",
        "BROCCOLI"), veggies.map(String::toUpperCase));
  }

  @Test
  public void mergeMaps() {
    Map<String, String> preExistingMap = ImmutableMap.of("pre-existing", "entry");
    HashMap<String, String> mapToMergeWithPreExisting = HashMap.of("foo", "bar");
    HashMap<String, String> mergedMap = HashMap.ofAll(preExistingMap).merge(mapToMergeWithPreExisting);

    assertEquals(HashMap.of("pre-existing", "entry",
        "foo", "bar"),
        mergedMap);
  }

  @Test
  public void forEach() {
    HashMap<String, String> items = HashMap.of("foo", "bar");
    HashMap<String, String> targetLonghand = HashMap.of();
    HashMap<String, String> targetShorthand = HashMap.of();

    Consumer<Tuple2<String, String>> longhand = tuple -> targetLonghand.put(tuple._1, tuple._2);
    items.forEach(longhand);
    items.forEach(tuple -> targetShorthand.put(tuple._1, tuple._2));

    assertEquals(targetShorthand, targetLonghand);
  }
}
