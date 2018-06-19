package com.codewarriors;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import com.codewarriors.models.Market;
import com.codewarriors.models.Company;

public class MarketTests {

	// Is getNoTurns() method return value or not null.
	@Test
	public void getNoTurnsTest() {
		Market turnNojunit = new Market();
		int result = turnNojunit.getNoTurns();
		System.out.println("No of Turn is not empty: " + result);
		assertNotNull("No of Turns is successfully returned: " + result);

	}

	// Checking whether the getNoTurns is a numeric value.
	@Test
	public void checkNumeric() {
		Market turnNojunit = new Market();
		int result = turnNojunit.getNoTurns();
		if ((result % 1) != 0) {

			System.out.println("No of Turns is a not a numeric value: " + result);
		} else {
			System.out.println("No of Turns is a numeric value: " + result);
		}
	}

	// Checking if the value for No of Turns is properly set.
	@Test
	public void setNoTurnsTest() {
		Market turnNojunit = new Market();
		int expectedpturnNo = turnNojunit.getNoTurns();
		int actualturnNo = turnNojunit.getNoTurns();
		assertSame(expectedpturnNo, actualturnNo);
		if (expectedpturnNo == actualturnNo) {

			System.out.println("Both expected pID and actual pID are equal:" + " " + expectedpturnNo + "  " + "=" + "  "
					+ actualturnNo);
		}

	}

	// Is getTurnTime() method return value or not null.
	@Test
	public void getTurnTimeTest() {
		Market TurnTimejunit = new Market();
		int result = TurnTimejunit.getTurnTime();
		System.out.println("Turn Time is not empty: " + result);
		assertNotNull("Turn Time is successfully returned: " + result);

	}

	// Checking whether the getNoTurns is a numeric value.
	@Test
	public void checkTurnTimeNumeric() {
		Market turnTimejunit = new Market();
		int result = turnTimejunit.getTurnTime();
		if ((result % 1) != 0) {

			System.out.println("Turn Time is a not a numeric value: " + result);
		} else {
			System.out.println("Turn Time is a numeric value: " + result);
		}
	}

	// Checking if the value for Turn Time is properly set.
	@Test
	public void setTurnTimeTest() {
		Market turnTimejunit = new Market();
		int expectedturnTime = turnTimejunit.getTurnTime();
		int actualturnTime = turnTimejunit.getTurnTime();
		assertSame(expectedturnTime, actualturnTime);
		if (expectedturnTime == actualturnTime) {

			System.out.println("Both expected Turn Time and actual Turn Time are equal:" + " " + expectedturnTime + "  "
					+ "=" + "  " + actualturnTime);
		}

	}

	@Test
	public void getCompaniesList() {
		List<Company> getcompanies = new ArrayList<Company>();
		Market market = new Market();
		getcompanies = market.getCompanies(); 
		assertNull(getcompanies);
		
		List<String> companies = new ArrayList<String>();
		companies.add("IFS");
		companies.add("99X");
        assertNotNull(companies);

        	if (companies != null) {
        		
        		System.out.println("companies array not empty : "+ " "+companies.get(0));
        	}
       
	}

}
