<%@page import="entite.*" %>
<section>
            <% 
                Matiere[] matieres = (Matiere[]) request.getAttribute("matieres");
                Style[] styles = (Style[]) request.getAttribute("styles");
            %>
        <h2>Voir meuble entre Prix min et Prix Max</h2>
        <form action="getmeublebyprix" method="GET" >
            <label for="prixmin">Prix Minimum: </label><br/>
            <input type="text" id="prixmin" name="prixmin" style="margin-bottom: 15px; padding: 8px; width: 50%;"/>
            <br/>
            <label for="prixmax">Prix Maximum: </label><br/>
            <input type="text" id="prixmax" name="prixmax" style="margin-bottom: 15px; padding: 8px; width: 50%;"/>
            <br/>
            <button type="submit" >Valider</button>
        </form>
        <% if(request.getAttribute("error")!=null){%>
            <p style="color: red;"><%=request.getAttribute("error")%></p>
        <%}%>
        <%
        Prixcategorie_v[] prixcategories = (Prixcategorie_v[])request.getAttribute("prixcategorie_vs");
        if(prixcategories!=null){ %>
            <table>
                <thead>
                    <tr>
                        <th>Meuble</th>
                        <th>Style</th>
                        <th>Taille</th>
                        <th>Prix</th>
                    </tr>
                </thead>
                <tbody>
                    <% 
                        for(Prixcategorie_v prixcategorie: prixcategories){ %>
                            <tr>
                                <td><%=prixcategorie.getNomcategorie()%></td>
                                <td><%=prixcategorie.getNomstyle()%></td>
                                <td><%=prixcategorie.getNomtaille()%></td>
                                <td><%=prixcategorie.getPrixtotal()%></td>
                            </tr><%
                        }
                    %>
                </tbody>
            </table> <%
        }
        %>
</section>
