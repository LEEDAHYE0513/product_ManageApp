package com.ssg.product_manageapp.domain;

import lombok.*;

@ToString
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class ProductVO {
    private Long pno;
    private String pname;
    private Long price;
    private Long count;
}
