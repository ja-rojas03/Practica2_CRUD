<!DOCTYPE html>
<html>
<head>
    <title>Nuevo Estudiante</title>
    <link href="/css/nuevoEstudiante.css" rel="stylesheet">
</head>
<body>
    <h1>Ingrese los datos del estudiante:</h1>
    <form action="/procesarEstudiante/" method="post"  enctype="application/x-www-form-urlencoded">
        <h2>Nombre:</h2>
        <input name="nombre" type="text"/><br/>

        <h2>Apellido:</h2>
        <input name="apellido" type="text"/><br/>

        <h2>Matricula:</h2>
        <input name="matricula" type="text"/><br/>

        <h2>Telefono:</h2>
        <input name="telefono" type="text"/><br/><br/>

        <button name="Enviar" type="submit">Registrar</button>
    </form>
</body>
</html>