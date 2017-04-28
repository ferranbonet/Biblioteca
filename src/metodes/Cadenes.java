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
public class Cadenes {
    /**
     * 
     * @param text On volem insertar la subcadena.
     * @param subcadena La que volem insertar dins del text.
     * @param numero A partir de la posició del text on volem insertar la subcadena.
     * @return El text amb la subacadena insertada a la posició indicada.
     */
    public static String insertaCadena(String text, String subcadena, int numero) {

        if (text == null) {
            return subcadena;
        }
        if (subcadena == null) {
            return text;
        }

        if (numero <= 0) {
            return subcadena + text;
        }
        if (numero >= text.length()) {
            return text + subcadena;
        }

        String resultat = "";
        int i;
        for (i = 0; i < numero; i++) {
            resultat += text.charAt(i);
        }
        resultat += subcadena;
        for (; i < text.length(); i++) {
            resultat += text.charAt(i);
        }

        return resultat;
    }

    /**
     * 
     * @param text Text d'on volem extreure una subcadena.
     * @param inici Posició del text d'es d'on volem començar a extreure la subcadena.
     * @param fi Posició del text on volem acabar d'extreure la subcadena.
     * @return La subcadena extreta del text.
     */
    public static String subcadena(String text, int inici, int fi) {

        if (text == null) {
            return text = null;
        }
        if (inici < 0) {
            inici = 0;
        }
        if (fi <= 0 || inici >= text.length() || inici >= fi) {
            return "";
        }
        if (fi > text.length()) {
            fi = text.length();
        }

        String resultat = "";

        for (int i = inici; i < fi; i++) {
            resultat = resultat + text.charAt(i);
        }

        return resultat;
        //return text.substring(inici, fi);
    }

    /**
     * 
     * @param text Text on es buscarà la subcadena.
     * @param subcadena Subcadena a buscar dintre del text.
     * @param posicio Posició on volem començar a buscar la subcadena.
     * @return Posició on s'ha trobat la subcadena, si no s'ha trobat retornarà -1.
     */
    //Retornem la primera aparició de la subcadena dins del text a partir de la posicio indicada o -1 si no s'ha trobat
    public static int buscaCadena(String text, String subcadena, int posicio) {

        //Tractem els casos especials
        if (text == null || subcadena == null) {
            return -1;
        }
        if (subcadena.length() == 0) {
            return (posicio <= text.length() ? posicio : text.length());
        }
        posicio = (posicio < 0 ? 0 : posicio);
        if (posicio >= text.length()) {
            return -1;
        }

        //Usarem un booleà per saber si hem trobat la subcadena dins el text (inicialment no l'hem trobat, per tant és false)
        boolean trobat = false;

        //Comencem la búsqueda a partir de la posicio, fins trobar la subcadena o arribar al final del text 
        int i;
        for (i = posicio; i < text.length() && !trobat; i++) {
            //Per cada lletra del text la comparem en la primera de la subcadena, en cas de trobar coincidència la tractarem dins de l'if
            if (text.charAt(i) == subcadena.charAt(0)) {
                //Si coincidixen les inicials continuarem la búsqueda en paral·lel de les lletres de la subcadena i el text
                int j;
                //Per fer la búsqueda en paral·lel accedim a la posició 'i+j' del text i 'j' de la subcadena
                for (j = 0; j < subcadena.length() && text.charAt(i + j) == subcadena.charAt(j); j++);
                //Si el for ha acabat per què hem arribat al final de la subcadena, significa que l'hem trobat dins el text 
                if (j == subcadena.length()) {
                    //Actualitzem el booleà que ens dius que hem trobat la subcadena dins el text, posant-la a true
                    trobat = true;
                    //Forcem el fí del for per evitar que 'i' s'incremente en un, ja que ara mateix 'i' és el resultat a retornar 
                    break;
                }
            }
        }

        //Si hem trobat la subcadena dins el text retornem 'i', i sinó retornem -1       
        return (trobat ? i : -1);
    }
}
