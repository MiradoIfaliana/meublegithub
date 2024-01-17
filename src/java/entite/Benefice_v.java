package entite;

import java.sql.Connection;

import generalise.Motherobj;
public class Benefice_v extends Motherobj<Benefice_v>  {
    int idcategorie; 
    int idstyle; 
    int idtaille; 
    double prixvente; 
    double prixrevient; 
    double benefice; 

    public Benefice_v(){ }
    
    public int getIdcategorie(){
        return this.idcategorie;
    }
    public void setIdcategorie(int idcategorie){
        this.idcategorie=idcategorie;
    }
    public int getIdstyle(){
        return this.idstyle;
    }
    public void setIdstyle(int idstyle){
        this.idstyle=idstyle;
    }
    public int getIdtaille(){
        return this.idtaille;
    }
    public void setIdtaille(int idtaille){
        this.idtaille=idtaille;
    }
    public double getPrixvente(){
        return this.prixvente;
    }
    public void setPrixvente(double prixvente){
        this.prixvente=prixvente;
    }
    public double getPrixrevient(){
        return this.prixrevient;
    }
    public void setPrixrevient(double prixrevient){
        this.prixrevient=prixrevient;
    }
    public double getBenefice(){
        return this.benefice;
    }
    public void setBenefice(double benefice){
        this.benefice=benefice;
    }

    public Benefice_v[] getByPrixMinByPrixMax(Connection connection,double prixmin,double prixmax)throws Exception{
        String query="select * from benefice_v where benefice between "+prixmin+" and "+prixmax;
        Benefice_v[] benefice_vs=this.readByQueryConvenable(connection, query);
        return benefice_vs;
    }
    public Benefice_v[] getByPrixMinByPrixMax(Connection connection,String prixmin,String prixmax)throws Exception{
        try{
            Double.valueOf(prixmin);
            Double.valueOf(prixmax);
        }catch(Exception e){ throw new Exception("prix invalide"); }
        return getByPrixMinByPrixMax(connection,Double.valueOf(prixmin),Double.valueOf(prixmax));
    }

}
