package com.ec.demos.githubactions.service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import ch.obermuhlner.math.big.BigDecimalMath;

public class CalculoInteresService {

    public static final CalculoInteresService INSTANCE = new CalculoInteresService();
    public static final BigDecimal TEA = new BigDecimal("0.150"); // Tasa Efectiva Anual del 5%
    public static final BigDecimal DIAS_ANIO = new BigDecimal("360");

    private CalculoInteresService() {
    }

    public BigDecimal calcularInteres(BigDecimal montoPrestamo, int plazoDias) {

        BigDecimal factorInteres = BigDecimalMath.pow(TEA.add(BigDecimal.ONE), 
                BigDecimal.valueOf(plazoDias)
                    .setScale(10, RoundingMode.HALF_UP)
                    .divide(DIAS_ANIO, RoundingMode.HALF_UP),
                new MathContext(10))
            .subtract(BigDecimal.ONE);

        return montoPrestamo
            .setScale(2, RoundingMode.HALF_UP)
            .multiply(factorInteres);
    }

}
