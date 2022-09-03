package com.example.agendacontactos;

import com.example.agendacontactos.clases.Persona;
import com.example.agendacontactos.implementacion.PersonaInterfaceImpl;

import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try{
            boolean estado;
            File archivo = new File("C:\\Users\\marco\\Desktop\\BDContactos.txt");
            int opt = 0;
            PersonaInterfaceImpl personaInterfaceImpl = new PersonaInterfaceImpl();
            ArrayList<Persona> p = personaInterfaceImpl.obtenerListaPersonas (archivo);
            Scanner leer = new Scanner(System.in);
            do {
                System.out.println ("Registro de Contacto");
                System.out.println ("===================\n");
                System.out.println ("1-Ingresar un nuevo Contacto");
                System.out.println ("2-Listar registro de Contacto");
                System.out.println ("3-Buscar Contacto");
                System.out.println ("4-Eliminar Contacto");
                System.out.println ("5-Modificar datos de un Contacto");
                System.out.println ("6-Hacer Backup del sistema");
                System.out.println ("7-Salir");
                System.out.println ("\nIngresar una opción\n");
                opt = leer.nextInt ();
                switch (opt) {
                    case 1:
                        System.out.println ("Registro de Persona");
                        System.out.println ("===================\n");
                        System.out.println ("Ingrese los siguientes datos:\n");
                        leer.nextLine ();
                        System.out.println ("Id:");
                        String id = leer.nextLine ();
                        estado = false;
                        for(int i = 0; i < p.size(); i++){
                            if(p.get(i).getId() == Integer.parseInt(id)){
                                estado = true;
                                break;
                            }
                        }

                        if(estado){
                            System.out.println("El id del contacto ya existe, registre uno nuevo.");
                        }else {
                            System.out.println ("Nombre:");
                            String nombre = leer.nextLine ();
                            System.out.println ("Apellido Paterno:");
                            String apellidoP = leer.nextLine ();
                            System.out.println ("Apellido Materno:");
                            String apellidoM = leer.nextLine ();
                            LocalDateTime fechaCreacion = LocalDateTime.now();
                            System.out.println ("N° Teléfono:");
                            String telefono = leer.nextLine ();
                            System.out.println ("N° Celular:");
                            String movil = leer.nextLine ();
                            System.out.println ("Dirección:");
                            String direccion = leer.nextLine ();
                            System.out.println ("E-mail:");
                            String email = leer.nextLine ();
                            p.add(new Persona(Integer.parseInt(id), nombre, apellidoP, apellidoM, fechaCreacion,
                                    telefono, movil, direccion, email));
                            personaInterfaceImpl.guardarListaPersonas(archivo, p);
                        }
                        break;

                    case 2:
                        System.out.println("Lista de Contactos");
                        System.out.printf("|%3s|%17s|%17s|%15s|%15s|%20s|%25s|%25s|%n",
                                "Id", "Nombre", "Apellido Paterno" , "Apellido Materno", "N° Teléfono", "N° Celular",
                                "Dirección", "Email");
                        for(int i = 0; i < p.size(); i++){
                            System.out.printf("|%3s|%17s|%17s|%15s|%15s|%20s|%25s|%25s|%n", p.get(i).getId(), p.get(i).getNombre(),
                                    p.get(i).getApellidoP(), p.get(i).getApellidoM(), p.get(i).getTelelfono(), p.get(i).getMovil(),
                                    p.get(i).getDireccion(), p.get(i).getEmail());
                        }
                        break;
                    case 3:
                        System.out.println ("Buscar Contacto");
                        System.out.println ("===============\n");
                        System.out.println ("Ingresa Id del contacto");
                        int buscado = Integer.parseInt(leer.next ());
                        ArrayList<Persona> encontrado = personaInterfaceImpl.obtenerUnaPersona(p, buscado);
                        if (encontrado.size() > 0){
                            System.out.printf("|%3s|%17s|%17s|%15s|%15s|%20s|%25s|%25s|%n",
                                    "Id", "Nombre", "Apellido Paterno" , "Apellido Materno", "N° Teléfono", "N° Celular",
                                    "Dirección", "Email");
                            System.out.printf("|%3s|%17s|%17s|%15s|%15s|%20s|%25s|%25s|%n", encontrado.get(0).getId(), encontrado.get(0).getNombre(),
                                    encontrado.get(0).getApellidoP(), encontrado.get(0).getApellidoM(), encontrado.get(0).getTelelfono(), encontrado.get(0).getMovil(),
                                    encontrado.get(0).getDireccion(), encontrado.get(0).getEmail());
                        }else {
                            System.out.println("El contacto no existe.");
                        }
                        break;
                    case 4:
                        System.out.println ("Eliminar Contacto");
                        System.out.println ("===============\n");
                        System.out.println ("Ingresa Id del contacto");
                        int buscadoEliminar = Integer.parseInt(leer.next ());
                        personaInterfaceImpl.eliminarUnaPersona(p, buscadoEliminar);
                        break;
                    case 5:
                        System.out.println ("Actualizar Contacto");
                        System.out.println ("===============\n");
                        System.out.println ("Ingresa Id del contacto");
                        int buscadoActualizar= Integer.parseInt(leer.next ());
                        personaInterfaceImpl.actualizarUnaPersona(p, buscadoActualizar, leer, archivo);
                        break;
                    case 6:
                        personaInterfaceImpl.hacerBackup("C:\\Users\\marco\\Desktop\\BDContactos.txt", "C:\\Users\\marco\\Desktop\\BDContactosBackup.txt");
                        break;
                    case 7:
                        System.out.println("Saliendo del sistema........");
                        break;
                    default:
                        System.out.println("Error, opción no valida.");
                }
            }while (opt != 7);
        }catch (Exception e){
            System.out.println("Error en el archivo al abrirlo. " + e.getMessage());
        }
    }
}
