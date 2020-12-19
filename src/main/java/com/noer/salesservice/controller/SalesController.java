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
@RequestMapping("/api")
public class SalesController {

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
    @GetMapping(value = "getMockPertanyaan",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getMockPertanyaan(){
        String obj = "{\n" +
                "   \"data\":[\n" +
                "      {\n" +
                "         \"id\":1,\n" +
                "         \"pertanyaanId\":1,\n" +
                "         \"nomorKontrak\":\"23456734\",\n" +
                "         \"deskripsiPertanyaan\":\"PIC FIELD WORK\",\n" +
                "         \"verifikasiLabel\":null,\n" +
                "         \"indexPertanyaan\":1,\n" +
                "         \"inputTambahan\":false,\n" +
                "         \"inputType\":\"LABEL\",\n" +
                "         \"picField\":\"12345678\",\n" +
                "         \"inputParameterType\":null,\n" +
                "         \"visitId\":\"001/0302/K1/REG/QPC/I/2020\",\n" +
                "         \"samplingFrameField\":null,\n" +
                "         \"samplingFrameValue\":null,\n" +
                "         \"details\":[\n" +
                "            {\n" +
                "               \"opsijawaban\":null,\n" +
                "               \"jawabanSatu\":\"\",\n" +
                "               \"jawabanDua\":\"\",\n" +
                "               \"statusAlert\": false\n" +
                "            }\n" +
                "         ]\n" +
                "      },\n" +
                "      {\n" +
                "         \"id\":2,\n" +
                "         \"pertanyaanId\":2,\n" +
                "         \"nomorKontrak\":\"23456734\",\n" +
                "         \"deskripsiPertanyaan\":\"NAMA RESPONDEN\",\n" +
                "         \"verifikasiLabel\":null,\n" +
                "         \"indexPertanyaan\":2,\n" +
                "         \"inputTambahan\":false,\n" +
                "         \"inputType\":\"TEXTINPUT\",\n" +
                "         \"picField\":\"12345678\",\n" +
                "         \"inputParameterType\":null,\n" +
                "         \"visitId\":\"001/0302/K1/REG/QPC/I/2020\",\n" +
                "         \"samplingFrameField\":null,\n" +
                "         \"samplingFrameValue\":null,\n" +
                "         \"details\":[\n" +
                "            {\n" +
                "               \"opsiJawaban\":null,\n" +
                "               \"jawabanSatu\":\"\",\n" +
                "               \"jawabanDua\":\"\",\n" +
                "               \"statusAlert\": false\n" +
                "            }\n" +
                "         ]\n" +
                "      },\n" +
                "      {\n" +
                "         \"id\":3,\n" +
                "         \"pertanyaanId\":3,\n" +
                "         \"nomorKontrak\":\"23456734\",\n" +
                "         \"deskripsiPertanyaan\":\"HUBUNGAN DENGAN NASABAH\",\n" +
                "         \"verifikasiLabel\":null,\n" +
                "         \"indexPertanyaan\":3,\n" +
                "         \"inputTambahan\":false,\n" +
                "         \"inputType\":\"DROPDOWN\",\n" +
                "         \"picField\":\"12345678\",\n" +
                "         \"inputParameterType\":\"HUBUNGAN_NASABAH\",\n" +
                "         \"visitId\":\"001/0302/K1/REG/QPC/I/2020\",\n" +
                "         \"samplingFrameField\":null,\n" +
                "         \"samplingFrameValue\":null,\n" +
                "         \"details\":[\n" +
                "            {\n" +
                "               \"opsiJawaban\":\"\",\n" +
                "               \"jawabanSatu\":\"\",\n" +
                "               \"jawabanDua\":\"\",\n" +
                "               \"statusAlert\": false\n" +
                "            }\n" +
                "         ]\n" +
                "      },\n" +
                "      {\n" +
                "         \"id\":4,\n" +
                "         \"pertanyaanId\":4,\n" +
                "         \"nomorKontrak\":\"23456734\",\n" +
                "         \"deskripsiPertanyaan\":\"DARI MANA BAPAK/IBU/SAUDARA/I MENGETAHUI ADIRA FINANCE?\",\n" +
                "         \"verifikasiLabel\":null,\n" +
                "         \"indexPertanyaan\":4,\n" +
                "         \"inputTambahan\":false,\n" +
                "         \"inputType\":\"CHECKBOX\",\n" +
                "         \"picField\":\"12345678\",\n" +
                "         \"inputParameterType\": null,\n" +
                "         \"visitId\":\"001/0302/K1/REG/QPC/I/2020\",\n" +
                "         \"samplingrameField\":\"\",\n" +
                "         \"samplingFrameValue\":\"\",\n" +
                "         \"details\":[\n" +
                "            {\n" +
                "               \"opsiJawaban\":\"DEALER\",\n" +
                "               \"jawabanSatu\":\"\",\n" +
                "               \"jawabanDua\":\"\",\n" +
                "               \"statusAlert\": false\n" +
                "            },\n" +
                "            {\n" +
                "               \"opsiJawaban\":\"SAUDARA/TEMAN\",\n" +
                "               \"jawabanSatu\":\"\",\n" +
                "               \"jawabanDua\":\"\",\n" +
                "               \"statusAlert\": false\n" +
                "            },\n" +
                "            {\n" +
                "               \"opsiJawaban\":\"IKLAN\",\n" +
                "               \"jawabanSatu\":\"\",\n" +
                "               \"jawabanDua\":\"\",\n" +
                "               \"statusAlert\": false\n" +
                "            },\n" +
                "            {\n" +
                "               \"opsiJawaban\":\"AGEN AXI/KEDAY\",\n" +
                "               \"jawabanSatu\":\"\",\n" +
                "               \"jawabanDua\":\"\",\n" +
                "               \"statusAlert\": false\n" +
                "            },\n" +
                "            {\n" +
                "               \"opsiJawaban\":\"MEDIATOR/PERANTARA\",\n" +
                "               \"jawabanSatu\":\"\",\n" +
                "               \"jawabanDua\":\"\",\n" +
                "               \"statusAlert\": false\n" +
                "            },\n" +
                "            {\n" +
                "               \"opsiJawaban\":\"DATANG LANGSUNG KE KANTOR ADIRA\",\n" +
                "               \"jawabanSatu\":\"\",\n" +
                "               \"jawabanDua\":\"\",\n" +
                "               \"statusAlert\": false\n" +
                "            }\n" +
                "         ]\n" +
                "      },\n" +
                "      {\n" +
                "         \"id\":5,\n" +
                "         \"pertanyaanId\":5,\n" +
                "         \"nomorKontrak\":\"23456734\",\n" +
                "         \"deskripsiPertanyaan\":\"PRODUK ADIRA APA YANG BAPAK/IBU/SAUDARA/I KREDIT DARI ADIRA FINANCE?\",\n" +
                "         \"verifikasiLabel\":\"\",\n" +
                "         \"indexPertanyaan\":\"5\",\n" +
                "         \"inputTambahan\":\"true\",\n" +
                "         \"inputType\":\"RADIO\",\n" +
                "         \"picField\":\"12345678\",\n" +
                "         \"inputParameterType\":\"\",\n" +
                "         \"visitId\":\"\",\n" +
                "         \"samplingFrameField\":\"PRODUCT\",\n" +
                "         \"samplingFrameValue\":\"0002F-REGULAR NMCY\",\n" +
                "         \"details\":[\n" +
                "            {\n" +
                "               \"opsiJawaban\":\"SESUAI\",\n" +
                "               \"jawabanSatu\":\"\",\n" +
                "               \"jawabanDua\":\"\",\n" +
                "               \"statusAlert\": false\n" +
                "            },\n" +
                "            {\n" +
                "               \"opsiJawaban\":\"TIDAK SESUAI\",\n" +
                "               \"jawabanSatu\":\"\",\n" +
                "               \"jawabanDua\":\"\",\n" +
                "               \"statusAlert\": true\n" +
                "            }\n" +
                "         ]\n" +
                "      },\n" +
                "       {\n" +
                "         \"id\":6,\n" +
                "         \"pertanyaanId\":6,\n" +
                "         \"nomorKontrak\":\"23456734\",\n" +
                "         \"deskripsiPertanyaan\":\"JIKA UANG TUNAI, BERAPA YANG DITERIMA BAPAK/IBU/SAUDARA/I?\",\n" +
                "         \"verifikasiLabel\":\"\",\n" +
                "         \"indexPertanyaan\":\"6\",\n" +
                "         \"inputTambahan\":\"false\",\n" +
                "         \"inputType\":\"TEXTINPUT\",\n" +
                "         \"picField\":\"12345678\",\n" +
                "         \"inputParameterType\":\"\",\n" +
                "         \"visitId\":\"\",\n" +
                "         \"samplingFrameField\": null,\n" +
                "         \"samplingFrameValue\": null,\n" +
                "         \"details\":[\n" +
                "            {\n" +
                "               \"opsiJawaban\": null,\n" +
                "               \"jawabanSatu\":\"\",\n" +
                "               \"jawabanDua\":\"\"\n" +
                "               \"statusAlert\": false\n" +
                "            }\n" +
                "         ]\n" +
                "      },\n" +
                "      {\n" +
                "         \"id\":7,\n" +
                "         \"pertanyaanId\":7,\n" +
                "         \"nomorKontrak\":\"23456734\",\n" +
                "         \"deskripsiPertanyaan\":\"UNIT YANG DIKREDIT ATAU DIJAMINKAN?\",\n" +
                "         \"verifikasiLabel\":\"\",\n" +
                "         \"indexPertanyaan\":\"7\",\n" +
                "         \"inputTambahan\":\"true\",\n" +
                "         \"inputType\":\"RADIO\",\n" +
                "         \"picField\":\"12345678\",\n" +
                "         \"inputParameterType\":\"\",\n" +
                "         \"visitId\":\"\",\n" +
                "         \"samplingFrameField\": null,\n" +
                "         \"samplingFrameValue\": \"HONDA VARIO 125 ESP CBS\",\n" +
                "         \"details\":[\n" +
                "            {\n" +
                "               \"opsiJawaban\": \"SESUAI\",\n" +
                "               \"jawabanSatu\":\"\",\n" +
                "               \"jawabanDua\":\"\",\n" +
                "               \"statusAlert\": false\n" +
                "            },\n" +
                "            {\n" +
                "               \"opsiJawaban\": \"TIDAK SESUAI\",\n" +
                "               \"jawabanSatu\":\"\",\n" +
                "               \"jawabanDua\":\"\",\n" +
                "               \"statusAlert\": true\n" +
                "            }\n" +
                "         ]\n" +
                "      },\n" +
                "       {\n" +
                "         \"id\":8,\n" +
                "         \"pertanyaanId\":8,\n" +
                "         \"nomorKontrak\":\"23456734\",\n" +
                "         \"deskripsiPertanyaan\":\"TUJUAN PENGGUNAAN UANG ATAU UNIT UNTUK APA?\",\n" +
                "         \"verifikasiLabel\":\"\",\n" +
                "         \"indexPertanyaan\":\"8\",\n" +
                "         \"inputTambahan\":\"true\",\n" +
                "         \"inputType\":\"RADIO\",\n" +
                "         \"picField\":\"12345678\",\n" +
                "         \"inputParameterType\":\"\",\n" +
                "         \"visitId\":\"\",\n" +
                "         \"samplingFrameField\": null,\n" +
                "         \"samplingFrameValue\": \"HONDA VARIO 125 ESP CBS\",\n" +
                "         \"details\":[\n" +
                "            {\n" +
                "               \"opsiJawaban\": \"SESUAI\",\n" +
                "               \"jawabanSatu\":\"\",\n" +
                "               \"jawabanDua\":\"\",\n" +
                "               \"statusAlert\": false\n" +
                "            },\n" +
                "            {\n" +
                "               \"opsiJawaban\": \"TIDAK SESUAI\",\n" +
                "               \"jawabanSatu\":\"\",\n" +
                "               \"jawabanDua\":\"\",\n" +
                "               \"statusAlert\": true\n" +
                "            }\n" +
                "         ]\n" +
                "      }\n" +
                "      \n" +
                "   ]\n" +
                "}";
        return ResponseEntity.ok(obj);
    }
}
