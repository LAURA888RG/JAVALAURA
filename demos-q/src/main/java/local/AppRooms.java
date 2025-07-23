package local;

import local.entities.Room;
import local.repositories.RecordDAO;

public class AppRooms {

     private static void checkRooms(){
         RoomDAO dao = new RoomDAO();

        dao.save(new Room("Info de una reunión"));
        dao.save(new Room("Info de otra reunión"));
         
        

        System.out.println("----------- Find All -----------");
        System.out.println(dao.findAll());
        System.out.println("----------- Find by ID valid -----------");
        System.out.println(dao.findById(1));
        System.out.println("----------- Find by ID invalid -----------");
        System.out.println(dao.findById(100));

        System.out.println("----------- Delete by ID 1 (si existe)-----------");

        dao.findById(1).ifPresentOrElse(
            dao::delete,
            () -> System.out.println("Recorda no encontrada: no se ha podido eliminar"));
             System.out.println("----------- Find All after delete -----------");
                System.out.println(dao.findAll());

        try {
            Room p3 = dao.findById(3).orElseThrow(() -> new RuntimeException("Person not found"));
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
        System.out.println("Rooms application");
        checkRooms();
    }



}
