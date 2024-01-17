/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entite;

/**
 *
 * @author Mirado
 */
import generalise.Motherobj;
import java.sql.Connection;
public class Prixcategorie_v extends Motherobj<Prixcategorie_v> {
    int idcategorie; 
    String nomcategorie; 
    int idstyle; 
    String nomstyle; 
    int idtaille; 
    String nomtaille; 
    double prixtotal; 

    public Prixcategorie_v(){ }
    
    public int getIdcategorie(){
        return this.idcategorie;
    }
    public void setIdcategorie(int idcategorie){
        this.idcategorie=idcategorie;
    }
    public String getNomcategorie(){
        return this.nomcategorie;
    }
    public void setNomcategorie(String nomcategorie){
        this.nomcategorie=nomcategorie;
    }
    public int getIdstyle(){
        return this.idstyle;
    }
    public void setIdstyle(int idstyle){
        this.idstyle=idstyle;
    }
    public String getNomstyle(){
        return this.nomstyle;
    }
    public void setNomstyle(String nomstyle){
        this.nomstyle=nomstyle;
    }
    public int getIdtaille(){
        return this.idtaille;
    }
    public void setIdtaille(int idtaille){
        this.idtaille=idtaille;
    }
    public String getNomtaille(){
        return this.nomtaille;
    }
    public void setNomtaille(String nomtaille){
        this.nomtaille=nomtaille;
    }
    public double getPrixtotal(){
        return this.prixtotal;
    }
    public void setPrixtotal(double prixtotal){
        this.prixtotal=prixtotal;
    }
    public Prixcategorie_v[] getAllByPrixMinMax(Connection connection,double prixmin,double prixmax)throws Exception{
        String query ="select * from prixcategorie_v where prixtotal>="+prixmin+" and prixtotal<="+prixmax;
        return this.readByQueryConvenable(connection, query);
    }
    public Prixcategorie_v[] getAllByPrixMinMax(Connection connection,String prixmin,String prixmax)throws Exception{
        double min=0;
        double max=0;
        try{ 
            min=Double.valueOf(prixmin); 
            max=Double.valueOf(prixmax); 
        }catch(Exception e){ throw new Exception("prix invalide ");}
        return getAllByPrixMinMax(connection,min,max);
    }
    
}
