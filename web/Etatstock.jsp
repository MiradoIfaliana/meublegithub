<%@page import="entite.*" %>
<section>
            <% 
                Matiere[] matieres = (Matiere[]) request.getAttribute("matieres");
            %>
        <h2>Etat de stock </h2>
        <form action="etatDeStock" method="GET" >
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
            </label>
            <br/>
            <label for="date">Date : </label><br/>
            <input type="date" id="date" name="date" style="margin-bottom: 15px; padding: 8px; width: 50%;"/>
            <br/>
            <button type="submit" >Valider</button>
        </form>
        <%
        Stockdetailbefore_f stockdetailbefore_f=(Stockdetailbefore_f)request.getAttribute("stockdetailbefore_f");
        if(stockdetailbefore_f!=null){ %>
            <table>
                <thead>
                    <tr>
                        <th>Matiere</th>
                        <th>Entree</th>
                        <th>Sortie</th>
                        <th>Reste</th>
                        <th>Date</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td><%=stockdetailbefore_f.getNommatiere()%></td>
                        <td><%=stockdetailbefore_f.getEquantite()%> <%=stockdetailbefore_f.getNomunite()%></td>
                        <td><%=stockdetailbefore_f.getSquantite()%> <%=stockdetailbefore_f.getNomunite()%></td>
                        <td><%=stockdetailbefore_f.getQuantiteReste()%> <%=stockdetailbefore_f.getNomunite()%></td>
                        <td><%=stockdetailbefore_f.getDatestock()%></td>
                    </tr>
                </tbody>
            </table><%
        }
        %>
        <% if(request.getAttribute("error")!=null){%>
            <p style="color: red;"><%=request.getAttribute("error")%></p>
        <%}%>
</section>
