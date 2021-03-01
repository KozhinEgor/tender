package com.keysight.tender.controller;

import com.keysight.tender.models.*;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SearchAtribut  {
    @Autowired
    private CustomerRepository customerRepository;
    private Customer customer;
    private Typetender typetender;
    @Autowired
    private TypetenderRepository typetenderRepository;
    private Winner winner;
    @Autowired
    private WinnerRepository winnerRepository;
    private Vendor vendor;
    @Autowired
    private VendorRepository vendorRepository;
    @Autowired
    private SpectrumAnalyserRepository spectrumAnalyserRepository;
    @Autowired
    private SignalGeneratorRepository signalGeneratorRepository;
    @Autowired
    private PulseGeneratorRepository pulseGeneratorRepository;
    @Autowired
    private SignalAnalyzerRepository signalAnalyzerRepository;
    @Autowired
    private OscilloscopeRepository oscilloscopeRepository;
    @Autowired
    private AnotherProductRepository anotherProductRepository;
    public Customer findCustomer ( String inn, String name) {
        if(inn.length() == 0){
            inn = "0";
        }
        List<Customer> FindCustomer = customerRepository.findTopByInnAndName(inn, name);

        if(FindCustomer.isEmpty()){
            //добавление новой записи

            customer = customerRepository.save(new Customer(inn,name));
        }
        else {
            customer = FindCustomer.get(0);
        }
        return customer;
    }

    public Typetender findTypetender(String type){
        List<Typetender> FindType= typetenderRepository.findByType(type);
        if(FindType.isEmpty()){
            //добавление новой записи
            typetender = typetenderRepository.save(new Typetender(type));
        }
        else {
            typetender = FindType.get(0);
        }

        return typetender;
    }
    public Winner findNoWinner(){
        List<Winner> FindWinner = winnerRepository.findByid(Long.valueOf(1));
        winner = FindWinner.get(0);
        return winner;
    }
    public Vendor findVendor(String name){
        List<Vendor> FindVendor= vendorRepository.findTopByName(name);
        if(name == ""){
            vendor = vendorRepository.findTopById(Long.valueOf(1));
        }
        if(FindVendor.isEmpty()){
            //добавление новой записи
            vendor = vendorRepository.save(new Vendor(name));
        }
        else {
            vendor = FindVendor.get(0);
        }

        return vendor;
    }

    public String getProduct (ProductCategory productCategory, Long product_id){
        switch (productCategory.getCategory_en()){
            case("spectrum_analyser"):
                SpectrumAnalyser spectrumAnalyser =  spectrumAnalyserRepository.findTopById(product_id);
                return spectrumAnalyser.getAnswear();

            case("signal_generator"):
                SignalGenerator signalGenerator = signalGeneratorRepository.findTopById(product_id);
                return signalGenerator.getAnswear();

            case("pulse_generator"):
                PulseGenerator pulseGenerator = pulseGeneratorRepository.findTopById(product_id);
                return pulseGenerator.getAnswear();

            case("signal_analyzer"):
                SignalAnalyzer signalAnalyzer = signalAnalyzerRepository.findTopById(product_id);
                return signalAnalyzer.getAnswear();

            case("oscilloscope"):
                Oscilloscope oscilloscope = oscilloscopeRepository.findTopById(product_id);
                return oscilloscope.getAnswear();

            case("another_product"):
                AnotherProduct anotherProduct = anotherProductRepository.findTopById(product_id);
                return anotherProduct.getAnswear();
        }
        return "";
    }

    static String changesymbol(String string) throws IOException, Exception{

        char[] str = string.toCharArray();
        boolean flag = false;
        ArrayList<Integer> flag2 = new ArrayList<Integer>();
        for(int i = 0; i< str.length;i++){
            if(str[i] == '('){
                flag = true;
            }
            else if(str[i] == ';' && flag){
                flag2.add(i);
            }
            else if(str[i] == ')'){
                if(flag && flag2 != null){
                    for(int el:flag2){
                        str[el] = ',';
                    }
                }
                flag = false;
                flag2.clear();
            }
        }

        // System.out.println(String.copyValueOf(str));
        return String.copyValueOf(str);
    }

    public void addProduct() throws Exception {

        InputStream ExcelFileToRead = new FileInputStream("C:\\Users\\egkozhin\\Documents\\allTenders.xlsx");
        XSSFWorkbook workbookRead = new XSSFWorkbook(ExcelFileToRead);
        XSSFSheet sheet = workbookRead.getSheetAt(177);
            int n = 1;
            while (sheet.getRow(n).getCell(2) != null && sheet.getRow(n).getCell(2).getCellType() != CellType.BLANK) {

                    String[] MasStr;
                    System.out.println(sheet.getRow(n).getCell(13).toString());
                    MasStr = changesymbol(sheet.getRow(n).getCell(13).toString()).split(";");
                    for (String el : MasStr) {
                        int number = 0;
                        String commet = "";
                        double summ= 0;
                        if (el.contains("оборудование") || el.contains("приборы")){


                            if (el.contains("сумма")){
                                summ = Double.parseDouble(el.substring(el.indexOf("сумма")+5).replaceAll("[\\s+a-zA-Z \\s+а-яА-Я : .]","").replaceAll("[,]",".").trim());
                            }
                            if(el.contains("(") ){
                                number  = Integer.parseInt(el.substring(el.indexOf(" - ")+3, el.indexOf("(")).trim());
                                commet = el.substring(el.indexOf("(") + 1,el.indexOf(")"));
                                el = el.replace(el.substring(el.indexOf("(") - 1,el.indexOf(")")+1),"");

                            }
                            else{
                                number = Integer.parseInt(el.substring(el.indexOf(" - ")+3).trim());
                            }

                            el = "Другое оборудование";

                        }
                        else if(el.contains(" - ")){
                            if(el.contains("(") ){
                                commet = el.substring(el.indexOf("(") + 1,el.indexOf(")"));
                                el = el.replace(el.substring(el.indexOf("(") - 1,el.indexOf(")")+1),"");

                            }
                            number = Integer.parseInt(el.substring(el.indexOf(" - ")+3).trim());

                            el = el.substring(0, el.indexOf(" - "));
                        }
                        el = el.toLowerCase();
                        el = el.trim();

                        boolean flag = true;
                        System.out.println(el + " "+ String.valueOf(number) + " commet - " +commet);


                    }

                n++;
            }


        ExcelFileToRead.close();

    }
}
