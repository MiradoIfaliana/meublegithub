/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entite;

import generalise.Motherobj;
import java.sql.Connection;

/**
 *
 * @author tsoa
 */
public class Quantitematiere extends Motherobj<Quantitematiere>{
    
    int idquantitematiere;
    int idmatierestyle;
    int idtaille;
    double quantite;
    int idcategorie;
    
    public Quantitematiere() {}
    public Quantitematiere(int qtm, int ms, int t, double qt,int idcategorie) 
            throws Exception {
        setIdquantitematiere(qtm);
        setIdmatierestyle(ms);
        setIdtaille(t);
        setQuantite(qt);
        setIdcategorie(idcategorie);
    }

    public int getIdquantitematiere() {
        return idquantitematiere;
    }

    public void setIdquantitematiere(int idquantitematiere) {
        this.idquantitematiere = idquantitematiere;
    }

    public int getIdmatierestyle() {
        return idmatierestyle;
    }

    public void setIdmatierestyle(int idmatierestyle) {
        this.idmatierestyle = idmatierestyle;
    }
    public void setIdmatierestyle(String idmatierestyle)
        throws Exception {
        int mts = -1;
        try {
            mts = Integer.parseInt(idmatierestyle);
        }
        catch (Exception e) {
            throw new Exception("idmatierestyle invalid!");
        }    
        setIdmatierestyle(mts);
    }

    public int getIdtaille() {
        return idtaille;
    }

    public void setIdtaille(int idtaille) {
        this.idtaille = idtaille;
    }
    public void setIdtaille(String idtaille) 
        throws Exception {
        int taille = -1;
        try {
            taille = Integer.parseInt(idtaille);
        }
        catch (Exception e) {
            throw new Exception("idtaille invalid!");
        }    
        setIdtaille(taille);
    }

    public double getQuantite() {
        return quantite;
    }
    public void setQuantite(String quantite) 
        throws Exception {
        double qte = -1;
        try {
            qte = Double.valueOf(quantite);
        }
        catch (Exception e) {
            throw new Exception("quantite invalid!");
        }    
        setQuantite(qte);
    }
    public void setQuantite(double quantite)
        throws Exception {
        if (quantite < 0) {
            throw new Exception("La quantite doit toujours etre >= 0");
        }
        
        this.quantite = quantite;
    }
    public int getIdcategorie() {
        return idcategorie;
    }
    public void setIdcategorie(int idcategorie) {
        this.idcategorie = idcategorie;
    }
    public void setIdcategorie(String idcategorie)
        throws Exception {
        int mts = -1;
        try {
            mts = Integer.parseInt(idcategorie);
        }
        catch (Exception e) {
            throw new Exception("idcategorie invalid!");
        }    
        setIdcategorie(mts);
    }
    public String getRequeteVerifyExistance(String[] idstylematieres,String idtaille,String idcategorie){
        // idquantitematiere | idmatierestyle | idtaille | quantite
        String query="select * from quantitematiere where idtaille="+idtaille+" and idcategorie="+idcategorie+" and idmatierestyle in("+idstylematieres[0];
        for(int i=1;i<idstylematieres.length;i++){
            query=query+","+idstylematieres[i];
        }
        query=query+")";
        return query;
    }
    
    public void insertAll(Connection connection, String[] idstylematieres, String[] quantites, String idtaille,String idcategorie)
        throws Exception {    
        if (idstylematieres == null) {  throw new Exception("Pas de stylematiere!");    }
        else if (idstylematieres.length == 0) { throw new Exception("Pas de stylematiere!");    }
        if (quantites == null) {    throw new Exception("Pas de quantite!"); }
        else if (quantites.length == 0) {   throw new Exception("Pas de quantite!");} 
        if (idtaille == null) { throw new Exception("Pas de taille!");}
        if (idstylematieres.length != quantites.length) {   throw new Exception("Association invalide entre matiere et quantite!"); }
        
        String query=this.getRequeteVerifyExistance(idstylematieres, idtaille,idcategorie);
        Quantitematiere[]qms=new Quantitematiere().readByQueryConvenable(connection, query);
        Taille tl=new Taille();
        tl.setIdtaille(idtaille);
        tl=tl.readById(connection, "idtaille");
        if(tl==null){   throw new Exception("taille id:"+idtaille+" invalide"); }
        if(qms!=null){  throw new Exception("quantite matiere pour taille "+tl.getNomtaille()+" existe deja");  }
        int len = quantites.length;
        Quantitematiere[] quantitematieres = new Quantitematiere[len];
        
        boolean autocommitToTrue=false;
        if(connection.getAutoCommit()==true){ connection.setAutoCommit(false); autocommitToTrue=true; }
        try{
            String quantt="0";
            double total=0;
            for (int i = 0 ; i < len ; i++) {
                    if(quantites[i].replaceAll(" ","").compareTo("")==0){ //pour ne pas avoir d'erreur lors de setquantite si il n'a pas inserer de quantite pour le matiere
                        quantt="0";
                    }else{
                        quantt=quantites[i];
                    }
                    quantitematieres[i] = new Quantitematiere();
                    quantitematieres[i].setIdmatierestyle(idstylematieres[i]);
                    quantitematieres[i].setQuantite(quantt);
                    quantitematieres[i].setIdtaille(idtaille);
                    quantitematieres[i].setIdcategorie(idcategorie);
                    quantitematieres[i].create(connection, "idquantitematiere");    
                    total=total+quantitematieres[i].getQuantite();
            }
            if(total==0){
                throw new Exception("aucune quantite enregistrée");
            }
            connection.commit();
        }catch(Exception ex){
            if(connection!=null){ connection.rollback(); }
            ex.printStackTrace();
            throw ex;
        }finally{
           if(connection!=null){ 
               if(autocommitToTrue==true){
                   connection.setAutoCommit(true); 
               }
           }
        }
    }
}
