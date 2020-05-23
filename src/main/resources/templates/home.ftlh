<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<nav><a href="/createPost">Create Post</a>  <form action="/filter" method="post">
        <input type="text" name="search">
        <button type="submit">search</button>
    </form>
       <form class="flex box-128" action="/logout" method="post">
        <#if _csrf??>
            <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
        </#if>
        <button class="flex box-128 logout-button">Выйти </button>
    </form>
    <a href="/profile">Profile</a> </nav>

<ul>
    <#list posts as p>
        <li>
            <p>
               <a href="/postDetail"> ${p.name}  ${p.createDate}  ${p.authorName} </a>
            </p>
        </li>
    </#list>
</ul>
</body>
</html>