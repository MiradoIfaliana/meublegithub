<%@page import="entite.*" %>
<section>
        <h2>Voir matiere</h2>
        
            <% 
                Style[] styles = (Style[]) request.getAttribute("styles");
            %>
        <form action="matieresOfStyleData">
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
            </label>
            <button type="submit">Valider</button>
        </form>
        <%
        Stylematiere_v[] stylematieres=(Stylematiere_v[])request.getAttribute("stylematieres");
        if(stylematieres!=null){ %>
            <h2>Matieres pour style : <%=stylematieres[0].getNomstyle()%></h2>
            <table>
                <thead>
                    <tr>
                        <th>Matiere</th>
                        <th>Unite</th>
                    </tr>
                </thead>
                <tbody>
                    <% 
                        for(Stylematiere_v stylematiere: stylematieres){ %>
                            <tr>
                                <td><%=stylematiere.getNommatiere()%></td>
                                <td><%=stylematiere.getUnite()%></td>
                            </tr><%
                        }
                    %>
                </tbody>
            </table> <%
        }
        %>
        <% if(request.getAttribute("error")!=null){%>
            <p style="color: red;"><%=request.getAttribute("error")%></p>
        <%}%>
</section>
