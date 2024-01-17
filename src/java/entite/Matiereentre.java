package entite;
import java.sql.Date;
import generalise.Motherobj;
public class Matiereentre extends Motherobj<Matiereentre>{
    int idmatiereentre; 
    int idmatiere; 
    double equantite; 
    Date dateentre; 

    public Matiereentre(){ }
    public Matiereentre(String idmatiereentre,String idmatiere,String equantite,String dateentre)throws Exception{
        setIdmatiereentre(idmatiereentre);
        setIdmatiere(idmatiere);
        setEquantite(equantite);
        setDateentre(dateentre);
     }
    
    public int getIdmatiereentre(){
        return this.idmatiereentre;
    }
    public void setIdmatiereentre(int idmatiereentre){
        this.idmatiereentre=idmatiereentre;
    }
    public void setIdmatiereentre(String idmatiereentre)throws Exception{
        try {
            Integer.valueOf(idmatiereentre);
        }
        catch(Exception e) {
            throw new Exception("idmatiereentre invalide!");
        }
        setIdmatiereentre(Integer.valueOf(idmatiereentre));
    }
    public int getIdmatiere(){
        return this.idmatiere;
    }
    public void setIdmatiere(int idmatiere){
        this.idmatiere=idmatiere;
    }
    public void setIdmatiere(String idmatiere)throws Exception{
        try {
            Integer.valueOf(idmatiere);
        }
        catch(Exception e) {
            throw new Exception("idmatiere invalide!");
        }
        setIdmatiere(Integer.valueOf(idmatiere));
    }
    public double getEquantite()throws Exception{
        return this.equantite;
    }
    public void setEquantite(double equantite)throws Exception{
        if(equantite<=0){ throw new Exception("quantite inferieur a zero"); }
        this.equantite=equantite;
    }
    public void setEquantite(String equantite) 
        throws Exception {
        double qte = -1;
        try {
            qte = Double.valueOf(equantite);
        }
        catch (Exception e) {
            throw new Exception("equantite invalid!");
        }    
        setEquantite(qte);
    }
    public Date getDateentre(){
        return this.dateentre;
    }
    public void setDateentre(Date dateentre){
        this.dateentre=dateentre;
    }
    public void setDateentre(String dateentre)throws Exception{
        try {
            Date.valueOf(dateentre);
        }
        catch(Exception e) {
            throw new Exception("dateentre invalide!");
        }
        setDateentre(Date.valueOf(dateentre));
    }

}
