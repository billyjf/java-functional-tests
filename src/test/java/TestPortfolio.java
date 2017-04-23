import mockito.Portfolio;
import mockito.Stock;
import mockito.StockService;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by bfish3 on 4/19/17.
 */
public class TestPortfolio {
  private Portfolio portfolio;
  private StockService stockService;

  @Before
  public void setUp() throws Exception {
    portfolio = new Portfolio();
    stockService = mock(StockService.class);
    portfolio.setStockService(stockService);
  }

  @Test
  public void testMarketValue() {
    List<Stock> stocks = new ArrayList<Stock>();
    Stock googleStock = new Stock("1", "Google", 10);
    Stock microsoftStock = new Stock("2", "Microsoft", 100);

    stocks.add(googleStock);
    stocks.add(microsoftStock);

    portfolio.setStocks(stocks);

    when(stockService.getPrice(googleStock)).thenReturn(50.00);
    when(stockService.getPrice(microsoftStock)).thenReturn((1000.00));

    double marketValue = portfolio.getMarketValue();

    assertThat(marketValue, is(100500.0));
  }
}
