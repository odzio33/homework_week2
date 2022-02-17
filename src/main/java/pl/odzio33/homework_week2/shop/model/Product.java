package pl.odzio33.homework_week2.shop.model;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class Product {
    private String productName;
    private BigDecimal productPrice;

    public Product() {
        this.productName = "DefaultNamePC";
        this.productPrice = BigDecimal.valueOf(1.00);
    }

    public Product(String productName, BigDecimal productPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", productPrice=" + productPrice + "[PLN]" +
                '}';
    }
}
