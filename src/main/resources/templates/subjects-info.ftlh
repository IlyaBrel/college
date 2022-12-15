<!DOCTYPE html>
<html>
<head>
    <title>COLLEGE</title>
</head>
<body>
<h1>COLLEGE</h1>
<hr>
<h4>Подробная информация о предмете </h4>
<b>Название предмета </b>${subject.title}<br>
<b>Описание </b>${subject.description}<br>
<b>Автор </b>${subject.author}<br>

<hr>
<h3>Cоздать новый предмет</h3>
<form action="/subject/delete/${subject.id}" method="post">
    <input type="submit" value="Удалить предмет">
</form>
</body>
</html>