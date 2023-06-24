package com.cg.model.dto.bill;

import com.cg.model.EPayment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BillReqDTO {
    private EPayment status;
}
