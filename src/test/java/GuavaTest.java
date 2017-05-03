import com.google.common.collect.ImmutableMap;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GuavaTest {
  @Test
  public void immutableMap() {
    Map<String, String> myGuavaMap = ImmutableMap.of("key", "value");

    assertTrue(myGuavaMap.containsKey("key"));
    assertEquals(myGuavaMap.get("key"), "value");
  }
}
