<!DOCTYPE html>
<html>
<head>
    <title>Información Estudiantes</title>
</head>
<body>

    <p>
        <br/>
        <table>
            <tr><th>Matricula</th><th>Nombre</th></tr>
            <#list estudiantes as estudiante>
                <tr><td>${estudiante.matricula?string["0"]}</td><td>${estudiante.nombre}</td></tr>
            </#list>
        </table>
    </p>

    <p><a href="/add">add student</a></p>
    <p><a href="/update">update student</a></p>
    <p><a href="/delete">delete student</a></p>

</body>
</html>