<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/html">
<head>
    <title>COLLEGE</title>
</head>
<body>
<h1>COLLEGE</h1>
<hr>
<h4>Предметы в колледже</h4>

<form action="/" method="get">
    Поиск по названию предмета: <input type="text" name="title"><br>
    <input type="submit" value="Поиск"/>
</form>
<#list subjects as subject>
    <div>
        <p><b>${subject.title}</b> ${subject.author} | <a href="/subject/${subject.id}">Подробнее</a></p>
    </div>
</#list>
<hr>
<h3>Cоздать новый предмет</h3>
<form action="/subject/create" method="post" enctype="multipart/form-data">
    Название предмета: <input type="text" name="title"><br><br>
    Описание: <input type="text" name="description"><br><br>
    Первая фотография: <input type="file" name="file1"/><br><br>
    Вторая фотография: <input type="file" name="file2"/><br><br>
    Третья фотография: <input type="file" name="file3"/><br><br>
    Автор: <input type="text" name="author"><br><br>
    <input type="submit" value="Добавить предмет">
</form>
</body>
</html>