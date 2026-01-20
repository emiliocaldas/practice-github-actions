package com.ec.demos.githubactions;

import java.math.BigDecimal;
import java.util.Scanner;

import com.ec.demos.githubactions.service.CalculoInteresService;

/**
 * Calculo de Interes de prestamo con TEA del 15% anual
 */
public class App {

    public static void main(String[] args) {
        System.out.println("Calculo de Interes de prestamo con TEA del 15% anual");

        CalculoInteresService calculoInteresService = CalculoInteresService.INSTANCE;

        String input;
        try (Scanner scanner = new Scanner(System.in)) {

            do {
                System.out.print("Enter loan amount: ");
                input = scanner.nextLine();
                BigDecimal montoPrestamo = new BigDecimal(input);

                System.out.print("Enter loan term in days: ");
                input = scanner.nextLine();
                int plazoDias = Integer.parseInt(input);

                BigDecimal interes = calculoInteresService.calcularInteres(montoPrestamo, plazoDias);
                System.out.println("Calculated interest: " + interes);

                System.out.println("Type 'exit' to quit or press Enter to calculate again.");
                input = scanner.nextLine();

            } while (!input.equals("exit"));
        }

        System.out.println("Exiting...");
    }
}
