package pl.odzio33.homework_week2.shop.sevice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pl.odzio33.homework_week2.shop.repository.ProductRepository;

@Service
@Profile("Start")
public class ShopStartService implements IShopService {
    ProductRepository productRepository;

    public ShopStartService() {

    }
    @Autowired
    public ShopStartService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void getProductSum() {
        System.out.println("Sum prize in StartService:" + productRepository.getSumProduct());
    }
}
