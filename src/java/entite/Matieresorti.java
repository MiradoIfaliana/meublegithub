package entite;
import java.sql.Date;
import generalise.Motherobj;
public class Matieresorti extends Motherobj<Matieresorti>{
    int idmatieresorti; 
    int idmatiere; 
    double squantite; 
    Date datesorti; 

    public Matieresorti(){ }
    public Matieresorti(int idmatieresorti,int idmatiere,double squantite,Date datesorti)throws Exception{
        setIdmatieresorti(idmatieresorti);
        setIdmatiere(idmatiere);
        setSquantite(squantite);
        setDatesorti(datesorti);
    }
    public int getIdmatieresorti(){
        return this.idmatieresorti;
    }
    public void setIdmatieresorti(int idmatieresorti){
        this.idmatieresorti=idmatieresorti;
    }
    public int getIdmatiere(){
        return this.idmatiere;
    }
    public void setIdmatiere(int idmatiere){
        this.idmatiere=idmatiere;
    }
    public double getSquantite(){
        return this.squantite;
    }
    public void setSquantite(double squantite)throws Exception{
        if(squantite<=0){ throw new Exception("squantite <=0 "); }
        this.squantite=squantite;
    }
    public Date getDatesorti(){
        return this.datesorti;
    }
    public void setDatesorti(Date datesorti){
        this.datesorti=datesorti;
    }
    // idcategorie | nomcategorie | idmatiere | nommatiere  | idstyle | nomstyle | idtaille | nomtaille | quantite | unite

}
