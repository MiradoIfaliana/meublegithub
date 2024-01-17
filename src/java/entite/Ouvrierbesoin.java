package entite;

import java.sql.Connection;

import generalise.Motherobj;
public class Ouvrierbesoin extends Motherobj<Ouvrierbesoin>  {
    int idouvrierbesoin; 
    int idcategorie; 
    int idouvrier; 

    public Ouvrierbesoin(){ }
    public Ouvrierbesoin(String idouvrierbesoin,String idcategorie,String idouvrier)throws Exception{
        setIdouvrier(idouvrier);
        setIdcategorie(idcategorie);
        setIdouvrier(idouvrier);
    }
    public int getIdouvrierbesoin(){
        return this.idouvrierbesoin;
    }
    public void setIdouvrierbesoin(int idouvrierbesoin){
        this.idouvrierbesoin=idouvrierbesoin;
    }
    public void setIdouvrierbesoin(String idouvrierbesoin) throws Exception {
        try {
            int id = Integer.parseInt(idouvrierbesoin);
            this.setIdouvrierbesoin(id);
        }
        catch(Exception e) {
            throw new Exception("ouvrierbesoin id invalide");
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
    public void verifeInsert(Connection connection)throws Exception{
        String query="select * from ouvrierbesoin where idcategorie="+this.idcategorie+" and idouvrier="+this.idouvrier;
        Ouvrierbesoin ov=this.readOneByQueryConvenable(connection, query);
        if(ov!=null){ throw new Exception("type ouvrier deja existant pour cette categorie"); }
        this.create(connection, "idouvrierbesoin");
    }

}
