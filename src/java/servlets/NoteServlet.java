package servlets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Note;

public class NoteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // get the path to the text file
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        // to read files
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        // read the lines from the text file
        String title = br.readLine();
        String contents = br.readLine();
        br.close();
        // construct the note object
        Note myNote = new Note(title, contents);
        // set the object as an attribute
        request.setAttribute("note", myNote);
        //capture the edit parameter
        String edit = request.getParameter("edit");

        if (edit == null) {
            // if edit is null, the parameter does not exist, so the user is trying to view the note
            getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
            return;
        } else {
            // edit is not null, so the parameter does exist
            // which means the user is trying to edit the note
            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);
            return;
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String title = request.getParameter("title");
        String contents = request.getParameter("contents");
        
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false)));

        pw.println(title);
        pw.println(contents);
        pw.close();

        // option 1: we could set the variables in an object 
        // set the object as an attribute 
        // and load the viewnote.jsp so the user can view the note
//        Note myNote = new Note(title, contents);
//        request.setAttribute("note", myNote);
//        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
//        return;

        // option 2: redirect the user, back to the doGet
        response.sendRedirect("note");
        return;
    }
}
