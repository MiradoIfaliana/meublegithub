<%@page import="entite.*" %>
<section>
    <h2>Salaire </h2>
    <form action="saveSalaire" method="GET">

        <label for="unite">ouvrier: </label><br/>
            <select id="ouvrier" name="idouvrier" required style="margin-bottom: 15px; padding: 8px; width: 50%;">
                <%
                Ouvrier[] ouvriers=(Ouvrier[])request.getAttribute("ouvriers");
                if(ouvriers!=null){
                    for (Ouvrier ouvrier: ouvriers) { %>
                    <option value="<%= ouvrier.getIdouvrier() %>" ><%= ouvrier.getTypeouvrier() %></option>
                    <% }
                }
                %>
            </select>
        <br/>
        <label for="salaire">Salaire: </label><br/>
        <input type="text" id="salaire" name="salaire" style="margin-bottom: 15px; padding: 8px; width: 50%;" />
        <br/>
        <label for="datesalaire">Date salaire: </label><br/>
        <input type="date" id="datesalaire" name="datesalaire" style="margin-bottom: 15px; padding: 8px; width: 50%;" />
        <br/>
        <button type="submit" >Valider</button>
    </form>
    <% if(request.getAttribute("error")!=null){%>
        <p style="color: red;"><%=request.getAttribute("error")%></p>
    <%}%>

</section>