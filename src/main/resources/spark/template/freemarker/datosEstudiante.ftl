<!DOCTYPE html>
<html>
<head>
    <title>Informacion Estudiantes</title>
    <link href="/css/datosEstudiante.css" rel="stylesheet">
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
                    <td><a href="/update/${estudiante.matricula?string["0"]}/"><img src="/images/pencil.png"/></a></td>
                </tr>
            </#list>
        </table>
    </p>

    <form action="/add/" method="get">
        <button name="Anadir" type="submit">Nuevo Estudiante</button>
    </form>

</body>
</html>