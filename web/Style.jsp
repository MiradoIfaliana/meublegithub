<section>
    <h2>Ajouter style</h2>
        <form action="saveStyle" method="GET">
            <label for="nomStyle">Nom Style :</label><br/>
            <input type="text" id="nomStyle" name="nomStyle"  style="margin-bottom: 15px; padding: 8px; width: 50%;" />
            <br/>
            <button type="submit" >Valider</button>
        </form>
        <% if(request.getAttribute("error")!=null){%>
            <p style="color: red;"><%=request.getAttribute("error")%></p>
        <%}%>
</section>
