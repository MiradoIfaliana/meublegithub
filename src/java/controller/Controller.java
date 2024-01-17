package controller;
import annotation.Scope;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import entite.*;
import java.sql.*;
import connect.*;
import java.time.LocalDate;
import java.util.Vector;
public class Controller {

    @Scope(name="saveCategorie")
    public String saveCategorie(HttpServletRequest request)throws Exception{
        Connection connection=null;
        String error="";
        try {
            connection = new Connect().getConnectionPsql();
            
            Categorie categorie = new Categorie();
            String nomCategorie = request.getParameter("nomCategorie");
            categorie.setNomcategorie(nomCategorie);
            categorie.verifecreate(connection);    
        }
        catch(Exception e) {
            e.printStackTrace();
            error=e.getMessage();
        }finally {
            if(connection != null) {
                try {
                    connection.close();
                }
                catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        request.setAttribute("error",error);
        return "Categorie.jsp";
    }
    //saveUnite
    @Scope(name="saveUnite")
    public String saveUnite(HttpServletRequest request)throws Exception{
        Connection connection=null;
        String error="";
        try {
            connection = new Connect().getConnectionPsql();
            
            Unite unite = new Unite();
            String nomunite = request.getParameter("nomunite");
            String unitee = request.getParameter("unite");
            unite.setNomunite(nomunite);
            unite.setUnite(unitee);
            unite.verifecreate(connection);    
        }
        catch(Exception e) {
            e.printStackTrace();
            error=e.getMessage();
        }finally {
            if(connection != null) {
                try {
                    connection.close();
                }
                catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        request.setAttribute("error",error); 
        return "Unite.jsp";
    }
    
    @Scope(name="toSaveMatiere")
    public String toSaveMatiere(HttpServletRequest request)throws Exception{
        Connection connection = null;
        Unite[] unites=null;
        String error="";
        try {
            connection = new Connect().getConnectionPsql();
            unites=new Unite().read(connection);
        }
        catch(Exception e) {
            e.printStackTrace();
            error=e.getMessage();
        }
        finally {
            if(connection != null) {
                try {
                    connection.close();
                }
                catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        request.setAttribute("unites", unites);
        request.setAttribute("error",error);
        return "Matiere.jsp";
    }

    @Scope(name="saveMatiere")
    public String saveMatiere(HttpServletRequest request)throws Exception{
        Connection connection=null;
        String error="";
        try {
            connection = new Connect().getConnectionPsql();
            
            Matiere matiere = new Matiere();
            String nomMatiere = request.getParameter("nomMatiere");
            String idunite=request.getParameter("idunite");
            matiere.setNommatiere(nomMatiere);
            matiere.setIdunite(idunite);
            matiere.verifecreateWithUnite(connection);    
        }
        catch(Exception e) {
            e.printStackTrace();
            error=e.getMessage();
        }finally {
            if(connection != null) {
                try {
                    connection.close();
                }
                catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        request.setAttribute("error",error);
        return "Matiere.jsp";
    }

    @Scope(name="saveStyle")
    public String saveStyle(HttpServletRequest request)throws Exception{
        Connection connection=null;
        String error="";
        try {
            connection = new Connect().getConnectionPsql();
            
            Style style = new Style();
            String nomStyle = request.getParameter("nomStyle");
            style.setNomstyle(nomStyle);
            style.verifecreate(connection);    
        }
        catch(Exception e) {
            e.printStackTrace();
            error=e.getMessage();
        }finally {
            if(connection != null) {
                try {
                    connection.close();
                }
                catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        request.setAttribute("error",error);
        return "Style.jsp";
    }

    
    @Scope(name="matieresOfStyleData")
    public String matieresOfStyleData(HttpServletRequest request)throws Exception{
        Connection connection = null;
        Style[] styles=null;
        Stylematiere_v[] stylematieres=null;
        String error="";
        try {
            connection = new Connect().getConnectionPsql();
            
            //styles
            styles = new Style().read(connection);
            //style matieres a affiché
            String idstyle=request.getParameter("idstyle");
            Style style=new Style();
            style.setIdstyle(idstyle);
            stylematieres=style.getAllMyStylematiere(connection);
            
        }catch(Exception ex){
            ex.printStackTrace();
            error=ex.getMessage();
        }finally {
            if(connection != null) {
                try {
                    connection.close();
                }
                catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
                    //envoyer vers le jsp
        request.setAttribute("styles", styles);
        request.setAttribute("stylematieres",stylematieres);
        request.setAttribute("error",error);
        return "VoirMatiere.jsp";
    }

    @Scope(name="saveTaille")
    public String saveTaille(HttpServletRequest request)throws Exception{
        Connection connection=null;
        String error="";
        try {
            connection = new Connect().getConnectionPsql();
            
            Taille taille = new Taille();
            String nomtaille = request.getParameter("nomtaille");
            taille.setNomtaille(nomtaille);
            taille.verifecreate(connection);    
        }
        catch(Exception e) {
            e.printStackTrace();
            error=e.getMessage();
        }finally {
            if(connection != null) {
                try {
                    connection.close();
                }
                catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        request.setAttribute("error",error);
        return "Taille.jsp";
    }
 
    @Scope(name="toMatiereQuantiteForm")
    public String toMatiereQuantiteForm(HttpServletRequest request)throws Exception{
        Stylematiere2_v[] stylematiere2_vs = null;
        String idStyle = request.getParameter("idstyle");
        Taille[] tailles = null;
        Connection connection=null;
        String error="";
        Style style = new Style();
        Categorie[] categories=null;
        try {
            connection = new Connect().getConnectionPsql();
            style.setIdstyle(idStyle);
            
            stylematiere2_vs = style.getAllMyStylematiere2(connection);
            
            Taille taille = new Taille();
            tailles = taille.read(connection);
            categories=new Categorie().read(connection);
        }
        catch(Exception e) {
            e.printStackTrace();
            error=e.getMessage();
        }finally {
            if(connection != null) {
                try {
                    connection.close();
                }
                catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        request.setAttribute("error",error);
        request.setAttribute("stylematiere2_vs", stylematiere2_vs);
        request.setAttribute("tailles", tailles);
        request.setAttribute("idstyle", style.getIdstyle());
        request.setAttribute("categories",categories);
        return "MatiereQuantiteForm.jsp";
    }


    @Scope(name="toSaveMatiereStyle")
    public String toSaveMatiereStyle(HttpServletRequest request)throws Exception{
        Connection connection = null;
        Style[] styles=null;
        Matiere[] matieres=null;
        String error="";
        try {
            connection = new Connect().getConnectionPsql();
            styles = new Style().read(connection);
            matieres = new Matiere().read(connection);
        }
        catch(Exception e) {
            e.printStackTrace();
            error=e.getMessage();

        }
        finally {
            if(connection != null) {
                try {
                    connection.close();
                }
                catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        request.setAttribute("styles", styles);
        request.setAttribute("matieres", matieres);
        request.setAttribute("error",error);
        return "MatiereStyle.jsp";
    }

    @Scope(name="saveMatiereStyle")
    public String saveMatiereStyle(HttpServletRequest request)throws Exception{
        Connection connection = null;
        String error="";
        Style[] styles=null;
        Matiere[] matieres=null;
        try {
            connection = new Connect().getConnectionPsql();
            styles = new Style().read(connection);
            matieres = new Matiere().read(connection);
            Matierestyle matiereStyle = new Matierestyle();
            
            Vector<String> Idmatieres = new Vector<>();
            String param;
            for (int i=0; i<matieres.length; i++) {
                param = request.getParameter("idmatiere"+i);
                if (param != null) {
                    if (param.compareTo("") != 0) {
                        Idmatieres.add(param);
                    }
                }
            }
            String[] idmat = null;
            if (Idmatieres.size() > 0) {
                int len = Idmatieres.size();
                idmat = new String[len];
                for (int i = 0; i < len; i++) {
                    idmat[i] = Idmatieres.get(i);
                }
            }
            
            String idstyle = request.getParameter("Idstyle");
            
            matiereStyle.insertAll(connection, idmat, idstyle);
        }
        catch(Exception e) {
            e.printStackTrace();
            error=e.getMessage();
        }
        finally {
            try {
                if (connection != null) {
                connection.close();
                }
            }
            catch(Exception ex) {
                ex.printStackTrace();
            }
        }
        request.setAttribute("styles", styles);
        request.setAttribute("matieres", matieres);
        request.setAttribute("error",error);
        return "MatiereStyle.jsp";
    }

    @Scope(name="toVoirMatiereOfStyle")
    public String toVoirMatiereOfStyle(HttpServletRequest request)throws Exception{
        Connection connection = null;
        Style[] styles=null;
        String error="";
        try {
            connection = new Connect().getConnectionPsql();
            styles = new Style().read(connection);
        }
        catch(Exception e) {
            e.printStackTrace();
            error=e.getMessage();
        }
        finally {
            if(connection != null) {
                try {
                    connection.close();
                }
                catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        request.setAttribute("styles", styles);
        request.setAttribute("error",error);
        return "VoirMatiere.jsp";
    }
    @Scope(name="tosaveTailleMatiere")
    public String tosaveTailleMatiere(HttpServletRequest request)throws Exception{
        Connection connection = null;
        Style[] styles=null;
        String error="";
        try {
            connection = new Connect().getConnectionPsql();
            styles = new Style().read(connection);
        }
        catch(Exception e) {
            e.printStackTrace();
            error=e.getMessage();
        }
        finally {
            if(connection != null) {
                try {
                    connection.close();
                }
                catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        request.setAttribute("styles", styles);
        request.setAttribute("error",error);
        return "StyleTailleDetail.jsp";
    }

    @Scope(name="saveQuantiteOfTailleMatiere")
    public String saveQuantiteOfTailleMatiere(HttpServletRequest request)throws Exception{
        Stylematiere2_v[] stylematiere2_vs = null;
            
        String idstyle = request.getParameter("idstyle");
        String idtaille = request.getParameter("idtaille");
        String idcategorie = request.getParameter("idcategorie");
        Taille[] tailles = null;
        Categorie[] categories=null;
        
        Connection connection=null;
        String error="";
        try {
            connection = new Connect().getConnectionPsql();
            Style style = new Style();
            style.setIdstyle(idstyle);
            
            stylematiere2_vs = style.getAllMyStylematiere2(connection);
            int len = stylematiere2_vs.length;
            String[] idmatierestyles = new String[len];
            String[] quantites = new String[len];
            for (int i = 0; i < len; i++) {
                idmatierestyles[i] = request.getParameter("idmatierestyle"+i);
                quantites[i] = request.getParameter("quantite"+i);
            }
            
            Taille taille = new Taille();
            tailles = taille.read(connection);
            categories=new Categorie().read(connection);
            
            Quantitematiere quantitematiere = new Quantitematiere();
            quantitematiere.insertAll(connection, idmatierestyles, quantites, idtaille,idcategorie);
            //insertAll(Connection connection, String[] idstylematieres, String[] quantites, String idtaille,String idcategorie)
        }
        catch(Exception e) {
            e.printStackTrace();
            error=e.getMessage();
        }finally {
            if(connection != null) {
                try {
                    connection.close();
                }
                catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        request.setAttribute("error",error);
        request.setAttribute("stylematiere2_vs", stylematiere2_vs);
        request.setAttribute("tailles", tailles);
        request.setAttribute("idstyle", idstyle);
        request.setAttribute("categories",categories);
        return "MatiereQuantiteForm.jsp";
    }

    @Scope(name="matiereQuantiteInfo")
    public String matiereQuantiteInfo(HttpServletRequest request)throws Exception{            
        Connection connection = null;
        Matierequantite_v[] matierequantite_vs = null;
        Matiere[] matieres=null;
        String error="";
        try {
            connection = new Connect().getConnectionPsql();
            
            Matiere matiere = new Matiere();
            if (request.getParameter("idmatiere") != null) {
                
            matiere.setIdmatiere(request.getParameter("idmatiere"));
                        
            matierequantite_vs = new Matierequantite_v()
                    .getAllByIdmatiere(connection, matiere.getIdmatiere());
            }
            
            matieres=new Matiere().read(connection);
        }
        catch(Exception e) {
            e.printStackTrace();
            error=e.getMessage();
        }
        finally {
            if(connection != null) {
                try {
                    connection.close();
                }
                catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        request.setAttribute("matierequantite_vs", matierequantite_vs);
        request.setAttribute("matieres", matieres);
        request.setAttribute("error",error);
        return "DetailMatiereQuantite.jsp";
    }

    @Scope(name="getmeublebyprix")
    public String getmeublebyprix(HttpServletRequest request)throws Exception{
         Prixcategorie_v[] prixcategorie_vs = null;
        Connection connection=null;
        String error="";
        try {
            connection = new Connect().getConnectionPsql();
            prixcategorie_vs=new Prixcategorie_v().getAllByPrixMinMax(connection, request.getParameter("prixmin"), request.getParameter("prixmax"));
            request.setAttribute("prixcategorie_vs",prixcategorie_vs);
        }
        catch(Exception e) {
            e.printStackTrace();
            error=e.getMessage();
        }finally {
            if(connection != null) {
                try {
                    connection.close();
                }
                catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        request.setAttribute("error",error);
        return "voirmeublebyprix.jsp";
        
    }
    @Scope(name="saveprixmatiere")
    public String saveprixmatiere(HttpServletRequest request)throws Exception{
        Connection connection=null;
        String error="";
        try {
            connection = new Connect().getConnectionPsql();
            Matiere[] matieres=new Matiere().read(connection);
            request.setAttribute("matieres",matieres);
            //(String idmatiereprix,String idmatiere,String prix,String dateprix)
            String date=request.getParameter("dateprix");
            if(date==null){
                date=Date.valueOf(LocalDate.now()).toString();
            }
            Matiereprix matiereprix=new Matiereprix("0",request.getParameter("idmatiere"),request.getParameter("prix"),date);
            matiereprix.create(connection, "idmatiereprix");
        }
        catch(Exception e) {
            e.printStackTrace();
            error=e.getMessage();
        }finally {
            if(connection != null) {
                try {
                    connection.close();
                }
                catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        request.setAttribute("error",error);
        return "Formprix.jsp";  
    }
    @Scope(name="toFormprix")
    public String toFormprix(HttpServletRequest request)throws Exception{
        Connection connection=null;
        String error="";
        try {
            connection = new Connect().getConnectionPsql();
            Matiere[] matieres=new Matiere().read(connection);
            request.setAttribute("matieres",matieres);
        }
        catch(Exception e) {
            e.printStackTrace();
            error=e.getMessage();
        }finally {
            if(connection != null) {
                try {
                    connection.close();
                }
                catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        request.setAttribute("error",error);
        return "Formprix.jsp";    
    }

    @Scope(name="toEntrerstock")
    public String toEntreestock(HttpServletRequest request)throws Exception{
        Connection connection=null;
        String error="";
        try {
            connection = new Connect().getConnectionPsql();
            Matiere[] matieres=new Matiere().read(connection);
            request.setAttribute("matieres",matieres);
        }
        catch(Exception e) {
            e.printStackTrace();
            error=e.getMessage();
        }finally {
            if(connection != null) {
                try {
                    connection.close();
                }
                catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        request.setAttribute("error",error);
        return "Entrerstock.jsp";    
    }

    @Scope(name="entrerstock")
    public String entreestock(HttpServletRequest request)throws Exception{
        Connection connection=null;
        String error="";
        try {
            connection = new Connect().getConnectionPsql();
            Matiere[] matieres=new Matiere().read(connection);
            request.setAttribute("matieres",matieres);

            String idmatiere=request.getParameter("idmatiere");
            String quantite=request.getParameter("quantite");
            String dateentre=request.getParameter("dateentre");
            Matiereentre matiereentre=new Matiereentre("0",idmatiere,quantite,dateentre);
            matiereentre.create(connection,"idmatiereentre");

        }
        catch(Exception e) {
            e.printStackTrace();
            error=e.getMessage();
        }finally {
            if(connection != null) {
                try {
                    connection.close();
                }
                catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        request.setAttribute("error",error);
        return "Entrerstock.jsp";    
    }

    @Scope(name="toEtatDeStock")
    public String toEtatDeStock(HttpServletRequest request)throws Exception{
        Connection connection=null;
        String error="";
        try {
            connection = new Connect().getConnectionPsql();
            Matiere[] matieres=new Matiere().read(connection);
            request.setAttribute("matieres",matieres);
        }
        catch(Exception e) {
            e.printStackTrace();
            error=e.getMessage();
        }finally {
            if(connection != null) {
                try {
                    connection.close();
                }
                catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        request.setAttribute("error",error);
        return "Etatstock.jsp";    
    }
    @Scope(name="etatDeStock")
    public String etatDeStock(HttpServletRequest request)throws Exception{
        Connection connection=null;
        String error="";
        try {
            connection = new Connect().getConnectionPsql();
            Matiere[] matieres=new Matiere().read(connection);
            request.setAttribute("matieres",matieres);

            String idmatiere=request.getParameter("idmatiere");
            String date=request.getParameter("date");
            Matiere matiere=new Matiere();
            matiere.setIdmatiere(idmatiere);
            Stockdetailbefore_f stockdetailbefore_f=matiere.getStockdetailbefore_fByDate(connection, date);
            request.setAttribute("stockdetailbefore_f",stockdetailbefore_f);
        }
        catch(Exception e) {
            e.printStackTrace();
            error=e.getMessage();
        }finally {
            if(connection != null) {
                try {
                    connection.close();
                }
                catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        request.setAttribute("error",error);
        return "Etatstock.jsp";    
    }

    @Scope(name="toFabriquer")
    public String toFabriquer(HttpServletRequest request)throws Exception{
        Connection connection=null;
        String error="";
        try {
            connection = new Connect().getConnectionPsql();
            Categorie[] categories=new Categorie().read(connection);
            Taille[] tailles=new Taille().read(connection);
            Style[] styles=new Style().read(connection);
            request.setAttribute("categories",categories);
            request.setAttribute("tailles",tailles);
            request.setAttribute("styles",styles);
        }
        catch(Exception e) {
            e.printStackTrace();
            error=e.getMessage();
        }finally {
            if(connection != null) {
                try {
                    connection.close();
                }
                catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        request.setAttribute("error",error);
        return "Fabriquer.jsp";    
    }

    @Scope(name="fabriquer")
    public String fabriquer(HttpServletRequest request)throws Exception{
        Connection connection=null;
        String error="";
        try {
            connection = new Connect().getConnectionPsql();
            Categorie[] categories=new Categorie().read(connection);
            Taille[] tailles=new Taille().read(connection);
            Style[] styles=new Style().read(connection);
            request.setAttribute("categories",categories);
            request.setAttribute("tailles",tailles);
            request.setAttribute("styles",styles);
            
            String idcategorie=request.getParameter("idcategorie");
            String idtaille=request.getParameter("idtaille");
            String idstyle=request.getParameter("idstyle");
            String quantite=request.getParameter("quantite");
            String datefab=request.getParameter("datefab");
            Fabrication fabrication=new Fabrication("0",idcategorie,quantite,datefab,idtaille,idstyle);
            fabrication.fabriquer(connection);
        }
        catch(Exception e) {
            e.printStackTrace();
            error=e.getMessage();
        }finally {
            if(connection != null) {
                try {
                    connection.close();
                }
                catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        request.setAttribute("error",error);
        return "Fabriquer.jsp";    
    }
    @Scope(name="saveOuvrier")
    public String saveOuvrier(HttpServletRequest request)throws Exception{
        Connection connection=null;
        String error="";
        try {
            connection = new Connect().getConnectionPsql();
            String typeouvrier=request.getParameter("typeouvrier");
            Ouvrier ouvrier=new Ouvrier("0",typeouvrier);
            ouvrier.verifecreate(connection);
        }
        catch(Exception e) {
            e.printStackTrace();
            error=e.getMessage();
        }finally {
            if(connection != null) {
                try {
                    connection.close();
                }
                catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        request.setAttribute("error",error);
        return "SaveOuvrier.jsp";
    }
    @Scope(name="toSaveSalaire")
    public String toSaveSalaire(HttpServletRequest request)throws Exception{
        Connection connection=null;
        String error="";
        try {
            connection = new Connect().getConnectionPsql();
            Ouvrier[] ouvriers=new Ouvrier().read(connection);
            request.setAttribute("ouvriers",ouvriers);
        }
        catch(Exception e) {
            e.printStackTrace();
            error=e.getMessage();
        }finally {
            if(connection != null) {
                try {
                    connection.close();
                }
                catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        request.setAttribute("error",error);
        return "SaveSalaire.jsp";
    }
    @Scope(name="saveSalaire")
    public String saveSalaire(HttpServletRequest request)throws Exception{
        Connection connection=null;
        String error="";
        try {
            connection = new Connect().getConnectionPsql();
            Ouvrier[] ouvriers=new Ouvrier().read(connection);
            request.setAttribute("ouvriers",ouvriers);
            String idouvrier=request.getParameter("idouvrier");
            String salaires=request.getParameter("salaire");
            String datesalaire=request.getParameter("datesalaire");
            Salaire salaire=new Salaire("0", idouvrier, salaires, datesalaire);
            salaire.create(connection, "idsalaire");
        }
        catch(Exception e) {
            e.printStackTrace();
            error=e.getMessage();
        }finally {
            if(connection != null) {
                try {
                    connection.close();
                }
                catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        request.setAttribute("error",error);
        return "SaveSalaire.jsp";
    }
    @Scope(name="toSaveDureeOuvrier")
    public String toSaveDureeOuvrier(HttpServletRequest request)throws Exception{
        Connection connection=null;
        String error="";
        try {
            connection = new Connect().getConnectionPsql();
            Style[] styles=new Style().read(connection);
            request.setAttribute("styles",styles);
        }
        catch(Exception e) {
            e.printStackTrace();
            error=e.getMessage();
        }finally {
            if(connection != null) {
                try {
                    connection.close();
                }
                catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        request.setAttribute("error",error);
        return "SaveDureeOuvrier.jsp";
    }
    @Scope(name="saveDureeOuvrier")
    public String saveDureeOuvrier(HttpServletRequest request)throws Exception{
        Connection connection=null;
        String error="";
        try {
            connection = new Connect().getConnectionPsql();
            Style[] styles=new Style().read(connection);
            request.setAttribute("styles",styles);
            String idstyle=request.getParameter("idstyle");
            String duree=request.getParameter("duree");
           Dureestyle dureestyle=new Dureestyle("0", idstyle, duree);
           dureestyle.setDuree(dureestyle.getDuree()*3600.0);
           dureestyle.create(connection, "iddureestyle");
        }
        catch(Exception e) {
            e.printStackTrace();
            error=e.getMessage();
        }finally {
            if(connection != null) {
                try {
                    connection.close();
                }
                catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        request.setAttribute("error",error);
        return "SaveDureeOuvrier.jsp";
    }
    @Scope(name="toSavePrixvente")
    public String toSavePrixvente(HttpServletRequest request)throws Exception{
        Connection connection=null;
        String error="";
        try {
            connection = new Connect().getConnectionPsql();
            Categorie[] categories=new Categorie().read(connection);
            Taille[] tailles=new Taille().read(connection);
            Style[] styles=new Style().read(connection);
            request.setAttribute("categories",categories);
            request.setAttribute("tailles",tailles);
            request.setAttribute("styles",styles);
        }
        catch(Exception e) {
            e.printStackTrace();
            error=e.getMessage();
        }finally {
            if(connection != null) {
                try {
                    connection.close();
                }
                catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        request.setAttribute("error",error);
        return "SavePrixvente.jsp";
    }
    @Scope(name="savePrixvente")
    public String savePrixvente(HttpServletRequest request)throws Exception{
        Connection connection=null;
        String error="";
        try {
            connection = new Connect().getConnectionPsql();
            Categorie[] categories=new Categorie().read(connection);
            Taille[] tailles=new Taille().read(connection);
            Style[] styles=new Style().read(connection);
            request.setAttribute("categories",categories);
            request.setAttribute("tailles",tailles);
            request.setAttribute("styles",styles);
            String idcategorie=request.getParameter("idcategorie");
            String idtaille=request.getParameter("idtaille");
            String idstyle=request.getParameter("idstyle");
            String prixventes=request.getParameter("prixvente");
            String dateprix=request.getParameter("dateprix");
           Prixvente prixvente=new Prixvente(prixventes, idcategorie, idstyle, idtaille, prixventes, dateprix);
           prixvente.create(connection, "idprixvente");
        }
        catch(Exception e) {
            e.printStackTrace();
            error=e.getMessage();
        }finally {
            if(connection != null) {
                try {
                    connection.close();
                }
                catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        request.setAttribute("error",error);
        return "SavePrixvente.jsp";
    }
    @Scope(name="toSaveOuvrierBesoin")
    public String toSaveOuvrierBesoin(HttpServletRequest request)throws Exception{
        Connection connection=null;
        String error="";
        try {
            connection = new Connect().getConnectionPsql();
            Categorie[] categories=new Categorie().read(connection);
            Ouvrier[] ouvriers=new Ouvrier().read(connection);
            request.setAttribute("categories",categories);
            request.setAttribute("ouvriers",ouvriers);
        }
        catch(Exception e) {
            e.printStackTrace();
            error=e.getMessage();
        }finally {
            if(connection != null) {
                try {
                    connection.close();
                }
                catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        request.setAttribute("error",error);
        return "SaveOuvrierBesoin";
    }
    @Scope(name="saveOuvrierBesoin")
    public String saveOuvrierBesoin(HttpServletRequest request)throws Exception{
        Connection connection=null;
        String error="";
        try {
            connection = new Connect().getConnectionPsql();
            Categorie[] categories=new Categorie().read(connection);
            Ouvrier[] ouvriers=new Ouvrier().read(connection);
            request.setAttribute("categories",categories);
            request.setAttribute("ouvriers",ouvriers);
            String idcategorie=request.getParameter("idcategorie");
            String idouvrier=request.getParameter("idouvrier");
            Ouvrierbesoin ouvrierbesoin=new Ouvrierbesoin("0", idcategorie, idouvrier);
            ouvrierbesoin.verifeInsert(connection);  
        }
        catch(Exception e) {
            e.printStackTrace();
            error=e.getMessage();
        }finally {
            if(connection != null) {
                try {
                    connection.close();
                }
                catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        request.setAttribute("error",error);
        return "SaveOuvrierBesoin";
    }
    @Scope(name="toSaveNbOuvrier")
    public String toSaveNbOuvrier(HttpServletRequest request)throws Exception{
        Connection connection=null;
        String error="";
        try {
            connection = new Connect().getConnectionPsql();
            Categorie[] categories=new Categorie().read(connection);
            Taille[] tailles=new Taille().read(connection);
            request.setAttribute("categories",categories);
            request.setAttribute("tailles",tailles);
        }
        catch(Exception e) {
            e.printStackTrace();
            error=e.getMessage();
        }finally {
            if(connection != null) {
                try {
                    connection.close();
                }
                catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        request.setAttribute("error",error);
        return "SaveNbOuvrier.jsp";
    }
    @Scope(name="saveNbOuvrier")
    public String saveNbOuvrier(HttpServletRequest request)throws Exception{
        Connection connection=null;
        String error="";
        try {
            connection = new Connect().getConnectionPsql();
            Categorie[] categories=new Categorie().read(connection);
            Taille[] tailles=new Taille().read(connection);
            request.setAttribute("categories",categories);
            request.setAttribute("tailles",tailles);
            String idcategorie=request.getParameter("idcategorie");
            String idtaille=request.getParameter("idtaille");
            String nombre=request.getParameter("nombre");
            Nbouvrier nbouvrier=new Nbouvrier("0", idcategorie, idtaille, nombre);
            nbouvrier.create(connection, "idnbouvrier");
        }
        catch(Exception e) {
            e.printStackTrace();
            error=e.getMessage();
        }finally {
            if(connection != null) {
                try {
                    connection.close();
                }
                catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        request.setAttribute("error",error);
        return "SaveNbOuvrier.jsp";
    }
    @Scope(name="voirCategorieBenefice")
    public String voirCategorieBenefice(HttpServletRequest request)throws Exception{
        Connection connection=null;
        String error="";
        try {
            connection = new Connect().getConnectionPsql();
            String prix1=request.getParameter("prix1");
            String prix2=request.getParameter("prix2");
            Beneficedetail_v beneficedetail_v=new Beneficedetail_v();
            Beneficedetail_v[] beneficedetail_vs=beneficedetail_v.getByPrixMinByPrixMax(connection, prix1, prix2);
            request.setAttribute("beneficedetail_vs",beneficedetail_vs);
        }
        catch(Exception e) {
            e.printStackTrace();
            error=e.getMessage();
        }finally {
            if(connection != null) {
                try {
                    connection.close();
                }
                catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        request.setAttribute("error",error);
        return "CategorieBenefice.jsp";
    }
    
}