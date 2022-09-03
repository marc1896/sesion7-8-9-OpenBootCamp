package com.example;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        System.out.println("----------------------------------------------------");
        String cadena = "Hola mundo";
        System.out.println("Cadena en sentido contrario: " + obtenText(cadena));
        System.out.println("----------------------------------------------------");
        String lista[] = new String[]{"Marco", "Antonio", "Hernandez", "Osorio"};
        for (String l : lista){
            System.out.println(l);
        }
        System.out.println("----------------------------------------------------");
        int listaBidi[][] = new int[][]{
                {1, 2, 3},
                {4, 5, 6}
        };
        for (int i = 0; i < listaBidi.length; i++){
            for (int j = 0; j < listaBidi[i].length; j++){
                System.out.println("Posicion[" + i + ", " + j +"], valor = " + listaBidi[i][j]);
            }
        }
        System.out.println("----------------------------------------------------");
        Vector<String> vector = new Vector<>();
        vector.add("Marco");
        vector.add("Antonio");
        vector.add("Hernandez");
        vector.add("Osorio");
        vector.add("26 Años");

        System.out.println(vector);
        vector.remove(2);
        vector.remove(3);
        System.out.println(vector);
        System.out.println("----------------------------------------------------");
        /*
            4. el problema de un vector con la capacidad por defecto si se tuvieran
            1000 elementos añadidos, seria que estariamos desperdiciando posiciones sin utilizar.
         */
        Vector<Integer> vectorInt = new Vector<>();
        for (int i = 0; i <= 999; i++){
            vectorInt.add(i);
        }
        System.out.println("tamaño: " + vectorInt.size() + " capacidad: " + vectorInt.capacity());
        System.out.println("----------------------------------------------------");
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Primavera");
        arrayList.add("Otoño");
        arrayList.add("Verano");
        arrayList.add("Invierno");
        LinkedList<String> linkedList = new LinkedList<>(arrayList);
        for (int i = 0; i < arrayList.size(); i++){
            System.out.println(arrayList.get(i));
            System.out.println(linkedList.get(i));
        }
        System.out.println("----------------------------------------------------");
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            arrayList1.add(i + 1);
        }
        System.out.println(arrayList1);
        for (int i = 0; i < arrayList1.size(); i++){
            if((arrayList1.get(i) % 2) == 0){
                arrayList1.remove(i);
                i--;
                continue;
            }
            System.out.println(arrayList1.get(i));
        }
        System.out.println("----------------------------------------------------");
        divide(4, 0);
    }

    public static int divide(int a, int b) throws ArithmeticException{
        int resultado = 0;
        try {
            resultado = a / b;
        }catch (ArithmeticException e){
            System.out.println("Esto no puede hacerse. " + e);
        }finally {
            System.out.println("Demo de código");
        }

        return resultado;
    }

    /**
     * Función que devuelve una cadena al revés
     * con ayuda de un bucle for
     * @param cadena de tipo String
     * @return retorna la cadena al reves
     */
    static String obtenText(String cadena) {
        String cadenaTemp = "";
        for (int i = (cadena.length() - 1); i >= 0; i--){
            cadenaTemp += cadena.charAt(i);
        }
        return cadenaTemp;
    }
}
