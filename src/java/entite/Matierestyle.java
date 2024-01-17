package entite;

import java.sql.Connection;
import generalise.Motherobj;

public class Matierestyle extends Motherobj<Matierestyle>{

    int idmatierestyle; 
    int idmatiere; 
    int idstyle; 

    public Matierestyle(){}

    public int getIdmatierestyle(){
        return this.idmatierestyle;
    }
    public void setIdmatierestyle(int idmatierestyle){
        this.idmatierestyle=idmatierestyle;
    }
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
    public int getIdstyle(){
        return this.idstyle;
    }
    public void setIdstyle(int idstyle){
        this.idstyle=idstyle;
    }
    public void setIdstyle(String idstyle)throws Exception{
        try {
            Integer.valueOf(idstyle);
        }
        catch(Exception e) {
            throw new Exception("idstyle invalide!");
        }
        setIdstyle(Integer.valueOf(idstyle));
    }
    public String requeteExistance(String[] idmatieres,String idstyle){
        String rq="select * from Matierestyle where (idstyle="+idstyle+" and idmatiere="+idmatieres[0]+")";
        for(int i=1;i<idmatieres.length;i++){
            rq=rq+" or (idstyle="+idstyle+" and idmatiere="+idmatieres[i]+")";
        }
        return rq;
    }
    public String requeteExistanceMatiere(Matierestyle[] matierestyles){
        String rq="select * from Matiere where idmatiere in("+matierestyles[0].getIdmatiere()+"";
        for(int i=1;i<matierestyles.length;i++){
            rq=rq+" ,"+matierestyles[i].getIdmatiere()+"";
        }
        rq=rq+")";
        return rq;
    }
    public Matiere[] getExistematiereOfIdmatiersOfStyle(Connection connection,String[] idmatieres,String idstyle)throws Exception{
        String rq=requeteExistance(idmatieres, idstyle);
        Matierestyle[] matierestyles=this.readByQueryConvenable(connection, rq);
        if(matierestyles!=null){
        String rqm=requeteExistanceMatiere(matierestyles);
        Matiere[] matieres=new Matiere().readByQueryConvenable(connection, rqm);
        return matieres;
        }
        return null;
    }

        public void insertAll(Connection connection,String[] idmatieres,String idstyle)throws Exception{
           if(idmatieres==null){ throw new Exception("aucune matiere selectionne");}
           else if(idmatieres.length==0){ throw new Exception("aucune matiere selectionne");}
           //si c'est matieres existe deja pour cette style
           Matiere[] matieres=getExistematiereOfIdmatiersOfStyle(connection, idmatieres, idstyle);
           if(matieres!=null){
                String message="pour ce style, ce(s) matiere(s) existe deja :"+matieres[0].getNommatiere();
                for(int i=1;i<matieres.length;i++){
                    message=message+","+matieres[i].getNommatiere();
                }
                throw new Exception(message);
           }           
           Matierestyle[] matierestyles=new Matierestyle[idmatieres.length];
           connection.setAutoCommit(false);
           boolean autocommitToTrue=false;
           if(connection.getAutoCommit()==true){ connection.setAutoCommit(false); autocommitToTrue=true; }
           try{
            for(int i=0;i<idmatieres.length;i++){
                matierestyles[i]=new Matierestyle();
                matierestyles[i].setIdmatiere(idmatieres[i]);
                matierestyles[i].setIdstyle(idstyle);
                matierestyles[i].create(connection, "idmatierestyle");
            }
            connection.commit();
           }catch(Exception ex){
               if(connection!=null){ connection.rollback(); }
               ex.printStackTrace();
           }finally{
                if(connection!=null){ if(autocommitToTrue==true){ connection.setAutoCommit(true); } }
           }
    }
}
