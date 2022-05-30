package com.sofka.utility;

import java.util.ArrayList;

/**
 * esta clase permite generar los numeros aleatorios para los jugadores
 * se utiliza de la siguiente manera
 * GenerarNumerosAleatorios ejemplo=new GenerarNumerosAleatorios();
 * contiene un metodo estatico(se usa sin necesidad de instanciar)
 */
public class GenerarNumerosAleatorios {
    /**
     * esta variable almacenara todos los numeros aleatorios generado
     */
    Integer matriz[][] = new Integer[5][5];

    /**
     * este metodo inicializa la matriz con numeros 0
     */
    public GenerarNumerosAleatorios() {
        Integer matrizaux[][] = new Integer[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                matrizaux[i][j] = 0;
            }
        }
        this.matriz = matrizaux;
        cargarB(this.matriz);
    }

    /**
     * Este metodo llena con numeros la primera columna de la matriz
     * @param matriz recibe la matriz inicializada
     */
    private void cargarB(Integer[][] matriz) {

        int aux = 0;
        Integer randomNum;

        ArrayList<Integer> array = new ArrayList<>();

        while (aux < 5) {
            randomNum = (int) Math.round(Math.random() * (15 - 1));

            if (randomNum > 0) {
                if ((array.indexOf(randomNum) == -1)) {
                    matriz[aux][0] = (int) randomNum;
                    array.add(randomNum);
                    aux++;

                }
            }
        }
        this.matriz = matriz;
        cargarI(this.matriz);
    }

    /**
     * Este metodo llena con numeros la segunda columna de la matriz
     * @param matriz recibe la matriz inicializada y con la priemra columna llena
     */
    private void cargarI(Integer[][] matriz) {
        int aux = 0;
        Integer randomNum;

        ArrayList<Integer> array = new ArrayList<>();

        while (aux < 5) {
            randomNum = (int) Math.floor((Math.random() * (30 - 16 + 1)) + 16);

            if (randomNum > 0) {
                if ((array.indexOf(randomNum) == -1)) {
                    matriz[aux][1] = (int) randomNum;
                    array.add(randomNum);
                    aux++;

                }
            }
        }
        this.matriz = matriz;
        cargarN(this.matriz);

    }

    /**
     * Este metodo llena con numeros la tercera columna de la matriz
     * @param matriz recibe la matriz inicializada y con la primera y segunda
     *               columna llena
     */
    private void cargarN(Integer[][] matriz) {
        int aux = 0;
        Integer randomNum;

        ArrayList<Integer> array = new ArrayList<>();

        while (aux < 5) {
            randomNum = (int) Math.floor((Math.random() * (45 - 31 + 1)) + 31);

            if (randomNum > 0) {
                if ((array.indexOf(randomNum) == -1)) {
                    matriz[aux][2] = (int) randomNum;
                    array.add(randomNum);
                    aux++;

                }
            }
        }
        this.matriz = matriz;
        cargarG(this.matriz);
    }
    /**
     * Este metodo llena con numeros la cuarta columna de la matriz
     * @param matriz recibe la matriz inicializada y con la primera,segunda y tercera
     *               columna llena
     */
    private void cargarG(Integer[][] matriz) {
        int aux = 0;
        Integer randomNum;

        ArrayList<Integer> array = new ArrayList<>();

        while (aux < 5) {
            randomNum = (int) Math.floor((Math.random() * (60 - 46 + 1)) + 46);

            if (randomNum > 0) {
                if ((array.indexOf(randomNum) == -1)) {
                    matriz[aux][3] = (int) randomNum;
                    array.add(randomNum);
                    aux++;

                }
            }
        }
        this.matriz = matriz;

    }
    /**
     * Este metodo llena con numeros la quinta columna de la matriz
     *
     */
    public Integer[][] cargarO() {
        int aux = 0;
        Integer randomNum;

        ArrayList<Integer> array = new ArrayList<>();

        while (aux < 5) {
            randomNum = (int) Math.floor((Math.random() * (75 - 61 + 1)) + 61);

            if (randomNum > 0) {
                if ((array.indexOf(randomNum) == -1)) {
                    this.matriz[aux][4] = (int) randomNum;
                    array.add(randomNum);
                    aux++;

                }
            }
        }


        return this.matriz;

    }

    /**
     * este metodo estaico para generar numeros aleatorios
     * @return retorna numero entre 1 y 75
     */
    public static Integer numberRandom(){
        Integer randomNum = (int) Math.floor((Math.random() * (75 - 1 + 1)) + 1);

        return randomNum;
    }
}
