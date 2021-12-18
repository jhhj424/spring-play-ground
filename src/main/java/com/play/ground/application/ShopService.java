package com.play.ground.application;

import com.play.ground.domain.Shop;
import com.play.ground.domain.ShopRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class ShopService {

    private final ShopRepository shopRepository;

    public List<Shop> findAll() {
        return shopRepository.findAll();
    }

    public void create(Shop shop) {
        shopRepository.save(shop);
    }

    @Transactional
    public void update(Shop shop) {
        log.info("shop: {}", shop);
        Shop persistShop = shopRepository.findById(shop.getId())
                .orElseThrow(IllegalArgumentException::new);

        persistShop.update(shop);
    }
}
