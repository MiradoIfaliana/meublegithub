package entite;

import java.sql.Connection;
import java.sql.Date;

import generalise.Motherobj;

public class Matiere extends Motherobj<Matiere>{

    int idmatiere; 
    String nommatiere;
    int idunite;

    public Matiere(){}

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

    public void verifecreateWithUnite(Connection connection)throws Exception{
            Matiere matiere=this.readOneByQueryConvenable(connection,"select * from matiere where nommatiere  ILIKE \'"+this.nommatiere+"\'");
            if(matiere!=null){ throw new Exception("matiere "+this.nommatiere.toUpperCase()+" existe deja"); }
            this.create(connection, "idmatiere");
    }
    public Stockdetailbefore_f getStockdetailbefore_fByDate(Connection connection,String date)throws Exception{
        try{    Date.valueOf(date); }
        catch(Exception e){ throw new Exception("date "+date+" invalide"); }
        String query="select * from Stockdetailbefore_f(\'"+Date.valueOf(date).toString()+"\') where idmatiere="+this.idmatiere;
        //System.out.println("QUERY="+query);
        return new Stockdetailbefore_f().readOneByQueryConvenable(connection,query);
    }
}
