package com.codewarriors.components;

import java.text.DecimalFormat;
import java.util.Random;

public class EventComponentEvents {
	

    public static int[][] eventComponentRandomEventGenerator() {
        /*
            This the coding phase for Event Component:
            **parent array returns randomly selected sectors/stocks with the randomValue indicator
                Event Component as two events:

                    1). Sector Events
                        1. BOOM Events (indicator => randomValue = 1)
                            Probability of event occur is 0.5; therefore this event affected for two sectors at a once
                        2. BUST Events (indicator => randomValue = 2)
                            Probability of event occur is 0.5; therefore this event affected for two sectors at a once

                    2). Stock Events
                        3. PROFIT_WARNING (indicator => randomValue = 3)
                            Probability of event occur is 0.50; therefore this event affected for six stocks at a once
                        4. TAKE_OVER (indicator => randomValue = 4)
                            Probability of event occur is 0.25; therefore this event affected for three stocks at a once
                        5. SCANDAL (indicator => randomValue = 5)
                            Probability of event occur is 0.25; therefore this event affected for three stocks at a once

         */

        //instances, arrays and variables declaration begin
        Random random = new Random();
        DecimalFormat decimalFormat = new DecimalFormat("###.##");
        int[] affectedSectorsStocks = new int[2];
        int[] affectedProfitWarning = new int[6];
        int[] affectedTakeOverScandal = new int[3];
        int[][] eventDurationHolder = new int[30][12];
        int randomEvent, randomEventDurationGap = 0, randomSct, randomSectorEvents, randomStockEvents, randomValue, randomStk;
        double randomSelector;
        //instances, arrays and variables declaration end

        for (int eventTrendRow = 0; eventTrendRow < eventDurationHolder.length; eventTrendRow++) {

            for (int eventTrendColumn = 0; eventTrendColumn < eventDurationHolder[eventTrendRow].length; eventTrendColumn++) {


//     if randomEvent equals
//                          (*):'0' : it is generating sector event ;
//                          (*):'1'  : it is generating stock event;
                {
                    randomSelector = Double.parseDouble(decimalFormat.format(random.doubles(0.00, 1.00).findAny().getAsDouble()));
                    if (randomSelector > 0.00 && randomSelector <= 0.33)
                        randomEvent = 0;
                    else
                        randomEvent = 1;

                    switch (randomEvent) {
                        case 0: //sector event
                            randomSectorEvents = Integer.parseInt(decimalFormat.format(random.ints(0, 2).findAny().getAsInt()));

                            switch (randomSectorEvents) {
                                case 0://Boom event randomValue = bust id=1
                                    randomEventDurationGap = Integer.parseInt(decimalFormat.format(random.ints(2, 6).findAny().getAsInt()));
                                    //randomEventDurationGap=5;
                                    System.out.println("Random Event Duration Gap : " + randomEventDurationGap);
                                    //select random two sectors out of four
                                    for (int i = 0; i < 2; i++) {
                                        randomSct = Integer.parseInt(decimalFormat.format(random.ints(1, 5).findAny().getAsInt()));

                                        if (contains(affectedSectorsStocks, randomSct)) {
                                            i--;

                                        } else {
                                            randomValue = Integer.parseInt(decimalFormat.format(random.ints(1, 5).findAny().getAsInt()));
                                            affectedSectorsStocks[i] = randomSct;
                                            System.out.println(randomSct + " " + randomEventDurationGap);
                                            //randomValue boom id=1
                                            sectorEventController(eventDurationHolder, randomEventDurationGap, randomSct, eventTrendRow, 1);
                                        }
                                    }
                                    break;

                                //call BUST Event
                                case 1: //bust event randomValue = bust id=2
                                    randomEventDurationGap = Integer.parseInt(decimalFormat.format(random.ints(2, 6).findAny().getAsInt()));
                                    for (int i = 0; i < 2; i++) {
                                        randomSct = Integer.parseInt(decimalFormat.format(random.ints(1, 5).findAny().getAsInt()));

                                        if (contains(affectedSectorsStocks, randomSct)) {
                                            i--;

                                        } else {
                                            randomValue = Integer.parseInt(decimalFormat.format(random.ints(-5, 0).findAny().getAsInt()));
                                            affectedSectorsStocks[i] = randomSct;
                                            sectorEventController(eventDurationHolder, randomEventDurationGap, randomSct, eventTrendRow, 2);
                                        }
                                    }


                                    break;

                            }
                            eventTrendRow = eventTrendRow + (randomEventDurationGap - 1);
                            break;

                        case 1:// stock event
                            //selecting stock event for current turn
                            randomStockEvents = Integer.parseInt(decimalFormat.format(random.ints(1, 4).findAny().getAsInt()));
                            randomEventDurationGap = Integer.parseInt(decimalFormat.format(random.ints(1, 8).findAny().getAsInt()));

                            switch (randomStockEvents) {
                                //call PROFIT_WARNING event
                                case 1:// randomValue = 3
                                    //select random 6 stocks out of twelve
                                    if (randomStockEvents == 1) {//PROFIT_WARNING
                                        for (int i = 0; i < 6; i++) {

                                            randomStk = Integer.parseInt(decimalFormat.format(random.ints(1, 12).findAny().getAsInt()));

                                            if (contains(affectedProfitWarning, randomStk)) {
                                                i--;

                                            } else {
                                                affectedProfitWarning[i] = randomStk;
                                            }
                                        }
                                        stockEventController(eventDurationHolder, randomEventDurationGap, affectedProfitWarning, eventTrendRow, 3);

                                    }
                                    break;
                                //call TAKE_OVER Event
                                case 2:// randomValue = 4
                                    if (randomStockEvents == 2) {
                                        for (int i = 0; i < 3; i++) {

                                            randomStk = Integer.parseInt(decimalFormat.format(random.ints(1, 12).findAny().getAsInt()));

                                            if (contains(affectedTakeOverScandal, randomStk)) {
                                                i--;

                                            } else {
                                                affectedTakeOverScandal[i] = randomStk;
                                            }

                                        }
                                        stockEventController(eventDurationHolder, randomEventDurationGap, affectedTakeOverScandal, eventTrendRow, 4);
                                    }


                                    break;
                                //call SCANDAL Event
                                case 3:// randomValue = 5

                                    for (int i = 0; i < 3; i++) {

                                        randomStk = Integer.parseInt(decimalFormat.format(random.ints(1, 12).findAny().getAsInt()));
                                        if (contains(affectedTakeOverScandal, randomStk)) {
                                            i--;
                                        } else {
                                            affectedTakeOverScandal[i] = randomStk;
                                        }

                                    }
                                    stockEventController(eventDurationHolder, randomEventDurationGap, affectedTakeOverScandal, eventTrendRow, 5);
                                    break;

                            }
                            eventTrendRow = eventTrendRow + (randomEventDurationGap - 1);
                            break;

                    }
                    break;
                }

            }

        }
        //test print of parent array
        for (int i = 0; i < eventDurationHolder.length; i++) {
            for (int j = 0; j < eventDurationHolder[i].length; j++) {
                System.out.print(eventDurationHolder[i][j] + " ");
            }
            System.out.println();
        }
        return eventDurationHolder;
    }

    private static boolean stockEventController(final int[][] eventDurations, final int randomEventDuration, final int[] affectedStocks, final int currentTurn, final int randomValue) {

        boolean result = false;
        int current = currentTurn;

        for (int i = 0; i < randomEventDuration; i++) {
            if (currentTurn == 0) {

                if (randomValue == 3) {
                    for (int j = 0; j < 6; j++) {
                        int abc = affectedStocks[j];
                        eventDurations[i][abc] = randomValue;
                    }
                } else if (randomValue == 4) {
                    for (int j = 0; j < 3; j++) {
                        int abc = affectedStocks[j];
                        eventDurations[i][abc] = randomValue;
                    }
                } else if (randomValue == 5) {
                    for (int j = 0; j < 3; j++) {
                        int abc = affectedStocks[j];
                        eventDurations[i][abc] = randomValue;
                    }
                }
            } else {
                int change = randomEventDuration;

                if ((currentTurn + randomEventDuration) >= 29) {
                    change = 30 - currentTurn;

                } else {
                    change = randomEventDuration;
                }
                int abc;
                for (int k = 0; k < change; k++) {
                    if (randomValue == 3) {
                        for (int j = 0; j < 6; j++) {
                            abc = affectedStocks[j];
                            eventDurations[current + k][abc] = randomValue;
                        }
                    } else if (randomValue == 4) {

                        for (int j = 0; j < 3; j++) {
                            abc = affectedStocks[j];
                            eventDurations[current + k][abc] = randomValue;
                        }

                    } else if (randomValue == 5) {
                        for (int j = 0; j < 3; j++) {
                            abc = affectedStocks[j];
                            eventDurations[current + k][abc] = randomValue;
                        }
                    }
                }


            }
        }
        return result;
    }


    private static boolean sectorEventController(final int[][] eventDurations, final int randomEventDuration, final int sector, final int currentTurn, final int randomValue) {
        boolean eventStatus = false;


        int valevent = randomEventDuration;
        if (currentTurn == 0) {

            for (int i = 0; i < randomEventDuration; i++) {
                if (sector == 1) {
                    for (int j = 0; j < 3; j++) {
                        eventDurations[i][j] = randomValue;
                    }
                } else if (sector == 2) {
                    for (int j = 3; j < 6; j++) {
                        eventDurations[i][j] = randomValue;
                    }
                } else if (sector == 3) {
                    for (int j = 6; j < 9; j++) {
                        eventDurations[i][j] = randomValue;
                    }
                } else {
                    for (int j = 9; j < 12; j++) {
                        eventDurations[i][j] = randomValue;
                    }
                }

            }

        } else {

            int change = randomEventDuration;
            if ((currentTurn + randomEventDuration) >= 29) {
                change = 30 - currentTurn;
            } else {
                change = randomEventDuration;
            }

            for (int i = 0; i < change; i++) {
                int gapcontroller, current = currentTurn;
                if (sector == 1) {
                    gapcontroller = 3;
                    for (int j = 0; j < gapcontroller; j++) {
                        eventDurations[current + i][j] = randomValue;
                    }
                } else if (sector == 2) {
                    gapcontroller = 6;
                    for (int j = 3; j < gapcontroller; j++) {
                        eventDurations[current + i][j] = randomValue;
                    }
                } else if (sector == 3) {
                    gapcontroller = 9;
                    for (int j = 6; j < gapcontroller; j++) {
                        eventDurations[current + i][j] = randomValue;
                    }
                } else {
                    gapcontroller = 12;
                    for (int j = 9; j < gapcontroller; j++) {
                        eventDurations[current + i][j] = randomValue;
                    }
                }

            }

        }
        
        return eventStatus;
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
