package entite;
import java.sql.Connection;
import generalise.Motherobj;
public class Beneficedetail_v extends Motherobj<Beneficedetail_v>  {
    int idcategorie; 
    String nomcategorie; 
    int idstyle; 
    String nomstyle; 
    int idtaille; 
    String nomtaille; 
    double prixvente; 
    double prixrevient; 
    double benefice; 

    public Beneficedetail_v(){ }
    
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
    public Beneficedetail_v[] getByPrixMinByPrixMax(Connection connection,double prixmin,double prixmax)throws Exception{
        String query="select * from beneficedetail_v where benefice between "+prixmin+" and "+prixmax;
        Beneficedetail_v[] beneficedetail_vs=this.readByQueryConvenable(connection, query);
        return beneficedetail_vs;
    }
    public Beneficedetail_v[] getByPrixMinByPrixMax(Connection connection,String prixmin,String prixmax)throws Exception{
        try{
            Double.valueOf(prixmin);
            Double.valueOf(prixmax);
        }catch(Exception e){ throw new Exception("prix invalide"); }
        return getByPrixMinByPrixMax(connection,Double.valueOf(prixmin),Double.valueOf(prixmax));
    }

}
