<%@page import="entite.*" %>
<section>
        <h2>Style pour l'ajout de quantite :</h2>
        
            <% 
                Style[] styles = (Style[]) request.getAttribute("styles");
            %>
        <form action="saveDureeOuvrier">
            <label for="style">Style:
                <select id="style" name="idstyle" required style="margin-bottom: 15px; padding: 8px; width: 50%;">
                    <%
                    if(styles!=null){
                        for (Style style: styles) { %>
                        <option value="<%= style.getIdstyle() %>" ><%= style.getNomstyle() %></option>
                        <% }
                    }
                    %>
                </select>
            </label><br/>
            <label for="duree">Duree Heure: </label><br/>
            <input type="text" id="duree" name="duree" style="margin-bottom: 15px; padding: 8px; width: 50%;"/>
            <br/>
            <button type="submit">Valider</button>
        </form>
        <% 
            if(request.getAttribute("error")!=null){%>
            <p style="color: red;"><%=request.getAttribute("error")%></p>
        <%}%>
</section>
