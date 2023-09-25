import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();

        NumberFormat us = NumberFormat.getCurrencyInstance(Locale.US);
        String formattedUs = us.format(payment);

        NumberFormat india = NumberFormat.getCurrencyInstance(new Locale("en", "IN"));
        DecimalFormatSymbols symbols = ((DecimalFormat) india).getDecimalFormatSymbols();
        symbols.setCurrencySymbol("Rs.");
        ((DecimalFormat) india).setDecimalFormatSymbols(symbols);
        String formattedIndia = india.format(payment);

        NumberFormat china = NumberFormat.getCurrencyInstance(Locale.CHINA);
        String formattedChina = china.format(payment);

        NumberFormat france = NumberFormat.getCurrencyInstance(Locale.FRANCE);
        String formattedFrance = france.format(payment);

        System.out.println("US: " + formattedUs);
        System.out.println("India: " + formattedIndia);
        System.out.println("China: " + formattedChina);
        System.out.println("France: " + formattedFrance);
    }
}