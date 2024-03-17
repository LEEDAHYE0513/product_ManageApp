package com.ssg.product_manageapp.dto;

import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@ToString
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private Long pno;
    @Size(min = 1,max= 100,message="상품이름은 1글자 이상~100글자 이하여야 합니다")
    private String pname;
    @Min(1)
    @Max(1000000)
    private Long price;
    @Min(0)
    @Max(99999)
    private Long count;
    private String pword;
}
