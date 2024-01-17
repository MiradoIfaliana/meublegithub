package entite;
import java.sql.Connection;
import java.sql.Date;
import generalise.Motherobj;
public class Stockdetailbefore_f extends Motherobj<Stockdetailbefore_f>{
    int idmatiere; 
    String nommatiere;  
    double equantite; 
    double squantite; 
    Date datestock ;
    int idunite; 
    String nomunite;
    // idcategorie | nomcategorie | idmatiere | nommatiere  | idstyle | nomstyle | idtaille | nomtaille | quantite | unite
    public Stockdetailbefore_f(){}
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
    public String getNommatiere(){
        return this.nommatiere;
    }
    public void setNommatiere(String nommatiere){
        this.nommatiere=nommatiere;
    }
    public double getEquantite() {
        return equantite;
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
    public void setEquantite(double equantite)
        throws Exception {
        if (equantite < 0) {
            throw new Exception("La equantite doit toujours etre >= 0");
        }
        
        this.equantite = equantite;
    }
    public double getSquantite() {
        return squantite;
    }
    public void setSquantite(String squantite) 
        throws Exception {
        double qte = -1;
        try {
            qte = Double.valueOf(squantite);
        }
        catch (Exception e) {
            throw new Exception("squantite invalid!");
        }    
        setSquantite(qte);
    }
    public void setSquantite(double squantite)
        throws Exception {
        if (squantite < 0) {
            throw new Exception("La squantite doit toujours etre >= 0");
        }
        
        this.squantite = squantite;
    }
    public double getQuantiteReste(){ return (this.equantite-this.squantite); }
    public Date getDatestock(){
        return this.datestock;
    }
    public void setDatestock(Date datestock){
        this.datestock=datestock;
    }
    public void setDatestock(String datestock)throws Exception{
        try{ Date.valueOf(datestock); }
        catch(Exception e){ throw new Exception("datestock :"+datestock+" invalide"); }
        setDatestock(Date.valueOf(datestock));
    }
    public int getIdunite() {
        return idunite;
    }
    public void setIdunite(int idunite) {
        this.idunite = idunite;
    }
    public void setIdunite(String idunite)throws Exception{
        try{ Integer.valueOf(idunite); }
        catch(Exception e){ throw new Exception("idunite :"+idunite+" invalide"); }
        setIdunite(Integer.valueOf(idunite));
    }
    public String getNomunite() {
        return nomunite;
    }
    public void setNomunite(String nomunite)throws Exception{
        if(nomunite==null){ throw new Exception("nom unite obligatoire");
        }else if(nomunite.replaceAll(" ","").compareTo("")==0){ throw new Exception("nom unite obligatoire"); }
        this.nomunite = nomunite;
    }
}
