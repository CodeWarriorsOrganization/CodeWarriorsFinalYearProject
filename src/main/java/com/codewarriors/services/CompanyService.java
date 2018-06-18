package com.codewarriors.services;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.codewarriors.models.Company;

@Service
@Transactional
public class CompanyService {
	public Company getCompanyDetails(String companyname) {

		Company company = new Company();

		switch (companyname) {
		case "JK Computer Services":
			company.setCompanyName("JK Computer Services");
			company.setSectorName("Technology");
			company.setDetails("https://en.wikipedia.org/wiki/John_Keells_Computer_Services");
			break;
		case "IFS":
			company.setCompanyName("IFS");
			company.setSectorName("Technology");
			company.setDetails("http://www.ifsworld.com/lk/");
			break;
		case "MillenniumIT":
			company.setCompanyName("MillenniumIT");
			company.setSectorName("Technology");
			company.setDetails("https://en.wikipedia.org/wiki/MillenniumIT");
			break;
		case "Cinnamon Air":
			company.setCompanyName("Cinnamon Air");
			company.setSectorName("Consumer services");
			company.setDetails("https://en.wikipedia.org/wiki/Cinnamon_Air");
			break;
		case "EAP Holdings":
			company.setCompanyName("EAP Holdings");
			company.setSectorName("Consumer services");
			company.setDetails("https://en.wikipedia.org/wiki/EAP_Holdings");
			break;
		case "ExpoRail":
			company.setCompanyName("ExpoRail");
			company.setSectorName("Consumer services");
			company.setDetails("https://en.wikipedia.org/wiki/ExpoRail");
			break;
		case "Nestle Lanka":
			company.setCompanyName("Nestle Lanka");
			company.setSectorName("Manufacturing");
			company.setDetails("https://www.nestle.lk/en");
			break;
		case "Bank of Ceylon":
			company.setCompanyName("Bank of Ceylon");
			company.setSectorName("Financials");
			company.setDetails("https://en.wikipedia.org/wiki/Bank_of_Ceylon");
			break;
		case "Tokyo Cement":
			company.setCompanyName("Tokyo Cement");
			company.setSectorName("Manufacturing");
			company.setDetails("http://www.tokyocement.com/");
			break;
		case "Brandix Lanka Limited":
			company.setCompanyName("Brandix Lanka Limited");
			company.setSectorName("Manufacturing");
			company.setDetails("http://www.brandix.com/");
			break;
		case "DFCC Bank":
			company.setCompanyName("DFCC Bank");
			company.setSectorName("Financials");
			company.setDetails("https://en.wikipedia.org/wiki/DFCC_Bank");
			break;
		case "HNB Bank":
			company.setCompanyName("HNB Bank");
			company.setSectorName("Financials");
			company.setDetails("https://en.wikipedia.org/wiki/Hatton_National_Bank");
			break;
		}

		return company;

	}

}
