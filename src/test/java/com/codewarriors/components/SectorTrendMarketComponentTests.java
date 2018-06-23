package com.codewarriors.components;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import com.codewarriors.components.SectorTrendMarketComponent;
import org.junit.Test;

public class SectorTrendMarketComponentTests {

	// checking does the sectorTrendMarketStockRandomValue returns an value.
	@Test
	public void sectorTrendMarketStockRandomValueTest() {

		int[][] result = SectorTrendMarketComponent.sectorTrendMarketStockRandomValue();
		assertNotNull(result);
		System.out.println("The function sectorTrendMarketStockRandomValueTest is not null, it returns a random value:"
				+ " " + result);
	}
	
	// Checking if sectorTrendMarketStockRandomValue method returns random values.
		@Test
		public void AssertNotSame() {
			int[][] result1 = SectorTrendMarketComponent.sectorTrendMarketStockRandomValue();
			int[][] result2 = SectorTrendMarketComponent.sectorTrendMarketStockRandomValue();
			assertNotSame(result1, result2);
			System.out.println("Ramdom value that get as the output at first attempt:" + " " + result1);
			System.out.println("Ramdom value that get as the output at second attempt:" + " " + result2);

		}

}
