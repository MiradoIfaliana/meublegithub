<%@page import="entite.*" %>
<section>
            <% 
                Matiere[] matieres = (Matiere[]) request.getAttribute("matieres");
                Style[] styles = (Style[]) request.getAttribute("styles");
            %>
        <h2>Ajouter matiere pour une style</h2>
        <form action="saveMatiereStyle" method="GET" >
            <label for="style">Style: </label><br/>
                <select id="style" name="Idstyle" required style="margin-bottom: 15px; padding: 8px; width: 50%;">
                    <%
                    if(styles!=null){
                        for (Style style: styles) { %>
                        <option value="<%= style.getIdstyle() %>" ><%= style.getNomstyle() %></option>
                        <% }
                    }
                    %>
                </select>
            <br/>
            <label for="style">Matiere: </label><br/>
            <%
                int i = 0;
                if(matieres!=null){
                    for (Matiere matiere: matieres) { %>   
                        <input type="checkbox" value="<%= matiere.getIdmatiere() %>" name="idmatiere<%= i %>"/>            
                        <label id="subLabel"><%= matiere.getNommatiere() %>
                        </label id="subLabel">
                        <br/>
                        <% 
                        i ++;    
                    }
                }
            %>
            
            <br/>
            <button type="submit" >Valider</button>
        </form>
        <% if(request.getAttribute("error")!=null){%>
            <p style="color: red;"><%=request.getAttribute("error")%></p>
        <%}%>
</section>