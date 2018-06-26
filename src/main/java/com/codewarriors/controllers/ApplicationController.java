package com.codewarriors.controllers;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Random;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codewarriors.db.BrokerService;
import com.codewarriors.db.HistoricalWinnerService;
import com.codewarriors.db.PlayerService;
import com.codewarriors.entities.Bank;
import com.codewarriors.entities.HistoricalWinners;
import com.codewarriors.entities.Player;
import com.codewarriors.entities.Transaction;
import com.codewarriors.models.AiTransactions;
import com.codewarriors.models.Company;
import com.codewarriors.models.GameContentHolder;
import com.codewarriors.models.Market;
import com.codewarriors.models.PlayerProfile;
import com.codewarriors.services.AiPlayerService;
import com.codewarriors.services.StockMarketPriceGeneratorService;

@Controller
public class ApplicationController {
	static DecimalFormat decimalFormat = new DecimalFormat("####.##");
	static Random random = new Random();

	@Autowired
	private BrokerService brokerService;
	@Autowired
	private PlayerService playerService;
	
	@Autowired
	private HistoricalWinnerService  winnerService;

	@RequestMapping(value = "/waitingScreen", method = RequestMethod.POST)
	public String result(@ModelAttribute("txtGetName") String name, BindingResult result, Model model,
			HttpSession session) {

		if (result.hasErrors()) {
			return "index";
		} else {
			Player player = new Player();
			player = playerService.playerExist(name);

			if (player != null) {
				model.addAttribute("errorMSG", "Player name exist!!");
				return "index";
			}

			else {
				Player p2 = new Player(name);
				playerService.savePlayer(p2);
				p2 = playerService.findByplayerName(name);

				Bank b = new Bank(name);

				brokerService.createBankAccount(b);

			// Multiplayer logic
    if (playerService.getAllPlayers().size() == 1) {

     StockMarketPriceGeneratorService markets = new StockMarketPriceGeneratorService();
     GameContentHolder.MARKET_PRICES = markets.generate();
     GameContentHolder.WAITING_START_TIME = LocalDateTime.now();
     
     //================================Ai 1======================================
     String aiPlayername = "AI Player 1 ";
     Player aiPlayer = new Player(aiPlayername);
     playerService.savePlayer(aiPlayer);
     p2 = playerService.findByplayerName(name);
     Bank aiPlayerBank = new Bank(aiPlayername);
     brokerService.createBankAccount(aiPlayerBank);
     
     

     AiPlayerService aiPlayerService = new AiPlayerService(GameContentHolder.MARKET_PRICES,
       aiPlayername);
     
     // database transfer data
     for (int turn = 0; turn <30; turn++) {
      
      System.out.println("************************************************Ai Player turn = " + turn +"   ");
      AiTransactions aiTransactions = aiPlayerService.play(turn);
      if (!aiTransactions.getBuyCompanies().isEmpty()) {
       System.out.println(
         "-------------------------------- AI calculateBuyingQuantity -------------------------------------------------------------------------");
             
       System.out.println("+++++++++++++befor calling calculateBuyingQuantity methode+++++++++");
       System.out.println("buy quntiy = " + aiTransactions.getBuyCompanies().size());

       List <Company> calculatedBuyingQuntity = calculateBuyingQuantity(aiTransactions.getBuyCompanies(), turn,aiPlayername);
       
       System.out.println("++++++++++++++++++++calculatedBuyingQuntity++++++++++++++++++++++++++");
       for (int i = 0; i < calculatedBuyingQuntity.size(); i++) {
        System.out.println("******************Company name=  "+calculatedBuyingQuntity.get(i).getCompanyName() + " qty= " + calculatedBuyingQuntity.get(i).getBuyQuantity());      
        
       }
       
       transaction(calculatedBuyingQuntity,turn,"BUY",aiPlayername); 
      }
      
      if (!aiTransactions.getSellCompanies().isEmpty()) {      
       List <Company> calculatedSelingingQuntity = calculateSellingQuantity(aiTransactions.getSellCompanies(), turn,aiPlayername);
       System.out.println("++++++++++++++++++++calculatedSellingQuntity++++++++++++++++++++++++++");
       for (int i = 0; i < calculatedSelingingQuntity.size(); i++) {
        System.out.println("******************Company name=  "+calculatedSelingingQuntity.get(i).getCompanyName());
        
       }
       
       transaction(calculatedSelingingQuntity,turn,"SELL",aiPlayername);
       
       
      }   
     
      
     }
     
   //=============================================Ai 2===================================
     
     String aiPlayername2 = "AI Player 2 ";
     Player aiPlayer2 = new Player(aiPlayername2);
     playerService.savePlayer(aiPlayer2);
     p2 = playerService.findByplayerName(name);
     Bank aiPlayerBank2 = new Bank(aiPlayername2);
     brokerService.createBankAccount(aiPlayerBank2);
     
     
     AiPlayerService aiPlayerService2 = new AiPlayerService(GameContentHolder.MARKET_PRICES,
    		 aiPlayername2);
     
     for (int turn = 0; turn <30; turn++) {
         
         System.out.println("************************************************Ai Player turn = " + turn +"   ");
         AiTransactions aiTransactions = aiPlayerService2.play(turn);
         if (!aiTransactions.getBuyCompanies().isEmpty()) {
          System.out.println(
            "-------------------------------- AI calculateBuyingQuantity -------------------------------------------------------------------------");
                
          System.out.println("+++++++++++++befor calling calculateBuyingQuantity methode+++++++++");
          System.out.println("buy quntiy = " + aiTransactions.getBuyCompanies().size());

          List <Company> calculatedBuyingQuntity = calculateBuyingQuantity(aiTransactions.getBuyCompanies(), turn,aiPlayername2);
          
          System.out.println("++++++++++++++++++++calculatedBuyingQuntity++++++++++++++++++++++++++");
          for (int i = 0; i < calculatedBuyingQuntity.size(); i++) {
           System.out.println("******************Company name=  "+calculatedBuyingQuntity.get(i).getCompanyName() + " qty= " + calculatedBuyingQuntity.get(i).getBuyQuantity());      
           
          }
          
          transaction(calculatedBuyingQuntity,turn,"BUY",aiPlayername2); 
         }
         
         if (!aiTransactions.getSellCompanies().isEmpty()) {      
          List <Company> calculatedSelingingQuntity = calculateSellingQuantity(aiTransactions.getSellCompanies(), turn,aiPlayername2);
          System.out.println("++++++++++++++++++++calculatedSellingQuntity++++++++++++++++++++++++++");
          for (int i = 0; i < calculatedSelingingQuntity.size(); i++) {
           System.out.println("******************Company name=  "+calculatedSelingingQuntity.get(i).getCompanyName());
           
          }
          
          transaction(calculatedSelingingQuntity,turn,"SELL",aiPlayername2);
          
          
         }   
        
         
        }
     

     
     
     
     // AiPlayer.startPlayer(GameContentHolder.MARKET_PRICES,aiPlayername);

    }
        else {

					LocalDateTime to = LocalDateTime.now();
					LocalDateTime from = GameContentHolder.WAITING_START_TIME;
					long secondsDiff = from.until(to, ChronoUnit.SECONDS);

					if (secondsDiff < 15) {
						model.addAttribute("SecondsTogo", (15 - secondsDiff));
					} else {
						model.addAttribute("errorMSG", "Waiting Time has out. Please try again.");
						return "index";
					}

				}

				model.addAttribute("playername", name);

				return "waitingScreen";
			}
		}
	}

	@GetMapping(value = "/gameScreen")
	public String loadGameScreen(@RequestParam String name, Model model) {

		Bank b1 = new Bank();
		b1 = brokerService.findByPnameAndType(name, "Initial");

		model.addAttribute("balance", b1.getBalance());
		model.addAttribute("pName", name);

		return "gameScreen";
	}

	@GetMapping(value = "/TestScreen")
	public String loadGameScreen() {

		return "testAnalist";
	}

	@RequestMapping(value = "/gameOverview", method = RequestMethod.GET)

	public String loadGameOverviewScreen(@RequestParam String Pname,Model model) {

		List<Player> players = new ArrayList<Player>();
		List<Bank> playerRanking = new ArrayList<Bank>();
		players = playerService.getAllPlayers();

		int size = players.size();

		List<Integer> noOfTrades = new ArrayList<Integer>();

		List<Transaction> getPlayerRows = new ArrayList<Transaction>();

		List<PlayerProfile> getFinalRankings = new ArrayList<PlayerProfile>();

		for (int i = 0; i < size; i++) {
			int Trades = 0;

			playerRanking.add(brokerService.getLastRecordByPlayer(players.get(i).getPlayerName()));

			getPlayerRows = brokerService.findRecordByPlayer(players.get(i).getPlayerName());
			noOfTrades.add(getPlayerRows.size());
			System.out.println(noOfTrades.get(i));
			int rank = (i + 1);
			String name = playerRanking.get(i).getpName();
			Trades = noOfTrades.get(i);
			System.out.println("Number of trades of " + name + " " + Trades);
			double balance = playerRanking.get(i).getBalance();
			double totalReturns = (balance - 1000);

			PlayerProfile p1 = new PlayerProfile(name, rank, Trades, balance, totalReturns);

			getFinalRankings.add(p1);

		}

		Collections.sort(getFinalRankings, new Comparator<PlayerProfile>()

		{

			public int compare(PlayerProfile b1, PlayerProfile b2) {

				return Double.valueOf(b2.getpBalance()).compareTo(b1.getpBalance());

			}

		});

		model.addAttribute("playerRankings", getFinalRankings);
		
		model.addAttribute("Pname",Pname);
		
		return "gameOverview";
	}
	
	
	@RequestMapping(value = "/playAgain", method = RequestMethod.GET)
	public String loadLoginScreen(@RequestParam String winnerName,String trades,String returns,String netWorth) {
		
		winnerService.deleteAllBankRecords();
		winnerService.deleteAllPlayers();
		winnerService.deleteAllTransactionRecords();
		
		double returns1 = Double.parseDouble(returns);
		double netWorth1 = Double.parseDouble(netWorth);
		int trade = Integer.parseInt(trades);
		
		
		HistoricalWinners winner = new HistoricalWinners(winnerName,trade,netWorth1,returns1);
		
		winnerService.saveWinner(winner);
		
		return "index";	
	}
	
	@RequestMapping(value = "/goToHome", method = RequestMethod.GET)
	public String ReturnScreen() {
		
      return "index";
	}
	
  // ==================================AI Player Tracsactions======================================
 
 

 private List<Company> calculateBuyingQuantity(List<Company> companies, int turn, String AiPlayerName) {
  List<Company> buy = new ArrayList<Company>();
  System.out.println();
  int randomQty = random.ints(5, 8).findAny().getAsInt();
  double bankBalance = getCurrentBankBalance(AiPlayerName);
  // asc order sort
  Collections.sort(companies, new Comparator<Company>() {
   public int compare(Company c1, Company c2) {
    return Double.valueOf(c1.getTurns().get(turn).getPrice()).compareTo(c2.getTurns().get(turn).getPrice());
   }
  });

  //System.out.println("Buy company size===========================" + companies.size());
  for (int i = 0; i < companies.size(); i++) {
   // current balance should retrieve from db
   double uPrice = companies.get(i).getTurns().get(turn).getPrice();
   System.out.println("^^^^  calculateBuyingQuantity ^^^^^");
   System.out.println("curent bank balance= " + bankBalance );
   if (bankBalance >= (uPrice * randomQty)) {
    
                Company company=companies.get(i);
                company.setBuyQuantity(randomQty);
                buy.add(company);
    //companies.get(i).setBuyQuantity(randomQty);
    bankBalance = (bankBalance - (uPrice * randomQty));
    System.out.println("@@@@@@@@@@bank balance= " + bankBalance);
    //System.out.println(" Bank Balance : " + bankBalance + "Random Qty : " + randomQty);
    randomQty--;

   } else {

    companies.remove(i);
   }

  }
//  System.out.println(
//    "*****************************************START***********************************************");
//  for (int i = 0; i < companies.size(); i++) {
//   System.out.println(" Company name : " + companies.get(i).getCompanyName() + " BuyingQTY "
//     + companies.get(i).getBuyQuantity());
//  }
//
//  System.out
//    .println("*******************************************END*********************************************");

  return buy;
 }

 private double getCurrentBankBalance(String AiPlayerName) {
  System.out.println("Bank Balance========== ");
  double bankbalance = brokerService.getLastRecordByPlayer(AiPlayerName).getBalance();
  System.out.println(brokerService.getLastRecordByPlayer(AiPlayerName).getBalance());

  System.out.println(
    "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
  return bankbalance;
 }

 private List<Company> calculateSellingQuantity(List<Company> companies, int turn, String AiPlayerName) {
         List<Company> sellCompany = new ArrayList<Company>(); 
         String playerName=AiPlayerName;
  for (int i = 0; i < companies.size(); i++) {
   int quntity = getSellingStockQuntity(companies.get(i),playerName);
   if (quntity != 0) {
    System.out.println("++++++++++++++++++++++++++calculateSellingQuantity area++++++++++++++++++");
    
    int sellQntity = random.ints(1, quntity + 1).findAny().getAsInt();
    Company company=companies.get(i);
    company.setSellQuantity(sellQntity);
    sellCompany.add(company);
    //companies.get(i).setSellQuantity(sellQntity);
    //System.out.println("company name= " + sellCompany.get(i).getCompanyName() + " quntity=" +sellCompany.get(i).getSellQuantity() );
   } else {
    companies.remove(i);
   }

  }

  // ===========================================print final sell contity of given
  // company========

  for (int i = 0; i < sellCompany.size(); i++) {

   System.out.println("======================= print sell quntiy=====================");
   System.out.println("company name= " + sellCompany.get(i).getCompanyName() + "   sell Quntity= "
     + sellCompany.get(i).getSellQuantity());

  }

  return sellCompany;
 }

 private int getSellingStockQuntity(Company company, String AiPlayerName) {
  
  //List<Transaction> transactionRecordsSell = new ArrayList<Transaction>();
  //List<Transaction> transactionRecordsBuy = new ArrayList<Transaction>();
  
   
  int soldQuantity = 0;
  int boughtQuantity = 0;
  int StockQtInHand=0;
  
  String playerName  = AiPlayerName;
  String companyName = company.getCompanyName();
  List<Transaction> transactionRecordsSell=brokerService.findDistinctCompaniesWithType(playerName, companyName, "SELL");
  List<Transaction> transactionRecordsBuy = brokerService.findDistinctCompaniesWithType(playerName, companyName, "BUY");
  
  for (int k = 0; k < transactionRecordsSell.size(); k++) {   
   soldQuantity = soldQuantity + transactionRecordsSell.get(k).getQuantity();
  }
  
  for (int j = 0; j < transactionRecordsBuy.size(); j++) {   
   boughtQuantity = boughtQuantity + transactionRecordsBuy.get(j).getQuantity();   
  }
  
   StockQtInHand = boughtQuantity - soldQuantity;

  return StockQtInHand;// return current available quntity of the particular company
 }

 private void transaction(List<Company> companiesList, int turn, String type, String AiPlayerName) {
  if (type == "BUY") {
   for (int i = 0; i < companiesList.size(); i++) {
    
    int turnid = turn;
    String typeID = "Withdraw";
    String companyName = companiesList.get(i).getCompanyName();
    double unitprice = companiesList.get(i).getTurns().get(turn).getPrice();
    int buyqty = companiesList.get(i).getBuyQuantity();
    double cost = Double.parseDouble(decimalFormat.format( unitprice * buyqty));
    double balance =Double.parseDouble(decimalFormat.format(getCurrentBankBalance(AiPlayerName) - cost)); 
    
    if(buyqty!=0) {
    Bank bank = new Bank(AiPlayerName, turnid, typeID, cost, balance);
    Transaction transaction = new Transaction(AiPlayerName, turnid, type, companyName, unitprice, buyqty,
      cost);
    brokerService.createBankAccount(bank);
    brokerService.createTransaction(transaction);
    }
    // database implemetation to be implement

   }

  } else if (type == "SELL") {
   for (int i = 0; i < companiesList.size(); i++) {
    
    int turnid = turn;
    String typeID = "Deposit";
    String companyName = companiesList.get(i).getCompanyName();
    double unitprice = companiesList.get(i).getTurns().get(turn).getPrice();
    int sellqty = companiesList.get(i).getSellQuantity();
    double cost = Double.parseDouble(decimalFormat.format( unitprice * sellqty)); 
    double balance =Double.parseDouble(decimalFormat.format( getCurrentBankBalance(AiPlayerName) + cost));  
    
    // database implemetation to be implement    
    if(sellqty!=0) {
     Bank bank = new Bank(AiPlayerName, turnid, typeID, cost, balance);
     Transaction transaction = new Transaction(AiPlayerName, turnid, type, companyName, unitprice, sellqty,
       cost);
     brokerService.createBankAccount(bank);
     brokerService.createTransaction(transaction);
    }
    
   }

  } else {
   System.out.println("Couln't handle this transaction :/");
  }

 }
  
  

}
