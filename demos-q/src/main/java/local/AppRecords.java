package local;


import java.util.UUID;

import local.entities.Record;
import local.repositories.RecordDAO;

public class AppRecords {
    private static void checkRecords(){
         RecordDAO dao = new RecordDAO();

        dao.save(new Record("Info de una reunión"));
        dao.save(new Record("Info de otra reunión"));
         
        

        System.out.println("----------- Find All -----------");
        System.out.println(dao.findAll());
        System.out.println("----------- Find by ID valid -----------");
        System.out.println(dao.findById(1));
        System.out.println("----------- Find by ID invalid -----------");
        System.out.println(dao.findById(100));

        System.out.println("----------- Delete by ID 1 (si existe)-----------");

        dao.findById(new UUID("a0cd5b5-1c2f-41d0-bc00-96bc7f9176cd")).ifPresentOrElse(
            dao::delete,
            () -> System.out.println("Recorda no encontrada: no se ha podido eliminar"));
             System.out.println("----------- Find All after delete -----------");
                System.out.println(dao.findAll());

        try {
            Record p3 = dao.findById(3).orElseThrow(() -> new RuntimeException("Person not found"));
            System.out.println("----------- Update by ID 2 -----------");
            p3.setContent("Info actualizada de la reunión");
            dao.update(p3);

            System.out.println("----------- Find All after update -----------");
            System.out.println(dao.findAll());

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    
    }


    

    public static void main(String[] args) {
        System.out.println("Records application");
        checkRecords();
    }



}
