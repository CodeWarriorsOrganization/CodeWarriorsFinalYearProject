package com.codewarriors;

import com.codewarriors.components.RandomMarketComponent;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;

import org.junit.Test;

public class RandomMarketComponentTests {

	// checking does the generateRandomMarketStockRandomValue returns an value.
	@Test
	public void generateRandomMarketStockRandomValueTest() {

		int[][] result = RandomMarketComponent.generateRandomMarketStockRandomValue();
		assertNotNull(result);
		System.out.println("The function generateRandomMarketStockRandomValue is not null, it returns a random value:"
				+ " " + result);
	}

	// Checking if generateRandomMarketStockRandomValue method returns random
	// values.
	@Test
	public void AssertNotSame() {
		int[][] result1 = RandomMarketComponent.generateRandomMarketStockRandomValue();
		int[][] result2 = RandomMarketComponent.generateRandomMarketStockRandomValue();
		assertNotSame(result1, result2, "Both result1 and result2 objects return random values or are not same ");

		System.out.println("Ramdom value that get as the output at first attempt:" + " " + result1);
		System.out.println("Ramdom value that get as the output at second attempt:" + " " + result2);

	}
}
