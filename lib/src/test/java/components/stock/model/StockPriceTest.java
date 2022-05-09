package components.stock.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

public class StockPriceTest {

	private static StockPrice price;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
//		long timeStamp, int numTransactions, double close, double open, double high, double low, int volume, double avgPrice
		 price = new StockPrice(System.currentTimeMillis(), 500000, 195.5, 180.0, 197.2, 180.0, 50000000, 187.5);
	}

	@Test
	public void test() {
		assertEquals("failure - date string is not the same", price.getDate(), "May 7, ^22");
		assertFalse("number of transactions should not be 0",price.getNumTransactions() == 0);
		assertFalse("close price should not be 0.0",price.getClose() == 0.0);
		assertFalse("open price should not be 0.0",price.getOpen() == 0.0);
		assertFalse("high price should not be 0.0",price.getHigh() == 0.0);
		assertFalse("low price should not be 0.0",price.getLow() == 0.0);
		assertFalse("volume should not be 0",price.getVolume() == 0);
		assertFalse("avg price should not be 0.0",price.getAvgPrice() == 0.0);
	}
	@After
	public void closePriceTest() {
		assertTrue("close price should be 195.5", price.getClose() == 195.5);
		price.setClose(0);
		assertTrue("close price should be 0.0", price.getClose() == 0);
	}

}
