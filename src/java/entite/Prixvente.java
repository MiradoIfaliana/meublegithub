package entite;
import java.sql.Date;

import generalise.Motherobj;
public class Prixvente extends Motherobj<Prixvente>  {
    int idprixvente; 
    int idcategorie; 
    int idstyle; 
    int idtaille; 
    double prixvente; 
    Date dateprix; 

    public Prixvente(){ }
    public Prixvente(String idprixvente,String idcategorie,String idstyle,String idtaille,String prixvente,String dateprix)throws Exception{
        setIdprixvente(idprixvente);
        setIdcategorie(idcategorie);
        setIdstyle(idstyle);
        setIdtaille(idtaille);
        setPrixvente(prixvente);
        setDateprix(dateprix);
     }
    
    public int getIdprixvente(){
        return this.idprixvente;
    }
    public void setIdprixvente(int idprixvente){
        this.idprixvente=idprixvente;
    }
    public void setIdprixvente(String idprixvente) throws Exception {
        try {
            int id = Integer.parseInt(idprixvente);
            this.setIdprixvente(id);
        }
        catch(Exception e) {
            throw new Exception("idprixvente invalide");
        }
    }
    public int getIdcategorie(){
        return this.idcategorie;
    }
    public void setIdcategorie(int idcategorie){
        this.idcategorie=idcategorie;
    }
    public void setIdcategorie(String idcategorie) throws Exception {
        try {
            int id = Integer.parseInt(idcategorie);
            this.setIdcategorie(id);
        }
        catch(Exception e) {
            throw new Exception("categorie id invalide");
        }
    }
    public int getIdstyle(){
        return this.idstyle;
    }
    public void setIdstyle(int idstyle){
        this.idstyle=idstyle;
    }
    public void setIdstyle(String idstyle)throws Exception{
        try{ Integer.valueOf(idstyle); }
        catch(Exception e){ throw new Exception("idstyle :"+idstyle+" invalide"); }
        setIdstyle(Integer.valueOf(idstyle));
    }
    public int getIdtaille(){
        return this.idtaille;
    }
    public void setIdtaille(String idtaille) {
        try{ Integer.valueOf(idtaille);
        }catch(Exception ex){ new Exception("idtaille :"+idtaille+" invalide"); }
        setIdtaille(Integer.valueOf(idtaille));
    }
    public void setIdtaille(int idtaille){
        this.idtaille=idtaille;
    }
    public double getPrixvente(){
        return this.prixvente;
    }
    public void setPrixvente(double prixvente)throws Exception{
        if(prixvente<=0){ throw new Exception("prix <= 0"); }
        this.prixvente=prixvente;
    }
    public void setPrixvente(String prixvente)throws Exception{
        try{ Double.valueOf(prixvente); }
        catch(Exception e){ throw new Exception("prixvente "+prixvente+" invalide");}
        setPrixvente(Double.valueOf(prixvente));
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
