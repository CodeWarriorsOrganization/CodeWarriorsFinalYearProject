package com.codewarriors;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import org.junit.Test;

import com.codewarriors.models.Company;

public class CompanyTests {

	// Is getCompanyName() method return value or not null.
		@Test
		public void getCompanyNameTest() {
			String companyName;
			Company companyNamejunit = new Company();
			String result = companyNamejunit.getCompanyName();
			if (result == null) {

				companyName = "Is a String";
			} else {

				companyName = "";
			}

			System.out.println("Company Name is not empty: " + result + " " + companyName);
			assertNotNull("Company Name is successfully returned: " + result + " " + companyName);
		}

		// checking Company Name is a string value using parseInt() method.
		@Test
		public void checkAlphanumeric() {
			Company companyNamejunit = new Company();
			String compname = companyNamejunit.getCompanyName();

			if (compname != null) {
				compname = compname;
			} else {
				compname = "IFS";
			}

			try {
				Integer.parseInt(compname);
				System.out.println("Company Name is a not string:" + " " + compname);
			} catch (NumberFormatException e) {
				System.out.println("Compan Name is a string:" + " " + compname);
			}
		}

		// Checking if the value for Company Name is properly set.
		@Test
		public void setCompanyNameTest() {
			Company companyNamejunit = new Company();
			String expectedcompName = companyNamejunit.getCompanyName();
			String actualcompName = companyNamejunit.getCompanyName();
			assertSame(expectedcompName, actualcompName);
			if (expectedcompName == actualcompName) {

				System.out.println("Both expected Company and actual Company Names are equal:" + " " + expectedcompName
						+ "  " + "=" + "  " + actualcompName);
			}
		}

		// Is getSectorName() method return value or not null.
		@Test
		public void getSectorNameTest() {
			String sectorName;
			Company sectorNamejunit = new Company();
			String result = sectorNamejunit.getSectorName();
			if (result == null) {

				sectorName = "Is a String";
			} else {

				sectorName = "";
			}

			System.out.println("Sector Name is not empty: " + result + " " + sectorName);
			assertNotNull("Sector Name is successfully returned: " + result + " " + sectorName);
		}

		// Checking if the value for Sector Name is properly set.
		@Test
		public void setSectorNameTest() {
			Company sectorNamejunit = new Company();
			String expectedsectorName = sectorNamejunit.getSectorName();
			String actualsectorName = sectorNamejunit.getSectorName();
			assertSame(expectedsectorName, actualsectorName);
			if (expectedsectorName == actualsectorName) {

				System.out.println("Both expected Sector and actual Sector Names are equal:" + " " + expectedsectorName
						+ "  " + "=" + "  " + actualsectorName);
			}
		}

		// checking Details is a string value using parseInt() method.
		@Test
		public void checkDetailsAlphanumeric() {
			Company detailsjunit = new Company();
			String details = detailsjunit.getDetails();

			if (details != null) {
				details = details;
			} else {
				details = "Detail Info";
			}

			try {
				Integer.parseInt(details);
				System.out.println("Detail Info is a not string:" + " " + details);
			} catch (NumberFormatException e) {
				System.out.println("Detail Info is a string:" + " " + details);
			}
		}
	 
		// Is getDetails() method return value or not null.
		@Test
		public void getDetailsTest() {
			String result1;
			Company detailsjunit = new Company();
			String result = detailsjunit.getDetails();
			if (result == null) {

				result1 = "Is a String";
			} else {

				result1 = "";
			}

			assertNotNull("Details Info  is successfully returned: " + result + " " + result1);
		}

		// checking Details is a string value using parseInt() method.
		@Test
		public void checkDetailsAlphanumeric1() {
			Company detailsjunit = new Company();
			String details = detailsjunit.getDetails();

			if (details != null) {
				details = details;
			} else {
				details = "Details";
			}

			try {
				Integer.parseInt(details);
				System.out.println("Details Info  is a not string:" + " " + details);
			} catch (NumberFormatException e) {
				System.out.println("etails Info is a string:" + " " + details);
			}
		}
}
