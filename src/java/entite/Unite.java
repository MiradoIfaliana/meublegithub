package entite;

import java.sql.Connection;

import generalise.Motherobj;

public class Unite extends Motherobj<Unite>{

    int idunite;
    String nomunite;
    String unite;
    public Unite(){}
    public int getIdunite() {
        return idunite;
    }
    public void setIdunite(int idunite){
        this.idunite = idunite;
    }
    public String getNomunite() {
        return nomunite;
    }
    public void setNomunite(String nomunite)throws Exception{
        if(nomunite==null){ throw new Exception("nom unite obligatoire");
        }else if(nomunite.replaceAll(" ","").compareTo("")==0){ throw new Exception("nom unite obligatoire"); }
        this.nomunite = nomunite;
    }
    public String getUnite() {
        return unite;
    }
    public void setUnite(String unite)throws Exception{
        if(unite==null){ throw new Exception("l'unite de mesure obligatoire");
        }else if(unite.replaceAll(" ","").compareTo("")==0){ throw new Exception("l'unite de mesure obligatoire"); }
        this.unite = unite;
    }
    public void verifecreate(Connection connection)throws Exception{
        Unite unite=this.readOneByQueryConvenable(connection,"select * from unite where nomunite  ILIKE \'"+this.nomunite+"\' or unite ILIKE \'"+this.unite+"\'");
        if(unite!=null){ throw new Exception("unite avec nom "+this.nomunite.toUpperCase()+" ou avec unite de mesure "+this.unite.toUpperCase()+" existe deja"); }
        this.create(connection, "idunite");
    }
    
}
