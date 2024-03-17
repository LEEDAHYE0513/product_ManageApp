package com.ssg.product_manageapp.service;

import com.ssg.product_manageapp.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    // 상품등록
    void register(ProductDTO productDTO);

    // 상품 조회
    ProductDTO getOne(long pno);

    // 상품 리스트 전체 조회
    List<ProductDTO> getAll(String pname);

    // 상품 수정
    void modify(ProductDTO productDTO);
    // 상품 삭제
    void remove(long pno);
}
