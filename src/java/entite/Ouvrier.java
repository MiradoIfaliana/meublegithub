package entite;
import java.sql.Connection;
import generalise.Motherobj;
public class Ouvrier extends Motherobj<Ouvrier>  {
    int idouvrier; 
    String typeouvrier; 

    public Ouvrier(){ }
    public Ouvrier(String idouvrier,String typeouvrier)throws Exception{
        setIdouvrier(idouvrier);
        setTypeouvrier(typeouvrier);
    }
    public int getIdouvrier(){
        return this.idouvrier;
    }
    public void setIdouvrier(int idouvrier){
        this.idouvrier=idouvrier;
    }
    public void setIdouvrier(String idouvrier) throws Exception {
        try {
            int id = Integer.parseInt(idouvrier);
            this.setIdouvrier(id);
        }
        catch(Exception e) {
            throw new Exception("ouvrier id invalide");
        }
    }
    public String getTypeouvrier(){
        return this.typeouvrier;
    }
    public void setTypeouvrier(String typeouvrier){
        this.typeouvrier=typeouvrier;
    }

    public void verifecreate(Connection connection)throws Exception{
        Ouvrier ouvrier = 
                this.readOneByQueryConvenable(connection,"select * from Ouvrier where typeouvrier  ILIKE \'"+this.typeouvrier+"\'");
        if(ouvrier!=null) { 
            throw new Exception("ouvrier "+this.typeouvrier.toUpperCase()+" existe deja"); 
        }
        this.create(connection, "idouvrier");
    }
    

}
