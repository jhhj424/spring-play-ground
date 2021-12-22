package com.play.ground.api;

import com.play.ground.domain.Shop;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ShopRequest {

    private String name;

    public Shop toShop() {
        return Shop.of(name);
    }
}
