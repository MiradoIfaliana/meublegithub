<%@page import="entite.*" %>
<section>
            <% 
                Matiere[] matieres = (Matiere[]) request.getAttribute("matieres");
            %>
        <h2>Voir meuble entre Prix min et Prix Max</h2>
        <form action="saveprixmatiere" method="GET" >
            <label for="matiere">matiere:
                <select id="matiere" name="idmatiere" required style="margin-bottom: 15px; padding: 8px; width: 50%;">
                    <%
                    if(matieres!=null){
                        for (Matiere matiere: matieres) { %>
                        <option value="<%= matiere.getIdmatiere() %>" ><%= matiere.getNommatiere() %></option>
                        <% }
                    }
                    %>
                </select>
            </label>
            <br/>
            <label for="prix">Prix : </label><br/>
            <input type="text" id="prix" name="prix" style="margin-bottom: 15px; padding: 8px; width: 50%;"/>
            <br/>
            <label for="dateprix">Date du prix : </label><br/>
            <input type="date" id="dateprix" name="dateprix" style="margin-bottom: 15px; padding: 8px; width: 50%;"/>
            <br/>
            <button type="submit" >Valider</button>
        </form>
        <% if(request.getAttribute("error")!=null){%>
            <p style="color: red;"><%=request.getAttribute("error")%></p>
        <%}%>
</section>
