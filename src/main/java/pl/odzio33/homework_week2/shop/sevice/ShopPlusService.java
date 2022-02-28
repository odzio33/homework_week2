package pl.odzio33.homework_week2.shop.sevice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pl.odzio33.homework_week2.shop.repository.ProductRepository;

import java.math.BigDecimal;

@Service
@Profile("Plus")
public class ShopPlusService extends ShopStartService implements IShopService {
    @Value("${vat-rate}")
    protected BigDecimal vatRate;

    ProductRepository productRepository;

    public ShopPlusService() {

    }
    @Autowired
    public ShopPlusService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void getProductSum() {
        getProductionSumPlus(productRepository, vatRate);
    }

    private static void getProductionSumPlus(ProductRepository productRepository, BigDecimal vatRate){
        System.out.println("Sum prize in PlusService:" + productRepository.getSumProduct());
        System.out.println("Sum prize + VAT:" + productRepository.getSumProductWithVat(vatRate));
    }

    public BigDecimal getVatRate() {
        return vatRate;
    }
}
