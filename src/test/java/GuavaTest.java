import com.google.common.collect.ImmutableMap;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class GuavaTest {
  @Test
  public void immutableMap() {
    Map<String, String> myGuavaMap = ImmutableMap.of("key", "value");

    assertTrue(myGuavaMap.containsKey("key"));
    assertThat(myGuavaMap.get("key"), is("value"));
  }
}
