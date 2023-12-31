package com.cg.repository;

import com.cg.model.Product;

import java.math.BigDecimal;
import java.util.List;

import com.cg.model.dto.product.ProductDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT NEW com.cg.model.dto.product.ProductDTO ( " +
            "pr.id, " +
            "pr.title, " +
            "pr.price, " +
            "pr.quantity, " +
            "pr.description, " +
            "pr.unit, " +
            "pr.category, " +
            "pr.productAvatar " +
            ") " +
            "FROM Product AS pr " +
            "WHERE pr.quantity > 0"
    )
    List<ProductDTO> findAllProductDTO();

    @Query("SELECT NEW com.cg.model.dto.product.ProductDTO ( " +
            "pr.id, " +
            "pr.title, " +
            "pr.price, " +
            "pr.quantity, " +
            "pr.description, " +
            "pr.unit, " +
            "pr.category, " +
            "pr.productAvatar " +
            ") " +
            "FROM Product AS pr " +
            "WHERE lower(pr.title)LIKE CONCAT('%', LOWER(?1), '%') " +
            "AND pr.category.id IN (?2) " +
            "AND pr.price BETWEEN ?3 AND ?4 " +
            "AND pr.quantity > 0" +
            "ORDER BY pr.id ASC"
    )
    Page<ProductDTO> findAllProductDTOByKeyWordAndCategoryAndPrice (String search, List<Long> category, BigDecimal minPrice, BigDecimal maxPrice, Pageable pageable);

    @Query("SELECT NEW com.cg.model.dto.product.ProductDTO ( " +
            "pr.id, " +
            "pr.title, " +
            "pr.price, " +
            "pr.quantity, " +
            "pr.description, " +
            "pr.unit, " +
            "pr.category, " +
            "pr.productAvatar " +
            ") " +
            "FROM Product AS pr " +
            "WHERE pr.quantity > 0" +
            "ORDER BY pr.id ASC"
    )
    Page<ProductDTO> findAllProductDTOPage(Pageable pageable);
    Boolean existsProductById(Long id);
}