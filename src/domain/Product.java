package domain;

import java.math.BigDecimal;
import java.util.StringJoiner;

public class Product {

    private String name;
    private BigDecimal price;
    private BigDecimal vat;

    public Product(String name, BigDecimal price, BigDecimal vat) {
        this.name = name;
        this.price = price;
        this.vat = vat;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getVat() {
        return vat;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Product.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("price=" + price)
                .add("vat=" + vat)
                .toString();
    }
}
