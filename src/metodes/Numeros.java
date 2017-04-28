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
public class Numeros {
    /**
     * 
     * @param numero Número que volem comprovar si és primer.
     * @return 
     */
    public static boolean primer(int numero) {
        int candidat = 2;
        int cDivisors = 0;
        if (numero <= 1) {
            return false;
        }

        for (; candidat <= numero && cDivisors < 1; candidat++) {
            if (numero % candidat == 0) {
                cDivisors++;
            }
        }
        //for equivalent que no utiliza la variable cDivisors
        //for (; candidat <= numero && numero%candidat!=0; candidat++);
        return numero == (candidat - 1);

    }

    /**
     * 
     * @param num Número a introduïr en un vector.
     * @return Vector amb un digit del número anterior a cada casella.
     */
    //Mètode de l'exercici 7
    //Rep com a paràmetre un número enter i retorna un vector de la dimensió necessària per guardar cada dígit del número en una casella del vector
    public static int[] vectorDigits(int num) {

        //Per saber la grandària del vector ho haguessem pogut fer comptant les vegades que es pot dividir a num entre 10 fins arribar a valdre 0
        //però hem usat el mètode length() dels Strings, convertint prèviament el paràmetre enter a String usant el mètode String.valueOf()
        int[] resultat = new int[String.valueOf(num).length() - (num >= 0 ? 0 : 1)];

        //Booleà que em servirà per saber si el paràmetre era negatiu, ja que en este cas lo passo a positiu
        boolean negatiu = (num < 0);
        if (negatiu) {
            num *= -1;
        }

        //Omplim el vector des de l'última casella fins la primera en els successius mòduls de la divisió entre 10
        for (int i = resultat.length - 1; i >= 0; i--) {
            resultat[i] = num % 10;
            //A cada iteració hem de dividir num entre 10
            num /= 10;
        }
        //Finalment, si el paràmetre era negatiu, canviem el signe de la primera casella del vector
        if (negatiu) {
            resultat[0] *= -1;
        }

        //Retornem el vector omplit correctament com a resultat
        return resultat;

    }

    /**
     * 
     * @param num Vector amb diversos digits.
     * @return Número format pels diversos digits del vector anterior.
     */
    //Mètode de l'exercici 13
    //Rep com a paràmetre un vector que representa un número enter (en el format de l'exercici 7) i retorna el número enter representat
    public static int numVector(int[] num) {

        //Per evitar problemes, si el vector és null retornem 0, i així no tindrem l'excepció NullPointerException
        if (num == null) {
            return 0;
        }

        //La idea es recòrrer el vector de dreta a esquerra i per cada dígit multiplicar-lo per la potència de 10 adequada i anar sumant les diferents multiplicacions
        //variables locals
        int resultat = 0;             //per calcular el resultat
        int factor = 1;               //per tenir el factor potèmcia de 10 necessari per cada dígit. Comença valent 1 i continua en 10, 100, 1000, ...
        boolean negatiu = (num[0] < 0); //si el núm ero representat és negatiu el passarem a positiu i al final li canviarem el signe al resultat

        //Si és negatiu lo passem a positiu per operar correctament en ell
        if (negatiu) {
            num[0] *= -1;
        }

        //Recorrem el vector des de l'última casella fins la primera i per cada dígit el multipliquem per la potència de 10 correcta
        for (int i = num.length - 1; i >= 0; i--) {
            resultat += num[i] * factor;
            //A cada iteració hem de multiplicar el factor per 10
            factor *= 10;
        }

        //Si és negatiu lo dixem com estava inicialment
        if (negatiu) {
            num[0] *= -1;
        }

        //Retornem el resultat obtingut, però en negatiu si cal
        return negatiu ? resultat * -1 : resultat;

    }
    /**
     * 
     * @param num Número del qual es vol saber la longitud
     * @return Retorna la longitud del número
     */
    public static int longitudNumero(int num) {
        int compt = 1;
        if (num < 0) {
            num *= -1;
        }
        for (; num / 10 >= 1; num /= 10) {
            compt++;
        }
        return compt;
    }
    
    /**
     * 
     * @param num Número el qual es vol capgirar
     * @return Número inicial capgirat
     */
    public static int revesNumero1(int num) {
        int invers = 0, elevat = longitudNumero(num) -1;
        if (longitudNumero(num) == 1) {
            return num;
        }
        
        while (num != 0) {
            invers += (num % 10) * Math.pow(10, elevat--);
            num /= 10;
        }
        return invers;
    }
    
    /**
     * 
     * @param vector Vector que volem capgirar
     * @return Vector iniciar capgirat
     */
    public static int[] giraVector(int[] vector) {
        int[] invers = new int [vector.length];
        for (int i = 0, j = vector.length - 1; i < vector.length; i++, j--) {
            invers[j] = vector[i];
        }
        return invers;
    }
    
    /**
     * 
     * @param num Número el qual es vol capgirar
     * @return Número inicial capgirat
     */
    public static int revesNumero2(int num) {
        boolean negatiu = false;
        if (num < 0) {
            num *= -1;
            negatiu = true;
        }
        int resultat = numVector(giraVector(vectorDigits(num)));
        if (negatiu) {
            resultat *= -1;
        }
        return resultat;
    }
    
    public static boolean numeroCapicua(int num) {
        return num == revesNumero1(num);
    }
    
    public static int factorial(int num) {
        int resultat = 1;
        if (num < 0) {
            return -1;
        }
        if (num == 0 || num == 1) {
            return 1;
        }
        for (int i = 1; i <= num; i++) {
            resultat *= i;
        }
        return resultat;
    }
    
    public static double potenciaE(int num) {
        double e = 0;
        for (int i = 0; i < 20; i++) {
            e += (Math.pow(num, i) / factorial(i));
        }
        return e;
    }
    
}
