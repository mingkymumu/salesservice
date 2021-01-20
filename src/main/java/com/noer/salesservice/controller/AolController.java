package com.noer.salesservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.noer.salesservice.dto.BaseAolRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author farhan
 */
@RestController
@RequestMapping("/aol/api")
@Slf4j
public class AolController {

    private ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    // parameter data = no kontrak, branch id
    @PostMapping(value = "inquiryPaymentHistory")
    public ResponseEntity<?> inquiryPaymentHistory(@RequestBody BaseAolRequest baseAolRequest) {
        try {
            log.info(objectMapper().writeValueAsString(baseAolRequest));
        } catch (JsonProcessingException e) {
        }
        String response;
        if (baseAolRequest.getData().getNoKontrak().length() == 12) {
            response = "{\n" +
                    "    \"header\": {\n" +
                    "        \"code\": \"200\",\n" +
                    "        \"message\": \"OK\",\n" +
                    "        \"srcCode\": \"00\",\n" +
                    "        \"srcMessage\": \"Permintaan berhasil diproses\",\n" +
                    "        \"addInfo\": {\n" +
                    "            \"refNo\": \"20190423121308653101216082298207\",\n" +
                    "            \"srcTarget\": \"0\"\n" +
                    "        }\n" +
                    "    },\n" +
                    "    \"data\": {\n" +
                    "        \"result\": \"SUCCESS\",\n" +
                    "        \"rc1\": [\n" +
                    "            {\n" +
                    "                \"alamat\": \"JALAN NO 1 12 KRANGGAN PRAJURIT KULON, KOTA          MOJOKERTO, PROVINSI JAWA TIMUR, 61321\",\n" +
                    "                \"custColcAddr\": \"JALAN NO 1 12 KRANGGAN PRAJURIT KULON, KOTA MOJOKERTO, PROVINSI JAWA TIMUR, 61321\",\n" +
                    "                \"custOtherAddr\": \"JALAN NO 1  KRANGGAN PRAJURIT KULON, KOTA MOJOKERTO, PROVINSI JAWA TIMUR, 61321\",\n" +
                    "                \"arecBrId\": \"0321\",\n" +
                    "                \"arecContNo\": \"032116200024\",\n" +
                    "                \"arecCurrDate\": \"2019-04-23 12:10:04.0\",\n" +
                    "                \"arecPdcAmount\": \"0\",\n" +
                    "                \"arecInstNo\": \"1\",\n" +
                    "                \"arecInstDate\": \"2016-11-03 00:00:00.0\",\n" +
                    "                \"angsuran\": \"1280800\",\n" +
                    "                \"arecInstPrin\": \"1280800\",\n" +
                    "                \"arecInstIntr\": \"0\",\n" +
                    "                \"arecTranDatetime\": \"2017-01-18 00:00:00.0\",\n" +
                    "                \"arecDepositAmount\": \"0\",\n" +
                    "                \"arecPnltCalc\": \"194682\",\n" +
                    "                \"arecPnltPaid\": \"0\",\n" +
                    "                \"arecRefNo\": \"032117R000025\",\n" +
                    "                \"arecRefDatetime\": \"2017-01-18 00:00:00.0\",\n" +
                    "                \"cashPdcStatus\": \"\",\n" +
                    "                \"cashPdcNo\": \"\",\n" +
                    "                \"paid\": \"PAID\",\n" +
                    "                \"bankName\": \"ADIRA ANGSURAN\",\n" +
                    "                \"arecInstlTranSeq\": \"3\",\n" +
                    "                \"userId\": \"\",\n" +
                    "                \"kolektor\": \"BAMBANG HARIYONO\",\n" +
                    "                \"applBrId\": \"0321\",\n" +
                    "                \"applContractNo\": \"032116200024\",\n" +
                    "                \"objtDesc\": \"MOBIL BARU\",\n" +
                    "                \"payterm\": \"IN ARREAR/BELAKANG\",\n" +
                    "                \"kolektorUmum\": \"AKHMAD FADLI\",\n" +
                    "                \"emplName\": \"DEDEN RIDWAN\",\n" +
                    "                \"insfInsfName\": \"SURVEY BY M PLUS S\",\n" +
                    "                \"arecIntrType\": \"ANNUITY\",\n" +
                    "                \"arecDayIntPaid\": \"BELUM TERBAYAR\",\n" +
                    "                \"arecIntrEff\": \"0\",\n" +
                    "                \"arecIntrFlat\": \"0\",\n" +
                    "                \"arecFirstInstDate\": \"2016-11-03 00:00:00.0\",\n" +
                    "                \"arecTop\": \"36\",\n" +
                    "                \"arecDaysInt\": \"0\",\n" +
                    "                \"arecPrin\": \"46105650\",\n" +
                    "                \"arecIntr\": \"0\",\n" +
                    "                \"custName\": \"SUMANTO SUMANTI\",\n" +
                    "                \"obbrDesc\": \"HONDA\",\n" +
                    "                \"objtFrameNo\": \"ASASDASDSAD\",\n" +
                    "                \"objtEngineNo\": \"SDFUI78DSU\",\n" +
                    "                \"obtyDesc\": \"SEDAN\",\n" +
                    "                \"objtPoliceNo\": \"B1234CD\",\n" +
                    "                \"obmoDesc\": \"CIVIC NOVA\",\n" +
                    "                \"arecPnltRate\": \"2\",\n" +
                    "                \"paymTypeDesc\": \"DEALER\",\n" +
                    "                \"applFinType\": \"1\",\n" +
                    "                \"newOd\": \"76\"\n" +
                    "            }\n" +
                    "\n" +
                    "        ]\n" +
                    "    }\n" +
                    "}\n";
            return ResponseEntity.ok(response);

        } else {
            response = "{\n" +
                    "    \"header\": {\n" +
                    "        \"code\": \"404\",\n" +
                    "        \"message\": \"Not Found\",\n" +
                    "        \"srcCode\": \"01\",\n" +
                    "        \"srcMessage\": \"Data tidak ditemukan\",\n" +
                    "        \"addInfo\": {\n" +
                    "            \"refNo\": \"20190423121618876310220011685481\",\n" +
                    "            \"srcTarget\": \"0\"\n" +
                    "        }\n" +
                    "    },\n" +
                    "    \"data\": {\n" +
                    "        \"result\": \"NO DATA FOUND\",\n" +
                    "        \"rc1\": []\n" +
                    "    }\n" +
                    "}\n";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

}
