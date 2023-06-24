package com.cg.model.dto.bill;

import com.cg.model.Bill;
import com.cg.model.Product;
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
public class BillDetailDTO {
    private Long id;
    private Product product;
    private String title;
    private String unit;
    private BigDecimal price;
    private Long quantity;
    private BigDecimal amount;

}
