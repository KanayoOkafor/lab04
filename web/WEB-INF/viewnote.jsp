

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Simple Note Keeper </title>
    </head>
    <body>
        <h1> Simple Note Keeper </h1>
        <h2> View Note </h2>
        <form>
            <div>
                <b>Title:</b>
                <p>${note.title}</p>
<!--                <input name="title" value="">-->
            </div>
            <div>
                <b>Contents:</b>
                <p>${note.contents}</p>
<!--                <input name="content" value="">-->
            </div>
          </form>
        <p> <a href="note?edit"> Edit </a> </p> 
        <p> ${display}</p>
    </body>
</html>
