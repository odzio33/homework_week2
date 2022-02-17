package pl.odzio33.homework_week2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.odzio33.homework_week2.shop.repository.ProductRepository;

@SpringBootApplication
public class HomeworkWeek2Application {

    public static void main(String[] args) {
        SpringApplication.run(HomeworkWeek2Application.class, args);
        ProductRepository productRepository = new ProductRepository();
        productRepository.showProductList();
    }

}
