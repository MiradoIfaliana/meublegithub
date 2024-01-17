/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entite;

import generalise.Motherobj;
import java.sql.Connection;

/**
 *
 * @author tsoa
 */
public class Taille extends Motherobj<Taille>{
    private int idtaille;
    private String nomtaille;
    
    public Taille() {}
    public Taille(int idtaille, String nomtaille) {
        setIdtaille(idtaille);
        setNomtaille(nomtaille);
    }

    public int getIdtaille() {
        return idtaille;
    }

    public void setIdtaille(int idtaille) {
        this.idtaille = idtaille;
    }
    public void setIdtaille(String idtaille) {
        try{ Integer.valueOf(idtaille);
        }catch(Exception ex){ new Exception("idtaille :"+idtaille+" invalide"); }
        setIdtaille(Integer.valueOf(idtaille));
    }
    public String getNomtaille() {
        return nomtaille;
    }

    public void setNomtaille(String taille) {
        this.nomtaille = taille;
    }
    
    public void verifecreate(Connection connection)throws Exception{
        Taille taille = this.readOneByQueryConvenable(connection,"select * from taille where nomtaille  ILIKE \'"+this.nomtaille+"\'");
        if(taille!=null) { 
            throw new Exception("taille "+this.nomtaille.toUpperCase()+" existe deja"); 
        }
        this.create(connection, "idtaille");
    }
}
