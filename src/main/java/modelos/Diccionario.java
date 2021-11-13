package modelos;

import controladores.ControladorFichero;

import java.util.Map;

public class Diccionario {

    //Atributos
    private String espanol;
    private String ingles;

    //Constructor
    public Diccionario() {
    }

    //Métodos Getter and Setter
    public String getEspanol() {
        return espanol;
    }

    public void setEspanol(String espanol) {
        this.espanol = espanol;
    }

    public String getIngles() {
        return ingles;
    }

    public void setIngles(String ingles) {
        this.ingles = ingles;
    }
}
