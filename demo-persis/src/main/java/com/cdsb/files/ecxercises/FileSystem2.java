package com.cdsb.files.ecxercises;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileSystem2 {

    // Leer lista ficheros y carpetas
    public static String listFiles(String pathName) {

        StringBuilder sb = new StringBuilder();
        Path path = Path.of(pathName);

        if(Files.notExists(path)) {
            return MessagesFS.FO_NOT.message.formatted(pathName);
        }

        if(!Files.isDirectory(path)) {
            return MessagesFS.NOT_IS_FO.message.formatted(pathName);
        }

        try {
            Files.list(path).forEach((p) -> {
                char type = Files.isDirectory(p) ? 'D' : 'F';
                sb.append("[").append(type).append("] ");
                sb.append(p.getFileName()).append("\n");
            });
            return sb.toString();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    // Crear carpetas
    public static String createFolder(String pathName) {
        Path path = Path.of(pathName);

        if(Files.exists(path) && Files.isDirectory(path)) {
            return MessagesFS.FO_EXISTS.message.formatted(pathName);
        }

        if(Files.exists(path) && !Files.isDirectory(path)) {
            return MessagesFS.FI_EXISTS.message.formatted(pathName);
        }

        try {
            Files.createDirectories(path);
            return MessagesFS.OK_FO_CREATE.message.formatted(pathName);
        } catch (IOException e) {
            return MessagesFS.FAIL_FO.message.formatted(pathName);
            e.getMessage();
        }
    }

    // Borra carpetas / ficheros

    private static String deleteFile(String pathName){
        Path path = Paths.get(pathName);
        if (Files.notExists(path)) {
            return MessagesFS.FI_NOT.message.formatted(pathName);
        }
        try {
            Files.delete(path);
        } catch (IOException e) {
            return MessagesFS.FAIL_DELETE.message.formatted(pathName) + "\n"
            + e.getMessage();
        } 
    }


    public static String deleteFolder(String pathName) {
        Path path = Paths.get(pathName);

    }
    // Crear ficheros
    public static String createFile(String pathName) {
        return "";
    }

    // Escribir en ficheros
    public static String writeFile(String pathName, String content) {
        return "";
    }

    // Leer de un fichero

    public static List<String> readFileToList(String pathName) {
        List<String> lines = new ArrayList<>();
        return lines;
    }

    public static String readFileToString(String pathName) {
    return "";
    }

    public static void main(String[] args) {

        String pathName;
        pathName = "no_folder";
        pathName = "demos-persis/pom.xml";
        pathName = "demos-persis";
        System.out.println(listFiles(pathName));
        pathName = "demos-persis/resources";
        pathName = "demos-persis/pom.xml";
        pathName = "demos-persis/resources/sample";
        System.out.println(createFolder(pathName));
    }

}