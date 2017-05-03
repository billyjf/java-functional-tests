import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StreamWithGuavaAndHamcrestTest {
  @Test
  public void allSumCombosOf5ForGivenPrices() {
    List<Integer> prices = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

    List<List<Integer>> result = prices.stream().flatMap(p1 ->
        prices.stream().flatMap(p2 ->
            p1 + p2 == 5 ? Stream.of(Arrays.asList(p1, p2)) : Stream.empty()
        )
    ).collect(Collectors.toList());

    assertThat(result, is(ImmutableList.of(ImmutableList.of(1, 4),
        ImmutableList.of(2, 3),
        ImmutableList.of(3, 2),
        ImmutableList.of(4, 1))));
  }
}
