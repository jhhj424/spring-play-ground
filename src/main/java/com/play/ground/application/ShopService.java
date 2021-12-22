package com.play.ground.application;

import com.play.ground.api.ShopRequest;
import com.play.ground.api.ShopResponse;
import com.play.ground.domain.Shop;
import com.play.ground.domain.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class ShopService {

    private final ShopRepository shopRepository;

    public List<ShopResponse> findAll() {
        return ShopResponse.ofList(shopRepository.findAll());
    }

    @Transactional
    public ShopResponse create(ShopRequest shopRequest) {
        Shop shop = shopRepository.save(shopRequest.toShop());
        return ShopResponse.of(shop);
    }

    @Transactional
    public void update(Long shopId, ShopRequest shopRequest) {
        System.out.println("shopId = " + shopId);
        Shop shop = shopRepository.findById(shopId)
                .orElseThrow(() -> new IllegalArgumentException("해당 매장이 존재하지 않습니다."));
        shop.update(shopRequest.toShop());
    }
}
