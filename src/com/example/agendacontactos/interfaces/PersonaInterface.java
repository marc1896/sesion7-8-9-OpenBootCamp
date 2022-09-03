package com.example.agendacontactos.interfaces;

import com.example.agendacontactos.clases.Persona;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public interface PersonaInterface {
    void guardarListaPersonas(File archivo, ArrayList<Persona> lista);

    ArrayList<Persona> obtenerListaPersonas(File archivo);

    ArrayList<Persona> obtenerUnaPersona(ArrayList<Persona> personas, int id);

    void eliminarUnaPersona(ArrayList<Persona> personas, int id);

    void actualizarUnaPersona(ArrayList<Persona> personas, int id, Scanner leer, File archivo);

    void hacerBackup(String rutaOrigen, String rutaDestino);

}
