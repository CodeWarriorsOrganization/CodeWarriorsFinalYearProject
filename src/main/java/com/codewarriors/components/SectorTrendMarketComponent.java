package com.codewarriors.components;

import java.text.DecimalFormat;
import java.util.Random;

public class SectorTrendMarketComponent {
	  public static int[][] sectorTrendMarketStockRandomValue() {
	        /*
	        when this function calls, it's returns two dimensional array which contains call of sector trend affected companies with its values
	        Assumptions:
	            01: Only four(4) Sectors pre-established
	            02: sectorTend[30][12] array's row values(12) are sorted by the sectors as follows :
	                arrayCompanies[12] = {0,1,2,3,4,5,6,7,8,9,10,11}
	                0-2  : sector 1,
	                3-5  : sector 2,
	                6-8  : sector 3,
	                9-11 : sector 4
	         */

	        Random randomobj = new Random();
	        DecimalFormat decimalFormat = new DecimalFormat();

	        int[][] sectorTrend = new int[30][12];

	        int random, min, max;

	        // for loop handles 30 turns
	        for (int i = 0; i < sectorTrend.length; i++) {
	            min = 1;
	            max = 5;
	            // random value for select which sector going to be fire
	            random = Integer.parseInt(decimalFormat.format(randomobj.ints(min, max).findAny().getAsInt()));

	            //switch to sector based on the random value
	            switch (random) {
	                case 1:
	                    findPreviousArrayElement(sectorTrend, i, random);
	                    break;
	                case 2:
	                    findPreviousArrayElement(sectorTrend, i, random);
	                    break;
	                case 3:
	                    findPreviousArrayElement(sectorTrend, i, random);
	                    break;
	                case 4:
	                    findPreviousArrayElement(sectorTrend, i, random);
	                    break;
	                default:
	                    System.out.println("Sorry I could'nt select Sector right now, see you at the next turn");
	                    break;
	            }

	        }
	        //test print of final result
	        for (int z = 0; z < sectorTrend.length; z++) {
	            for (int w = 0; w < sectorTrend[z].length; w++) {
	              //  System.out.print(sectorTrend[z][w] + " ");

	            }
	          //  System.out.println(" ");

	        }

	        return sectorTrend;
	    }

	    //method which handles value changing sectors and stocks of the current turn
	    public static void findPreviousArrayElement(final int[][] arraySectorArray, final int currentTurn, final int randomSector) {

	        //objects and variables declaration begins

	        Random randomobj = new Random();
	        DecimalFormat decimalFormat = new DecimalFormat();
	        int position, val = 0;

	        //objects and variables declaration ends

	        if (randomSector == 1) {
	            //position '0' is the fist index of sector 1
	            position = 0;

	        } else if (randomSector == 2) {
	            //position '3' is the fist index of sector 2
	            position = 3;

	        } else if (randomSector == 3) {
	            //position '6' is the fist index of sector 3
	            position = 6;

	        } else {
	            //position '9' is the fist index of sector 4
	            position = 9;
	        }

	        //loop which handles current turn and previous turn for do the prediction of current turn
	        for (int j = 0; j < arraySectorArray.length; j++) {

	            if (currentTurn == 0) {
	                //Assumption : game allowed only values increasing
	                val = arraySectorArray[currentTurn][position] + 1;
	                break;

	            } else if (Integer.parseInt(String.valueOf(arraySectorArray[currentTurn - 1][position])) == (-3)) {
	                //(-3) is the at lowest value for the sector trend market component therefore based on rules given need to increase the value by '1'
	                val = arraySectorArray[currentTurn - 1][position] + 1;
	                break;

	            } else if (Integer.parseInt(String.valueOf(arraySectorArray[currentTurn - 1][position])) == (3)) {
	                //(+3) is the at most values for the sector trend market component therefore based on rules given need to decrease the value by '1'
	                val = arraySectorArray[currentTurn - 1][position] - 1;
	                break;

	            } else {
	                //if indicator value is '1' increases value by 1 or else decreases by '1'
	                int indicator = Integer.parseInt(decimalFormat.format(randomobj.ints(1, 3).findAny().getAsInt()));

	                if (indicator == 1) {
	                    //indicator '1' represents value should increase by '1'
	                    val = arraySectorArray[currentTurn - 1][position] + 1;
	                    break;

	                } else {
	                    //indicator '2' represents value should decrease by '1'
	                    val = arraySectorArray[currentTurn - 1][position] - 1;
	                    break;
	                }

	            }

	        }
	        //computation #trick for the following for loop block ;)
	        position = position - 1;

	        //update the predicted values with the sectorArray(parent array); in here updates all companies belongs to randomly selected sector
	        for (int i = 0; i < 3; i++) {
	            position++;
	            //insert the affected row of the parent array
	            arraySectorArray[currentTurn][position] = val;
	        }
	    }

}
