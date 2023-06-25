package com.cg.model.dto.cart;

import com.cg.model.Cart;
import com.cg.model.LocationRegion;
import com.cg.model.User;
import com.cg.model.dto.locationRegion.LocationRegionDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartDTO {
    private Long id;
    private BigDecimal totalAmount;

    public Cart toCart(User user) {
        return new Cart()
                .setId(id)
                .setTotalAmount(totalAmount)
                .setUser(user);
    }
}
