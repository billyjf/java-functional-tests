import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class StreamJavaUtilOnlyTest {

  @Test
  public void allSumCombosOf5ForGivenPrices() {
    List<Integer> prices = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

    List<List<Integer>> result = prices.stream().flatMap(p1 ->
      prices.stream().flatMap(p2 ->
        p1 + p2 == 5 ? Stream.of(Arrays.asList(p1, p2)) : Stream.empty()
      )
    ).collect(Collectors.toList());

    assertEquals(result, Arrays.asList(Arrays.asList(1, 4),
        Arrays.asList(2, 3),
        Arrays.asList(3, 2),
        Arrays.asList(4, 1)));
  }
}
