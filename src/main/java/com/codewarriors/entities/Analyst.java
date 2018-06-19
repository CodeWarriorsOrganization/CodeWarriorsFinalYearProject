package com.codewarriors.entities;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.codewarriors.models.AnalysisMessage;
import com.codewarriors.models.Company;
import com.codewarriors.models.Market;
import com.codewarriors.models.Message;
import com.codewarriors.models.TurnMessage;


public class Analyst {
	
	

	public AnalysisMessage getStockData(Market market) {
	    AnalysisMessage analysisMessage =new AnalysisMessage();
	    List<TurnMessage> turnMesages= new ArrayList<TurnMessage>();
	    List<Company> companies = new ArrayList<Company>();
	    DecimalFormat df = new DecimalFormat("#.###");
		Company company;
		companies = market.getCompanies();		
		int turnSize=market.getNoTurns();
		int companySize=market.getCompanies().size();			
		
		// Not usable this is use for print all stock price of company(12) in all turns(30)
		System.out.println("company price=");
		for (int t = 0; t < turnSize; t++) {				
			for (int c = 0; c < companySize; c++) {
				System.out.print(companies.get(c).getTurns().get(t).getPrice()+"  ");
			}
			System.out.println("");
		}
		//
		
			 
           
		for (int t = 0; t < turnSize; t++) {
			TurnMessage turnMessage = new TurnMessage();
			
			for (int c = 0; c < companySize; c++) {				
				company = companies.get(c);				
				int sizelimit = 0;				
				if (t < 21) {
					sizelimit = t + 9;
				} else {
					sizelimit = turnSize-1;
				}				
				double priceCangingPercentage=Double.parseDouble(df.format( (company.getTurns().get(sizelimit).getPrice()-company.getTurns().get(t).getPrice())/100));				
				company.setCompanypriceCangingPercentage(priceCangingPercentage);				
			}
			
			
			System.out.println("turn="+t+"=");
			
			for (int a = 0; a < 12; a++) {				
				System.out.print(companies.get(a).getCompanypriceCangingPercentage()+"    ");
			}
			System.out.println("    ");
			
			Collections.sort(companies, new Comparator<Company>(){		      
		      public int compare(Company c1, Company c2) {		       
		       return Double.valueOf(c1.getCompanypriceCangingPercentage()).compareTo(c2.getCompanypriceCangingPercentage()); 		       
		      }
		 });			
			
			System.out.println("companypriceCangingPercentageAscendingOrdere=  ");
			List<Message> buyMessage = new  ArrayList<Message>() ;
			for (int a = 0; a < 12; a++) {
				if(a<3) {
					Message message= new Message();
					if(t<29) {
						message.setMessage("this company is best for buy= "+companies.get(a).getCompanyName());
					}else {
						message.setMessage("After this turn, Stock Market will closed");
					}
					
					buyMessage.add(message);
				}else {
					//break;
				}
				System.out.print("name= "+companies.get(a).getCompanyName()+" "+"presentage= "+ companies.get(a).getCompanypriceCangingPercentage()+"   ");
			
			}
			turnMessage.setBuyMessages(buyMessage);
			
			
			
			Collections.sort(companies, new Comparator<Company>(){		      
			      public int compare(Company c1, Company c2) {		       
			       return Double.valueOf(c2.getCompanypriceCangingPercentage()).compareTo(c1.getCompanypriceCangingPercentage()); 		       
			      }
			 });			
			List<Message> sellMessage = new  ArrayList<Message>() ;
				System.out.println("companypriceCangingPercentageDescendingOrder=  ");
				
				for (int a = 0; a < 12; a++) {
					if(a<3) {
						Message message= new Message();
						if(t<29) {
							message.setMessage("this company is best for sell= "+companies.get(a).getCompanyName());
						}else {
							message.setMessage("After this turn, Stock Market will closed");
						}
						sellMessage.add(message);
					}else {
						//break;
					}
					System.out.print("name= "+companies.get(a).getCompanyName()+" "+"presentage= "+ companies.get(a).getCompanypriceCangingPercentage()+"   ");
				}
				
				turnMessage.setSellMessages(sellMessage);
				
						
			turnMesages.add(turnMessage);
		} 
		analysisMessage.setTurnMessage(turnMesages);
		
		return analysisMessage;

		
	}

}
