package com.ec.demos.githubactions.service;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculoInteresServiceTest {

    private final CalculoInteresService calculoInteresService = CalculoInteresService.INSTANCE;

    @Test
    void calcularInteresShouldReturnOk1() {

        BigDecimal montoPrestamo = new BigDecimal(1000);
        int plazoDias = 30;

        BigDecimal montoInteres = calculoInteresService.calcularInteres(montoPrestamo, plazoDias);
        BigDecimal montoEsperado = new BigDecimal("11.714917"); //11.71491700000

        assertEquals(0, montoInteres.compareTo(montoEsperado));
    }

    @Test
    void calcularInteresShouldReturnOk2() {

        BigDecimal montoPrestamo = new BigDecimal(5000);
        int plazoDias = 90;

        BigDecimal montoInteres = calculoInteresService.calcularInteres(montoPrestamo, plazoDias);
        BigDecimal montoEsperado = new BigDecimal("177.79038"); //177.79038000000

        assertEquals(0, montoInteres.compareTo(montoEsperado));
    }

    @ParameterizedTest
    @ValueSource(strings = {"2500|58.9176825", "3500|82.4847555", "4500|106.0518285"})
    void calcularInteresShouldReturnOkValues(String montosStr) {

        String montoPrestamoStr = montosStr.split("\\|")[0];
        String montoEsperadoStr = montosStr.split("\\|")[1];

        BigDecimal montoPrestamo = new BigDecimal(montoPrestamoStr);
        int plazoDias = 60;

        BigDecimal montoInteres = calculoInteresService.calcularInteres(montoPrestamo, plazoDias);
        BigDecimal montoEsperado = new BigDecimal(montoEsperadoStr);

        assertEquals(0, montoInteres.compareTo(montoEsperado));
    }
}
