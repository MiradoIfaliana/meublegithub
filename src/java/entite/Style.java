package entite;

import java.sql.Connection;

import generalise.Motherobj;

public class Style extends Motherobj<Style>{

    int idstyle; 
    String nomstyle; 

    public Style(){}

    public int getIdstyle(){
        return this.idstyle;
    }
    public void setIdstyle(int idstyle){
        this.idstyle=idstyle;
    }
    public void setIdstyle(String idstyle)throws Exception{
        try{ Integer.valueOf(idstyle); }
        catch(Exception e){ throw new Exception("idstyle :"+idstyle+" invalide"); }
        setIdstyle(Integer.valueOf(idstyle));
    }
    public String getNomstyle(){
        return this.nomstyle;
    }
    public void setNomstyle(String nomstyle){
        this.nomstyle=nomstyle;
    }
    public void verifecreate(Connection connection)throws Exception{
        Style style=this.readOneByQueryConvenable(connection,"select * from style where nomstyle  ILIKE \'"+this.nomstyle+"\'");
        if(style!=null){ throw new Exception("style "+this.nomstyle.toUpperCase()+" existe deja"); }
        this.create(connection, "idstyle");
    }
    public Stylematiere_v[] getAllMyStylematiere(Connection connection)throws Exception{
        String query="select * from Stylematiere_v where idstyle="+this.idstyle;
        return new Stylematiere_v().readByQueryConvenable(connection, query);
    }
    public Stylematiere2_v[] getAllMyStylematiere2(Connection connection)throws Exception{
        String query="select * from Stylematiere2_v where idstyle="+this.idstyle;
        return new Stylematiere2_v().readByQueryConvenable(connection, query);
    }

}
