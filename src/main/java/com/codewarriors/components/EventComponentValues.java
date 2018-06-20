package com.codewarriors.components;

import java.text.DecimalFormat;
import java.util.Random;

public class EventComponentValues {
	
	 public static int[][] eventComponentValuesGenerator(final int[][] eventDuration) {

	        //instances, arrays and variables declaration begin
	        Random random = new Random();
	        DecimalFormat decimalFormat = new DecimalFormat("###.##");
	        int[][] eventValues = new int[30][12];
	        int[] row = new int[15];
	        //because i need to get difference initialized to '1'
	        int increment = 1;
	        //instances, arrays and variables declaration end

	        //find event firing elements
	        for (int i = 0; i < eventDuration.length - 1; i++) {
	            for (int j = 0; j < eventDuration[i].length; j++) {
	                int a = eventDuration[i][j];
	                int b = eventDuration[i + 1][j];

	                if (!(eventDuration[i][j] == eventDuration[i + 1][j])) {
	                    row[increment] = i;
	                    increment++;
	                    break;
	                }
	            }
	        }
	        //checks the end of the array and make a #trick ;)
	        for (int i = 0; i < row.length; i++) {
	            if( (row[i] != 0 ) && ( row[i+1] == 0 ) && ( row[i+2] ==0 ) ) {
	                row[i + 1] = 29;
	                break;
	            }
	        }
	        //random values for events : changing values already given in the game specification doc -- begin
	        int randomboom = Integer.parseInt(decimalFormat.format(random.ints(1, 6).findAny().getAsInt()));
	        int randombust = Integer.parseInt(decimalFormat.format(random.ints(-5, 0).findAny().getAsInt()));
	        int randomprofit = Integer.parseInt(decimalFormat.format(random.ints(2, 4).findAny().getAsInt()));
	        int randomtakeover = Integer.parseInt(decimalFormat.format(random.ints(-5, 0).findAny().getAsInt()));
	        int randomscandal = Integer.parseInt(decimalFormat.format(random.ints(-5, -2).findAny().getAsInt()));
	        //random values for events -- end

	        //find the values for given events and assign them into parent array
	        for (int i = 0; i < row.length -1; i++) {

	            for (int j = row[i]; j <= row[i + 1]; j++) {

	                for (int k = 0; k < 12; k++) {

	                    int cc = eventDuration[j][k];
	                    if (cc > 0) {
	                        if (cc == 1) {
	                             eventValues[j][k] = randomboom;
	                        } else if (cc == 2) {
	                            eventValues[j][k] = randombust;
	                        } else if (cc == 3) {
	                            eventValues[j][k] = randomprofit;
	                        } else if (cc == 4) {
	                            eventValues[j][k] = randomtakeover;
	                        } else if (cc == 5) {
	                            eventValues[j][k] = randomscandal;
	                        }

	                    }
	                }
	            }
	        }
	        //test console print of parent array
	        for (int i = 0; i < eventValues.length; i++) {
	            for (int j = 0; j < eventValues[i].length; j++) {
	                System.out.print(eventValues[i][j] + " ");
	            }
	            System.out.println();
	        }

	        //returning parent array
	        return eventValues;
	    }


}
