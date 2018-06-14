package com.codewarriors.services;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.codewarriors.entities.Company;

@Service
@Transactional
public class CompanyService {
	public Company getCompanyDetails(String companyname) {

		Company company = new Company();

		switch (companyname) {
		case "IFS":
			company.setCompanyName("IFS");
			company.setSectorName("Technology");
			company.setDetails("http://www.ifsworld.com/lk/");
			break;
		case "Virtusa":
			company.setCompanyName("BOC");
			company.setSectorName("Finance");
			company.setDetails("helloo");
			break;
		case "MIT":
			company.setCompanyName("Dialog");
			company.setSectorName("Consumer Service");
			company.setDetails("helloo");
			break;
		case "99x":
			company.setCompanyName("Virtusa");
			company.setSectorName("Technology");
			company.setDetails("helloo");
			break;
		case "Telecom":
			company.setCompanyName("99x");
			company.setSectorName("Technology");
			company.setDetails("helloo");
			break;
		}

		return company;

	}

}
