package mockito;

import lombok.AllArgsConstructor;

/**
 * Created by bfish3 on 4/24/17.
 */
@AllArgsConstructor
public class MockitoCustomArgumentMatcher {} /* extends ArgumentMatcher<ListFunctionsRequest> {
  protected final String marker;

  @Override
  public boolean matches(Object arg) {
    return Option.of(arg)
        .filter(ListFunctionsRequest.class::isInstance)
        .map(ListFunctionsRequest.class::cast)
        .flatMap(res -> Option.of(res.getMarker()))
        .equals(Option.of(marker));
  }

  public static ListFunctionsRequest listFunctionsRequestWithMarker(String marker) {
    return argThat(new ListFunctionsRequestWithMarker(marker));
  }
}*/