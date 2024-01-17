<%@page import="entite.*" %>
<section>
    <%
        Taille[] tailles = (Taille[]) request.getAttribute("tailles");
        Categorie[] categories=(Categorie[]) request.getAttribute("categories");
        Stylematiere2_v[] stylematiere2_vs = (Stylematiere2_v[]) request.getAttribute("stylematiere2_vs");
        String stylenom="";
        if(stylematiere2_vs!=null){ if(stylematiere2_vs.length!=0){ stylenom=stylematiere2_vs[0].getNomstyle().toUpperCase(); } }
    %>
    <h2>Quantite pour style: "<%=stylenom%>" <span style="color: black;font-size:50%;">(mettre Quantitée 0 ou rien pour matiere non inclu dans le categorie)</span></h2>
        <form action="saveQuantiteOfTailleMatiere" method="GET">
            <% if(request.getAttribute("error")!=null){%>
                <p style="color: red;"><%=request.getAttribute("error")%></p>
            <%}%>
            <label for="taille">taille:<br/>
                <select id="taille" name="idtaille" required style="margin-bottom: 15px; padding: 8px; width: 50%;">
                    <%
                    if(tailles!=null){
                        for (Taille taille: tailles) { %>
                        <option value="<%= taille.getIdtaille() %>" ><%= taille.getNomtaille() %></option>
                        <% }
                    }
                    %>
                </select>
            </label><br/>
            <label for="categorie">categorie:<br/>
                <select id="categorie" name="idcategorie" required style="margin-bottom: 15px; padding: 8px; width: 50%;">
                    <%
                    if(categories!=null){
                        for (Categorie categorie: categories) { %>
                        <option value="<%= categorie.getIdcategorie() %>" ><%= categorie.getNomcategorie() %></option>
                        <% }
                    }
                    %>
                </select>
            </label>
             
            
            <input name="idstyle" value="<%= request.getAttribute("idstyle")%>" type="hidden">
            <%
              if (stylematiere2_vs != null) { 
                int i = 0;
                for (Stylematiere2_v stylematiere2_v : stylematiere2_vs) { %>
                
                    <br/>
                    <label for="nomCategorie">Quantite: <%= stylematiere2_v.getNommatiere()%> </label>
                    <input name="idmatierestyle<%= i%>" value="<%= stylematiere2_v.getIdmatierestyle()%>" type="hidden">
                    <br/>
                    <input type="text" id="nomCategorie" name="quantite<%= i%>" style="margin-bottom: 15px; padding: 8px; width: 50%;"/>
                    
                        <% 
                            i ++;
                    }
                }  
            %>
            <br/>
            <button type="submit">Valider</button>
        </form>
</section>
