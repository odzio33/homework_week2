package pl.odzio33.homework_week2.shop.sevice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pl.odzio33.homework_week2.shop.repository.ProductRepository;

import java.math.BigDecimal;

@Service
@Profile("Pro")
public class ShopProService extends ShopPlusService implements IShopService{
    @Value("${discount}")
    private BigDecimal discount;

    ProductRepository productRepository;

    public ShopProService(){};

    @Autowired
    public ShopProService(ProductRepository productRepository) {
        super(productRepository);
        this.productRepository = productRepository;
    }

    @Override
    public void getProductSum() {
        super.getProductSum();
        getProductSumWithVatAndDiscount();
    }

    private void getProductSumWithVatAndDiscount(){
        BigDecimal productWithVat = productRepository.getSumProductWithVat(vatRate);
        System.out.println("Sum prize + VAT + discount:" + productWithVat.subtract(discount));
    }
}
