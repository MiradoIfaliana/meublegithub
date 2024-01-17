/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entite;
/**
 *
 * @author Mirado
 */
public class Matierequantite  {
    private int idmatiere;
    private String nommatiere;
    private double quantite;
    public Matierequantite(){}
    public Matierequantite(int idmatiere,String nommatiere,double quantite)throws Exception{
        setIdmatiere(idmatiere);
        setNommatiere(nommatiere);
        setQuantite(quantite);
    }

    public int getIdmatiere(){
        return this.idmatiere;
    }
    public void setIdmatiere(int idmatiere){
        this.idmatiere=idmatiere;
    }
    public void setIdmatiere(String idmatiere) throws Exception {
        try {
            int id = Integer.parseInt(idmatiere);
            this.setIdmatiere(id);
        }
        catch(Exception e) {
            throw e;
        }
    }
    public String getNommatiere(){
        return this.nommatiere;
    }
    public void setNommatiere(String nommatiere){
        this.nommatiere=nommatiere;
    }
    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
    } 

 
       
}
