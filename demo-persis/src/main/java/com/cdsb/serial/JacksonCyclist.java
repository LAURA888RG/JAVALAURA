package com.cdsb.serial;

import java.time.LocalDate;

import com.cdsb.files.FileSystem2;

public class JacksonCyclist {
 
    Cyclist cyclist;
     
    void readBikes(){
        FileSystem2.readFileToString(pathName);
    }
     
    JacksonCyclist() {
        cyclist =new Cyclist("Pepe", LocalDate.of(2000,10, 10) );
    }

}
