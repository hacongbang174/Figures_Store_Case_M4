package com.cg.model.dto.bill;

import com.cg.model.EPayment;
import com.cg.model.dto.user.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BillDTO {
    private Long id;
    private BigDecimal totalAmount;
    private UserDTO userDTO;
    private EPayment status;
}
