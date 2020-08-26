package com.noer.salesservice.salesrequest;

import com.noer.salesservice.vo.ProductVO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;
@Getter
@Setter
@Accessors(chain=true)
@NoArgsConstructor
@AllArgsConstructor
public class SalesRequest {
    private Long userId;
    private List<ProductVO> products;
}
