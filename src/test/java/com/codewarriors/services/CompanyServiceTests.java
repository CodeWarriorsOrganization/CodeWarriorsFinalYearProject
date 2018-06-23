package com.codewarriors.services;

import static org.junit.Assert.*;
import org.junit.Test;
import com.codewarriors.models.Company;
import com.codewarriors.services.CompanyService;

public class CompanyServiceTests {

	// Is getCompanyDetails() method return value or not null.
			@Test
			public void getCompanyDetailsTest() {
				Company companyDetails;
				CompanyService companyDetailjunit = new CompanyService();
				companyDetails = companyDetailjunit.getCompanyDetails("JK Computer Services");
				
				System.out.println("Company Name is not empty: " + companyDetails );
				assertNotNull("Company Name is successfully returned: " + companyDetails);
			}

}
