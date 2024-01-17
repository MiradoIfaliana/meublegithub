<%-- 
    Document   : index
    Created on : 8 déc. 2023, 19:31:50
    Author     : Mirado
--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Prediction</title>
    <link rel="stylesheet" href="all.css">
    <link rel="stylesheet" href="all.min.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            background-color: #ffffff;
        }

        header {
            background-color: #004c6e;
            color: #fff;
            padding: 10px;
            text-align: center;
        }

        nav {
            width: 200px;
            background-color:#004c6e;
            height: 100vh;
            position: fixed;
            top: 0;
            left: 0;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            overflow-y: auto;
            z-index: 2;
        }

        nav a {
            display: block;
            padding: 15px;
            text-decoration: none;
            color: #fffdfd;
            border-bottom: 1px solid #eee;
            transition: background-color 0.3s;
        }

        nav a:hover {
            background-color: #f0f2f5;
        }

        header ul {
            list-style-type: none;
            margin: 0;
            padding: 10px;
            display: flex;
            justify-content: space-around;
            background-color: #004c6e;
        }

        header li {
            display: inline;
        }

        header a {
            text-decoration: none;
            color: #fff;
            padding: 10px;
            transition: background-color 0.3s;
        }

        header a:hover {
            background-color: #345492;
        }

        section {
            margin-left: 220px;
            padding: 20px;
        }
        section label{
            font-weight: bold;
        }
        #subLabel{
            font-weight: 300;
        }
        button{
            padding: 10px; 
            background-color: #4267b2; 
            color: #fff; 
            border: none; 
        }
        button :hover{
            background-color: #2a4985; 
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }

        th {
            background-color: #4267b2;
            color: white;
        }
        form{
            max-width: 600px; 
            
            margin-top: 30px;
            padding: 20px; 
            background-color: #fff; 
            border-radius: 8px; 
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
        }
        h2{
            font-size: 2em; 
            color: #4267b2;
        }
        input {
            box-sizing: border-box;
            width: 100%;
            padding: 12px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            transition: 0.3s;
        }
        
        input:focus {
            outline: none;
            border-color: #4267b2;
            box-shadow: 0 4px 8px rgba(66, 103, 178, 0.3);
        }
        
        input[type="checkbox"] {
            margin: 0;
            width: auto;
        }
        select {
            width: 100%;
            padding: 12px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            background-color: #fff;
            color: #333;
            appearance: none;
            -webkit-appearance: none;
            -moz-appearance: none;
            cursor: pointer;
            transition: 0.3s;
        }
        
        select:hover, select:focus {
            outline: none;
            border-color: #4267b2;
            box-shadow: 0 4px 8px rgba(66, 103, 178, 0.3);
        }
        footer {
            position: fixed;
            bottom: 0;
            width: 100%;
            background-color: #95a5ba;
            text-align: center;
            z-index: 1;
        }
        .rounded-logo {
            border-radius: 5%;
            overflow: hidden;
            width: 99%; /* Vous pouvez ajuster la largeur selon vos besoins */
            max-width: 600px;
            height: auto;
        }
        section{
            margin-bottom:200px;
        }
    </style>
</head>
<body>

    <header>
        <ul>
            <li><i class="fa fa-house"></i><a href="RedirectServlet?section=Acceuil.jsp">Acceuil</a></li>
            <li><a href="#"></a></li>
            <li><a href="#"></a></li>
        </ul>
    </header>

    <nav>
        <img src="./assets/images/meublelogo.png" alt="Meubles de qualité" class="rounded-logo" >
        <a href="RedirectServlet?section=Categorie.jsp">Inserer Categorie</a>
        <a href="RedirectServlet?section=Unite.jsp">Inserer Unite</a>
        <a href="toSaveMatiere">Inserer Matiere</a>
        <a href="RedirectServlet?section=Style.jsp">Inserer Style</a>
        <a href="toSaveMatiereStyle">Matiere Style</a>
        <a href="toVoirMatiereOfStyle">Voir Matiere</a>
        <a href="RedirectServlet?section=Taille.jsp">Inserer Taille</a>
        <a href="tosaveTailleMatiere">Inserer Quantite</a>
        <a href="matiereQuantiteInfo">Voir Matiere Quantite</a>
        <a href="toFormprix">Ajouter prix</a>
        <a href="RedirectServlet?section=voirmeublebyprix.jsp">Meuble by prix</a>
        <a href="toFormprix">Ajouter prix</a>
        <a href="toEntrerstock">Entrer Stock</a>
        <a href="toEtatDeStock">Etat Stock</a>
        <a href="toFabriquer">Fabrication</a>  
        <a href="RedirectServlet?section=SaveOuvrier.jsp">Inserer Ouvrier</a>  
        <a href="toSaveSalaire">Inserer salaire</a>  
        <a href="toSaveDureeOuvrier">Inserer Duree</a>  
        <a href="toSavePrixvente">Inserer Prix vente</a>  
        <a href="toSaveOuvrierBesoin">Inserer ouvrier besoin</a> 
        <a href="toSaveNbOuvrier">Inserer nombre ouvrier </a>  
        <a href="RedirectServlet?section=CategorieBenefice.jsp">Voir Meuble benefice </a>  
    </nav>
    <<% if(request.getAttribute("section")!=null){ %>
        <jsp:include page="${section}" />
    <%}else{ %>
        <jsp:include page="Acceuil.jsp" />
    <%}%>
    
    <footer>
        <p>&copy; 2023 S5 S3. Tous droits réservés.</p>
    </footer>

</body>
</html>



