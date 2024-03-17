package com.ssg.product_manageapp.mapper;

import com.ssg.product_manageapp.domain.ProductVO;
import com.ssg.product_manageapp.dto.ProductDTO;

import java.util.List;

public interface ProductMapper {
    // 상품등록
    void insert(ProductVO productVO);

    // 상품 조회
   ProductVO select(Long pno);

    // 상품 리스트 전체 조회
    List<ProductVO> selectAll(String pname);

    // 상품 수정
    void update(ProductVO productVO);

    // 상품 삭제
    void delete(Long pno);

    // 상품 검색
    ProductVO search();
}
