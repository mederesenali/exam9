<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form action="/createPost" method="post">
    <label>Post name</label>
    <input type="text" name="name"><br>
    <label>content</label>
    <input type="text" name="content"><br>
    <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
    <input type="submit" value="post">
</form>
</body>
</html>