package com.cg.api;


import com.cg.exception.DataInputException;
import com.cg.model.Bill;
import com.cg.model.BillDetail;
import com.cg.model.User;
import com.cg.model.dto.bill.BillDTO;
import com.cg.model.dto.bill.BillDetailDTO;
import com.cg.model.dto.cart.CartDetailDTO;
import com.cg.model.dto.product.ProductDTO;
import com.cg.service.bill.IBillService;
import com.cg.service.billDetail.IBillDetailService;
import com.cg.service.cart.ICartService;
import com.cg.service.cartDetail.ICartDetailService;
import com.cg.service.product.IProductService;
import com.cg.service.user.IUserService;
import com.cg.utils.AppUtils;
import com.cg.utils.ValidateUtils;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bills")
public class BillAPI {

    @Autowired
    private IBillService billService;

    @Autowired
    private IBillDetailService billDetailService;

    @Autowired
    private IUserService userService;

    @Autowired
    private IProductService productService;

    @Autowired
    private AppUtils appUtils;

    @Autowired
    private ValidateUtils validateUtils;

    @GetMapping()
    public ResponseEntity<List<?>> findAllBills() {
        try {
            List<BillDTO> billDTOS = billService.findAllBillDTO();

            if (billDTOS.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(billDTOS, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/bill-detail-by-bill/{id}")
    public ResponseEntity<List<?>> findAllBillDetail (@PathVariable String id) {
        if (!validateUtils.isNumberValid(id)) {
            throw new DataInputException("Mã bill không hợp lệ");
        }
        Long billId = Long.parseLong(id);

        try {
            List<BillDetailDTO> billDetailDTOS = billDetailService.findBillDetailByBillId(billId);

            if (billDetailDTOS.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(billDetailDTOS, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/bill-detail-by-user")
    public ResponseEntity<List<?>> findAllBillDetailByUser() {

        String username = appUtils.getPrincipalUsername();

        Optional<User> userOptional = userService.findByUsername(username);
        if (userOptional.isEmpty()) {
            throw new DataInputException("User not valid");
        }

        try {
            List<BillDTO> billDTOS = billService.findBillDTOByIdUser(userOptional.get().getId());

            if (billDTOS.isEmpty()) {
                throw new DataInputException("Bill not valid");
            }

            List<BillDetailDTO> billDetailDTOS = billDetailService.findAllBillDetailDTO(userOptional.get().getId());


            if (billDetailDTOS.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(billDetailDTOS, HttpStatus.OK);

        } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
