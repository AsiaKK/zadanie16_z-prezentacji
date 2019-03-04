package utils;

import domain.Product;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        MyFileReader myFileReader = new MyFileReader();
        ProductValuesCalculation productValuesCalculation = new ProductValuesCalculation();

        List<Product> productsFromFile = myFileReader.getFromFile("Vat.CSV");
        System.out.println("Wczytuję dane z pliku");

        printOrders(productsFromFile);

        BigDecimal sumBrutto = productValuesCalculation.sumBruttoPrice(productsFromFile);
        System.out.println("Suma brutto = " + sumBrutto);

        BigDecimal sumVat = productValuesCalculation.sumVat(productsFromFile);
        System.out.println("Suma Vat = " + sumVat);

        BigDecimal sumNetto = productValuesCalculation.sumNettoPrice(productsFromFile);
        System.out.println("Suma Netto = " + sumNetto);

    }

    private static void printOrders(List<Product> products) {
        System.out.println("ZESTAWIENIE ZAMOWIEN");
        for (Product product : products) {
            System.out.println(product.toString());
        }
    }
}