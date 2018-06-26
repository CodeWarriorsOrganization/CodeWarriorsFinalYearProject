package com.codewarriors.services;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.codewarriors.components.EventComponentEvents;
import com.codewarriors.components.EventComponentValues;
import com.codewarriors.components.GeneralTrendMarketComponent;
import com.codewarriors.components.RandomMarketComponent;
import com.codewarriors.components.SectorTrendMarketComponent;
import com.codewarriors.entities.Analyst;
import com.codewarriors.models.Company;
import com.codewarriors.models.Event;
import com.codewarriors.models.Market;
import com.codewarriors.models.Turn;

public class StockMarketPriceGeneratorService {

	Random random = new Random();
	int companysStockIncresingPresentages[][] = new int[12][30];
	int companyRandomStarterPrice[] = new int[30];
	double finalCompanyStockPrice[][] = new double[12][30];
	int eventComponent[][] = new int[30][12];

	List<String> companyNames = Arrays.asList("JK Computer Services", "IFS", "MillenniumIT", "Cinnamon Air",
			"EAP Holdings", "ExpoRail", "Nestle Lanka", "Bank of Ceylon", "Brandix Lanka Limited", "Tokyo Cement",
			"DFCC Bank", "HNB Bank");
	List<String> sectorNames = Arrays.asList("Technology", "Consumer services", "Manufacturing", "Financials");
	List<Company> companies = new ArrayList<Company>();
	Market market = new Market();

	int stockStarterPriceLow = 10;
	int stockStarterPriceHigh = 30;

	public Market generate() {
		companysStockIncresingPresentages = computeTrendCoponent(getRandomMarketComponent(),
				getSectorTrendMarketComponent(), getGeneralTrendMarketComponent(), getEventComponent());

		// This is use for all companies's random stock starter price
		for (int i = 0; i < 12; i++) {
			companyRandomStarterPrice[i] = random.nextInt(stockStarterPriceHigh - stockStarterPriceLow)
					+ stockStarterPriceLow;
			System.out.println("");
			System.out.println("+++" + companyRandomStarterPrice[i] + "   ");
		}

		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 30; j++) {

				if (j == 0) {
					finalCompanyStockPrice[i][j] = finalStockPriceCalculator(companyRandomStarterPrice[i],
							companysStockIncresingPresentages[i][j]);

				} else {
					finalCompanyStockPrice[i][j] = finalStockPriceCalculator(finalCompanyStockPrice[i][j - 1],
							companysStockIncresingPresentages[i][j]);

				}
			}

		}

		market.setNoTurns(30);// game time is 0s
		market.setTurnTime(10000);// companies stock price will change after 6s

		// this is use for calculate all companies final stock price in every turn and
		// add to object
		for (int j = 0; j < 12; j++) {
			Company company = new Company();
			List<Turn> turnList = new ArrayList<Turn>();

			company.setCompanyName(companyNames.get(j));
			if (j < 3) {
				company.setSectorName(sectorNames.get(0));
			} else if (3 <= j && j < 6) {
				company.setSectorName(sectorNames.get(1));
			} else if (6 <= j && j < 9) {
				company.setSectorName(sectorNames.get(2));
			} else if (6 <= j && j < 12) {
				company.setSectorName(sectorNames.get(3));
			}

			for (int i = 0; i < 30; i++) {
				Turn turn = new Turn();
				turn.setTurnId(i);
				turn.setPrice(finalCompanyStockPrice[j][i]);
				turnList.add(turn);

			}
			company.setTurns(turnList);
			companies.add(company);
		}
		market.setCompanies(companies);
		Analyst analyst = new Analyst();

		market.setAnalysisMessage(analyst.getRecommendations(market));
 //=====================================Start Event message Ganarating Part =================================
		List<Event> occurringEvents = new ArrayList<Event>();

		for (int i = 0; i < 30; i++) {
			Event occurringEvent = new Event();
			List<String> eventEfectedCopmany = new ArrayList<String>();
			int eventValue = 0;
			for (int j = 0; j < 12; j++) {

				int value = eventComponent[i][j];
				if (0 < value) {

					eventValue = value;

					switch (j) {

					case 0:
						eventEfectedCopmany.add(companyNames.get(0));
						break;

					case 1:
						eventEfectedCopmany.add(companyNames.get(1));
						break;

					case 2:
						eventEfectedCopmany.add(companyNames.get(2));
						break;

					case 3:
						eventEfectedCopmany.add(companyNames.get(3));
						break;

					case 4:
						eventEfectedCopmany.add(companyNames.get(4));
						break;

					case 5:
						eventEfectedCopmany.add(companyNames.get(5));
						break;

					case 6:
						eventEfectedCopmany.add(companyNames.get(6));
						break;

					case 7:
						eventEfectedCopmany.add(companyNames.get(7));
						break;

					case 8:
						eventEfectedCopmany.add(companyNames.get(8));
						break;

					case 9:
						eventEfectedCopmany.add(companyNames.get(9));
						break;

					case 10:
						eventEfectedCopmany.add(companyNames.get(10));
						break;

					case 11:
						eventEfectedCopmany.add(companyNames.get(11));
						break;
					}
				}
			}

			occurringEvent.setEventAfectedCompanies(eventEfectedCopmany);
			switch (eventValue) {

			case 1:
				occurringEvent.setEventName("BOOM Events");
				break;

			case 2:
				occurringEvent.setEventName("BUST Events");
				break;

			case 3:
				occurringEvent.setEventName("PROFIT_WARNING");
				break;

			case 4:
				occurringEvent.setEventName("TAKE_OVER");
				break;

			case 5:
				occurringEvent.setEventName("SCANDAL");
				break;

			}
			
			
			occurringEvents.add(occurringEvent);

		}
		
		for(int i=0; i<30;i++){
			
			System.out.println("============event details printng area =============================================");
			System.out.println("turn Number= "+i);
			System.out.println("Event Name= " +occurringEvents.get(i).getEventName());
			
			for(int x=0; x<occurringEvents.get(i).getEventAfectedCompanies().size();x++) {
				System.out.println("Affected companies= " +occurringEvents.get(i).getEventAfectedCompanies().get(x));
				
			}
			
		}
		
//===============================end Event Genarating part===========================		

		// analyst.getStockData(market);
		// AiPlayer.startPlayer(market);

		// AiPlayerService aiPlayerService = new AiPlayerService(market, "AIplayer1");
		// aiPlayerService.play(0);
		market.setEvents(occurringEvents);
		return market;
	}

	private double finalStockPriceCalculator(double stockPrice, double presentage) {
		DecimalFormat df = new DecimalFormat("#.##");
		double anser = Double.parseDouble(df.format(stockPrice * ((presentage + 100) / 100)));
		return anser;
	}

	private int[][] getRandomMarketComponent() {
		int randomMarketComponent[][] = new int[30][12];
		randomMarketComponent = RandomMarketComponent.generateRandomMarketStockRandomValue();
		System.out.println("genarate randomMarketComponent=  ");
		for (int i = 0; i < 30; i++) {
			for (int j = 0; j < 12; j++) {
				System.out.print(randomMarketComponent[i][j] + "  ");
			}
			System.out.println("");
		}
		return randomMarketComponent;
	}

	private int[][] getSectorTrendMarketComponent() {
		int sectorTrendMarketComponent[][] = new int[30][12];
		sectorTrendMarketComponent = SectorTrendMarketComponent.sectorTrendMarketStockRandomValue();
		System.out.println("");
		System.out.println("genarate sectorTrendMarketComponent=  ");
		for (int i = 0; i < 30; i++) {
			for (int j = 0; j < 12; j++) {
				System.out.print(sectorTrendMarketComponent[i][j] + "  ");

			}
			System.out.println("");
		}
		return sectorTrendMarketComponent;
	}

	private int[][] getGeneralTrendMarketComponent() {
		int generalTrendMarketComponent[][] = new int[30][12];
		generalTrendMarketComponent = GeneralTrendMarketComponent.generateGeneralTrendMarketStockRandomValue();
		System.out.println("");
		System.out.println("genarate generalTrendMarketComponent=  ");
		for (int i = 0; i < 30; i++) {
			for (int j = 0; j < 12; j++) {
				System.out.print(generalTrendMarketComponent[i][j] + "  ");
			}
			System.out.println("");
		}
		return generalTrendMarketComponent;
	}

	private int[][] getEventComponent() {

		int[][] eventDurationHolder = new int[30][12];
		int[][] eventValues = new int[30][12];

		eventDurationHolder = EventComponentEvents.eventComponentRandomEventGenerator();
		eventValues = EventComponentValues.eventComponentValuesGenerator(eventDurationHolder);
		eventComponent = eventDurationHolder;
		System.out.println("");
		System.out.println("genarate event event details*******=  ");
		for (int i = 0; i < 30; i++) {
			for (int j = 0; j < 12; j++) {
				System.out.print(eventDurationHolder[i][j] + "  ");
			}
			System.out.println("");
		}
		System.out.println("");
		System.out.println("genarate event event value*******=  ");
		for (int i = 0; i < 30; i++) {
			for (int j = 0; j < 12; j++) {
				System.out.print(eventValues[i][j] + "  ");
			}
			System.out.println("");
		}
		return eventValues;
	}

	private int[][] computeTrendCoponent(int[][] CSP, int[][] STC, int[][] GTMC, int[][] EC) {

		int tempCompanysStockIncresingPresentages[][] = new int[30][12];
		int tempTransformedCompanysStockIncresingPresentages[][] = new int[12][30];
		System.out.print(" computeTrendCoponent= ");
		for (int i = 0; i < 30; i++) {
			for (int j = 0; j < 12; j++) {
				int calulatedPresentage = CSP[i][j] + STC[i][j] + GTMC[i][j] + EC[i][j];
				if (calulatedPresentage >= 0) {
					tempCompanysStockIncresingPresentages[i][j] = calulatedPresentage;
				} else {
					tempCompanysStockIncresingPresentages[i][j] = 0;
				}

				System.out.print(tempCompanysStockIncresingPresentages[i][j] + "  ");
			}
			System.out.println("");
		}

		for (int i = 0; i < 30; i++) {
			for (int j = 0; j < 12; j++) {
				tempTransformedCompanysStockIncresingPresentages[j][i] = tempCompanysStockIncresingPresentages[i][j];
			}
		}

		System.out.println("all companies stock Presentages befor transformed=");
		System.out.println("");
		for (int i = 0; i < 30; i++) {
			for (int j = 0; j < 12; j++) {
				// transformedFinalCompanyStockPrice[j][i]=
				System.out.print(tempCompanysStockIncresingPresentages[i][j] + "  ");
			}
			System.out.println("");
		}

		System.out.println("all companies stock Presentages after transformed=");
		System.out.println("");
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 30; j++) {
				// transformedFinalCompanyStockPrice[j][i]=
				System.out.print(tempTransformedCompanysStockIncresingPresentages[i][j] + "  ");
			}
			System.out.println("");
		}

		return tempTransformedCompanysStockIncresingPresentages;
	}

}
