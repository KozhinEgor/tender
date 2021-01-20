package com.keysight.tender.controller;


import com.keysight.tender.models.*;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFHyperlink;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping(path = "/demo")
public class TypeTenderController {

    @Autowired
    private SearchAtribut searchAtribut;
    private Customer customer;
    private Typetender typetender;
    private Winner winner;
    private Tender Tender;
    @Autowired
    private TenderRepository tenderRepository;
    private DateTimeFormatter format_date= DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");




    @GetMapping("/add")
    public @ResponseBody String addNewType() throws  Exception {
        InputStream ExcelFileToRead = new FileInputStream("C:\\Users\\Егор\\Documents\\работа\\2020_wk40.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(ExcelFileToRead);
        XSSFSheet sheet = workbook.getSheetAt(0);
        int count = 1;
        while(sheet.getRow(count).getCell(0) != null){
            XSSFRow row = sheet.getRow(count);
            customer = searchAtribut.findCustomer(row.getCell(1).getStringCellValue(),sheet.getRow(count).getCell(0).getStringCellValue()) ;
            typetender = searchAtribut.findTypetender(row.getCell(4).getStringCellValue());
            winner = searchAtribut.findNoWinner();
            String NumberTender = new DataFormatter().formatCellValue(row.getCell(5));
            Tender= new Tender();
            Tender.setCustomer(customer);
            Tender.setnameTender(row.getCell(2).getStringCellValue());
            Tender.setnumberTender(NumberTender);
            Tender.setbicoTender(row.getCell(2).getHyperlink().getAddress());
            Tender.setgosZakupki(row.getCell(3).getHyperlink().getAddress());
            Tender.setTypetender(typetender);
            Tender.setPrice(new BigDecimal(row.getCell(6).getNumericCellValue()).setScale(2, BigDecimal.ROUND_CEILING));
            Tender.setCurrency(row.getCell(7).getStringCellValue());
            Tender.setRate(row.getCell(8).getNumericCellValue());
            Tender.setdateStart(LocalDateTime.parse(row.getCell(10).getStringCellValue()+" 03:00:00",format_date));
            Tender.setdateFinish(LocalDateTime.parse(row.getCell(11).getStringCellValue(),format_date));
            Tender.setWinner(winner);
            Tender.setwinSum(new BigDecimal(0));
            Tender.setfullSum(Tender.getPrice());
            Tender.setSum(Tender.getPrice());
            tenderRepository.save(Tender);

            /*Tender = tenderRepository.save(new Tender(
                                    customer,
                                    row.getCell(2).getStringCellValue(),
                                    row.getCell(5).getStringCellValue(),
                                    row.getCell(2).getHyperlink().getAddress(),
                                    row.getCell(3).getHyperlink().getAddress(),
                                    typetender,
                                    new BigDecimal(row.getCell(6).getStringCellValue()).setScale(2, BigDecimal.ROUND_CEILING),
                                    row.getCell(7).getStringCellValue(),
                                    row.getCell(8).getNumericCellValue(),
                                    new SimpleDateFormat("dd.mm.yyyy").parse(row.getCell(10).getStringCellValue()),
                                    new SimpleDateFormat("dd.mm.yyyy hh:mm:ss").parse(row.getCell(11).getStringCellValue()),
                                    winner)
                                    );*/
            count++;
        }

        ExcelFileToRead.close();
        return "Saved";
    }
    /*@GetMapping(path = "/search")
    public @ResponseBody List<Typetender> FindByType(){
        return tenderRepository.findByType("Чет");
    }*/
    @GetMapping(path = "/getAll")
        public @ResponseBody Iterable<Tender> getAllType(){

          return tenderRepository.findAll();
        }
    @GetMapping(path = "/getAllfinish")
    public @ResponseBody Iterable<Timestamp> getAllfinish(){

        return tenderRepository.findDateFinish();
    }
    //-i -H "Accept: application/json"-H "Content-Type: application/json"-X POST --data "{\"dateStart\":\"2020-10-01T00:00:00\",\"dateFinish\":\"2020-10-10T12:00:00\"}" http://localhost:8081/demo/betweenDate
    @CrossOrigin
    @RequestMapping( path = "/betweenDate")
    @ResponseBody public  Iterable<Tender> getAllTenderBetween (@RequestBody ReceivedJSON json){
        return tenderRepository.findAll();
    }

}
