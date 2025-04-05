package services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import utils.*;

public class ExtractServices implements ConsoleStyle
{

    public static void extract(String bankName) throws InterruptedException 
    {
        CleanScreen.clean();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String now = LocalDateTime.now().format(formatter);

        // Header
        System.out.println(BOLDER + "════════════════════════════════════════════════════════════════════════════════════");
        System.out.println(BOLDER + SUCCESS + "                                     BANK STATEMENT                                      " + RESET);
        System.out.println(BOLDER + "════════════════════════════════════════════════════════════════════════════════════");

        // Client Info
        System.out.printf(BOLDER + "%-20s %s\n" + RESET, "Client ID:", "554");
        System.out.printf(BOLDER + "%-20s %s\n" + RESET, "Bank:", bankName);
        System.out.printf(BOLDER + "%-20s %s\n" + RESET, "Branch:", "0012-3");

        System.out.println(BOLDER + "════════════════════════════════════════════════════════════════════════════════════");

        // Statement Header
        System.out.printf(BOLDER + "%-15s %-30s %-15s %20s\n", "DATE", "DESCRIPTION", "DOC", "AMOUNT");
        System.out.println(BOLDER + "────────────────────────────────────────────────────────────────────────────────────");

        // Transactions
        System.out.printf(BOLDER + "%-15s %-30s %-15s %20s\n", "10/02/2023", "Transfer Received", "654321", "+2,500.00");
        System.out.printf(BOLDER + "%-15s %-30s %-15s %20s\n", "11/02/2023", "Electricity Bill", "112233", "-350.89");
        System.out.printf(BOLDER + "%-15s %-30s %-15s %20s\n", "13/02/2023", "Grocery Store", "778899", "-213.45");
        System.out.printf(BOLDER + "%-15s %-30s %-15s %20s\n", "15/02/2023", "Salary Deposit", "987654", "+3,200.00");

        System.out.println(BOLDER + "════════════════════════════════════════════════════════════════════════════════════");
        System.out.printf(BOLDER + SUCCESS + "%-30s %50s\n", "Current Balance:", "\tR$ 5.136,66" + RESET);
        System.out.printf(BOLDER + INFO    + "%-30s %50s\n", "Available Limit:", "\tR$ 1.000,00" + RESET);
        System.out.printf(BOLDER + WARNING + "%-30s %50s\n", "Total Available:", "\tR$ 6.136,66" + RESET);
        System.out.println(BOLDER + "════════════════════════════════════════════════════════════════════════════════════");
    }

}
