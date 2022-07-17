package com.blz;

import java.text.DateFormatSymbols;
import java.util.Arrays;

public class Gambler {
    public static final int BET = 1;
    public static final int AMOUNT = 100;
    public static float WON = 0;
    public static float LOSE = 0;
    public static int MONTH = 0;
    public static int total = 31;

    public static void main(String[] args) {
        DateFormatSymbols monthname = new DateFormatSymbols();
        String[] months = monthname.getMonths();
        for (MONTH = 1; MONTH < (months.length - 1); MONTH++) {
            String month = months[MONTH];
            System.out.println(month);
            WON = 0;
            LOSE = 0;
            int amount = 0;
            int[] days = new int[31];
            for (int day = 1; day < 31; day++) {
                int stake = 100;
                while (stake > (0.5 * AMOUNT) && stake < (1.5 * AMOUNT)) {
                    int bet = (int) (Math.floor(Math.random() * 10) % 2);
                    if (bet == BET) {
                        stake++;
                    } else if (bet == 0) {
                        stake--;
                    }
                }
                if (stake > AMOUNT) {
                    WON++;
                    amount = amount + 50;
                    days[day] = amount;
                    System.out.println("Day " + day + " Won," + " Total Amount from bet is $" + amount);
                } else if (stake < AMOUNT) {
                    LOSE++;
                    amount = amount - 50;
                    days[day] = amount;
                    System.out.println("Day " + day + " Lose," + " Total Amount from bet is $" + amount);
                }
            }
            if (WON > LOSE) {
                System.out.println("Month:" + month + ", WON:" + WON + " times," + " LOSE:" + LOSE + " times" + ", the total amount won is $" + amount);
                float percent = (((WON - LOSE) / 30) * 100);
                System.out.println("Luckiest Day:WON($" + getlargest(days, total) + ")");
                System.out.println("Won by " + percent + "%");
            } else if (LOSE > WON) {
                System.out.println("Month:" + month + ", WON:" + WON + " times," + " LOSE:" + LOSE + " times" + ", the total amount lose is $" + amount);
                float percent = (((LOSE - WON) / 30) * 100);
                System.out.println("Luckiest Day:WON($" + getlargest(days, total) + ")");
                System.out.println("Lose by " + percent + "%");
            } else System.out.println("Luckiest Day:WON($" + getlargest(days, total) + ")");
            System.out.println("Month:" + month + ", WON:" + WON + " times," + " LOSE:" + LOSE + " times" + ", Neither Won nor Lose");
        }
    }

    private static int getlargest(int[] days, int total) {
        int temp;
        for (int x = 0; x < total; x++) {
            for (int y = x + 1; y < total; y++) {
                if (days[x] > days[y]) {
                    temp = days[x];
                    days[x] = days[y];
                    days[y] = temp;
                }
            }
        }
        int smallest = days[0];
        int largest = days[0];
        int i;
        for (i = 1; i < days.length; i++) {
            if (days[i] > largest) {

                largest = days[i];
            } else if (days[i] < smallest) smallest = days[i];
        }
        System.out.println("Unluckiest Day:LOST($" + smallest + ")");
        return days[total - 1];
    }
}