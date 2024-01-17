<section>
    <h2>Ajouter taille</h2>
        <form action="saveTaille" method="GET">
            <label for="nomtaille">Nom taille: </label><br/>
            <input type="text" id="nomtaille" name="nomtaille" style="margin-bottom: 15px; padding: 8px; width: 50%;"/>
            <br/>
            <button type="submit">Valider</button>
        </form>
        <% if(request.getAttribute("error")!=null){%>
            <p style="color: red;"><%=request.getAttribute("error")%></p>
        <%}%>
</section>
