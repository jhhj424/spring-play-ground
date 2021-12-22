package com.play.ground.api;

import com.play.ground.application.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/shops")
@RestController
public class ShopController {

    private final ShopService shopService;

    @GetMapping
    public ResponseEntity<List<ShopResponse>> findShops() {
        List<ShopResponse> shops = shopService.findAll();
        return ResponseEntity.ok()
                .body(shops);
    }

    @PostMapping
    public ResponseEntity<ShopResponse> create(@RequestBody ShopRequest shopRequest) {
        ShopResponse shop = shopService.create(shopRequest);
        return ResponseEntity.created(URI.create("/api/shops" + shop.getId()))
                .body(shop);
    }

    @PutMapping("/{shopId}")
    public ResponseEntity<Void> update(@PathVariable Long shopId, @RequestBody ShopRequest shopRequest) {
        shopService.update(shopId, shopRequest);
        return ResponseEntity.ok().build();
    }
}
