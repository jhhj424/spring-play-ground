package com.play.ground.api;

import com.play.ground.application.ShopService;
import com.play.ground.domain.Shop;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class ShopController {

    private final ShopService shopService;

    @GetMapping("/shop")
    public List<Shop> findAll() {
        return shopService.findAll();
    }

    @PostMapping("/shop")
    public void create(@RequestBody Shop shop) {
        log.info("ShopName: {}", shop.getName());
        shopService.create(shop);
    }

    @PutMapping("/shop")
    public void update(@RequestBody Shop shop) {
        shopService.update(shop);
    }
}
