<%@page import="entite.*" %>
<section>
    <%
        Categorie[] categories=(Categorie[]) request.getAttribute("categories");
        Ouvrier[] ouvriers = (Ouvrier[]) request.getAttribute("ouvriers");
    %>
    <h2>Ouvrier besoin : </h2>
        <form action="saveOuvrierBesoin" method="GET">
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
            <label for="unite">ouvrier: </label><br/>
            <select id="ouvrier" name="idouvrier" required style="margin-bottom: 15px; padding: 8px; width: 50%;">
                <%
                if(ouvriers!=null){
                    for (Ouvrier ouvrier: ouvriers) { %>
                    <option value="<%= ouvrier.getIdouvrier() %>" ><%= ouvrier.getTypeouvrier() %></option>
                    <% }
                }
                %>
            </select>
        <br/>
            <button type="submit">Valider</button>
        </form>
</section>
