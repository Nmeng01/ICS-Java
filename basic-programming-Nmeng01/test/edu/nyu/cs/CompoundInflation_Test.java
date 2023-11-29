// DO NOT TOUCH THIS FILE!
package edu.nyu.cs;

// import junit 4 testing framework
import org.junit.Test;
import org.junit.Rule;
import static org.junit.Assert.*;
import org.junit.contrib.java.lang.system.SystemOutRule; // system rules lib - useful for capturing system output
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.*;
// import static org.mockito.Mockito.*;

import org.junit.ClassRule;

public class CompoundInflation_Test {

    // @Rule
    // public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @ClassRule
    public static final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule();

    private String[] mockInputs = {
        "120",
        "1600",
        "2100",
        "45.15"            
    };
    private String[] expectedValues = {
        "$114",
        "$1522",
        "$1997",
        "$43"
    };
    private String[] expectedOutputs = {
        "If you save $120 per month with 10% annual inflation, after 6 months, your account will hold an amount equivalent to $114 today.",
        "If you save $1600 per month with 10% annual inflation, after 6 months, your account will hold an amount equivalent to $1522 today.",
        "If you save $2100 per month with 10% annual inflation, after 6 months, your account will hold an amount equivalent to $1997 today.",
        "If you save $45 per month with 10% annual inflation, after 6 months, your account will hold an amount equivalent to $43 today."
    };

    @Test
    public void testCorrectCalculations() {
        systemOutRule.enableLog(); // start capturing System.out
        int i = 0;
        for (String mockInput : this.mockInputs) {
            systemInMock.provideLines(mockInput);
            String[] args = {};
            try {
                CompoundInflation.main(args);
                String output = systemOutRule.getLogWithNormalizedLineSeparator();
                assertEquals(true, output.contains(this.expectedValues[i]));
                i++;
            }
            catch (Exception e) {
                assertEquals(true, e); // program crashed
            }
        }
    }

    @Test
    public void testExactOutput() {
        int i = 0;
        String[] args = {};
        systemOutRule.enableLog(); // start capturing System.out
        for (String mockInput : this.mockInputs) {
            systemOutRule.clearLog(); // clear any previous output from the log
            systemInMock.provideLines(mockInput);
            try {
                CompoundInflation.main(args);
                String output = systemOutRule.getLogWithNormalizedLineSeparator();
                String[] lines = output.split("\n");
                assertEquals(this.expectedOutputs[i], lines[1]); // second line should match expected
                i++;
            }
            catch (Exception e) {
                assertEquals(true, e); // program crashed
            }
        }
    }


}
