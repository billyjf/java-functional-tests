import com.nike.riposte.server.http.RequestInfo;
import org.junit.Test;
import org.mockito.Mock;
import riposte.SampleRequestProcessor;

import static org.junit.Assert.assertNull;

public class SampleRequestProcessorTest {
  @Mock
  private RequestInfo<?> rInfo;

  @Test
  public void idFromHeaders() {
    SampleRequestProcessor processor = new SampleRequestProcessor();

    assertNull(processor.apply(null, rInfo));
  }
}
