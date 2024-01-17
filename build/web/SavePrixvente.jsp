<%@page import="entite.*" %>
<section>
    <%
        Categorie[] categories=(Categorie[]) request.getAttribute("categories");
        Taille[] tailles = (Taille[]) request.getAttribute("tailles");
        Style[] styles = (Style[]) request.getAttribute("styles");
    %>
    <h2>Prix de vente : </h2>
        <form action="savePrixvente" method="GET">
            <% if(request.getAttribute("error")!=null){%>
                <p style="color: red;"><%=request.getAttribute("error")%></p>
            <%}%>
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
            </label><br/>
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
            <label for="style">style:<br/>
                <select id="style" name="idstyle" required style="margin-bottom: 15px; padding: 8px; width: 50%;">
                    <%
                    if(styles!=null){
                        for (Style style: styles) { %>
                        <option value="<%= style.getIdstyle() %>" ><%= style.getNomstyle() %></option>
                        <% }
                    }
                    %>
                </select>
            </label>
            <br/>
                <label for="prixvente">Prix vente : </label><br/>
                <input name="prixvente" id="prixvente" type="text" style="margin-bottom: 15px; padding: 8px; width: 50%;">
            <br/>
                <label for="dateprix">Date Prix : </label><br/>
                <input name="dateprix" id="dateprix" type="date" style="margin-bottom: 15px; padding: 8px; width: 50%;">
            <br/>
            <button type="submit">Valider</button>
        </form>
</section>
