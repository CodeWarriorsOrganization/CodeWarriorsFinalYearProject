package com.codewarriors.components;

import java.text.DecimalFormat;
import java.util.Random;
public class GeneralTrendMarketComponent {
	
	public static int[][] generateGeneralTrendMarketStockRandomValue() {
		
		        //--variables declaration begin
		        Random randomObj = new Random();
		        DecimalFormat decimalFormat = new DecimalFormat("###.##");
		        int numofcompanies = 12, numberofturns = 30, min = 1, max = 12, random, valcompanyindex, valrandom;
		        int[][] generalTrend = new int[numberofturns][numofcompanies];
		        //--variables declaration end
		        //------------------------------GENERAL TREND MARKET COMPONENT ALGORITHM BEGIN--------
		        //      outer for loop handles number of turns
		        for (int z = 0; z < generalTrend.length; z++) {

		            //          first inner for loop handles number of companies/stocks
		            for (int j = 0; j < generalTrend[z].length; j++) {

		                //----------arrays declaration begin
		                //              assigned an array with dummy values because should maintain starting array without having '0's ;) #trick
		                int[] arrayRandomCompanies = {21, 22, 23, 24, 25, 26};
		                int[] arrayRandomValues = new int[6];
		                int[] arrayfinalizedturn = new int[12];
		                //----------arrays declaration end

		                //--------------randomly select companies which are going to change the values
		                for (int a = 0; a < 6; a++) {

		                    random = Integer.parseInt(decimalFormat.format(randomObj.ints(min, max).findAny().getAsInt()));
		                    //                  deduct by 1 because of IntStream returns an effectively unlimited stream of pseudorandom int values, each conforming to the given origin (inclusive) and bound (exclusive)
		                    random -= 1;
		                    //                  checks generated random integer exist in the arrayRandomCompanies

		                    if (contains(arrayRandomCompanies, random)) {
		                        a--;
		                    } else {
		                        arrayRandomCompanies[a] = random;
		                    }
		                }
		    /*
		    based on the Probabilities given :
		        P(increase) = 0.25 =>
		            numberOfCompanies * 0.25 = 12 * 0.25 = 3
		            Assumptions:
		                01: 3 /12 companies will increase the values by randomly generated values between (+3)-(+1)
		                02: from the first three indexes represent increasing company digits arrayRandomCompanies
		                03: from the last three indexes represent decreasing company digits arrayRandomCompanies
		                04: between two turn difference of increasing or decreasing should by '1........3'

		    */
		                for (int c = 0; c < 6; c++) {
		                    int companyindex = arrayRandomCompanies[c];
		                    if (c < 3) {
		                        if (z == 0) {
		                            arrayRandomValues[c] = 1;// random;
		                        } else if (generalTrend[z - 1][companyindex] == (-3)) {
		                            arrayRandomValues[c] = generalTrend[z - 1][companyindex] + 1;

		                        } else {
		                            arrayRandomValues[c] = generalTrend[z - 1][companyindex] + 1;
		                        }
		                    } else {
		                        if (z == 0) {
		                            arrayRandomValues[c] = -1;

		                        } else if (generalTrend[z - 1][companyindex] == (+3)) {
		                            arrayRandomValues[c] = generalTrend[z - 1][companyindex] - 1;
		                        } else {
		                            arrayRandomValues[c] = generalTrend[z - 1][companyindex] - 1;
		                        }
		                    }
		                }
		                //mapping finalized values : one turn + 12 companies

		                for (int d = 0; d < 6; d++) {

		                    valcompanyindex = arrayRandomCompanies[d];
		                    valrandom = arrayRandomValues[d];
		                    int e = arrayfinalizedturn[valcompanyindex];
		                    if (e == 0) {
		                        arrayfinalizedturn[valcompanyindex] = valrandom;
		                    }

		                }

		                for (int x = 0; x < generalTrend[z].length; x++) {
		                    generalTrend[z][x] = arrayfinalizedturn[x];
		                }

		                //              set randomly generated value to parent array
		                break;
		            }

		        }
		        //------------------------------GENERAL TREND MARKET COMPONENT ALGORITHM ENDS--------
		        //      test printing for validation
		        for (int v = 0; v < generalTrend.length; v++) {

		            for (int w = 0; w < generalTrend[v].length; w++) {
		              //  System.out.print(generalTrend[v][w] + "   ");
		            }
		           // System.out.println("");
		        }
		        //      returns finalized array
		        return generalTrend;

		    }

		    public static boolean contains(final int[] array, final int v) {

		        boolean result = false;

		        for (int i : array) {
		            if (i == v) {
		                result = true;
		                break;
		            }
		        }

		        return result;
		    }

}
