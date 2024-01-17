<%@page import="entite.*" %>
<section>
        <h2>Voir Detail quantite matiere</h2>
        
            <% 
                Matiere[] matieres = (Matiere[]) request.getAttribute("matieres");
                
            %>
        <form action="matiereQuantiteInfo">
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
            <button type="submit">Valider</button>
        </form>
        <%
        Matierequantite_v[] matierequantites = 
                (Matierequantite_v[])request.getAttribute("matierequantite_vs");
        if(matierequantites!=null){ %>
            <table>
                <thead>
                    <tr>
                        <th>Matiere</th>
                        <th>Categorie</th>
                        <th>Style</th>
                        <th>Taille</th>
                        <th>Quantite</th>
                        <th>Unite</th>
                    </tr>
                </thead>
                <tbody>
                    <% 
                        for(Matierequantite_v matierequantite: matierequantites){ %>
                            <tr>
                                <td><%=matierequantite.getNommatiere()%></td>
                                <td><%=matierequantite.getNomcategorie()%></td>
                                <td><%=matierequantite.getNomstyle()%></td>
                                <td><%=matierequantite.getNomtaille()%></td>
                                <td><%=matierequantite.getQuantite()%></td>
                                <td><%=matierequantite.getUnite()%></td>
                            </tr><%
                        }
                    %>
                </tbody>
                <% if(request.getAttribute("error")!=null){%>
                    <p style="color: red;"><%=request.getAttribute("error")%></p>
                <%}%>
            </table> <%
        }
        %>

</section>
