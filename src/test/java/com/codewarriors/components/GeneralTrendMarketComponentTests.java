package com.codewarriors.components;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import com.codewarriors.components.GeneralTrendMarketComponent;
import org.junit.Test;
public class GeneralTrendMarketComponentTests {

	// checking does the generateGeneralTrendMarketStockRandomValue returns an value.
		@Test
		public void generateGeneralTrendMarketStockRandomValueTest() {

			int[][] result = GeneralTrendMarketComponent.generateGeneralTrendMarketStockRandomValue();
			assertNotNull(result);
			System.out.println("The function generateGeneralTrendMarketStockRandomValue is not null, it returns a random value:"
					+ " " + result);
		}
		
		// Checking if generateGeneralTrendMarketStockRandomValue method returns random values.
			@Test
			public void AssertNotSame() {
				int[][] result1 = GeneralTrendMarketComponent.generateGeneralTrendMarketStockRandomValue();
				int[][] result2 = GeneralTrendMarketComponent.generateGeneralTrendMarketStockRandomValue();
				assertNotSame(result1, result2);
				System.out.println("Ramdom value that get as the output at first attempt:" + " " + result1);
				System.out.println("Ramdom value that get as the output at second attempt:" + " " + result2);

			}

}
