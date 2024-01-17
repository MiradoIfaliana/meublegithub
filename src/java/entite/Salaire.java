package entite;
import java.sql.Date;

import generalise.Motherobj;
public class Salaire extends Motherobj<Salaire>  {
    int idsalaire; 
    int idouvrier; 
    double salaires; 
    Date datesalaire; 

    public Salaire(){ }
    public Salaire(String idsalaire,String idouvrier,String salaires,String datesalaire)throws Exception{
        setIdsalaire(idsalaire);
        setIdouvrier(idouvrier);
        setSalaires(salaires);
        setDatesalaire(datesalaire);
     }
    
    public int getIdsalaire(){
        return this.idsalaire;
    }
    public void setIdsalaire(int idsalaire){
        this.idsalaire=idsalaire;
    }
    public void setIdsalaire(String idsalaire)throws Exception{
        try{ Integer.valueOf(idsalaire);
        }catch(Exception ex){ throw new Exception("idsalaire :"+idsalaire+" invalide"); }
        setIdsalaire(Integer.valueOf(idsalaire));
    }
    public int getIdouvrier(){
        return this.idouvrier;
    }
    public void setIdouvrier(int idouvrier){
        this.idouvrier=idouvrier;
    }
    public void setIdouvrier(String idouvrier)throws Exception{
        try{ Integer.valueOf(idouvrier);
        }catch(Exception ex){ throw new Exception("idouvrier :"+idouvrier+" invalide"); }
        setIdouvrier(Integer.valueOf(idouvrier));
    }
    public double getSalaires(){
        return this.salaires;
    }
    public void setSalaires(double salaires)throws Exception{
        if(salaires<=0){ throw new Exception(" salaire <=0 "); }
        this.salaires=salaires;
    }
    public void setSalaires(String salaires)throws Exception {
        try{ Double.valueOf(salaires);
        }catch(Exception ex){ throw new Exception("salaires :"+salaires+" invalide"); }
        setSalaires(Double.valueOf(salaires));
    }
    public Date getDatesalaire(){
        return this.datesalaire;
    }
    public void setDatesalaire(Date datesalaire){
        this.datesalaire=datesalaire;
    }
    public void setDatesalaire(String datesalaire)throws Exception{
        try{ Date.valueOf(datesalaire); }
        catch(Exception e){ throw new Exception("datesalaire :"+datesalaire+" invalide"); }
        setDatesalaire(Date.valueOf(datesalaire));
    }

}
