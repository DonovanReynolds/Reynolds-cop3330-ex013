package org.example;

import java.util.Scanner;

/*
 *   UCF COP 3330 Fall 2021 Assignment 13 Solution
 *   Copyright 2021 Donovan Reynolds
 */
public class App 
{
    public static void main( String[] args )
    {
        String principalText = inputOutput("What is the prinicpal amount?");
        String rateText = inputOutput("What is the rate?");
        String timeText = inputOutput("What is the number of years?");
        String timesText = inputOutput("What is the number of times the interest is compounded per year?");

        double principal = stringToDouble(principalText);
        double rate = stringToDouble(rateText)/100;
        int time = stringToInt(timeText);
        int times = stringToInt(timesText);

        double total = compoundInterest(principal,rate,time,times);
        total = Math.ceil(total*100)/100;

        String output = String.format("$%.2f invested at %.1f%% for %d years compounded %d times per year is $%.2f",principal,rate*100,time,times,total);

        System.out.println(output);

    }

    public static double compoundInterest (double p, double r, int t,int n)
    {
        return p * Math.pow((1+r/n),(n*t));
    }

    public static String inputOutput(String textToSay)
    {
        Scanner input = new Scanner(System.in);
        System.out.println(textToSay);
        return input.nextLine();
    }

    public static int stringToInt(String text)
    {
        return Integer.parseInt(text);
    }

    public static double stringToDouble (String text)
    {
        return Double.parseDouble(text);
    }
}
