<#-- импортируем основной шаблон-контейнер который содержит в себе разметку для основной структуры страницы -->
<#import "partials/main.ftlh" as main />

<#-- обрабатываем его, и передаём ему список скриптов, которые необходимо подключить-->
<@main.renderWith>


    <#if errorText?? >
        <div>
            <p>${errorText!'-- no message --'}</p>
        </div>
    </#if>

    <nav>
    <div class="flex flex-justify-content-center">
        <a class="flex box-128" href="/forgot"> Забыли Пароль </a>
        <a class="flex box-128" href="/register"> Регистрация </a>
        <a class="flex box-128" href="/login"> Войти </a>
    </div>
</nav>

</@main.renderWith>