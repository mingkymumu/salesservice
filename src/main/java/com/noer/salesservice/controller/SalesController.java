package com.noer.salesservice.controller;

import com.noer.salesservice.domain.Sales;
import com.noer.salesservice.domain.SalesDetails;
import com.noer.salesservice.dto.SalesDTO;
import com.noer.salesservice.dto.SalesDetailsDTO;
import com.noer.salesservice.salesrequest.SalesRequest;
import com.noer.salesservice.salesresponse.ProductResponse;
import com.noer.salesservice.salesresponse.UserResponse;
import com.noer.salesservice.service.SalesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/salesservice")
public class SalesController {
//    private final String USER_URL = "http://springboot-docker-compose-app-container-user:8000/api/userservice/user/";
//    private final String PRODUCT_URL = "http://springboot-docker-compose-app-container-product:8001/api/productservice/getproduct/";
//    private final String USER_URL = "http://localhost:8000/api/userservice/user/";
//    private final String PRODUCT_URL = "http://localhost:8001/api/productservice/getproduct/";

    private SalesService salesService;


//    @Autowired
//    RestTemplate restTemplate;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public SalesController(SalesService salesService) {
        this.salesService = salesService;

    }

//    @PostMapping(value = "createTrans")
//    public ResponseEntity<String> createSales(@RequestBody SalesRequest request){
//        Sales sales = new Sales();
//        UserResponse userResponse = restTemplate.getForObject(USER_URL+request.getUserId(),UserResponse.class);
//        sales.setUserId(userResponse.getId());
//        sales.setUserName(userResponse.getFullName());
//        sales.setTransactionDate(new Date());
//        if(request.getProducts().size() > 0){
//        List<SalesDetails> list =  request.getProducts().stream().map(obj -> {
//                SalesDetails details = new SalesDetails();
//                details.setSales(sales);
//                ProductResponse productResponse = restTemplate.getForObject(PRODUCT_URL+obj.getProductId(),ProductResponse.class);
//                details.setProductId(productResponse.getId());
//                details.setProductName(productResponse.getProductName());
//                details.setQuantity(obj.getQty());
//                details.setProductPrice(productResponse.getPrice());
//                return  details;
//            }).collect(Collectors.toList());
//            sales.setDetails(list);
//            sales.setTotal(sales.getTotal());
//        }
//        salesService.saveSalesTransaction(sales);
//        return ResponseEntity.ok("Data Success Saved");
//    }

    @DeleteMapping(value = "deleteTrans")
    public ResponseEntity<String> deleteSales(@RequestParam Long id){
        salesService.deleteSales(id);
        return ResponseEntity.ok("Data Success deleted");
    }

    @GetMapping(value = "getAllSales")
    public ResponseEntity<List<SalesDTO>> getAllSales(){
       List<Sales> salesList = salesService.getAllSales();
       List<SalesDTO> list = salesList.stream().filter(item -> item!=null).map(item -> {
           SalesDTO salesDTO = new SalesDTO(item.getId(),item.getUserId(),item.getUserName(), item.getTotal(),item.getTransactionDate(),convertToDTO(item.getDetails()));
           return salesDTO;
       }).collect(Collectors.toList());
       return ResponseEntity.ok(list);
    }

    private List<SalesDetailsDTO> convertToDTO (List<SalesDetails> list){
        return list.stream().filter(obj -> obj!= null).map( obj -> {
            SalesDetailsDTO salesDetailsDTO = new SalesDetailsDTO(obj.getId(),obj.getQuantity(),obj.getProductId(),obj.getProductName(),obj.getProductPrice(),0d);
            return salesDetailsDTO;
        }).collect(Collectors.toList());
    }
    @GetMapping(value = "getMockPenugasanList", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getMockPenugasan() {
        String obj = "{\n" +
                "   \"data\":[\n" +
                "      {\n" +
                "         \"no\":\"1\",\n" +
                "         \"namaNasabah\":\"Tom Cruise\",\n" +
                "         \"areaCollection\":\"MALANG-KOTA\",\n" +
                "         \"zipCode\":\"454545\",\n" +
                "         \"alamat\":\"MALANG UTARA\",\n" +
                "         \"merekModel\":\"Honda Vario\",\n" +
                "         \"nomorPolisi\":\"W6767HJ\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"no\":\"2\",\n" +
                "         \"namaNasabah\":\"Rihanna\",\n" +
                "         \"areaCollection\":\"SiDOARJO-KOTA\",\n" +
                "         \"zipCode\":\"454545\",\n" +
                "         \"alamat\":\"MALANG UTARA\",\n" +
                "         \"merekModel\":\"Honda Vario\",\n" +
                "         \"nomorPolisi\":\"W6767HJ\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"no\":\"3\",\n" +
                "         \"namaNasabah\":\"Stallone\",\n" +
                "         \"areaCollection\":\"MALANG-KOTA\",\n" +
                "         \"zipCode\":\"454545\",\n" +
                "         \"alamat\":\"MALANG UTARA\",\n" +
                "         \"merekModel\":\"Honda Vario\",\n" +
                "         \"nomorPolisi\":\"W6767HJ\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"no\":\"4\",\n" +
                "         \"namaNasabah\":\"Arnold\",\n" +
                "         \"areaCollection\":\"GRESIK-KOTA\",\n" +
                "         \"zipCode\":\"454545\",\n" +
                "         \"alamat\":\"MALANG UTARA\",\n" +
                "         \"merekModel\":\"Honda Vario\",\n" +
                "         \"nomorPolisi\":\"W6767HJ\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"no\":\"5\",\n" +
                "         \"namaNasabah\":\"Nick Carter\",\n" +
                "         \"areaCollection\":\"JOMBANG-KOTA\",\n" +
                "         \"zipCode\":\"454545\",\n" +
                "         \"alamat\":\"MALANG UTARA\",\n" +
                "         \"merekModel\":\"Honda Vario\",\n" +
                "         \"nomorPolisi\":\"W6767HJ\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"no\":\"6\",\n" +
                "         \"namaNasabah\":\"Aaron Carter\",\n" +
                "         \"areaCollection\":\"MOJOKERTO-KOTA\",\n" +
                "         \"zipCode\":\"454545\",\n" +
                "         \"alamat\":\"MALANG UTARA\",\n" +
                "         \"merekModel\":\"Honda Vario\",\n" +
                "         \"nomorPolisi\":\"W6767HJ\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"no\":\"7\",\n" +
                "         \"namaNasabah\":\"John cage\",\n" +
                "         \"areaCollection\":\"MALANG-KOTA\",\n" +
                "         \"zipCode\":\"454545\",\n" +
                "         \"alamat\":\"MALANG UTARA\",\n" +
                "         \"merekModel\":\"Honda Vario\",\n" +
                "         \"nomorPolisi\":\"W6767HJ\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"no\":\"8\",\n" +
                "         \"namaNasabah\":\"Sandra Bullock\",\n" +
                "         \"areaCollection\":\"GRESIK-KOTA\",\n" +
                "         \"zipCode\":\"454545\",\n" +
                "         \"alamat\":\"MALANG UTARA\",\n" +
                "         \"merekModel\":\"Honda Vario\",\n" +
                "         \"nomorPolisi\":\"W6767HJ\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"no\":\"9\",\n" +
                "         \"namaNasabah\":\"Tom Hank\",\n" +
                "         \"areaCollection\":\"GRESIK-KOTA\",\n" +
                "         \"zipCode\":\"454545\",\n" +
                "         \"alamat\":\"MALANG UTARA\",\n" +
                "         \"merekModel\":\"Honda Vario\",\n" +
                "         \"nomorPolisi\":\"W6767HJ\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"no\":\"10\",\n" +
                "         \"namaNasabah\":\"Richard Gere\",\n" +
                "         \"areaCollection\":\"MALANG-KOTA\",\n" +
                "         \"zipCode\":\"454545\",\n" +
                "         \"alamat\":\"MALANG UTARA\",\n" +
                "         \"merekModel\":\"Honda Vario\",\n" +
                "         \"nomorPolisi\":\"W6767HJ\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"no\":\"11\",\n" +
                "         \"namaNasabah\":\"Osama Bin Laden\",\n" +
                "         \"areaCollection\":\"MALANG-KOTA\",\n" +
                "         \"zipCode\":\"454545\",\n" +
                "         \"alamat\":\"MALANG UTARA\",\n" +
                "         \"merekModel\":\"Honda Vario\",\n" +
                "         \"nomorPolisi\":\"W6767HJ\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"no\":\"12\",\n" +
                "         \"namaNasabah\":\"Black Pink\",\n" +
                "         \"areaCollection\":\"MALANG-KOTA\",\n" +
                "         \"zipCode\":\"454545\",\n" +
                "         \"alamat\":\"MALANG UTARA\",\n" +
                "         \"merekModel\":\"Honda Vario\",\n" +
                "         \"nomorPolisi\":\"W6767HJ\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"no\":\"13\",\n" +
                "         \"namaNasabah\":\"Mang oleh\",\n" +
                "         \"areaCollection\":\"MALANG-KOTA\",\n" +
                "         \"zipCode\":\"454545\",\n" +
                "         \"alamat\":\"MALANG UTARA\",\n" +
                "         \"merekModel\":\"Honda Vario\",\n" +
                "         \"nomorPolisi\":\"W6767HJ\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"no\":\"14\",\n" +
                "         \"namaNasabah\":\"jason\",\n" +
                "         \"areaCollection\":\"MALANG-KOTA\",\n" +
                "         \"zipCode\":\"454545\",\n" +
                "         \"alamat\":\"MALANG UTARA\",\n" +
                "         \"merekModel\":\"Honda Vario\",\n" +
                "         \"nomorPolisi\":\"W6767HJ\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"no\":\"15\",\n" +
                "         \"namaNasabah\":\"Mark\",\n" +
                "         \"areaCollection\":\"SURABAYA-KOTA\",\n" +
                "         \"zipCode\":\"454545\",\n" +
                "         \"alamat\":\"SURABAYA UTARA\",\n" +
                "         \"merekModel\":\"Honda Vario\",\n" +
                "         \"nomorPolisi\":\"W6767HJ\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"no\":\"16\",\n" +
                "         \"namaNasabah\":\"Micheal\",\n" +
                "         \"areaCollection\":\"SURABAYA-KOTA\",\n" +
                "         \"zipCode\":\"454545\",\n" +
                "         \"alamat\":\"SURABAYA UTARA\",\n" +
                "         \"merekModel\":\"Honda Vario\",\n" +
                "         \"nomorPolisi\":\"W6767HJ\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"no\":\"17\",\n" +
                "         \"namaNasabah\":\"Ronaldo\",\n" +
                "         \"areaCollection\":\"SURABAYA-KOTA\",\n" +
                "         \"zipCode\":\"454545\",\n" +
                "         \"alamat\":\"SURABAYA UTARA\",\n" +
                "         \"merekModel\":\"Honda Vario\",\n" +
                "         \"nomorPolisi\":\"W6767HJ\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"no\":\"18\",\n" +
                "         \"namaNasabah\":\"Messi\",\n" +
                "         \"areaCollection\":\"SURABAYA-KOTA\",\n" +
                "         \"zipCode\":\"454545\",\n" +
                "         \"alamat\":\"SURABAYA UTARA\",\n" +
                "         \"merekModel\":\"Honda Vario\",\n" +
                "         \"nomorPolisi\":\"W6767HJ\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"no\":\"19\",\n" +
                "         \"namaNasabah\":\"Bob Marley\",\n" +
                "         \"areaCollection\":\"SURABAYA-KOTA\",\n" +
                "         \"zipCode\":\"454545\",\n" +
                "         \"alamat\":\"SURABAYA UTARA\",\n" +
                "         \"merekModel\":\"Honda Vario\",\n" +
                "         \"nomorPolisi\":\"W6767HJ\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"no\":\"20\",\n" +
                "         \"namaNasabah\":\"John wick\",\n" +
                "         \"areaCollection\":\"SURABAYA-KOTA\",\n" +
                "         \"zipCode\":\"454545\",\n" +
                "         \"alamat\":\"SURABAYA UTARA\",\n" +
                "         \"merekModel\":\"Honda Vario\",\n" +
                "         \"nomorPolisi\":\"W6767HJ\"\n" +
                "      }\n" +
                "   ]\n" +
                "}";
        return ResponseEntity.ok(obj);
    }

}
