package utils;

import domain.Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MyFileReader {


    public List<Product> getFromFile(String pathToFile) throws IOException {

        List<Product> products = new ArrayList<>();

        FileReader fileReader = new FileReader(pathToFile);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String singleLine;

        while ((singleLine = bufferedReader.readLine()) != null) {
            products.add(convertToProduct(singleLine));
        }

        bufferedReader.close();
        return products;
    }

    private Product convertToProduct(String input) {
        String[] values = input.split(";");

        String name = values[0];
        BigDecimal price = new BigDecimal(values[1]);
        BigDecimal vat = new BigDecimal(values[2]);

        return new Product(name, price, vat);
    }
}
