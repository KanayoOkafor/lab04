

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Simple Note Keeper </title>
    </head>
    <body>
        <h1> Simple Note Keeper </h1>
        <h2> Edit Note </h2>

        <form method="post" action="note">
            <div>
                <label> Title:  </label><br>
                <input type="text" name="title" value="${note.title}">
            </div>
            <div>
                <label> Contents: </label><br>
                <textarea name="contents" rows="5" cols="26">${note.contents}</textarea> 
            </div>
            <div>
                <input type="submit" value="Edit Note!">
            </div>
          </form>
        <p> <a href="note"> Cancel </p>

    </body>
</html>
