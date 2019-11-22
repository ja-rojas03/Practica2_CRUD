<!DOCTYPE html>
<html>
<head>
    <title>Informacion Estudiantes</title>
    <link href="/css/datosEstudiante.css" rel="stylesheet">
</head>
<body>
    <h1>Listado de Estudiantes</h1>
    <div>
        <br/>
        <table>
            <tr>
                <th>Matricula</th>
                <th>Nombre</th>
                <th>Telefono</th>
            </tr>
            <#list estudiantes as estudiante>
                <tr>
                    <td>${estudiante.matricula?string["0"]}</td>
                    <td>${estudiante.nombre} ${estudiante.apellido}</td>
                    <td>${estudiante.telefono}</td>
                    <td><a href="/visualize/${estudiante.matricula?string["0"]}/"><img src="https://img.icons8.com/material-sharp/50/000000/visible.png" width="30px" height="30px"></a></td>
                    <td><a href="/update/${estudiante.matricula?string["0"]}/"><img src="/images/pencil.png" /></a></td>
                </tr>
            </#list>
        </table>
        <br/><br/>

        <form action="/add/" method="get">
            <button name="Anadir" type="submit">Nuevo Estudiante</button>
        </form>

    </div>


</body>
</html>