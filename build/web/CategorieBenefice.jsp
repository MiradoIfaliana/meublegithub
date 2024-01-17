<%@page import="entite.*" %>
<section>

        <h2>Voir Benefice entre Prix min et Prix Max</h2>
        <form action="voirCategorieBenefice" method="GET" >
            <br/>
            <label for="prixmin">Prix Min : </label><br/>
            <input type="text" id="prixmin" name="prix1" style="margin-bottom: 15px; padding: 8px; width: 50%;"/>
            <br/>
            <label for="prixMax">Prix Max : </label><br/>
            <input type="text" id="prixMax" name="prix2" style="margin-bottom: 15px; padding: 8px; width: 50%;"/>
            <br/>
            <br/>
            <button type="submit">Valider</button>
        </form>
        <% if(request.getAttribute("error")!=null){%>
            <p style="color: red;"><%=request.getAttribute("error")%></p>
        <%}
        Beneficedetail_v[] beneficedetail_vs = (Beneficedetail_v[])request.getAttribute("beneficedetail_vs");
        if(beneficedetail_vs!=null){ %>
            <table>
                <thead>
                    <tr>
                        <th>Meuble</th>
                        <th>Style</th>
                        <th>Taille</th>
                        <th>Prix vente</th>
                        <th>Prix revient</th>
                        <th>Benefice</th>
                    </tr>
                </thead>
                <tbody>
                    <% 
                        for(Beneficedetail_v beneficedetail_v : beneficedetail_vs){ %>
                            <tr>
                                <td><%=beneficedetail_v.getNomcategorie()%></td>
                                <td><%=beneficedetail_v.getNomstyle()%></td>
                                <td><%=beneficedetail_v.getNomtaille()%></td>
                                <td><%=beneficedetail_v.getPrixvente()%></td>
                                <td><%=beneficedetail_v.getPrixrevient()%></td>
                                <td><%=beneficedetail_v.getBenefice()%></td>
                            </tr><%
                        }
                    %>
                </tbody>
            </table> <%
        }
        %>
</section>
