<!DOCTYPE html>
<html>
<head>
    <title>Nuevo Estudiante</title>
<#--    <link href="/css/nuevoEstudiante.css" rel="stylesheet">-->
    <link href="/css/visualEstudiante.css" rel="stylesheet">
</head>
<body>
<h1>Datos del estudiante:</h1>
    <div>
        <h3>Nombre:</h3>
        <h2>${estudiante.nombre}</h2><br/>
    </div>

    <div>
        <h3 >Apellido:</h3>
        <h2 >${estudiante.apellido}</h2><br/>
    </div>

    <div >
        <h3 >Matricula:</h3>
        <h2 >${estudiante.matricula?string["0"]}</h2><br/>
    </div>

    <div >
        <h3 >Telefono:</h3>
        <h2>${estudiante.telefono}</h2><br/><br/>
    </div>
    <form action="/" method="get">
        <button name="Enviar" type="submit">Inicio</button>
    </form>

</body>
</html>