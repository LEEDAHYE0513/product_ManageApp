package com.ssg.product_manageapp.service;

import com.ssg.product_manageapp.config.ModelMapper;
import com.ssg.product_manageapp.domain.ProductVO;
import com.ssg.product_manageapp.dto.ProductDTO;
import com.ssg.product_manageapp.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
    private final ProductMapper productMapper;
    private final ModelMapper modelMapper;

    // 상품등록
    @Override
    public void register(ProductDTO productDTO){
        ProductVO productVO = modelMapper.getMapper().map(productDTO, ProductVO.class);
        productMapper.insert(productVO);
    }

    // 상품 조회
    @Override
    public ProductDTO getOne(long pid){
        ProductDTO productDTO = modelMapper.getMapper().map(productMapper.select(pid), ProductDTO.class);
        return productDTO;
    }

    // 상품 리스트 전체 조회
    @Override
    public List<ProductDTO> getAll(String pname){
        List<ProductDTO> dtoList = productMapper.selectAll(pname).stream()
                .map(vo-> modelMapper.getMapper().map(vo, ProductDTO.class))
                .collect(Collectors.toList());
        return dtoList;
    }

    // 상품 수정
    @Override
    public void modify(ProductDTO productDTO){
        ProductVO productVO = modelMapper.getMapper().map(productDTO, ProductVO.class);
        productMapper.update(productVO);
    }
    // 상품 삭제
    @Override
    public void remove(long pid){
        productMapper.delete(pid);
    }

}
