package pl.odzio33.homework_week2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.odzio33.homework_week2.shop.model.Product;
import pl.odzio33.homework_week2.shop.repository.ProductRepository;
import pl.odzio33.homework_week2.shop.sevice.IShopService;

import java.math.BigDecimal;
import java.util.Scanner;

@Component
public class ShopApplication  implements CommandLineRunner {
    final ProductRepository productRepository;
    final Product product;
    final IShopService iShopService;

    public ShopApplication(ProductRepository productRepository, Product product, IShopService iShopService){
        this.productRepository = productRepository;
        this.product = product;
        this.iShopService = iShopService;
    }

    @Override
    public void run(String... args){
        productRepository.generateProducts();
        int option = 0;
        String productName;
        BigDecimal productPrice;
        Scanner scanner;

        System.out.println("Witaj w sklepie!");

        while(option != 9) {
            System.out.println("Wybierz 1 - dodaj product");
            System.out.println("Wybierz 2 - pokaż koszyk");
            System.out.println("Wybierz 9 - zakoncz");
            scanner = new Scanner(System.in);
            option = Integer.parseInt(scanner.next());
            switch (option){
                case 1:
                    System.out.println("Podaj nazwę produktu:");
                    scanner = new Scanner(System.in);
                    productName = scanner.next();

                    System.out.println("Podaj cenę (BigDecimal) produktu:");
                    scanner = new Scanner(System.in);
                    productPrice = scanner.nextBigDecimal();

                    productRepository.addProduct(new Product(productName,productPrice));

                case 2:
                    productRepository.showProductList();
                    iShopService.getProductSum();
                case 9:
                    break;
            }
        }
        System.exit(0);
    }
}
