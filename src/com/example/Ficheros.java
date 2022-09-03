package com.example;


import java.io.*;

public class Ficheros {
    public static void main(String[] args) {
        String urlOrigen = "C:\\Users\\marco\\Desktop\\Cursos Programacion\\PROYECTOS REALIZADOS\\origen.txt";
        String urlDestino = "C:\\Users\\marco\\Desktop\\Cursos Programacion\\PROYECTOS REALIZADOS\\destino.txt";
        copiarFichero(urlOrigen, urlDestino);
    }

    static void copiarFichero(String fileIn, String fileOut){
        try {
            FileInputStream fileInputStream = new FileInputStream(fileIn);
            PrintStream printStream = new PrintStream(fileOut);
            byte []datos = fileInputStream.readAllBytes();
            printStream.write(datos);
        }catch (FileNotFoundException ex){
            System.out.println("Error archivo no encontrado. " + ex.getMessage());
        }catch (IOException ex){
            System.out.println("Error no se puede leer el archivo. " + ex.getMessage());
        }
    }
}
