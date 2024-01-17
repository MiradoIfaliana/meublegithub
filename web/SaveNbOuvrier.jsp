<%@page import="entite.*" %>
<section>
    <%
        Categorie[] categories=(Categorie[]) request.getAttribute("categories");
        Taille[] tailles = (Taille[]) request.getAttribute("tailles");
    %>
    <h2>Nombre ouvrier : </h2>
        <form action="saveNbOuvrier" method="GET">
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
                <label for="nombre">Nombre : </label><br/>
                <input name="nombre" id="nombre" type="text" style="margin-bottom: 15px; padding: 8px; width: 50%;">
            <br/>
            <button type="submit">Valider</button>
        </form>
</section>
