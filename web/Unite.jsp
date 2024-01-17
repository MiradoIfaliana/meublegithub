<%@page import="entite.*" %>
<section>
    <h2>Ajouter Unite de mesure</h2>
    <form action="saveUnite" method="GET">
        <label for="nomunite">Nom Unite (Kilograme,...) : </label><br/>
        <input type="text" id="nomunite" name="nomunite" style="margin-bottom: 15px; padding: 8px; width: 50%;" />
        <br/>
        <label for="unite">Unite (Kg,...) : </label><br/>
        <input type="text" id="unite" name="unite"  style="margin-bottom: 15px; padding: 8px; width: 50%;" />
        <br/>
        <button type="submit" >
            Valider
        </button>
    </form>
    <% if(request.getAttribute("error")!=null){%>
        <p style="color: red;"><%=request.getAttribute("error")%></p>
    <%}%>

</section>