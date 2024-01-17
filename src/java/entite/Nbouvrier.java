package entite;
import java.sql.Connection;
import generalise.Motherobj;
public class Nbouvrier extends Motherobj<Nbouvrier>  {
    int idnbouvrier; 
    int idcategorie; 
    int idtaille; 
    double nombre; 

    public Nbouvrier(){ }
    public Nbouvrier(String idnbouvrier,String idcategorie,String idtaille,String nombre)throws Exception{
        setIdnbouvrier(idnbouvrier);
        setIdcategorie(idcategorie);
        setIdtaille(idtaille);
        setNombre(nombre);
    }
    public int getIdnbouvrier(){
        return this.idnbouvrier;
    }
    public void setIdnbouvrier(int idnbouvrier){
        this.idnbouvrier=idnbouvrier;
    }
    public void setIdnbouvrier(String idnbouvrier) throws Exception {
        try {
            int id = Integer.parseInt(idnbouvrier);
            this.setIdnbouvrier(id);
        }
        catch(Exception e) {
            throw new Exception("nbouvrier id invalide");
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
    public int getIdtaille(){
        return this.idtaille;
    }
    public void setIdtaille(int idtaille){
        this.idtaille=idtaille;
    }
    public void setIdtaille(String idtaille) {
        try{ Integer.valueOf(idtaille);
        }catch(Exception ex){ new Exception("idtaille :"+idtaille+" invalide"); }
        setIdtaille(Integer.valueOf(idtaille));
    }
    public double getNombre(){
        return this.nombre;
    }
    public void setNombre(double nombre)throws Exception{
        if(nombre<=0){ throw new Exception("nombre <=0"); }
        this.nombre=nombre;
    }
    public void setNombre(String nombre) throws Exception{
        try{ Integer.valueOf(nombre);
        }catch(Exception ex){ new Exception("nombre :"+nombre+" invalide"); }
        setNombre(Integer.valueOf(nombre));
    }

}
