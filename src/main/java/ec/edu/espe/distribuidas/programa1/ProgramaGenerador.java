/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.programa1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author Daniel
 */
public class ProgramaGenerador {

    public static void main(String[] args) throws IOException {

        ArrayList<String> nombres = new ArrayList<>();
        ArrayList<String> apellidos = new ArrayList<>();
        ArrayList<String> datosFin = new ArrayList<>();



                    try {
                File fileDir = new File("C:\\Users\\Daniel\\Documents\\nombres.txt");
                BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileDir), "UTF8"));
                String linea;
                while ((linea = in.readLine()) != null) {
                    //System.out.println(linea);       
                    nombres.add(linea);
                }
                in.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            try {
                File fileDir = new File("C:\\Users\\Daniel\\Documents\\apellidos.txt");
                BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileDir), "UTF8"));
                String linea;
                while ((linea = in.readLine()) != null) {
                    //System.out.println(linea);
                    apellidos.add(linea);
                }
                in.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            
        int numero;
        String fechaNac;
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        System.out.print("Ingresar el numero de datos: ");
        String cantidad = br.readLine();
        
        System.out.print("Ingresar cedula incial: ");
        String cedula = br.readLine();
        int cedulaNumerico = Integer.parseInt(cedula);
    
        String aux;
    
        for (int i = 0; i < Integer.parseInt(cantidad); i++) {
                aux="";
                cedulaNumerico++;

                numero = (int) (Math.random() * nombres.size()) + 0;
                aux += nombres.get(numero);
                
                numero = (int) (Math.random() * apellidos.size()) + 0;
                aux += apellidos.get(numero);

                fechaNac = generarFecha();
                aux += fechaNac;
                
                System.out.println(""+aux);
        }
    }

    public static String generarFecha() {
        Random random = new Random();
        int minDay = (int) LocalDate.of(1960, 1, 1).toEpochDay();
        int maxDay = (int) LocalDate.of(2000, 1, 1).toEpochDay();
        long randomDay = minDay + random.nextInt(maxDay - minDay);
        LocalDate randomBirthDate = LocalDate.ofEpochDay(randomDay);
        return randomBirthDate.toString();
    }

}
