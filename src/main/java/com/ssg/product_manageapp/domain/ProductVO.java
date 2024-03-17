package com.ssg.product_manageapp.domain;

import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

@ToString
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class ProuductVO {
    private Long pid;
    private String pname;
    private Long price;
    private Long count;
}
