package pl.odzio33.homework_week2.shop.repository;

import org.springframework.stereotype.Repository;
import pl.odzio33.homework_week2.shop.model.Product;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class ProductRepository {
    public List<Product> productList;


    private static final int MIN_PRICE = 50;
    private static final int MAX_PRICE = 300;

    public void generateProducts() {
        Random generator = new Random();
        productList =
                Stream.iterate(1, n -> n + 1)
                        .limit(5)
                        .map(x -> new Product("Prod" + x, BigDecimal.valueOf((long) generator.nextInt(MAX_PRICE - MIN_PRICE) + MIN_PRICE).setScale(2, RoundingMode.CEILING)))
                        .collect(Collectors.toList());
    }
    public void addProduct(Product product){
        productList.add(product);
    }

    public BigDecimal getSumProduct() {
        return productList.stream().map(Product::getProductPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal getSumProductWithVat(BigDecimal vatRate){
        return getSumProduct().multiply(vatRate);
    }

    public void showProductList() {
        productList.forEach(System.out::println);
    }
}
