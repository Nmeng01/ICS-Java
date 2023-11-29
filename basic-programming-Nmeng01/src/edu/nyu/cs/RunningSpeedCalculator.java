package edu.nyu.cs;

import java.util.Scanner;

/**
 * This question is based on Question 1-10 in Liang's Intro to Java textbook.
 * 
 * Complete this program such that it:
 *  - asks the user how many kilometers they have run
 *  - asks the user how many minutes it took them to run that distance
 *  - displays the average speed of the runner in miles per hour
 * 
 * Here is a sample of what the program should output when run, with example user responses - yours should exactly match this pattern:
 *  How many kilometers did you run?
 *  10
 *  How many minutes did it take you?
 *  30
 *  Your average speed was 12.5 miles per hour.
 */
public class RunningSpeedCalculator {

  /**
   * The main function is automatically called first in a Java program.
   * Write your program logic within this function.
   * Use the Scanner class's nextLine() function to get user input as a String
   * Use the Double.parseDouble() function to covert a String to a double.
   * Do not round any numbers or limit any decimal places in your calculations.
   * Assume 1 mile = 1.609344 kilometers.
   * 
   * @param args An array of any command-line arguments.  Java requires the main function include this, even if not used.
   * @throws Exception Allows us to not worry about Exceptions in this function. Java requires the main functino include this, even if not used.
   */
  public static void main(String[] args) throws Exception {
    System.out.println("How many kilometers did you run?");
    Scanner distance_input = new Scanner(System.in);
    String distance = distance_input.nextLine();
    double distance_double = Double.parseDouble(distance);
    double distance_miles = distance_double/1.609344;
    System.out.println("How many minutes did it take you?");
    Scanner time_input = new Scanner(System.in);
    String time = time_input.nextLine();
    double time_double = Double.parseDouble(time);
    double time_hours = time_double/60;
    double avg_speed_mph = distance_miles/time_hours;
    System.out.print("Your average speed was " + avg_speed_mph + " miles per hour.");
    distance_input.close();
    time_input.close();
  }


}
