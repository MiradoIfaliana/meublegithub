/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entite;

import generalise.Motherobj;
import java.sql.Connection;

/**
 *
 * @author Mirado
 */
public class Matierequantite_v extends Motherobj<Matierequantite_v> {
    private int idcategorie;
    private String nomcategorie;
    private int idmatiere;
    private String nommatiere;
    private int idstyle;
    private String nomstyle;
    private int idtaille;
    private String nomtaille;
    private double quantite;
    private String unite;
    
    public Matierequantite_v() {}

    public int getIdcategorie() {
        return idcategorie;
    }
    public void setIdcategorie(int idcategorie) {
        this.idcategorie = idcategorie;
    }

    public String getNomcategorie() {
        return nomcategorie;
    }

    public void setNomcategorie(String nomcategorie) {
        this.nomcategorie = nomcategorie;
    }

    public int getIdmatiere() {
        return idmatiere;
    }

    public void setIdmatiere(int idmatiere) {
        this.idmatiere = idmatiere;
    }

    public String getNommatiere() {
        return nommatiere;
    }

    public void setNommatiere(String nommatiere) {
        this.nommatiere = nommatiere;
    }

    public int getIdstyle() {
        return idstyle;
    }

    public void setIdstyle(int idstyle) {
        this.idstyle = idstyle;
    }

    public String getNomstyle() {
        return nomstyle;
    }

    public void setNomstyle(String nomstyle) {
        this.nomstyle = nomstyle;
    }

    public int getIdtaille() {
        return idtaille;
    }

    public void setIdtaille(int idtaille) {
        this.idtaille = idtaille;
    }

    public String getNomtaille() {
        return nomtaille;
    }

    public void setNomtaille(String nomtaille) {
        this.nomtaille = nomtaille;
    }

    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }

    public String getUnite() {
        return unite;
    }

    public void setUnite(String unite) {
        this.unite = unite;
    }
    
    
    public Matierequantite_v[] getAllByIdmatiere(Connection connection, int idmatiere) 
        throws Exception {
        String query = "SELECT * FROM Matierequantite_v WHERE idmatiere = "
                + idmatiere ;
        
        return this.readByQueryConvenable(connection, query);
    }
    public Matierequantite_v[] getAllByIdmatiere(Connection connection, int idmatiere,int idcategorie) 
        throws Exception {
        String query = "SELECT * FROM Matierequantite_v WHERE idmatiere = "+ idmatiere + " and idcategorie = "+idcategorie ;
        
        return this.readByQueryConvenable(connection, query);
    }

    public Matierequantite_v[] getAllByIdcategorieByIdstyleByIdtailleOrderByIdmatiere(Connection connection, int idcategorie,int idstyle,int idtaille) 
    throws Exception {
        String query = "SELECT * FROM Matierequantite_v WHERE idcategorie = "+ idcategorie + " and idstyle = "+idstyle+" and idtaille="+idtaille +" order by idmatiere ASC" ;
        return this.readByQueryConvenable(connection, query);
    }

}
