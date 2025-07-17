package com.cdsb.serial;

import java.beans.Visibility;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.cdsb.files.FileSystem2;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonBike {

    List<Bicycle> listBikes = new ArrayList<>();
    ObjectMapper mapper = new ObjectMapper();

    String pathName = "demos-persis/resources/bikes.json";

    JacksonBike()  {
        mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
        Bicycle[] bicycles = {
        new Bicycle("Trek", "Domane", 28, "Red", 22, true ),
         new Bicycle("Giant", "Defi", 30, "Blue", 18,false ), 
         new Bicycle("Specialized", "Roubaix", 32, "Black", 20, true )
        };
        listBikes = List.of(bicycles);
    }

    public void toJSON() {
        try {
            String jsonStr = mapper.writeValueAsString(listBikes);
            return jsonStr;

        } catch (JsonProcessingException e) {
           return e.getMessage();
          
    }
}
   //deserialize o parse
   public Bicycle[] fromJSON(String jsonString) {
       Bicycle[] result = {};
     try {
         return mapper.readValue(jsonString, Bicycle[].class);
     } catch (JsonProcessingException e) {
        System.out.println(e.getMessage());
      
    }
    return result;
}


public String saveBikes (String data){
       return FileSystem2.writeFile(pathName, data);
    }

    public String save(String data){
        return FileSystem2.writeFile(pathName, data);
    }

    public String read() {
        return FileSystem2.readFileToString(pathName);
    }

    public static void main(String[] args) {
        JacksonBike jBike = new JacksonBike();
        System.out.println(jBike.listBikes);
        String jsonString = jBike.toJSON();
        System.out.println(
           jBike.save(jsonString)
        );
        System.out.println("-".repeat(50));
        Bicycle[] finalBikes = jBike.fromJSON(jBike.read());
        System.out.println(Arrays.);

       // Bicycle[] finalBikes = jBike.fromJSON(jsonString);
       // System.out.println(
       //     Arrays.toString(finalBikes));
    }
}
