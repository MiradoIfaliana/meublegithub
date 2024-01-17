create database meuble;
\c meuble;

create table categorie(
    idcategorie serial primary key,
    nomcategorie varchar(20)
);
create table style(
    idstyle serial primary key,
    nomstyle varchar(20)
);
create table unite(
    idunite serial primary key,
    nomunite varchar(40),
    unite varchar(10)
);
create table matiere(
    idmatiere serial primary key,
    nommatiere varchar(20),
    idunite int references unite(idunite)
);
create table matierestyle(
    idmatierestyle serial primary key,
    idmatiere int references matiere(idmatiere),
    idstyle int references style(idstyle), unique(idmatiere,idstyle),
);
--------
create or replace view stylematiere_v as
select
    s.idstyle,
    s.nomstyle,
    m.idmatiere,
    m.nommatiere ,
    m.idunite,
    u.unite
    from matierestyle as ms
    join matiere as m on ms.idmatiere=m.idmatiere
    join style as s on ms.idstyle=s.idstyle
    left join unite as u on m.idunite=u.idunite;
---------
create table taille(
    idtaille serial primary key,
    nomtaille varchar(40)
);
--alter table quantitematiere add column idcategorie int references categorie(idcategorie);

create table quantitematiere(
    idquantitematiere serial primary key,
    idmatierestyle int references matierestyle(idmatierestyle),
    idcategorie int references categorie(idcategorie),
    idtaille int references taille(idtaille),
    quantite float check(quantite >= 0)
);
---------
create or replace view stylematiere2_v as
select
    ms.idmatierestyle,
    s.idstyle,
    s.nomstyle,
    m.idmatiere,
    m.nommatiere ,
    m.idunite,
    u.unite
    from matierestyle as ms
    join matiere as m on ms.idmatiere=m.idmatiere
    join style as s on ms.idstyle=s.idstyle
    left join unite as u on m.idunite=u.idunite;

create or replace view matierequantite_v as
select
    qm.idcategorie,
    c.nomcategorie,
    m.idmatiere,
    m.nommatiere,
    s.idstyle,
    s.nomstyle,
    t.idtaille,
    t.nomtaille,
    qm.quantite,
    u.unite
    from quantitematiere as qm
    join categorie as c 
        on qm.idcategorie=c.idcategorie
    join matierestyle as ms
        on ms.idmatierestyle = qm.idmatierestyle
    join matiere as m 
        on ms.idmatiere = m.idmatiere
    join style as s
        on ms.idstyle = s.idstyle
    join taille as t
        on t.idtaille = qm.idtaille
    join unite as u
        on u.idunite = m.idunite;

create table matiereprix(
    idmatiereprix serial primary key,
    idmatiere int references matiere(idmatiere),
    prix float check (prix>0),
    dateprix date
);

create or replace view matiereprixnow_v as 
    select mp.idmatiere,
    mp.prix,
    mp.dateprix
    from matiereprix as mp 
    join ( select idmatiere,max(dateprix) as dateprix 
            from matiereprix group by idmatiere
    ) as tab1
    on (mp.idmatiere=tab1.idmatiere and mp.dateprix=tab1.dateprix);

create or replace view prixcategoriebrute_v as
    select qm.idcategorie,
    ms.idstyle,
    qm.idtaille,
    sum(qm.quantite*mpn_v.prix) as prixtotal
    from quantitematiere as qm
    join matierestyle as ms on qm.idmatierestyle=ms.idmatierestyle
    join matiereprixnow_v as mpn_v on ms.idmatiere=mpn_v.idmatiere
    group by qm.idcategorie,ms.idstyle, qm.idtaille;

create or replace view prixcategorie_v as
    select 
    pcb_v.idcategorie,
    c.nomcategorie,
    pcb_v.idstyle,
    s.nomstyle,
    pcb_v.idtaille,
    t.nomtaille,
    pcb_v.prixtotal
    from prixcategoriebrute_v as pcb_v
    join categorie as c on c.idcategorie=pcb_v.idcategorie
    join style as s on s.idstyle=pcb_v.idstyle
    join taille as t on t.idtaille=pcb_v.idtaille;
----------------------------
create table matiereentre(
    idmatiereentre serial primary key,
    idmatiere int references matiere(idmatiere),
    equantite float check (equantite>=0),
    dateentre date
);
create table matieresorti(
    idmatieresorti serial primary key,
    idmatiere int references matiere(idmatiere),
    squantite float check (squantite>=0),
    datesorti date
);
create table fabrication(
    idfabrication serial primary key,
    idcategorie int references categorie(idcategorie),
    quantitefab float check (quantitefab>0),
    datefab date,
    idtaille int references taille(idtaille),
    idstyle int references style(idstyle)
);
create or replace view matiereentre_v as
    select idmatiere,dateentre,sum(equantite) as equantite 
    from matiereentre 
    group by idmatiere,dateentre;

create or replace function entrebefore_f(datefin date)
    returns table (idmatiere int,equantite float) As $$
    BEGIN
    return query
        select tab.idmatiere,max(tab.equantite) as equantite  from (
            select me_v.idmatiere,me_v.equantite from matiereentre_v as me_v
            where dateentre<=datefin
            union
            select m.idmatiere,0 as equantite from matiere as m
        ) as tab group by tab.idmatiere;
    end;
    $$ language plpgsql;
--select * from entrebefore_f('2023-04-04');

create or replace view matieresorti_v as
    select idmatiere,datesorti,sum(squantite) as squantite 
    from matieresorti 
    group by idmatiere,datesorti;

create or replace function sortiebefore_f(datefin date)
    returns table (idmatiere int,squantite float) As $$
    BEGIN
    return query
        select tab.idmatiere,max(tab.squantite) as squantite from (
            select ms_v.idmatiere,ms_v.squantite 
            from matieresorti_v as ms_v
            where datesorti<=datefin
            union
            select m.idmatiere,0 as squantite from matiere as m
        ) as tab group by tab.idmatiere;
    end;
    $$ language plpgsql;
--select * from sortiebefore_f('2023-04-04');   


-- create or replace view matieresorti_v as
--     select tab.idmatiere,tab.datesorti,max(tab.squantite) as squantite from (
--         select idmatiere,datesorti,sum(squantite) as squantite 
--         from matieresorti 
--         group by idmatiere,datesorti
--         union
--         select idmatiere,me_v.dateentre as datesorti,0 as squantite
--         from matiere cross join matiereentre_v as me_v
--     ) as tab ;

create or replace function stockbefore_f(datefin date)
    returns table (idmatiere int,equantite float,squantite float, datestock date) As $$
    BEGIN
    return query
        select tab.idmatiere,tab.equantite,tab.squantite,datefin as datestock from (
            select eb_f.idmatiere,sum(eb_f.equantite) as equantite,sum(sb_f.squantite) as squantite
            from entrebefore_f(datefin) as eb_f 
            join sortiebefore_f(datefin) as sb_f 
            on eb_f.idmatiere=sb_f.idmatiere
            group by eb_f.idmatiere
        ) as tab;
    end;
    $$ language plpgsql;
--select * from stockbefore_f('2023-04-04');

create or replace function stockdetailbefore_f(datefin date)
    returns table (idmatiere int,nommatiere varchar,equantite float,squantite float, datestock date,idunite int,nomunite varchar) As $$
    BEGIN
    return query
        select stb_f.idmatiere,m.nommatiere,stb_f.equantite ,stb_f.squantite,stb_f.datestock,u.idunite,u.nomunite
        from stockbefore_f(datefin) as stb_f
        join matiere as m
        on m.idmatiere=stb_f.idmatiere
        join unite as u
        on u.idunite=m.idunite;
    end;
    $$ language plpgsql;
--select * from stockdetailbefore_f('2023-04-04');

create table prixvente(
    idprixvente serial primary key,
    idcategorie int references categorie(idcategorie),
    idstyle int references style(idstyle),
    idtaille int references taille(idtaille),
    prixvente float check(prixvente>0),
    dateprix date
);
create table ouvrier(
    idouvrier serial primary key,
    typeouvrier varchar(50)
);
create table salaire(
    idsalaire serial primary key,
    idouvrier int references ouvrier(idouvrier),
    salaires float check(salaires>0),
    datesalaire date
);
create table ouvrierbesoin(
    idouvrierbesoin serial primary key,
    idcategorie int references categorie(idcategorie),
    idouvrier int references ouvrier(idouvrier)
);
create table dureestyle(
    iddureestyle serial primary key,
    idstyle int references style(idstyle),
    duree float check (duree>0)
);
create table nbouvrier(
    idnbouvrier serial primary key,
    idcategorie int references categorie(idcategorie),
    idtaille int references taille (idtaille),
    nombre float check(nombre>0)
);


create or replace view ouvrierbesoininfo_v as
    select co.idouvrierbesoin,
        co.idcategorie,
        co.idouvrier,
        nbo.idnbouvrier,
        nbo.idtaille,
        nbo.nombre,
        ds.idstyle,
        ds.duree,
        s.idsalaire,
        s.salaires
        from ouvrierbesoin as co 
        join nbouvrier as nbo on co.idcategorie=nbo.idcategorie
        cross join dureestyle as ds
        join salaire as s on co.idouvrier=s.idouvrier;

create or replace view prixrevientouvrier_v as 
    select idcategorie,idstyle,idtaille,sum(nombre*(duree/3600.0)*salaires) as prixrevientouvrier
    from ouvrierbesoininfo_v group by idcategorie,idstyle,idtaille;

create or replace view prixrevient_v as 
    select pro_v.idcategorie,pro_v.idstyle,pro_v.idtaille, (pro_v.prixrevientouvrier+pc_v.prixtotal) as prixrevient
    from prixrevientouvrier_v as pro_v
    join prixcategoriebrute_v as pc_v
    on( pro_v.idcategorie=pc_v.idcategorie and pro_v.idstyle=pc_v.idstyle and pro_v.idtaille=pc_v.idtaille );

create or replace view benefice_v as
    select pr_v.idcategorie,pr_v.idstyle,pr_v.idtaille,pv.prixvente,pr_v.prixrevient,(pv.prixvente-pr_v.prixrevient) as benefice
    from prixrevient_v as pr_v
    join prixvente as pv 
    on ( pr_v.idcategorie=pv.idcategorie and pr_v.idstyle=pv.idstyle and pr_v.idtaille=pv.idtaille);

create or replace view beneficedetail_v as
    select b_v.idcategorie,c.nomcategorie,b_v.idstyle,s.nomstyle,b_v.idtaille,t.nomtaille,b_v.prixvente,b_v.prixrevient,b_v.benefice
    from benefice_v as b_v
    join categorie as c on c.idcategorie=b_v.idcategorie
    join style as s on s.idstyle=b_v.idstyle
    join taille as t on t.idtaille=b_v.idtaille;
