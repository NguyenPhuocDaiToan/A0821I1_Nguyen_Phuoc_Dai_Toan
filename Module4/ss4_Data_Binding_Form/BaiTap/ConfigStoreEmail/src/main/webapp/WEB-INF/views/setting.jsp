<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 3/25/2022
  Time: 3:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Config Email</title>
</head>
<body>
<h1>Setting</h1>
<form:form action="/save" method="post" modelAttribute="set">
    <div>
        Languages:
        <form:select path="language" onchange="onchangeLanguage()" id="id_language">
            <option ${set.language=='English'?'selected':''} value="English">English</option>
            <option ${set.language=='Vietnamese'?'selected':''} value="Vietnamese">Vietnamese</option>
            <option ${set.language=='Chinese'?'selected':''} value="Chinese">Chinese</option>
            <option ${set.language=='Japanese'?'selected':''} value="Japanese">Japanese</option>
        </form:select>
    </div>
    <div>
        Show:
        <form:select path="pageSize">
            <option ${set.pageSize==10?'selected':''}>10</option>
            <option ${set.pageSize==15?'selected':''}>15</option>
            <option ${set.pageSize==20?'selected':''}>20</option>
        </form:select>
        emails per page
    </div>

    <div>
        Spam filter:
        <form:checkbox path="spamFilter"/> Enable spam filters
    </div>
    <div>
        Signature:
        <form:textarea rows="3" cols="10" path="signature"/>
    </div>
    <input type="submit" value="Submit"/>

</form:form>
</body>

<script>
    function onchangeLanguage() {
        let language = document.getElementById("id_language").value;
        console.log(language);
        window.location = '/getSetting/' + language;
    }
</script>
</html>