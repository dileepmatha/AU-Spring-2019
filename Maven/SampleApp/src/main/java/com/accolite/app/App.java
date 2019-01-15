package com.accolite.app;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
    static double Max(){
        DescriptiveStatistics stats = new DescriptiveStatistics();
        for( int i = 0; i<5; i++) {
            stats.addValue(i);
        }
        double mean = stats.getMax();
        return mean;
    }
    static double Min(){
        DescriptiveStatistics stats = new DescriptiveStatistics();
        for( int i = 0; i<5; i++) {
            stats.addValue(i);
        }
        double mean = stats.getMin();
        return mean;
    }
}
