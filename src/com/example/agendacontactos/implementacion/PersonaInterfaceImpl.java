package com.example.agendacontactos.implementacion;

import com.example.agendacontactos.clases.Persona;
import com.example.agendacontactos.interfaces.PersonaInterface;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonaInterfaceImpl implements PersonaInterface {
    @Override
    public void guardarListaPersonas(File archivo, ArrayList<Persona> lista) {
        try{
            FileWriter escribir = new FileWriter(archivo);
            BufferedWriter bufferedWriter = new BufferedWriter(escribir);
            for(Persona p : lista){
                bufferedWriter.write(p.getId() + "/-" + p.getNombre() + "/-" + p.getApellidoP() +
                        "/-" + p.getApellidoM() + "/-" + p.getDireccion() + "/-" + p.getTelelfono() +
                        "/-" + p.getMovil() + "/-" + p.getFechaCreacion() + "/-" + p.getEmail() + "\n");
            }
            bufferedWriter.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public ArrayList<Persona> obtenerListaPersonas(File archivo) {
       ArrayList<Persona> lista = new ArrayList<>();

        try {
            Scanner leer = new Scanner(archivo);
            while (leer.hasNextLine()){
                // el objeto scanner lee linea a linea desde el archivo
                String linea = leer.nextLine();
                Scanner delimitar = new Scanner(linea);
                //se usa una expresión regular
                //que valida que antes o despues de una coma (/) exista cualquier cosa
                //parte la cadena recibida cada vez que encuentre una coma
                delimitar.useDelimiter("/-");
                Persona e= new Persona();
                e.setId(Integer.parseInt(delimitar.next()));
                e.setNombre(delimitar.next());
                e.setApellidoP(delimitar.next());
                e.setApellidoM(delimitar.next());
                e.setDireccion(delimitar.next());
                e.setTelelfono(delimitar.next());
                e.setMovil(delimitar.next());
                e.setFechaCreacion(LocalDateTime.parse(delimitar.next()));
                e.setEmail(delimitar.next());
                lista.add(e);
            }
            //se cierra el objeto scanner
            leer.close();
        } catch (IOException e) {
            System.out.println("Error. " + e.getMessage());;
        }
        return lista;
    }

    @Override
    public ArrayList<Persona> obtenerUnaPersona(ArrayList<Persona> personas, int id) {
        ArrayList<Persona> encontrado = new ArrayList<>();
        try{
            for(Persona p : personas){
                if (p.getId() == id){
                    encontrado.add(p);
                    break;
                }
            }

        }catch (Exception e){
            System.out.println("Error al obtener un contacto. " + e.getMessage());
        }
        return encontrado;
    }


    @Override
    public void eliminarUnaPersona(ArrayList<Persona> personas, int id) {
       try{
           ArrayList<Persona> encontrado = new ArrayList<>();
           String txt = "";
           for(int i = 0; i < personas.size(); i++){
               if (personas.get(i).getId() == id){
                   personas.remove(i);
                   System.out.println("Contacto eliminado");
                   break;
               }
           }
       }catch (Exception e){
           System.out.println("Error al eliminar un contacto. " + e.getMessage());
       }
    }

    @Override
    public void actualizarUnaPersona(ArrayList<Persona> personas, int id, Scanner leer, File archivo) {
       try{
           String txt = "";
           for(int i = 0; i < personas.size(); i++){
               if (personas.get(i).getId() == id){
                   System.out.println("Contacto con ID: " + personas.get(i).getId());
                   System.out.println("Nombre(" + personas.get(i).getNombre() +"): ");
                   String nombre = leer.next();
                   System.out.println("Apellido Paterno(" + personas.get(i).getApellidoP() +"): ");
                   String apellidoP = leer.next();
                   System.out.println("Apellido Materno(" + personas.get(i).getApellidoM() +"): ");
                   String apellidoM = leer.next();
                   LocalDateTime fechaCreacion = LocalDateTime.now();
                   System.out.println("N° Teléfono(" + personas.get(i).getTelelfono() +"): ");
                   String telefono = leer.next();
                   System.out.println("N° Celular(" + personas.get(i).getMovil() +"): ");
                   String movil = leer.next();
                   System.out.println("Dirección(" + personas.get(i).getDireccion() +"): ");
                   String direccion = leer.next();
                   System.out.println("E-mail(" + personas.get(i).getEmail() +"): ");
                   String email = leer.next();
                   Persona persona = new Persona(personas.get(i).getId(), nombre, apellidoP, apellidoM, fechaCreacion, telefono, movil, direccion, email);
                   personas.set((id - 1), persona);
                   System.out.println("El contacto se actualizo correctamente.");
                   break;
               }
           }
           FileWriter escribir = new FileWriter(archivo);
           BufferedWriter bufferedWriter = new BufferedWriter(escribir);
           for(Persona p : personas){
               bufferedWriter.write(p.getId() + "/-" + p.getNombre() + "/-" + p.getApellidoP() +
                       "/-" + p.getApellidoM() + "/-" + p.getDireccion() + "/-" + p.getTelelfono() +
                       "/-" + p.getMovil() + "/-" + p.getFechaCreacion() + "/-" + p.getEmail() + "\n");
           }
           bufferedWriter.close();
       } catch (IOException e) {
           throw new RuntimeException(e);
       }
    }

    @Override
    public void hacerBackup(String fileIn, String fileOut) {
        try {
            FileInputStream fileInputStream = new FileInputStream(fileIn);
            PrintStream printStream = new PrintStream(fileOut);
            byte []datos = fileInputStream.readAllBytes();
            printStream.write(datos);
            System.out.println("Backup realizado correctamente.");
        }catch (FileNotFoundException ex){
            System.out.println("Error archivo no encontrado. " + ex.getMessage());
        }catch (IOException ex){
            System.out.println("Error no se puede leer el archivo. " + ex.getMessage());
        }
    }
}
