package com.blz;

public class Gambler {
    public static final int BET = 1;
    public static final int AMOUNT = 100;

    public static void main(String[] args) {

        int stake = 100;

        while (stake > (0.5 * AMOUNT) && stake < (1.5 * AMOUNT)) {
            int bet = (int) (Math.floor(Math.random() * 10) % 2);
            if (bet == 1) {
                System.out.println("Won $1");
                System.out.println("Initial Stake is $" + stake + ", won $1 " + "and total is " + "$"+(stake + BET));
                stake++;
            } else if (bet == 0) {
                System.out.println("Loss $1");
                System.out.println("Initial Stake is $" + stake + ", lost $1 " + "and total is " + "$"+(stake - BET));
                stake--;
            }
        }
    }
}
