<!DOCTYPE html>
<html>
<head>
    <title>Informacion Estudiantes</title>
    <style>
        table {
            border: solid 2px black;
        }

    </style>
</head>
<body>

    <p>
        <br/>
        <table>
            <tr>
                <th>Matricula</th>
                <th>Nombre</th>
                <th>Apellido</th>
                <th>Telefono</th>
            </tr>
            <#list estudiantes as estudiante>
                <tr>
                    <td>${estudiante.matricula?string["0"]}</td>
                    <td>${estudiante.nombre}</td>
                    <td>${estudiante.apellido}</td>
                    <td>${estudiante.telefono}</td>
                </tr>
            </#list>
        </table>
    </p>

    <p>
        <span><a href="/add">ADD</a></span>
        <span><a href="/update">UPDATE</a></span>
        <span><a href="/delete">DELETE</a></span>
    </p>

</body>
</html>