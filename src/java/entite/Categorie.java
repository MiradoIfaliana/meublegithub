package entite;

import java.sql.Connection;

import generalise.Motherobj;

public class Categorie extends Motherobj<Categorie>{

    int idcategorie; 
    String nomcategorie; 

    public Categorie(){}

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
    public String getNomcategorie(){
        return this.nomcategorie;
    }
    public void setNomcategorie(String nomcategorie){
        this.nomcategorie=nomcategorie;
    }
    public void verifecreate(Connection connection)throws Exception{
        Categorie categorie = 
                this.readOneByQueryConvenable(connection,"select * from categorie where nomcategorie  ILIKE \'"+this.nomcategorie+"\'");
        if(categorie!=null) { 
            throw new Exception("categorie "+this.nomcategorie.toUpperCase()+" existe deja"); 
        }
        this.create(connection, "idcategorie");
    }

}
