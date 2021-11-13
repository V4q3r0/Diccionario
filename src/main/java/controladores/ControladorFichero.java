package controladores;

import modelos.Diccionario;

import java.io.*;

public class ControladorFichero {

    //Utilizamos las clases necesarias para escribir y leer ficheros
    private FileWriter fw = null;
    private BufferedWriter bw = null;
    private BufferedReader br = null;
    private FileReader fr = null;

    //Controlador
    public ControladorFichero(){
    }

    //funcion para ingresar datos al fichero
    public void insertarDefinicion(Diccionario dic) throws IOException {

        try {
            //El fichero se creara por defecto en la ruta: C:\Users\Alejandro\IdeaProjects\Practica\diccionario.txt
            fw = new FileWriter("diccionario.txt", true);
            bw = new BufferedWriter(fw);

            //Reciclamos código usando la función para comprobar un dato en el fichero
            String leer = this.consultarDiccionario(dic.getEspanol());
            if(leer!=null) {
                System.out.println("La palabra indicada ya existe en nuestro diccionario.");
            }else {
                // Escribimos linea a linea en el fichero
                String cadena = dic.getEspanol() + ", " + dic.getIngles() + "\n";
                bw.write(cadena);

                bw.close();
                fw.close();
                System.out.println("Haz ingresado una nueva palabra en el diccionario.");
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }finally {
        }

    }

    //funcion para leer el fichero completo
    public void consultarDiccionario(){

        try{
            fr = new FileReader("diccionario.txt");
            br = new BufferedReader(fr);

            //leemos linea por linea del fichero
            String linea = br.readLine();
            while(linea!=null){
                String[] parts = linea.split(",");
                //Imprime cada linea del codigo separando cada linea en dos donde encuentre una coma (,)
                System.out.println("Palabra en español: "+parts[0]+", palabra en ingles: "+parts[1]);
                linea=br.readLine();
            }

        }catch (IOException e){
            System.out.println(e);
        }

    }

    //funcion para leer el fichero y buscar una palabra clave en cada linea
    public String consultarDiccionario(String palabra){

        try {
            fr = new FileReader("diccionario.txt");
            br = new BufferedReader(fr);

            //Leemos linea por linea del fichero
            String linea = br.readLine();
            while (linea != null) {
                String[] parts = linea.split(",");
                //Comparamos la primera parte de la linea con la palabra que buscamos
                if (parts[0].equals(palabra)) {
                    return linea;
                }
                linea = br.readLine();
            }
        }catch (IOException e){
            System.out.println(e);
        }
        return null;
    }
}
