package edu.nyu.cs;



/**
 * This question is based on Question 1-11 in Liang's Intro to Java textbook.
 * 
 * Complete this program such that it:
 *  - calculates and displays the projected population for each of the next five years.
 *
 * The U.S. Census Bureau projects population based on the following assumptions:
 *  - Current population: 332,403,650
 *  - Each year has 365 days
 *  - One birth every 7 seconds
 *  - One death every 13 seconds
 *  - One new immigrant every 45 seconds
 * 
 * Hint:
 *  - There are no fractional people.  All population projections must be integers.
 *  - In Java, if two integers perform division, the result is an integer - the fractional part is truncated.  
 *  - To get an accurate result, one of the values in the division must be a number with a decimal place.
 * 
 * Sample output. Your program should format the output exactly like this: 
 *  Here are the projected population numbers for the next five years:
 *  - Year 2023: 333505890
 *  - Year 2024: 345678825 
 *  - Year 2025: 358766234 
 *  - Year 2026: 365805245 
 *  - Year 2027: 373925136 
 */
public class PopulationProjector {

    /**
     * The main function is automatically called first in a Java program.
     * Complete the assignment within this function.
     * 
     * @param args An array of any command-line arguments.  Java requires the main function include this, even if not used.
     * @throws Exception Allows us to not worry about Exceptions in this function. Java requires the main functino include this, even if not used.
     */
    public static void main(String[] args) throws Exception {
        System.out.println("Here are the projected population numbers for the next five years:");
        int curr_year = 2023;
        int sec_per_year = 60*60*24*365;
        double curr_pop = 332403650.0;
        for(int i = 0; i < 5; i++) {
            curr_pop = curr_pop + sec_per_year/7.0 + sec_per_year/45.0 - sec_per_year/13.0;
            Double temp_pop = new Double(curr_pop);
            int curr_pop_int = temp_pop.intValue();
            System.out.println("- Year " + curr_year + ": " + curr_pop_int);
            curr_pop = curr_pop_int;
            curr_year++;
            
        }
    }


}
