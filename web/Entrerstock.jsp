<%@page import="entite.*" %>
<section>
            <% 
                Matiere[] matieres = (Matiere[]) request.getAttribute("matieres");
            %>
        <h2>Entrer stock </h2>
        <form action="entrerstock" method="GET" >
            <label for="matiere">Matiere: </label><br/>
                <select id="matiere" name="idmatiere" required style="margin-bottom: 15px; padding: 8px; width: 50%;">
                    <%
                    if(matieres!=null){
                        for (Matiere matiere: matieres) { %>
                        <option value="<%= matiere.getIdmatiere() %>" ><%= matiere.getNommatiere() %></option>
                        <% }
                    }
                    %>
                </select>
            <br/>
                <label for="date">Date : </label><br/>
                <input type="date" id="date" name="dateentre" style="margin-bottom: 15px; padding: 8px; width: 50%;"/>
            <br/>
                <label for="quantite">Quantite : </label><br/>
                <input type="text" id="quantite" name="quantite" style="margin-bottom: 15px; padding: 8px; width: 50%;"/>
            <br/>
            <button type="submit" >Valider</button>
        </form>
</section>