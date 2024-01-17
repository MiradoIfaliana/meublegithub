<%@page import="entite.*" %>
<section>
    <h2>Ajouter matiere</h2>
    <form action="saveMatiere" method="GET">
        <label for="nomMatiere">Nom Matiere: </label><br/>
        <input type="text" id="nomMatiere" name="nomMatiere" style="margin-bottom: 15px; padding: 8px; width: 50%;" />
        <br/>
        <label for="unite">Unite: </label><br/>
            <select id="unite" name="idunite" required style="margin-bottom: 15px; padding: 8px; width: 50%;">
                <%
                Unite[] unites=(Unite[])request.getAttribute("unites");
                if(unites!=null){
                    for (Unite unite: unites) { %>
                    <option value="<%= unite.getIdunite() %>" ><%= unite.getNomunite() %></option>
                    <% }
                }
                %>
            </select>
        <br/>
        <button type="submit" >Valider</button>
    </form>
    <% if(request.getAttribute("error")!=null){%>
        <p style="color: red;"><%=request.getAttribute("error")%></p>
    <%}%>

</section>