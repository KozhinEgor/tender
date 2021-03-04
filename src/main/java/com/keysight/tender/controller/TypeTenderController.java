package com.keysight.tender.controller;


import com.keysight.tender.models.*;
import com.sun.xml.bind.v2.runtime.output.SAXOutput;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


@Controller
@RequestMapping(path = "/demo")
public class TypeTenderController {
    @Autowired
    private TypetenderRepository typetenderRepository;
    @Autowired
    private SearchAtribut searchAtribut;
    private Customer customer;
    private Typetender typetender;
    private Winner winner;
    private Tender Tender;
    private Orders orders;
    @Autowired
    private TenderRepository tenderRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private WinnerRepository winnerRepository;
    @Autowired
    private SpectrumAnalyserRepository spectrumAnalyserRepository;
    @Autowired
    private VoltmeterRepository voltmeterRepository;
    @Autowired
    private PulseGeneratorRepository pulseGeneratorRepository;
    @Autowired
    private MultimeterRepository multimeterRepository;
    @Autowired
    private VendorRepository vendorRepository;
    @Autowired
    private SignalGeneratorRepository signalGeneratorRepository;
    @Autowired
    private SignalAnalyzerRepository signalAnalyzerRepository;
    @Autowired
    private OscilloscopeRepository oscilloscopeRepository;
    @Autowired
    private OrdersRepository ordersRepository;
    private DateTimeFormatter format_date= DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss z");
    ArrayList<Extensionconfig.Interface> repository = new ArrayList<Extensionconfig.Interface>();



    @GetMapping("/add/{number}")
    public @ResponseBody String addNewType(@PathVariable int number) throws  Exception {
        String answear = "good";
        InputStream ExcelFileToRead = new FileInputStream("C:\\Users\\egkozhin\\Documents\\allTenders.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(ExcelFileToRead);
        XSSFSheet sheet = workbook.getSheetAt(number);
        //ВНИМАНИЕ
        int bias = 1;
            int count = 1;
            while (sheet.getRow(count).getCell(0) != null) {
                XSSFRow row = sheet.getRow(count);
                String NumberTender = new DataFormatter().formatCellValue(row.getCell(5-bias));
                if (tenderRepository.findTopByNumberTender(NumberTender)!= null){
                    answear =answear+System.lineSeparator()+ sheet.getSheetName() +" "+count+" = "+ tenderRepository.findTopByNumberTender(NumberTender).getId();
                }
                else{
                    //String INNCustomer = new DataFormatter().formatCellValue(row.getCell(1));
                    customer = searchAtribut.findCustomer("", sheet.getRow(count).getCell(0).getStringCellValue());
                    typetender = searchAtribut.findTypetender(row.getCell(4-bias).getStringCellValue());
                    winner = searchAtribut.findNoWinner();
                    String el = "НЕТ ПРОДУКТОВ!! ОБРАТИТЬ ВНИМАНИЕ!!";
                    try {
                        el = row.getCell(13-bias).getStringCellValue();
                    }
                    catch (NullPointerException e){ }
                    Tender tender = new Tender();
                    tender.setcustomer(customer);
                    tender.setnameTender(row.getCell(2-bias).getStringCellValue());
                    tender.setnumberTender(NumberTender);
                    tender.setbicoTender(row.getCell(2-bias).getHyperlink().getAddress());
                    tender.setgosZakupki(row.getCell(3-bias).getHyperlink().getAddress());
                    tender.settypetender(typetender);
                    tender.setPrice(new BigDecimal(row.getCell(6-bias).getNumericCellValue()).setScale(2, BigDecimal.ROUND_CEILING));
                    tender.setCurrency(row.getCell(7-bias).getStringCellValue());
                    tender.setRate(row.getCell(8-bias).getNumericCellValue());
                    tender.setdateStart(ZonedDateTime.parse(row.getCell(10-bias).getStringCellValue() + " 00:00:00 Z", format_date));
                    tender.setdateFinish(ZonedDateTime.parse(row.getCell(11-bias).getStringCellValue() + " 00:00:00 Z", format_date));
                    tender.setwinner(winner);
                    tender.setwinSum(new BigDecimal(0));

                    if (el.contains("Полная сумма")) {
                        String sum = el.substring(el.indexOf("сумма") + "сумма".length()).replaceAll("[\\s+a-zA-Z \\s+а-яА-Я : \\s . ( )]", "").replaceAll("[,]", ".").trim();
                        tender.setfullSum(new BigDecimal(sum).setScale(2, BigDecimal.ROUND_CEILING));
                        el=el.substring(0, el.indexOf("Полная сумма")).trim();
                    } else {
                        tender.setfullSum(tender.getPrice());
                    }

                    tender.setSum(tender.getPrice().multiply(new BigDecimal(tender.getRate())));
                    tenderRepository.save(tender);
                    System.out.println("\n");
                    System.out.println("Заполняю продукты тендера "+tender.getId() + " " + count);
                    searchAtribut.addProduct(el, tender);

                }
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
        return answear;
    }
    /*@GetMapping(path = "/search")
    public @ResponseBody List<Typetender> FindByType(){
        return tenderRepository.findByType("Чет");
    }*/

    @GetMapping(path = "/test/{number}/{rowN}")
    public @ResponseBody String getAlls(@PathVariable int number,@PathVariable int rowN) throws Exception {
        InputStream ExcelFileToRead = new FileInputStream("C:\\Users\\egkozhin\\Documents\\allTenders.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(ExcelFileToRead);
        XSSFSheet sheet = workbook.getSheetAt(number);
        XSSFRow row = sheet.getRow(rowN);
        String el = row.getCell(13).getStringCellValue();
        String NumberTender = new DataFormatter().formatCellValue(row.getCell(5));
        if (el.contains("Полная сумма")) {
            el=el.substring(0, el.indexOf("Полная сумма")).trim();
        }

        searchAtribut.addProduct(el, tenderRepository.findTopByNumberTender(NumberTender));
        /*orders = ordersRepository.findTopById(Long.valueOf(1));
        OrdersModel or = new OrdersModel(orders, searchAtribut.getProduct(orders.getProductCategory(),orders.getId_product()));*/
        return "good";
    }
    @GetMapping(path = "/getAllTypes")
    public @ResponseBody Iterable<Typetender> getAllType(){
        return typetenderRepository.findAll();
    }
    @GetMapping(path = "/getAllCustom")
    public @ResponseBody Iterable<Customer> getAllCustom(){
        return customerRepository.findAll();
    }
    @GetMapping(path = "/getAllWinner")
    public @ResponseBody Iterable<Winner> getAllWinner(){
        return winnerRepository.findAll();
    }
    @GetMapping(path = "/getAll")
    public @ResponseBody Iterable<Tender> getAll(){
        return tenderRepository.findAll();
    }
    //-i -H "Accept: application/json"-H "Content-Type: application/json"-X POST --data "{\"dateStart\":\"2020-10-01T00:00:00\",\"dateFinish\":\"2020-10-10T12:00:00\"}" http://localhost:8081/demo/betweenDate

    @RequestMapping( path = "/betweenDate")
    @ResponseBody public  Iterable<Tender> getAllTenderBetween (@RequestBody ReceivedJSON json){
        json.getRequest();
        System.out.println(json.getDateFinish());
        return tenderRepository.SelectMyQuery(json.getDateFinish(), json.getDateStart(),json.getType(),json.getCustom(),json.getWinner(),json.getMinSum(),json.getMaxSum());
    }
    @RequestMapping( path = "/orders")
    @ResponseBody public  ArrayList<TenderProduct> getOrdersBetween (){
        ArrayList<OrdersModel> ordersModels = new ArrayList<OrdersModel>();
        Iterable<Tender> tenders = tenderRepository.findAll();
        /*List<Orders> orders = ordersRepository.findAllByTenderIn(tenders);
        for(Orders order : orders){
            OrdersModel o = new OrdersModel(order,searchAtribut.getProduct(order.getProductCategory().getCategory_en(),order.getId_product()));
            ordersModels.add(o);
        }
*/
        ArrayList<TenderProduct> tenderProduct = new ArrayList<TenderProduct>();
        for(Tender tender : tenders){
            for(Orders orders : ordersRepository.findAllByTender(tender)){
                    OrdersModel o = new OrdersModel(orders, searchAtribut.getProduct(orders.getProductCategory().getCategory_en(),orders.getId_product()));
                    ordersModels.add(o);
            }
            tenderProduct.add(new TenderProduct(tender,ordersModels));
            ordersModels.clear();
        }
        return tenderProduct;
    }

}
