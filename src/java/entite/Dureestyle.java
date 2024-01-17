package entite;

import generalise.Motherobj;
public class Dureestyle extends Motherobj<Dureestyle>  {
    int iddureestyle; 
    int idstyle; 
    double duree; 

    public Dureestyle(){ }
    public Dureestyle(String iddureestyle,String idstyle,String duree)throws Exception{
        setIddureestyle(iddureestyle);
        setIdstyle(idstyle);
        setDuree(duree);

     }
    
    public int getIddureestyle(){
        return this.iddureestyle;
    }
    public void setIddureestyle(int iddureestyle){
        this.iddureestyle=iddureestyle;
    }
    public void setIddureestyle(String iddureestyle)throws Exception{
        try {
            Integer.valueOf(iddureestyle);
        }
        catch(Exception e) {
            throw new Exception("iddureestyle invalide!");
        }
        setIddureestyle(Integer.valueOf(iddureestyle));
    }
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
    public double getDuree(){
        return this.duree;
    }
    public void setDuree(double duree){
        this.duree=duree;
    }
    public void setDuree(String duree)throws Exception{
        try{ Double.valueOf(duree); }
        catch(Exception e){ throw new Exception("duree :"+duree+" invalide"); }
        setDuree(Double.valueOf(duree));
    }

}
