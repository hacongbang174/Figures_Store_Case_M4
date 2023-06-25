package com.cg.model.dto.bill;

import com.cg.model.EPayment;
import com.cg.model.LocationRegion;
import com.cg.model.User;
import com.cg.model.dto.locationRegion.LocationRegionDTO;
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
    private LocationRegionDTO locationRegionDTO;
    private EPayment status;

    public BillDTO(Long id, BigDecimal totalAmount, User user, LocationRegion locationRegion, EPayment status) {
        this.id = id;
        this.totalAmount = totalAmount;
        this.userDTO = user.toUserDTO();
        this.locationRegionDTO = locationRegion.toLocationRegionDTO();
        this.status = status;
    }
}
