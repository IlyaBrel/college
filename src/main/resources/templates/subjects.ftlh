<!DOCTYPE html>
<html>
<head>
    <title>COLLEGE</title>
</head>
<body>
<h1>COLLEGE</h1><hr>
<h4>Предметы в колледже</h4>
<#list subjects as subject>
    <div>
        <p><b>${subject.title}</b> ${subject.author} | <a href="/subject/${subject.id}">Подробнее</a> </p>
    </div>
</#list>
        <hr>
        <h3>Cоздать новый предмет</h3>
        <form action="/subject/create" method="post">
            Название предмета: <input type="text" name="title"><br><br>
            Описание: <input type="text" name="description"><br><br>
            Автор: <input type="text" name="author"><br><br>
            <input type="submit" value="Добавить товар">
        </form>
</body>
</html>