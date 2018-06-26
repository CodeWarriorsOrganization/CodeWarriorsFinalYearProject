package com.codewarriors.models;

import static org.junit.Assert.*;
import org.junit.Test;
import antlr.collections.List;
import com.codewarriors.models.AiTransactions;

public class AiTransactionsTests {

	// Is getBuyCompanies() method return value or not null.
			@Test
			public void getBuyCompaniesTest() {

				AiTransactions Aijunit = new AiTransactions();
				List buycomaimsg = (List) Aijunit.getBuyCompanies();
				assertNotNull("Message is successfully returned: " + buycomaimsg);
			}

			// Checking if the value for setBuyCompanies is properly set.
			@Test
			public void setBuyCompaniesTest() {
				AiTransactions Aijunit = new AiTransactions();
				List expectedbuycomaimsg = (List) Aijunit.getBuyCompanies();
				List actualbuycomaimsg = (List) Aijunit.getBuyCompanies();
				assertSame(expectedbuycomaimsg, actualbuycomaimsg);
			}


			// Is getSellCompanies() method return value or not null.
					@Test
					public void getSellCompaniesTest() {

						AiTransactions Aijunit = new AiTransactions();
						List sellcomaimsg = (List) Aijunit.getSellCompanies();
						assertNotNull("Message is successfully returned: " + sellcomaimsg);
					}

					// Checking if the value for setSellCompanies is properly set.
					@Test
					public void setSellCompaniesTest() {
						AiTransactions Aijunit = new AiTransactions();
						List expectedsellcomaimsg = (List) Aijunit.getSellCompanies();
						List actualsellcomaimsg = (List) Aijunit.getSellCompanies();
						assertSame(expectedsellcomaimsg, actualsellcomaimsg);
					}

}
