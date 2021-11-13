package main;

import controladores.ControladorFichero;
import modelos.Diccionario;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        //Variables y clases
        Scanner entrada = new Scanner(System.in);
        String opcion;
        Diccionario dic = new Diccionario();
        ControladorFichero cf = new ControladorFichero();
        do{
            //Menú de la consola para manipular nuestro programa
            System.out.println("**************************");
            System.out.println("Bienvenido a nuestro diccionario, a continuación\n tienes una variedad de opciones para realizar.");
            System.out.println("**************************");
            System.out.println("1. Registrar una nueva palabra.");
            System.out.println("2. Consultar diccionario.");
            System.out.println("3. Consultar un termino.");
            System.out.println("4. Salir.");
            System.out.println("Escribe tú opción: ");

            //Recibimos el dato por teclado para sabes que acción realizar
            opcion = entrada.nextLine();
            if(isNumeric(opcion)){ //Comprobamos si nuestro dato es númerico
                int opt = Integer.parseInt(opcion);
                switch (opt){
                    case 1:{
                        String espanol, ingles;
                        System.out.println("***************************");
                        System.out.println("AGREGAR NUEVA PALABRA AL DICCIONARIO.");
                        System.out.println("Escriba la palabra en español: ");
                        espanol = entrada.nextLine();
                        System.out.println("Escriba la palabra en ingles: ");
                        ingles = entrada.nextLine();
                        System.out.println("***************************");
                        dic.setEspanol(espanol);
                        dic.setIngles(ingles);
                        cf.insertarDefinicion(dic);
                        break;
                    }
                    case 2:{
                        cf.consultarDiccionario();
                        break;
                    }
                    case 3:{
                        String palabra;
                        System.out.println("**************************");
                        System.out.println("BUSCAR UNA DEFINICION EN EL DICCIONARIO.");
                        System.out.println("**************************");
                        System.out.println("Escribe la palabra para buscar: ");
                        palabra = entrada.nextLine();
                        String cadena = cf.consultarDiccionario(palabra);
                        if(cadena != null){
                            String[] parts = cadena.split(",");
                            System.out.println("Palabra en español: "+parts[0]+", definición en ingles: "+parts[1]);
                        }else{
                            System.out.println("La palabra no existe en nuestro diccionario.");
                            System.out.println("Puedes agregar una definición de está palabra.");
                        }

                        break;
                    }
                    case 4:{
                        System.exit(0);
                        break;
                    }
                    default:
                        System.out.println("El dato ingresado no es valido.");
                }
            }else{
                System.out.println("El dato ingresado no es númerico.");
            }
        }while(!opcion.equals("4")); //Condición para continuar ejecutando el programa

    }

    //Función para comprobar si un String es un número.
    public static boolean isNumeric(String cadena){
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe){
            return false;
        }
    }
}
