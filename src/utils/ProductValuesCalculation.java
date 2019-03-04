package utils;

import domain.Product;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class ProductValuesCalculation {

    public BigDecimal sumBruttoPrice(List<Product> products){
        BigDecimal sumBrutto = new BigDecimal(0);
        for (Product product : products) {
            sumBrutto = sumBrutto.add(product.getPrice());
        }
        return sumBrutto;
    }

    public BigDecimal sumVat(List<Product> products){
     BigDecimal sumVat = new BigDecimal(0);
        for (Product product : products) {
            sumVat = sumVat.add(calculateVat(product));
        }
        return sumVat;
    }

    public BigDecimal sumNettoPrice(List<Product> products){
        BigDecimal sumNetto = new BigDecimal(0);
        for (Product product : products) {
            sumNetto = sumNetto.add(calculateNetto(product));
        }
        return sumNetto;
    }

    public BigDecimal calculateVat(Product product){
        //vat = brutto - netto
        BigDecimal netto = calculateNetto(product);
        BigDecimal vat = product.getPrice().subtract(netto);
        return vat;
    }

    private BigDecimal calculateNetto(Product product) {
        //netto = (brutto /(1+vat))
        BigDecimal vatFactor = new BigDecimal(1).add(product.getVat());
        return product.getPrice().divide(vatFactor, 2, RoundingMode.HALF_UP);
    }
}