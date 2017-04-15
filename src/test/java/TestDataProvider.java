import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static com.tngtech.java.junit.dataprovider.DataProviders.$;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by bfish3 on 4/13/17.
 */

@RunWith(DataProviderRunner.class)
public class TestDataProvider {

  @Before
  public void setUp() throws Exception {

  }

  @Test
  @UseDataProvider
  public void testDataProvider(boolean value) throws Exception {
    assertThat(value, is(true));
  }

  @DataProvider
  public static Object[][] dataTestDataProvider() {
    return new Object[][] {
        $(new Boolean(true))
    };
  }
}
