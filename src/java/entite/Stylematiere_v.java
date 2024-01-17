package entite;

import generalise.Motherobj;

public class Stylematiere_v extends Motherobj<Stylematiere_v>{

    int idstyle; 
    String nomstyle; 
    int idmatiere; 
    String nommatiere; 
    int idunite;
    String unite;

    public Stylematiere_v(){}

    public int getIdstyle(){
        return this.idstyle;
    }
    public void setIdstyle(int idstyle){
        this.idstyle=idstyle;
    }
    public void setIdstyle(String idstyle)throws Exception{
        try{ Integer.valueOf(idstyle); }
        catch(Exception ex){ throw new Exception("idstyle :"+idstyle+" invalide"); }
        setIdstyle(Integer.valueOf(idstyle));
    }
    public String getNomstyle(){
        return this.nomstyle;
    }
    public void setNomstyle(String nomstyle){
        this.nomstyle=nomstyle;
    }
    public int getIdmatiere(){
        return this.idmatiere;
    }
    public void setIdmatiere(int idmatiere){
        this.idmatiere=idmatiere;
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

    public String getUnite() {
        return unite;
    }
    public void setUnite(String unite) {
        this.unite = unite;
    }
    

}
