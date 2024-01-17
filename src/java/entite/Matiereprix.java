/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entite;

/**
 *
 * @author Mirado
 */
import java.sql.Connection;
import generalise.Motherobj;
import java.sql.Date;
public class Matiereprix extends Motherobj<Matiereprix>{
    int idmatiereprix; 
    int idmatiere; 
    double prix; 
    Date dateprix; 

    public Matiereprix(){ }
    public Matiereprix(String idmatiereprix,String idmatiere,String prix,String dateprix)throws Exception{
        setIdmatiereprix(idmatiereprix);
        setIdmatiere(idmatiere);
        setPrix(prix);
        setDateprix(dateprix);
    }
    public int getIdmatiereprix(){
        return this.idmatiereprix;
    }
    public void setIdmatiereprix(int idmatiereprix){
        this.idmatiereprix=idmatiereprix;
    }
    public void setIdmatiereprix(String idmatiereprix)throws Exception{
        try{ Integer.valueOf(idmatiereprix); }
        catch(Exception e){ throw new Exception("idmatiereprix :"+idmatiereprix+" invalide"); }
        setIdmatiereprix(Integer.valueOf(idmatiereprix));
    }
    public int getIdmatiere(){
        return this.idmatiere;
    }
    public void setIdmatiere(int idmatiere){
        this.idmatiere=idmatiere;
    }
    public void setIdmatiere(String idmatiere)throws Exception{
        try{ Integer.valueOf(idmatiere); }
        catch(Exception e){ throw new Exception("idmatiere :"+idmatiere+" invalide"); }
        setIdmatiere(Integer.valueOf(idmatiere));
    }

    public double getPrix(){
        return this.prix;
    }
    public void setPrix(double prix)throws Exception{
        if(prix<=0){ throw new Exception("prix "+prix+" invalide,doit etre > 0"); }
        this.prix=prix;
    }
    public void setPrix(String prix)throws Exception{
        try{ Double.valueOf(prix); }
        catch(Exception e){ throw new Exception("prix "+prix+" invalide");}
        setPrix(Double.valueOf(prix));
    }
    public Date getDateprix(){
        return this.dateprix;
    }
    public void setDateprix(Date dateprix){
        this.dateprix=dateprix;
    }
    public void setDateprix(String dateprix)throws Exception{
        try{ Date.valueOf(dateprix); }
        catch(Exception e){ throw new Exception("dateprix :"+dateprix+" invalide"); }
        setDateprix(Date.valueOf(dateprix));
    }

    
}
