<section>
    <h2>Ajouter Type Ouvrier</h2>
        <form action="saveOuvrier" method="GET">
            <label for="typeouvrier">Type ouvrier: </label><br/>
            <input type="text" id="typeouvrier" name="typeouvrier" style="margin-bottom: 15px; padding: 8px; width: 50%;"/>
            <br/>
            <button type="submit">Valider</button>
        </form>
        <% if(request.getAttribute("error")!=null){%>
            <p style="color: red;"><%=request.getAttribute("error")%></p>
        <%}%>
</section>