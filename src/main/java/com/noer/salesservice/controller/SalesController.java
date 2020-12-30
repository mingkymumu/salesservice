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
                "         \"no\":\"23456734\",\n" +
                "         \"namaNasabah\":\"Tom Cruise\",\n" +
                "         \"areaCollection\":\"MALANG-KOTA\",\n" +
                "         \"zipCode\":\"454545\",\n" +
                "         \"alamat\":\"MALANG UTARA\",\n" +
                "         \"merekModel\":\"Honda Vario\",\n" +
                "         \"nomorPolisi\":\"W6767HJ\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"no\":\"23456735\",\n" +
                "         \"namaNasabah\":\"Rihanna\",\n" +
                "         \"areaCollection\":\"SiDOARJO-KOTA\",\n" +
                "         \"zipCode\":\"454545\",\n" +
                "         \"alamat\":\"MALANG UTARA\",\n" +
                "         \"merekModel\":\"Honda Vario\",\n" +
                "         \"nomorPolisi\":\"W6767HJ\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"no\":\"23456736\",\n" +
                "         \"namaNasabah\":\"Stallone\",\n" +
                "         \"areaCollection\":\"MALANG-KOTA\",\n" +
                "         \"zipCode\":\"454545\",\n" +
                "         \"alamat\":\"MALANG UTARA\",\n" +
                "         \"merekModel\":\"Honda Vario\",\n" +
                "         \"nomorPolisi\":\"W6767HJ\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"no\":\"23456737\",\n" +
                "         \"namaNasabah\":\"Arnold\",\n" +
                "         \"areaCollection\":\"GRESIK-KOTA\",\n" +
                "         \"zipCode\":\"454545\",\n" +
                "         \"alamat\":\"MALANG UTARA\",\n" +
                "         \"merekModel\":\"Honda Vario\",\n" +
                "         \"nomorPolisi\":\"W6767HJ\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"no\":\"23456738\",\n" +
                "         \"namaNasabah\":\"Nick Carter\",\n" +
                "         \"areaCollection\":\"JOMBANG-KOTA\",\n" +
                "         \"zipCode\":\"454545\",\n" +
                "         \"alamat\":\"MALANG UTARA\",\n" +
                "         \"merekModel\":\"Honda Vario\",\n" +
                "         \"nomorPolisi\":\"W6767HJ\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"no\":\"23456739\",\n" +
                "         \"namaNasabah\":\"Aaron Carter\",\n" +
                "         \"areaCollection\":\"MOJOKERTO-KOTA\",\n" +
                "         \"zipCode\":\"454545\",\n" +
                "         \"alamat\":\"MALANG UTARA\",\n" +
                "         \"merekModel\":\"Honda Vario\",\n" +
                "         \"nomorPolisi\":\"W6767HJ\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"no\":\"23456740\",\n" +
                "         \"namaNasabah\":\"John cage\",\n" +
                "         \"areaCollection\":\"MALANG-KOTA\",\n" +
                "         \"zipCode\":\"454545\",\n" +
                "         \"alamat\":\"MALANG UTARA\",\n" +
                "         \"merekModel\":\"Honda Vario\",\n" +
                "         \"nomorPolisi\":\"W6767HJ\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"no\":\"23456741\",\n" +
                "         \"namaNasabah\":\"Sandra Bullock\",\n" +
                "         \"areaCollection\":\"GRESIK-KOTA\",\n" +
                "         \"zipCode\":\"454545\",\n" +
                "         \"alamat\":\"MALANG UTARA\",\n" +
                "         \"merekModel\":\"Honda Vario\",\n" +
                "         \"nomorPolisi\":\"W6767HJ\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"no\":\"23456742\",\n" +
                "         \"namaNasabah\":\"Tom Hank\",\n" +
                "         \"areaCollection\":\"GRESIK-KOTA\",\n" +
                "         \"zipCode\":\"454545\",\n" +
                "         \"alamat\":\"MALANG UTARA\",\n" +
                "         \"merekModel\":\"Honda Vario\",\n" +
                "         \"nomorPolisi\":\"W6767HJ\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"no\":\"23456743\",\n" +
                "         \"namaNasabah\":\"Richard Gere\",\n" +
                "         \"areaCollection\":\"MALANG-KOTA\",\n" +
                "         \"zipCode\":\"454545\",\n" +
                "         \"alamat\":\"MALANG UTARA\",\n" +
                "         \"merekModel\":\"Honda Vario\",\n" +
                "         \"nomorPolisi\":\"W6767HJ\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"no\":\"23456744\",\n" +
                "         \"namaNasabah\":\"Osama Bin Laden\",\n" +
                "         \"areaCollection\":\"MALANG-KOTA\",\n" +
                "         \"zipCode\":\"454545\",\n" +
                "         \"alamat\":\"MALANG UTARA\",\n" +
                "         \"merekModel\":\"Honda Vario\",\n" +
                "         \"nomorPolisi\":\"W6767HJ\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"no\":\"23456745\",\n" +
                "         \"namaNasabah\":\"Black Pink\",\n" +
                "         \"areaCollection\":\"MALANG-KOTA\",\n" +
                "         \"zipCode\":\"454545\",\n" +
                "         \"alamat\":\"MALANG UTARA\",\n" +
                "         \"merekModel\":\"Honda Vario\",\n" +
                "         \"nomorPolisi\":\"W6767HJ\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"no\":\"23456746\",\n" +
                "         \"namaNasabah\":\"Mang oleh\",\n" +
                "         \"areaCollection\":\"MALANG-KOTA\",\n" +
                "         \"zipCode\":\"454545\",\n" +
                "         \"alamat\":\"MALANG UTARA\",\n" +
                "         \"merekModel\":\"Honda Vario\",\n" +
                "         \"nomorPolisi\":\"W6767HJ\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"no\":\"23456747\",\n" +
                "         \"namaNasabah\":\"jason\",\n" +
                "         \"areaCollection\":\"MALANG-KOTA\",\n" +
                "         \"zipCode\":\"454545\",\n" +
                "         \"alamat\":\"MALANG UTARA\",\n" +
                "         \"merekModel\":\"Honda Vario\",\n" +
                "         \"nomorPolisi\":\"W6767HJ\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"no\":\"23456748\",\n" +
                "         \"namaNasabah\":\"Mark\",\n" +
                "         \"areaCollection\":\"SURABAYA-KOTA\",\n" +
                "         \"zipCode\":\"454545\",\n" +
                "         \"alamat\":\"SURABAYA UTARA\",\n" +
                "         \"merekModel\":\"Honda Vario\",\n" +
                "         \"nomorPolisi\":\"W6767HJ\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"no\":\"23456749\",\n" +
                "         \"namaNasabah\":\"Micheal\",\n" +
                "         \"areaCollection\":\"SURABAYA-KOTA\",\n" +
                "         \"zipCode\":\"454545\",\n" +
                "         \"alamat\":\"SURABAYA UTARA\",\n" +
                "         \"merekModel\":\"Honda Vario\",\n" +
                "         \"nomorPolisi\":\"W6767HJ\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"no\":\"23456750\",\n" +
                "         \"namaNasabah\":\"Ronaldo\",\n" +
                "         \"areaCollection\":\"SURABAYA-KOTA\",\n" +
                "         \"zipCode\":\"454545\",\n" +
                "         \"alamat\":\"SURABAYA UTARA\",\n" +
                "         \"merekModel\":\"Honda Vario\",\n" +
                "         \"nomorPolisi\":\"W6767HJ\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"no\":\"23456751\",\n" +
                "         \"namaNasabah\":\"Messi\",\n" +
                "         \"areaCollection\":\"SURABAYA-KOTA\",\n" +
                "         \"zipCode\":\"454545\",\n" +
                "         \"alamat\":\"SURABAYA UTARA\",\n" +
                "         \"merekModel\":\"Honda Vario\",\n" +
                "         \"nomorPolisi\":\"W6767HJ\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"no\":\"23456752\",\n" +
                "         \"namaNasabah\":\"Bob Marley\",\n" +
                "         \"areaCollection\":\"SURABAYA-KOTA\",\n" +
                "         \"zipCode\":\"454545\",\n" +
                "         \"alamat\":\"SURABAYA UTARA\",\n" +
                "         \"merekModel\":\"Honda Vario\",\n" +
                "         \"nomorPolisi\":\"W6767HJ\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"no\":\"23456753\",\n" +
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
                "        \"inputTambahanType\":null,\n" +
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
                "        \"inputTambahanType\":null,\n" +
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
                "        \"inputTambahanType\":null,\n" +
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
                "        \"inputTambahanType\":null,\n" +
                "         \"inputType\":\"RADIO\",\n" +
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
                "         \"inputTambahan\":true,\n" +
                "        \"inputTambahanType\":\"TEXTINPUT\",\n" +
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
                "         \"inputTambahan\": false,\n" +
                "         \"inputTambahanType\":null,\n" +
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
                "               \"jawabanDua\":\"\",\n" +
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
                "         \"inputTambahan\":true,\n" +
                "        \"inputTambahanType\":\"TEXTINPUT\",\n" +
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
                "         \"inputTambahan\":true,\n" +
                "         \"inputTambahanType\":\"TEXTINPUT\",\n" +
                "         \"inputType\":\"RADIO\",\n" +
                "         \"picField\":\"12345678\",\n" +
                "         \"inputParameterType\":\"\",\n" +
                "         \"visitId\":\"\",\n" +
                "         \"samplingFrameField\": null,\n" +
                "         \"samplingFrameValue\": \"MULTIGUNA-MURABAHAH\",\n" +
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
                "      {\n" +
                "         \"id\":9,\n" +
                "         \"pertanyaanId\":9,\n" +
                "         \"nomorKontrak\":\"23456734\",\n" +
                "         \"deskripsiPertanyaan\":\"STATUS UNIT\",\n" +
                "         \"verifikasiLabel\":null,\n" +
                "         \"indexPertanyaan\":9,\n" +
                "         \"inputTambahan\":false,\n" +
                "        \"inputTambahanType\":null,\n" +
                "         \"inputType\":\"RADIO\",\n" +
                "         \"picField\":\"12345678\",\n" +
                "         \"inputParameterType\": null,\n" +
                "         \"visitId\":\"001/0302/K1/REG/QPC/I/2020\",\n" +
                "         \"samplingrameField\":\"\",\n" +
                "         \"samplingFrameValue\":\"\",\n" +
                "         \"details\":[\n" +
                "            {\n" +
                "               \"opsiJawaban\":\"NASABAH/PASANGAN\",\n" +
                "               \"jawabanSatu\":\"\",\n" +
                "               \"jawabanDua\":\"\",\n" +
                "               \"statusAlert\": false\n" +
                "            },\n" +
                "            {\n" +
                "               \"opsiJawaban\":\"KELUARGA\",\n" +
                "               \"jawabanSatu\":\"\",\n" +
                "               \"jawabanDua\":\"\",\n" +
                "               \"statusAlert\": false\n" +
                "            },\n" +
                "            {\n" +
                "               \"opsiJawaban\":\"SAUDARA/TEMAN\",\n" +
                "               \"jawabanSatu\":\"\",\n" +
                "               \"jawabanDua\":\"\",\n" +
                "               \"statusAlert\": true\n" +
                "            },\n" +
                "            {\n" +
                "               \"opsiJawaban\":\"GADAI\",\n" +
                "               \"jawabanSatu\":\"\",\n" +
                "               \"jawabanDua\":\"\",\n" +
                "               \"statusAlert\": true\n" +
                "            },\n" +
                "            {\n" +
                "               \"opsiJawaban\":\"OVER/CREDIT\",\n" +
                "               \"jawabanSatu\":\"\",\n" +
                "               \"jawabanDua\":\"\",\n" +
                "               \"statusAlert\": true\n" +
                "            },\n" +
                "            {\n" +
                "               \"opsiJawaban\":\"DITARIK\",\n" +
                "               \"jawabanSatu\":\"\",\n" +
                "               \"jawabanDua\":\"\",\n" +
                "               \"statusAlert\": true\n" +
                "            },\n" +
                "            {\n" +
                "               \"opsiJawaban\":\"HILANG\",\n" +
                "               \"jawabanSatu\":\"\",\n" +
                "               \"jawabanDua\":\"\",\n" +
                "               \"statusAlert\": true\n" +
                "            },\n" +
                "            {\n" +
                "               \"opsiJawaban\":\"BARANG BUKTI(KEPOLISIAN)\",\n" +
                "               \"jawabanSatu\":\"\",\n" +
                "               \"jawabanDua\":\"\",\n" +
                "               \"statusAlert\": true\n" +
                "            },\n" +
                "            {\n" +
                "               \"opsiJawaban\":\"TIDAK DIKETAHUI\",\n" +
                "               \"jawabanSatu\":\"\",\n" +
                "               \"jawabanDua\":\"\",\n" +
                "               \"statusAlert\": true\n" +
                "            }\n" +
                "         ]\n" +
                "      },\n" +
                "      {\n" +
                "         \"id\":10,\n" +
                "         \"pertanyaanId\":10,\n" +
                "         \"nomorKontrak\":\"23456734\",\n" +
                "         \"deskripsiPertanyaan\":\"UNIT/UANG TUNAI TERSEBUT DIGUNAKAN OLEH SIAPA?\",\n" +
                "         \"verifikasiLabel\":null,\n" +
                "         \"indexPertanyaan\":10,\n" +
                "         \"inputTambahan\":false,\n" +
                "        \"inputTambahanType\":null,\n" +
                "         \"inputType\":\"RADIO\",\n" +
                "         \"picField\":\"12345678\",\n" +
                "         \"inputParameterType\": null,\n" +
                "         \"visitId\":\"001/0302/K1/REG/QPC/I/2020\",\n" +
                "         \"samplingrameField\":\"\",\n" +
                "         \"samplingFrameValue\":\"\",\n" +
                "         \"details\":[\n" +
                "            {\n" +
                "               \"opsiJawaban\":\"SENDIRI/PASANGAN\",\n" +
                "               \"jawabanSatu\":\"\",\n" +
                "               \"jawabanDua\":\"\",\n" +
                "               \"statusAlert\": false\n" +
                "            },\n" +
                "            {\n" +
                "               \"opsiJawaban\":\"ANAK/ORANG TUA\",\n" +
                "               \"jawabanSatu\":\"\",\n" +
                "               \"jawabanDua\":\"\",\n" +
                "               \"statusAlert\": true\n" +
                "            },\n" +
                "            {\n" +
                "               \"opsiJawaban\":\"SAUDARA/TEMAN\",\n" +
                "               \"jawabanSatu\":\"\",\n" +
                "               \"jawabanDua\":\"\",\n" +
                "               \"statusAlert\": true\n" +
                "            },\n" +
                "            {\n" +
                "               \"opsiJawaban\":\"LAINNYA\",\n" +
                "               \"jawabanSatu\":\"\",\n" +
                "               \"jawabanDua\":\"\",\n" +
                "               \"statusAlert\": true\n" +
                "            }\n" +
                "         ]\n" +
                "      },\n" +
                "      {\n" +
                "         \"id\":11,\n" +
                "         \"pertanyaanId\":11,\n" +
                "         \"nomorKontrak\":\"23456734\",\n" +
                "         \"deskripsiPertanyaan\":\"APAKAH PETUGAS SURVEY DATANG KE RUMAH??\",\n" +
                "         \"verifikasiLabel\":\"\",\n" +
                "         \"indexPertanyaan\":11,\n" +
                "         \"inputTambahan\": false,\n" +
                "        \"inputTambahanType\":null,\n" +
                "         \"inputType\":\"RADIO\",\n" +
                "         \"picField\":\"12345678\",\n" +
                "         \"inputParameterType\":\"\",\n" +
                "         \"visitId\":\"\",\n" +
                "         \"samplingFrameField\": null,\n" +
                "         \"samplingFrameValue\": null,\n" +
                "         \"details\":[\n" +
                "            {\n" +
                "               \"opsiJawaban\": \"YA\",\n" +
                "               \"jawabanSatu\":\"\",\n" +
                "               \"jawabanDua\":\"\",\n" +
                "               \"statusAlert\": false\n" +
                "            },\n" +
                "            {\n" +
                "               \"opsiJawaban\": \"TIDAK\",\n" +
                "               \"jawabanSatu\":\"\",\n" +
                "               \"jawabanDua\":\"\",\n" +
                "               \"statusAlert\": false\n" +
                "            }\n" +
                "         ]\n" +
                "      },\n" +
                "      {\n" +
                "         \"id\":12,\n" +
                "         \"pertanyaanId\":12,\n" +
                "         \"nomorKontrak\":\"23456734\",\n" +
                "         \"deskripsiPertanyaan\":\"APAKAH PETUGAS SURVEY MEMBERIKAN PENJELASAN TERKAIT KREDIT ADIRA?\",\n" +
                "         \"verifikasiLabel\":null,\n" +
                "         \"indexPertanyaan\":12,\n" +
                "         \"inputTambahan\":false,\n" +
                "        \"inputTambahanType\":null,\n" +
                "         \"inputType\":\"CHECKBOX\",\n" +
                "         \"picField\":\"12345678\",\n" +
                "         \"inputParameterType\": null,\n" +
                "         \"visitId\":\"001/0302/K1/REG/QPC/I/2020\",\n" +
                "         \"samplingrameField\":\"\",\n" +
                "         \"samplingFrameValue\":\"\",\n" +
                "         \"details\":[\n" +
                "            {\n" +
                "               \"opsiJawaban\":\"HARGA UNIT\",\n" +
                "               \"jawabanSatu\":\"\",\n" +
                "               \"jawabanDua\":\"\",\n" +
                "               \"statusAlert\": false\n" +
                "            },\n" +
                "            {\n" +
                "               \"opsiJawaban\":\"ANGSURAM\",\n" +
                "               \"jawabanSatu\":\"\",\n" +
                "               \"jawabanDua\":\"\",\n" +
                "               \"statusAlert\": false\n" +
                "            },\n" +
                "            {\n" +
                "               \"opsiJawaban\":\"TENOR\",\n" +
                "               \"jawabanSatu\":\"\",\n" +
                "               \"jawabanDua\":\"\",\n" +
                "               \"statusAlert\": false\n" +
                "            },\n" +
                "            {\n" +
                "               \"opsiJawaban\":\"BUNGA/MARGIN\",\n" +
                "               \"jawabanSatu\":\"\",\n" +
                "               \"jawabanDua\":\"\",\n" +
                "               \"statusAlert\": false\n" +
                "            },\n" +
                "            {\n" +
                "               \"opsiJawaban\":\"CARA MEMBAYAR ANGSURAN\",\n" +
                "               \"jawabanSatu\":\"\",\n" +
                "               \"jawabanDua\":\"\",\n" +
                "               \"statusAlert\": false\n" +
                "            },\n" +
                "            {\n" +
                "               \"opsiJawaban\":\"TIDAK DIBERIKAN PENJELASAN\",\n" +
                "               \"jawabanSatu\":\"\",\n" +
                "               \"jawabanDua\":\"\",\n" +
                "               \"statusAlert\": true\n" +
                "            }\n" +
                "         ]\n" +
                "      },\n" +
                "      {\n" +
                "         \"id\":13,\n" +
                "         \"pertanyaanId\":13,\n" +
                "         \"nomorKontrak\":\"23456734\",\n" +
                "         \"deskripsiPertanyaan\":\"APAKAH BAPAK/IBU/SAUDARA/I (NASABAH) MENANDATANGANI AKAD/PERJANJIAN KREDIT?\",\n" +
                "         \"verifikasiLabel\":\"\",\n" +
                "         \"indexPertanyaan\":13,\n" +
                "         \"inputTambahan\":false,\n" +
                "        \"inputTambahanType\":null,\n" +
                "         \"inputType\":\"RADIO\",\n" +
                "         \"picField\":\"12345678\",\n" +
                "         \"inputParameterType\":\"\",\n" +
                "         \"visitId\":\"\",\n" +
                "         \"samplingFrameField\": null,\n" +
                "         \"samplingFrameValue\": null,\n" +
                "         \"details\":[\n" +
                "            {\n" +
                "               \"opsiJawaban\": \"YA\",\n" +
                "               \"jawabanSatu\":\"\",\n" +
                "               \"jawabanDua\":\"\",\n" +
                "               \"statusAlert\": false\n" +
                "            },\n" +
                "            {\n" +
                "               \"opsiJawaban\": \"TIDAK\",\n" +
                "               \"jawabanSatu\":\"\",\n" +
                "               \"jawabanDua\":\"\",\n" +
                "               \"statusAlert\": true\n" +
                "            },\n" +
                "            {\n" +
                "               \"opsiJawaban\": \"TIDAK DIKETAHUI\",\n" +
                "               \"jawabanSatu\":\"\",\n" +
                "               \"jawabanDua\":\"\",\n" +
                "               \"statusAlert\": true\n" +
                "            }\n" +
                "         ]\n" +
                "      },\n" +
                "      {\n" +
                "         \"id\":14,\n" +
                "         \"pertanyaanId\":14,\n" +
                "         \"nomorKontrak\":\"23456734\",\n" +
                "         \"deskripsiPertanyaan\":\"BAGAIMANA BAPAK/IBU/SAUDARA/I MENERIMA UNIT/UANG TUNAI?\",\n" +
                "         \"verifikasiLabel\":\"\",\n" +
                "         \"indexPertanyaan\":14,\n" +
                "         \"inputTambahan\":false,\n" +
                "        \"inputTambahanType\":null,\n" +
                "         \"inputType\":\"RADIO\",\n" +
                "         \"picField\":\"12345678\",\n" +
                "         \"inputParameterType\":\"\",\n" +
                "         \"visitId\":\"\",\n" +
                "         \"samplingFrameField\": null,\n" +
                "         \"samplingFrameValue\": null,\n" +
                "         \"details\":[\n" +
                "            {\n" +
                "               \"opsiJawaban\": \"DIANTAR KE RUMAH\",\n" +
                "               \"jawabanSatu\":\"\",\n" +
                "               \"jawabanDua\":\"\",\n" +
                "               \"statusAlert\": false\n" +
                "            },\n" +
                "            {\n" +
                "               \"opsiJawaban\": \"AMBIL DARI DEALER/SHOWROOM\",\n" +
                "               \"jawabanSatu\":\"\",\n" +
                "               \"jawabanDua\":\"\",\n" +
                "               \"statusAlert\": false\n" +
                "            },\n" +
                "            {\n" +
                "               \"opsiJawaban\": \"DIANTAR MEDIATOR\",\n" +
                "               \"jawabanSatu\":\"\",\n" +
                "               \"jawabanDua\":\"\",\n" +
                "               \"statusAlert\": false\n" +
                "            },\n" +
                "           {\n" +
                "               \"opsiJawaban\": \"LAINNYA\",\n" +
                "               \"jawabanSatu\":\"\",\n" +
                "               \"jawabanDua\":\"\",\n" +
                "               \"statusAlert\": false\n" +
                "            }\n" +
                "         ]\n" +
                "      },\n" +
                "       {\n" +
                "         \"id\":15,\n" +
                "         \"pertanyaanId\":15,\n" +
                "         \"nomorKontrak\":\"23456734\",\n" +
                "         \"deskripsiPertanyaan\":\"BERAPA BIAYA ADMINISTRASI YANG DIBERIKAN KEPADA PETUGAS ADIRA?\",\n" +
                "         \"verifikasiLabel\":null,\n" +
                "         \"indexPertanyaan\":15,\n" +
                "         \"inputTambahan\":false,\n" +
                "         \"inputTambahanType\":null,\n" +
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
                "               \"statusAlert\": true\n" +
                "            }\n" +
                "         ]\n" +
                "      },\n" +
                "       {\n" +
                "         \"id\":16,\n" +
                "         \"pertanyaanId\":16,\n" +
                "         \"nomorKontrak\":\"23456734\",\n" +
                "         \"deskripsiPertanyaan\":\"TUJUAN PENGGUNAAN UANG ATAU UNIT UNTUK APA?\",\n" +
                "         \"verifikasiLabel\":\"\",\n" +
                "         \"indexPertanyaan\":\"16\",\n" +
                "         \"inputTambahan\":true,\n" +
                "          \"inputTambahanType\":\"TEXTINPUT\",\n" +
                "         \"inputType\":\"RADIO\",\n" +
                "         \"picField\":\"12345678\",\n" +
                "         \"inputParameterType\":\"\",\n" +
                "         \"visitId\":\"\",\n" +
                "         \"samplingFrameField\": null,\n" +
                "         \"samplingFrameValue\": \"03 - PEG.SWASTA FORMAL\",\n" +
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
                "     {\n" +
                "         \"id\":17,\n" +
                "         \"pertanyaanId\":17,\n" +
                "         \"nomorKontrak\":\"23456734\",\n" +
                "         \"deskripsiPertanyaan\":\"BERAPA LAMA BAPAK/IBU/SAUDARA/I BEKERJA ATAU WIRAUSAHA?\",\n" +
                "         \"verifikasiLabel\":\"\",\n" +
                "         \"indexPertanyaan\":\"17\",\n" +
                "         \"inputTambahan\":true,\n" +
                "       \"inputTambahanType\":\"NUMERICINPUTNOCURRENCY\",\n" +
                "         \"inputType\":\"RADIO\",\n" +
                "         \"picField\":\"12345678\",\n" +
                "         \"inputParameterType\":\"\",\n" +
                "         \"visitId\":\"\",\n" +
                "         \"samplingFrameField\": null,\n" +
                "         \"samplingFrameValue\": \"36\",\n" +
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
                "      {\n" +
                "         \"id\":18,\n" +
                "         \"pertanyaanId\":18,\n" +
                "         \"nomorKontrak\":\"23456734\",\n" +
                "         \"deskripsiPertanyaan\":\"STATUS KEPEMILIKAN RUMAH\",\n" +
                "         \"verifikasiLabel\":\"\",\n" +
                "         \"indexPertanyaan\":\"18\",\n" +
                "         \"inputTambahan\":true,\n" +
                "        \"inputTambahanType\":\"TEXTINPUT\",\n" +
                "         \"inputType\":\"RADIO\",\n" +
                "         \"picField\":\"12345678\",\n" +
                "         \"inputParameterType\":\"\",\n" +
                "         \"visitId\":\"\",\n" +
                "         \"samplingFrameField\": null,\n" +
                "         \"samplingFrameValue\": \"02 - MILIK KELUARGA\",\n" +
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
                "     {\n" +
                "         \"id\":19,\n" +
                "         \"pertanyaanId\":19,\n" +
                "         \"nomorKontrak\":\"23456734\",\n" +
                "         \"deskripsiPertanyaan\":\"BERAPA LAMA BAPAK/IBU/SAUDARA/I MENEMPATI RUMAH INI?\",\n" +
                "         \"verifikasiLabel\":\"\",\n" +
                "         \"indexPertanyaan\":\"19\",\n" +
                "         \"inputTambahan\":true,\n" +
                "         \"inputTambahanType\":\"NUMERICINPUTNOCURRENCY\",\n" +
                "         \"inputType\":\"RADIO\",\n" +
                "         \"picField\":\"12345678\",\n" +
                "         \"inputParameterType\":\"\",\n" +
                "         \"visitId\":\"\",\n" +
                "         \"samplingFrameField\": null,\n" +
                "         \"samplingFrameValue\": \"120\",\n" +
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
                "     {\n" +
                "         \"id\":20,\n" +
                "         \"pertanyaanId\":20,\n" +
                "         \"nomorKontrak\":\"23456734\",\n" +
                "         \"deskripsiPertanyaan\":\"APAKAH BAPAK/IBU/SAUDARA/I (NASABAH) SUDAH MENIKAH DAN MEMILIKI ANAK?\",\n" +
                "         \"verifikasiLabel\":\"\",\n" +
                "         \"indexPertanyaan\":\"20\",\n" +
                "         \"inputTambahan\":true,\n" +
                "         \"inputTambahanType\":\"TEXTINPUT\",\n" +
                "         \"inputType\":\"RADIO\",\n" +
                "         \"picField\":\"12345678\",\n" +
                "         \"inputParameterType\":\"\",\n" +
                "         \"visitId\":\"\",\n" +
                "         \"samplingFrameField\": null,\n" +
                "         \"samplingFrameValue\": \"02 - SINGLE\",\n" +
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
                "      {\n" +
                "         \"id\":21,\n" +
                "         \"pertanyaanId\":21,\n" +
                "         \"nomorKontrak\":\"23456734\",\n" +
                "         \"deskripsiPertanyaan\":\"APA BAPAK/IBU/SAUDARA/I (NASABAH ADIRA) MEMILIKI USAHA/PEKERJAAN/PENGHASILAN LAIN?\",\n" +
                "         \"verifikasiLabel\":\"\",\n" +
                "         \"indexPertanyaan\":\"21\",\n" +
                "         \"inputTambahan\":true,\n" +
                "         \"inputTambahanType\":\"NUMERICINPUT\",\n" +
                "         \"inputType\":\"RADIO\",\n" +
                "         \"picField\":\"12345678\",\n" +
                "         \"inputParameterType\":\"\",\n" +
                "         \"visitId\":\"\",\n" +
                "         \"samplingFrameField\": null,\n" +
                "         \"samplingFrameValue\": \"Rp 500,000\",\n" +
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
                "     {\n" +
                "         \"id\":22,\n" +
                "         \"pertanyaanId\":22,\n" +
                "         \"nomorKontrak\":\"23456734\",\n" +
                "         \"deskripsiPertanyaan\":\"JUMLAH DP YANG DIBAYARKAN?\",\n" +
                "         \"verifikasiLabel\":\"\",\n" +
                "         \"indexPertanyaan\":22,\n" +
                "         \"inputTambahan\":true,\n" +
                "         \"inputTambahanType\":\"NUMERICINPUT\",\n" +
                "         \"inputType\":\"RADIO\",\n" +
                "         \"picField\":\"12345678\",\n" +
                "         \"inputParameterType\":\"\",\n" +
                "         \"visitId\":\"\",\n" +
                "         \"samplingFrameField\": null,\n" +
                "         \"samplingFrameValue\": \"Rp 2,600,000\",\n" +
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
                "      {    \n" +
                "         \"id\":23,\n" +
                "         \"pertanyaanId\":23,\n" +
                "         \"nomorKontrak\":\"23456734\",\n" +
                "         \"deskripsiPertanyaan\":\"JUMLAH ANGSURAN\",\n" +
                "         \"verifikasiLabel\":\"\",\n" +
                "         \"indexPertanyaan\":\"23\",\n" +
                "         \"inputTambahan\":true,\n" +
                "         \"inputTambahanType\":\"NUMERICINPUT\",\n" +
                "         \"inputType\":\"RADIO\",\n" +
                "         \"picField\":\"12345678\",\n" +
                "         \"inputParameterType\":\"\",\n" +
                "         \"visitId\":\"\",\n" +
                "         \"samplingFrameField\": null,\n" +
                "         \"samplingFrameValue\": \"Rp 499,000\",\n" +
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
                "      {    \n" +
                "         \"id\":24,\n" +
                "         \"pertanyaanId\":24,\n" +
                "         \"nomorKontrak\":\"23456734\",\n" +
                "         \"deskripsiPertanyaan\":\"BERAPA KALI ANGSURAN YANG SUDAH BAPAK/IBU/SAUDARA/I BAYARKAN?\",\n" +
                "         \"verifikasiLabel\":\"\",\n" +
                "         \"indexPertanyaan\":\"24\",\n" +
                "         \"inputTambahan\":true,\n" +
                "         \"inputTambahanType\":\"TEXTINPUT\",\n" +
                "         \"inputType\":\"RADIO\",\n" +
                "         \"picField\":\"12345678\",\n" +
                "         \"inputParameterType\":\"\",\n" +
                "         \"visitId\":\"\",\n" +
                "         \"samplingFrameField\": null,\n" +
                "         \"samplingFrameValue\": \"11 (ANGS KE -1)\",\n" +
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
                "      {\n" +
                "         \"id\":25,\n" +
                "         \"pertanyaanId\":25,\n" +
                "         \"nomorKontrak\":\"23456734\",\n" +
                "         \"deskripsiPertanyaan\":\"PEMBAYARAN ANGSURAN DILAKUKAN MELALUI? (DAPAT >1 JAWABAN)\",\n" +
                "         \"verifikasiLabel\":\"\",\n" +
                "         \"indexPertanyaan\":\"25\",\n" +
                "         \"inputTambahan\":false,\n" +
                "         \"inputTambahanType\":null,\n" +
                "         \"inputType\":\"CHECKBOX\",\n" +
                "         \"picField\":\"12345678\",\n" +
                "         \"inputParameterType\":\"\",\n" +
                "         \"visitId\":\"\",\n" +
                "         \"samplingFrameField\": null,\n" +
                "         \"samplingFrameValue\": null,\n" +
                "         \"details\":[\n" +
                "            {\n" +
                "               \"opsiJawaban\": \"KASIR\",\n" +
                "               \"jawabanSatu\":\"\",\n" +
                "               \"jawabanDua\":\"\",\n" +
                "               \"statusAlert\": false\n" +
                "            },\n" +
                "            {\n" +
                "               \"opsiJawaban\": \"PT. POS\",\n" +
                "               \"jawabanSatu\":\"\",\n" +
                "               \"jawabanDua\":\"\",\n" +
                "               \"statusAlert\": false\n" +
                "            },\n" +
                "            {\n" +
                "               \"opsiJawaban\": \"TRANSFER\",\n" +
                "               \"jawabanSatu\":\"\",\n" +
                "               \"jawabanDua\":\"\",\n" +
                "               \"statusAlert\": false\n" +
                "            },\n" +
                "           {\n" +
                "               \"opsiJawaban\": \"INDOMARET/ALFAMART\",\n" +
                "               \"jawabanSatu\":\"\",\n" +
                "               \"jawabanDua\":\"\",\n" +
                "               \"statusAlert\": false\n" +
                "            },\n" +
                "           {\n" +
                "               \"opsiJawaban\": \"KEDAY\",\n" +
                "               \"jawabanSatu\":\"\",\n" +
                "               \"jawabanDua\":\"\",\n" +
                "               \"statusAlert\": false\n" +
                "            },\n" +
                "           {\n" +
                "               \"opsiJawaban\": \"KOLEKTOR\",\n" +
                "               \"jawabanSatu\":\"\",\n" +
                "               \"jawabanDua\":\"\",\n" +
                "               \"statusAlert\": false\n" +
                "            },\n" +
                "           {\n" +
                "               \"opsiJawaban\": \"DEALER/SHOW ROOM\",\n" +
                "               \"jawabanSatu\":\"\",\n" +
                "               \"jawabanDua\":\"\",\n" +
                "               \"statusAlert\": false\n" +
                "            },\n" +
                "           {\n" +
                "               \"opsiJawaban\": \"LAINNYA\",\n" +
                "               \"jawabanSatu\":\"\",\n" +
                "               \"jawabanDua\":\"\",\n" +
                "               \"statusAlert\": false\n" +
                "            }\n" +
                "          ,\n" +
                "         ]\n" +
                "      },\n" +
                "      {    \n" +
                "         \"id\":26,\n" +
                "         \"pertanyaanId\":26,\n" +
                "         \"nomorKontrak\":\"23456734\",\n" +
                "         \"deskripsiPertanyaan\":\"APAKAH BAPAK/IBU/SAUDARA/I PERNAH TERLAMBAT MEMBAYAR ANGSURAN?\",\n" +
                "         \"verifikasiLabel\":\"\",\n" +
                "         \"indexPertanyaan\":\"26\",\n" +
                "         \"inputTambahan\":true,\n" +
                "          \"inputTambahanType\":\"TEXTINPUT\",\n" +
                "         \"inputType\":\"RADIO\",\n" +
                "         \"picField\":\"12345678\",\n" +
                "         \"inputParameterType\":\"\",\n" +
                "         \"visitId\":\"\",\n" +
                "         \"samplingFrameField\": null,\n" +
                "         \"samplingFrameValue\": \"23 (TOTAL OVD)\",\n" +
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
                "      {\n" +
                "         \"id\":27,\n" +
                "         \"pertanyaanId\":27,\n" +
                "         \"nomorKontrak\":\"23456734\",\n" +
                "         \"deskripsiPertanyaan\":\"JIKA YA, BAGAIMANA CARA PETUGAS ADIRA MENGINGATKAN BAPAK/IBU/SAUDARA/I?\",\n" +
                "         \"verifikasiLabel\":\"\",\n" +
                "         \"indexPertanyaan\":27,\n" +
                "         \"inputTambahan\":false,\n" +
                "         \"inputTambahanType\":null,\n" +
                "         \"inputType\":\"RADIO\",\n" +
                "         \"picField\":\"12345678\",\n" +
                "         \"inputParameterType\":\"\",\n" +
                "         \"visitId\":\"\",\n" +
                "         \"samplingFrameField\": null,\n" +
                "         \"samplingFrameValue\": null,\n" +
                "         \"details\":[\n" +
                "            {\n" +
                "               \"opsiJawaban\": \"DATANG KE RUMAH\",\n" +
                "               \"jawabanSatu\":\"\",\n" +
                "               \"jawabanDua\":\"\",\n" +
                "               \"statusAlert\": false\n" +
                "            },\n" +
                "            {\n" +
                "               \"opsiJawaban\": \"TIDAK PERNAH DATANG KE RUMAH\",\n" +
                "               \"jawabanSatu\":\"\",\n" +
                "               \"jawabanDua\":\"\",\n" +
                "               \"statusAlert\": false\n" +
                "            },\n" +
                "            {\n" +
                "               \"opsiJawaban\": \"TELEFON/SURAT\",\n" +
                "               \"jawabanSatu\":\"\",\n" +
                "               \"jawabanDua\":\"\",\n" +
                "               \"statusAlert\": false\n" +
                "            },\n" +
                "           {\n" +
                "               \"opsiJawaban\": \"TIDAK PERNAH DIINGATKAN\",\n" +
                "               \"jawabanSatu\":\"\",\n" +
                "               \"jawabanDua\":\"\",\n" +
                "               \"statusAlert\": false\n" +
                "            }\n" +
                "         ]\n" +
                "      },\n" +
                "     {\n" +
                "         \"id\":28,\n" +
                "         \"pertanyaanId\":28,\n" +
                "         \"nomorKontrak\":\"23456734\",\n" +
                "         \"deskripsiPertanyaan\":\"APAKAH KOLEKTOR MENANYAKAN ALASAN KETERLAMBATAN PEMBAYARAN?\",\n" +
                "         \"verifikasiLabel\":\"\",\n" +
                "         \"indexPertanyaan\":28,\n" +
                "         \"inputTambahan\": false,\n" +
                "         \"inputTambahanType\":null,\n" +
                "         \"inputType\":\"RADIO\",\n" +
                "         \"picField\":\"12345678\",\n" +
                "         \"inputParameterType\":\"\",\n" +
                "         \"visitId\":\"\",\n" +
                "         \"samplingFrameField\": null,\n" +
                "         \"samplingFrameValue\": null,\n" +
                "         \"details\":[\n" +
                "            {\n" +
                "               \"opsiJawaban\": \"YA\",\n" +
                "               \"jawabanSatu\":\"\",\n" +
                "               \"jawabanDua\":\"\",\n" +
                "               \"statusAlert\": false\n" +
                "            },\n" +
                "            {\n" +
                "               \"opsiJawaban\": \"TIDAK\",\n" +
                "               \"jawabanSatu\":\"\",\n" +
                "               \"jawabanDua\":\"\",\n" +
                "               \"statusAlert\": false\n" +
                "            }\n" +
                "         ]\n" +
                "      },\n" +
                "      {\n" +
                "         \"id\":29,\n" +
                "         \"pertanyaanId\":29,\n" +
                "         \"nomorKontrak\":\"23456734\",\n" +
                "         \"deskripsiPertanyaan\":\"APAKAH BAPAK/IBU/SAUDARA/I PERNAH MEMBAYAR ANGSURAN KEPADA KOLEKTOR ADIRA?\",\n" +
                "         \"verifikasiLabel\":\"\",\n" +
                "         \"indexPertanyaan\":29,\n" +
                "         \"inputTambahan\": false,\n" +
                "         \"inputTambahanType\":null,\n" +
                "         \"inputType\":\"RADIO\",\n" +
                "         \"picField\":\"12345678\",\n" +
                "         \"inputParameterType\":\"\",\n" +
                "         \"visitId\":\"\",\n" +
                "         \"samplingFrameField\": null,\n" +
                "         \"samplingFrameValue\": null,\n" +
                "         \"details\":[\n" +
                "            {\n" +
                "               \"opsiJawaban\": \"YA\",\n" +
                "               \"jawabanSatu\":\"\",\n" +
                "               \"jawabanDua\":\"\",\n" +
                "               \"statusAlert\": false\n" +
                "            },\n" +
                "            {\n" +
                "               \"opsiJawaban\": \"TIDAK\",\n" +
                "               \"jawabanSatu\":\"\",\n" +
                "               \"jawabanDua\":\"\",\n" +
                "               \"statusAlert\": false\n" +
                "            }\n" +
                "         ]\n" +
                "      },\n" +
                "     {    \n" +
                "         \"id\":30,\n" +
                "         \"pertanyaanId\":30,\n" +
                "         \"nomorKontrak\":\"23456734\",\n" +
                "         \"deskripsiPertanyaan\":\"KAPAN UNIT DITARIK OLEH ADIRA?\",\n" +
                "         \"verifikasiLabel\":\"\",\n" +
                "         \"indexPertanyaan\":\"30\",\n" +
                "         \"inputTambahan\":true,\n" +
                "         \"inputTambahanType\":\"DATEINPUT\",\n" +
                "         \"inputType\":\"RADIO\",\n" +
                "         \"picField\":\"12345678\",\n" +
                "         \"inputParameterType\":\"\",\n" +
                "         \"visitId\":\"\",\n" +
                "         \"samplingFrameField\": null,\n" +
                "         \"samplingFrameValue\": \"23-JAN-2020\",\n" +
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
                "     {    \n" +
                "         \"id\":31,\n" +
                "         \"pertanyaanId\":31,\n" +
                "         \"nomorKontrak\":\"23456734\",\n" +
                "         \"deskripsiPertanyaan\":\"SIAPA YANG MELAKUKAN PENARIKAN?\",\n" +
                "         \"verifikasiLabel\":\"\",\n" +
                "         \"indexPertanyaan\":\"31\",\n" +
                "         \"inputTambahan\":true,\n" +
                "         \"inputTambahanType\":\"TEXTINPUT\",\n" +
                "         \"inputType\":\"RADIO\",\n" +
                "         \"picField\":\"12345678\",\n" +
                "         \"inputParameterType\":\"\",\n" +
                "         \"visitId\":\"\",\n" +
                "         \"samplingFrameField\": null,\n" +
                "         \"samplingFrameValue\": \"KOSMANOV\",\n" +
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
                "         \"id\":32,\n" +
                "         \"pertanyaanId\":32,\n" +
                "         \"nomorKontrak\":\"23456734\",\n" +
                "         \"deskripsiPertanyaan\":\"JIKA YA, BAGAIMANA CARA PETUGAS ADIRA MENGINGATKAN BAPAK/IBU/SAUDARA/I?\",\n" +
                "         \"verifikasiLabel\":\"\",\n" +
                "         \"indexPertanyaan\":32,\n" +
                "         \"inputTambahan\":false,\n" +
                "         \"inputTambahanType\":null,\n" +
                "         \"inputType\":\"RADIO\",\n" +
                "         \"picField\":\"12345678\",\n" +
                "         \"inputParameterType\":\"\",\n" +
                "         \"visitId\":\"\",\n" +
                "         \"samplingFrameField\": null,\n" +
                "         \"samplingFrameValue\": null,\n" +
                "         \"details\":[\n" +
                "            {\n" +
                "               \"opsiJawaban\": \"UNIT DAN STNK DIBERIKAN\",\n" +
                "               \"jawabanSatu\":\"\",\n" +
                "               \"jawabanDua\":\"\",\n" +
                "               \"statusAlert\": false\n" +
                "            },\n" +
                "            {\n" +
                "               \"opsiJawaban\": \"UNIT SAJA STNK DI NASABAH\",\n" +
                "               \"jawabanSatu\":\"\",\n" +
                "               \"jawabanDua\":\"\",\n" +
                "               \"statusAlert\": false\n" +
                "            },\n" +
                "            {\n" +
                "               \"opsiJawaban\": \"DIBERIKAN SURAT PENARIKAN\",\n" +
                "               \"jawabanSatu\":\"\",\n" +
                "               \"jawabanDua\":\"\",\n" +
                "               \"statusAlert\": false\n" +
                "            },\n" +
                "           {\n" +
                "               \"opsiJawaban\": \"TIDAK DIBERIKAN SURAT PENARIKAN\",\n" +
                "               \"jawabanSatu\":\"\",\n" +
                "               \"jawabanDua\":\"\",\n" +
                "               \"statusAlert\": false\n" +
                "            },\n" +
                "            {\n" +
                "               \"opsiJawaban\": \"000 - TIDAK DITARIK\",\n" +
                "               \"jawabanSatu\":\"\",\n" +
                "               \"jawabanDua\":\"\",\n" +
                "               \"statusAlert\": false\n" +
                "            }\n" +
                "         ]\n" +
                "      },\n" +
                "     {\n" +
                "         \"id\":33,\n" +
                "         \"pertanyaanId\":33,\n" +
                "         \"nomorKontrak\":\"23456734\",\n" +
                "         \"deskripsiPertanyaan\":\"JIKA YA, BAGAIMANA CARA PETUGAS ADIRA MENGINGATKAN BAPAK/IBU/SAUDARA/I?\",\n" +
                "         \"verifikasiLabel\":\"\",\n" +
                "         \"indexPertanyaan\":33,\n" +
                "         \"inputTambahan\":false,\n" +
                "         \"inputTambahanType\":null,\n" +
                "         \"inputType\":\"RADIO\",\n" +
                "         \"picField\":\"12345678\",\n" +
                "         \"inputParameterType\":\"\",\n" +
                "         \"visitId\":\"\",\n" +
                "         \"samplingFrameField\": null,\n" +
                "         \"samplingFrameValue\": null,\n" +
                "         \"details\":[\n" +
                "            {\n" +
                "               \"opsiJawaban\": \"KONDISI BAIK (ORIGINAL)\",\n" +
                "               \"jawabanSatu\":\"\",\n" +
                "               \"jawabanDua\":\"\",\n" +
                "               \"statusAlert\": false\n" +
                "            },\n" +
                "            {\n" +
                "               \"opsiJawaban\": \"KONDISI BAIK (MODIF)\",\n" +
                "               \"jawabanSatu\":\"\",\n" +
                "               \"jawabanDua\":\"\",\n" +
                "               \"statusAlert\": false\n" +
                "            },\n" +
                "            {\n" +
                "               \"opsiJawaban\": \"KONDISI RUSAK\",\n" +
                "               \"jawabanSatu\":\"\",\n" +
                "               \"jawabanDua\":\"\",\n" +
                "               \"statusAlert\": false\n" +
                "            },\n" +
                "           {\n" +
                "               \"opsiJawaban\": \"LAINNYA\",\n" +
                "               \"jawabanSatu\":\"\",\n" +
                "               \"jawabanDua\":\"\",\n" +
                "               \"statusAlert\": false\n" +
                "            }\n" +
                "            \n" +
                "         ]\n" +
                "      }\n" +
                "      \n" +
                "   ]\n" +
                "}";
        return ResponseEntity.ok(obj);
    }
}
