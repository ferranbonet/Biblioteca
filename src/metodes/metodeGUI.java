/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodes;

import java.util.Arrays;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author fbonet
 */
public class metodeGUI {

    public static void carregarTaula(String[] nomCols, Object[][] dades, JTable taula) {
        if (nomCols == null || dades == null) {
            return;
        }
        Vector columnNames = new Vector();
        Vector data = new Vector();
        DefaultTableModel model;
        int ncamps = nomCols.length;
        for (String s : nomCols) {
            columnNames.addElement(s);
        }
        if (dades.length != 0) {
            for (int i = 0; i < dades.length; i++) {
                Vector row = new Vector(ncamps);
                for (int j = 0; j < dades[i].length; j++) {
                    row.add(dades[i][j]);
                }
                data.addElement(row);
            }
        }
        model = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        taula.setModel(model);
        TableColumn column;
        for (int i = 0; i < taula.getColumnCount(); i++) {
            column = taula.getColumnModel().getColumn(i);
            column.setMaxWidth(250);
        }
    }

    public static Object[][] transformarDades(Serie[] dades) {
        Object[][] resultat = new Object[dades.length][5];
        int omplerts = 0;
        for (int i = 0; i < dades.length; i++) {
            if (dades[i].isOmplert()) {
                resultat[omplerts][0] = i;
                resultat[omplerts][1] = dades[i].getNom();
                resultat[omplerts][2] = dades[i].getGenere();
                resultat[omplerts][3] = dades[i].getDescripcio();
                resultat[omplerts][4] = dades[i].getNumCapitols();
                resultat[omplerts][5] = dades[i].getDuracioCapitols();
                resultat[omplerts][6] = dades[i].getAnyEmissio();
                resultat[omplerts][7] = dades[i].getNota();
                resultat[omplerts][8] = dades[i].isAcabat();
                omplerts++;
            }
        }
        return Arrays.copyOf(resultat, omplerts);
    }
}

class Serie {

    private String nom = "";
    private String genere = "";
    private String descripcio = "";
    private int numCapitols = 0;
    private int duracioCapitols = 0;
    private int anyEmissio = 0;
    private double nota = 0.0;
    private boolean acabat = false;
    private boolean omplert = false;
    private char acabatChar;

    public Serie(String nom, String genere, String descripcio, int numCapitols, int duracioCapitols, int anyEmissio, double nota, boolean acabat, boolean omplert, char acabatChar) {
        this.nom = nom;
        this.genere = genere;
        this.descripcio = descripcio;
        this.numCapitols = numCapitols;
        this.duracioCapitols = duracioCapitols;
        this.anyEmissio = anyEmissio;
        this.nota = nota;
        this.acabat = acabat;
        this.omplert = omplert;
        this.acabatChar = acabatChar;
    }

    @Override
    public String toString() {
        return "\nNom: " + nom
                + "\nGènere: " + genere
                + "\nDescripció: " + descripcio
                + "\nNúmero de capítols: " + numCapitols
                + "\nDuració capítols: " + duracioCapitols
                + "\nAny d'emissió: " + anyEmissio
                + "\nNota: " + nota
                + (acabat ? "\nAcabat" : "\nNo acabat");
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public int getNumCapitols() {
        return numCapitols;
    }

    public void setNumCapitols(int numCapitols) {
        this.numCapitols = numCapitols;
    }

    public int getDuracioCapitols() {
        return duracioCapitols;
    }

    public void setDuracioCapitols(int duracioCapitols) {
        this.duracioCapitols = duracioCapitols;
    }

    public int getAnyEmissio() {
        return anyEmissio;
    }

    public void setAnyEmissio(int anyEmissio) {
        this.anyEmissio = anyEmissio;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public boolean isAcabat() {
        return acabat;
    }

    public void setAcabat(boolean acabat) {
        this.acabat = acabat;
    }

    public boolean isOmplert() {
        return omplert;
    }

    public void setOmplert(boolean omplert) {
        this.omplert = omplert;
    }

    public char getAcabatChar() {
        return acabatChar;
    }

    public void setAcabatChar(char acabatChar) {
        this.acabatChar = acabatChar;
    }
}
