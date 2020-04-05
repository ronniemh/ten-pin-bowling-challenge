package dev.ronniemoncayo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.sound.sampled.SourceDataLine;

/**
 * Class containing main method
 * @author Ronnie Moncayo
 */
public class App 
{
    public static void main( String[] args )
    {
       String text = "11";
       System.out.println(text.matches("([0-9]|10|F)"));
    }

}
