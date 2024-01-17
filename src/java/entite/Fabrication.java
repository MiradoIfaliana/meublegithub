package entite;
import java.sql.Connection;
import java.sql.Date;
import java.util.Vector;
import generalise.Motherobj;

public class Fabrication extends Motherobj<Fabrication>{
    int idfabrication; 
    int idcategorie; 
    double quantitefab; 
    Date datefab; 
    int idtaille; 
    int idstyle; 

    public Fabrication(){ }
    public Fabrication(String idfabrication,String idcategorie,String quantitefab,String datefab,String idtaille,String idstyle)throws Exception{
        setIdfabrication(idfabrication);
        setIdcategorie(idcategorie);
        setQuantitefab(quantitefab);
        setDatefab(datefab);
        setIdtaille(idtaille);
        setIdstyle(idstyle);
     }
    
    public int getIdfabrication(){
        return this.idfabrication;
    }
    public void setIdfabrication(int idfabrication){
        this.idfabrication=idfabrication;
    }
    public void setIdfabrication(String idfabrication)throws Exception{
        try {
            Integer.valueOf(idfabrication);
        }
        catch(Exception e) {
            throw new Exception("idfabrication invalide!");
        }
        setIdfabrication(Integer.valueOf(idfabrication));
    }
    public int getIdcategorie(){
        return this.idcategorie;
    }
    public void setIdcategorie(int idcategorie){
        this.idcategorie=idcategorie;
    }
    public void setIdcategorie(String idcategorie)throws Exception{
        try {
            Integer.valueOf(idcategorie);
        }
        catch(Exception e) {
            throw new Exception("idcategorie invalide!");
        }
        setIdcategorie(Integer.valueOf(idcategorie));
    }
    public double getQuantitefab(){
        return this.quantitefab;
    }
    public void setQuantitefab(double quantitefab)throws Exception{
        if(quantitefab<=0){ throw new Exception("quantite <= zero"); }
        this.quantitefab=quantitefab;
    }
    public void setQuantitefab(String quantitefab)throws Exception{
        try{ Double.valueOf(quantitefab); }
        catch(Exception ex){ throw new Exception("quantite +"+quantitefab+" invalide"); }
        setQuantitefab(Double.valueOf(quantitefab));
    }
    public Date getDatefab(){
        return this.datefab;
    }
    public void setDatefab(Date datefab){
        this.datefab=datefab;
    }
    public void setDatefab(String datefab)throws Exception{
        try {
            Date.valueOf(datefab);
        }
        catch(Exception e) {
            throw new Exception("datefab invalide!");
        }
        setDatefab(Date.valueOf(datefab));
    }
    public int getIdtaille(){
        return this.idtaille;
    }
    public void setIdtaille(int idtaille){
        this.idtaille=idtaille;
    }
    public void setIdtaille(String idtaille)throws Exception{
        try {
            Integer.valueOf(idtaille);
        }
        catch(Exception e) {
            throw new Exception("idtaille invalide!");
        }
        setIdtaille(Integer.valueOf(idtaille));
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
    public Vector<Matierequantite> getMatiereManquante(Connection connection,int idcategorie,int idstyle,int idtaille,Date date,double quantitefabr)throws Exception{
        Matierequantite_v[] matierequantite_vs=new Matierequantite_v().getAllByIdcategorieByIdstyleByIdtailleOrderByIdmatiere(connection, idcategorie, idstyle, idtaille);
        if(matierequantite_vs==null){ throw new Exception("donnee du quantite matiere pour style id:"+idstyle+" taille id:"+idtaille+" categorie id:"+idcategorie+" null"); }
        String query="select * from Stockdetailbefore_f(\'"+date.toString()+"\') where idmatiere in("+matierequantite_vs[0].getIdmatiere();
        for(int i=1;i<matierequantite_vs.length;i++){
            query=query+","+matierequantite_vs[i].getIdmatiere();
        }
        query=query+") order by idmatiere ASC";
        Stockdetailbefore_f[] stockdetailbefore_fs=new Stockdetailbefore_f().readByQueryConvenable(connection,query);
        if(stockdetailbefore_fs==null){ throw new Exception("stock null"); }
        Vector<Matierequantite> vmq=new Vector<Matierequantite>();
        double dtemp=0;
        for(int i=0;i<matierequantite_vs.length;i++){
            for(int j=0;j<stockdetailbefore_fs.length;j++){
                if(stockdetailbefore_fs[j].getIdmatiere()==matierequantite_vs[i].getIdmatiere()){
                    dtemp=stockdetailbefore_fs[j].getQuantiteReste()-(matierequantite_vs[i].getQuantite()*quantitefabr);
                    if(dtemp<0){
                        vmq.add( new Matierequantite(stockdetailbefore_fs[i].getIdmatiere(),stockdetailbefore_fs[i].getNommatiere(),-dtemp) );
                    }
                    j=matierequantite_vs.length;
                }
            }
        }
        return vmq;
    }

    public Vector<Vector> getMatiereManqueAndMatiereSorti(Connection connection,int idcategorie,int idstyle,int idtaille,Date date,double quantitefabr)throws Exception{
        //Matiere a besoin pour la fabrication de cette categorie de style <idstyle> de taille <idtaille>
        Matierequantite_v[] matierequantite_vs=new Matierequantite_v().getAllByIdcategorieByIdstyleByIdtailleOrderByIdmatiere(connection, idcategorie, idstyle, idtaille);
        if(matierequantite_vs==null){ throw new Exception("donnee du quantite matiere pour style id:"+idstyle+" taille id:"+idtaille+" categorie id:"+idcategorie+" null"); }
        String query="select * from Stockdetailbefore_f(\'"+date.toString()+"\') where idmatiere in("+matierequantite_vs[0].getIdmatiere();
        for(int i=1;i<matierequantite_vs.length;i++){
            query=query+","+matierequantite_vs[i].getIdmatiere();
        }
        query=query+") order by idmatiere ASC";
        //stock de ces matiere a besoin pour la fabrication
        Stockdetailbefore_f[] stockdetailbefore_fs=new Stockdetailbefore_f().readByQueryConvenable(connection,query);
        if(stockdetailbefore_fs==null){ throw new Exception("stock null"); }
        Vector<Vector> vector=new Vector<Vector>();
        Vector<Matierequantite> vmq=new Vector<Matierequantite>();
        Vector<Matieresorti> vms=new Vector<Matieresorti>();
        double dtemp=0;
        for(int i=0;i<matierequantite_vs.length;i++){
            for(int j=0;j<stockdetailbefore_fs.length;j++){
                if(stockdetailbefore_fs[j].getIdmatiere()==matierequantite_vs[i].getIdmatiere()){
                    dtemp=stockdetailbefore_fs[j].getQuantiteReste()-(matierequantite_vs[i].getQuantite()*quantitefabr); //stock misy - quantitebesoin*quantite de fabrication
                    if(dtemp<0){
                        vmq.add( new Matierequantite(stockdetailbefore_fs[i].getIdmatiere(),stockdetailbefore_fs[i].getNommatiere(),-dtemp) );
                    }else{
                        System.out.println("-------");
                        System.out.println("besoin:"+matierequantite_vs[i].getQuantite());
                        System.out.println("quantite fab:"+quantitefabr);
                        System.out.println("total:"+matierequantite_vs[i].getQuantite()*quantitefabr);
                        vms.add(new Matieresorti(0,matierequantite_vs[i].getIdmatiere(), matierequantite_vs[i].getQuantite()*quantitefabr , date));
                    }
                    j=matierequantite_vs.length;
                }
            }
        }
        vector.add(vmq);
        vector.add(vms);
        return vector;
    }
    public void fabriquer(Connection connection)throws Exception{
        Vector<Vector> v=getMatiereManqueAndMatiereSorti(connection, this.idcategorie, this.idstyle, this.idtaille, this.datefab, this.quantitefab);
        Vector<Matierequantite> vmq=(Vector<Matierequantite>)v.elementAt(0);
        Vector<Matieresorti> vms=(Vector<Matieresorti>)v.elementAt(1);
        if(vmq.isEmpty()==true){ 
            boolean isToFalse=false;
            if(connection.getAutoCommit()==true){
                connection.setAutoCommit(false);
                isToFalse=true;
            }
            try{
                for(int i=0;i<vms.size();i++){
                    vms.elementAt(i).create(connection,"idmatieresorti");
                }
                this.create(connection,"idfabrication");
                //CREENA NY FABRICATION this.create(connection,"idfabrication");
            }catch(Exception ex){
                connection.rollback();
            }finally{
                if(isToFalse==true){ connection.setAutoCommit(true); }
            }
        }else{
            String exception="Quantite de stock manquante : ";
            for(int i=0;i<vmq.size();i++){
                exception=exception+"<br>-"+vmq.elementAt(i).getNommatiere()+": manque= "+vmq.elementAt(i).getQuantite()+""; 
            }
            exception=exception.substring(0,exception.length()-1);
            throw new Exception(exception);
        }

    }

}
