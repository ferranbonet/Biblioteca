/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodes;

/**
 *
 * @author fbonet
 */
public class Dates {

    /**
     *
     * @param any Any que volem comprovar si és bixest.
     * @return Retorna true si l'any és bixest
     */
    public static boolean bixest(int any) {
        return ((any >= 1584) && (any % 400 == 0 || (any % 4 == 0 && any % 100 != 0)));
    }

    /**
     *
     * @param dia Dia de la data
     * @param mes Mes de la data
     * @param any Any de la data
     * @return Retorna true si la data és correcta
     */
    public static boolean dataCorrecta(int dia, int mes, int any) {
        int[] diesMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (bixest(any)) {
            diesMes[1] = 29;
        }
        return ((mes >= 1 && mes <= 12) && (dia >= 1 && dia <= diesMes[--mes]));
    }

    /**
     *
     * @param dia Dia de la data
     * @param mes Mes de la data
     * @param any Any de la data
     * @return Retorna el dia següent a la data introduïda
     */
    public static int[] diaSeguent(int dia, int mes, int any) {
        if (!dataCorrecta(dia, mes, any)) {
            return null;
        }
        if (dataCorrecta(dia + 1, mes, any)) {
            return new int[]{dia + 1, mes, any};
        }
        if (dataCorrecta(1, mes + 1, any)) {
            return new int[]{1, mes + 1, any};
        }
        return new int[]{1, 1, any + 1};
    }

    /**
     *
     * @param dia1 Dia de la 1a data
     * @param mes1 Mes de la 1a data
     * @param any1 Any de la 1a data
     * @param dia2 Dia de la 2a data
     * @param mes2 Mes de la 2a data
     * @param any2 Any de la 2a data
     * @return Retorna 1 si la 1a data és major, 0 si són iguals, -1 si la 2a és
     * major o -2 si alguna és incorrecta
     */
    public static int comparaDates(int dia1, int mes1, int any1, int dia2, int mes2, int any2) {
        if (!dataCorrecta(dia1, mes1, any1) || !dataCorrecta(dia2, mes2, any2)) {
            return -2;
        }
        if (any1 > any2) {
            return 1;
        } else if (any1 < any2) {
            return -1;
        }
        if (mes1 > mes2) {
            return 1;
        } else if (mes1 < mes2) {
            return -1;
        }
        if (dia1 > dia2) {
            return 1;
        } else if (dia1 < dia2) {
            return -1;
        }
        return 0;
    }

    /**
     * 
     * @param dia1 Dia de la 1a data
     * @param mes1 Mes de la 1a data
     * @param any1 Any de la 1a data
     * @param dia2 Dia de la 2a data
     * @param mes2 Mes de la 2a data
     * @param any2 Any de la 2a data
     * @return Retorna la diferencia entre les dues dates o -1 si alguna és incorrecta
     */
    public static int diferenciaDies(int dia1, int mes1, int any1, int dia2, int mes2, int any2) {
        int compt = 0;
        switch (comparaDates(dia1, mes1, any1, dia2, mes2, any2)) {
            case -2:
                return -1;
            case -1:
                do {
                    int[] seguent = diaSeguent(dia1, mes1, any1);
                    dia1 = seguent[0];
                    mes1 = seguent[1];
                    any1 = seguent[2];
                    compt++;
                } while (comparaDates(dia1, mes1, any1, dia2, mes2, any2) != 0);
                break;
            case 0:
                return 0;
            case 1:
                do {
                    int[] seguent = diaSeguent(dia2, mes2, any2);
                    dia2 = seguent[0];
                    mes2 = seguent[1];
                    any2 = seguent[2];
                    compt++;
                } while (comparaDates(dia1, mes1, any1, dia2, mes2, any2) != 0);
                break;
        }
        return compt;
    }

}
