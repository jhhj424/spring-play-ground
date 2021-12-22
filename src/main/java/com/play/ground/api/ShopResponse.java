package com.play.ground.api;

import com.play.ground.domain.Shop;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
public class ShopResponse {

    private final long id;
    private final String name;

    public static List<ShopResponse> ofList(List<Shop> shops) {
        return shops.stream()
                .map(ShopResponse::of)
                .collect(Collectors.toList());
    }

    public static ShopResponse of(Shop shop) {
        return new ShopResponse(shop.getId(), shop.getName());
    }
}
