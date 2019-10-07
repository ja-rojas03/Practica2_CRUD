<!DOCTYPE html>
<html>
<head>
    <title>Nuevo Estudiante</title>
    <link href="/css/nuevoEstudiante.css" rel="stylesheet">
</head>
<body>
<h1>Actualice los datos del estudiante:</h1>
<form action="/updateEstudiante/" method="post"  enctype="application/x-www-form-urlencoded">
    <h2>Nombre:</h2><br/>
    <input name="nombre" type="text" value="${estudiante.nombre}"/><br/>

    <h2>Apellido:</h2><br/>
    <input name="apellido" type="text" value="${estudiante.apellido}"/><br/>

    <h2>Matricula:</h2><br/>
    <input name="matricula" type="text" value="${estudiante.matricula?string["0"]}"/><br/>

    <h2>Telefono:</h2><br/>
    <input name="telefono" type="text" value="${estudiante.telefono}"/><br/><br/>

    <input name="pos" type="hidden" value="${pos}"/>
    <span>
        <button name="Enviar" type="submit">Actualizar</button>
        <button name="Borrar" type="submit" formaction="/delete/">Eliminar</button>
    </span>
</form>
</body>
</html>