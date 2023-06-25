package com.cg.repository;

import com.cg.model.Bill;
import com.cg.model.User;
import com.cg.model.dto.bill.BillDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {

    @Query("SELECT NEW com.cg.model.dto.bill.BillDTO(" +
            "b.id, " +
            "b.totalAmount, " +
            "b.user," +
            "b.locationRegion," +
            "b.status) " +
            "FROM Bill b " +
            "WHERE b.status = 1")
    List<BillDTO> findAllBillDTO ();
    @Query("SELECT NEW com.cg.model.dto.bill.BillDTO(" +
            "b.id, " +
            "b.totalAmount, " +
            "b.user," +
            "b.locationRegion," +
            "b.status) " +
            "FROM Bill b " +
            "WHERE b.user.id = :id")
    List<BillDTO> findBillDTOByIdUser (Long id);

}