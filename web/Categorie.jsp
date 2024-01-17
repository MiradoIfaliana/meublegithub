<section>
    <h2>Ajouter categorie</h2>
        <form action="saveCategorie" method="GET">
            <label for="nomCategorie">Nom Categorie: </label><br/>
            <input type="text" id="nomCategorie" name="nomCategorie" style="margin-bottom: 15px; padding: 8px; width: 50%;"/>
            <br/>
            <button type="submit">Valider</button>
        </form>
        <% if(request.getAttribute("error")!=null){%>
            <p style="color: red;"><%=request.getAttribute("error")%></p>
        <%}%>
</section>