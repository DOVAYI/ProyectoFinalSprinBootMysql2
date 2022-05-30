package com.sofka.utility;

/**
 * esta clase permite Restructar id y otros
 * tiene un metodo estatico que puede ser accedido sin necesidad de instanciar
 * ejemplo Restructurar.restructurar(parametro)
 */
public class Restructurar {

    /**
     * Este metodo elimina comillas y otros
     * @param valor idjugador y/o otros datos
     * @return
     */
    public static String restructurar(String valor){
        String vector[];
        String aux1 = valor;
        String aux2;
        String aux3="";
        try {
            vector = aux1.split(":");
            aux2 = vector[1].replace("}", "");
            aux3 = aux2.replace("\"", "");
        } catch (ArrayIndexOutOfBoundsException e) {
            e.getMessage();
        }

        return aux3;
    }
}
