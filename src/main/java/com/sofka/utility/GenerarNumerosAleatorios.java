package com.sofka.utility;

import java.util.ArrayList;

public class GenerarNumerosAleatorios {

    Integer matriz[][] = new Integer[5][5];

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

    public static Integer numberRandom(){
        Integer randomNum = (int) Math.floor((Math.random() * (75 - 1 + 1)) + 1);

        return randomNum;
    }
}
