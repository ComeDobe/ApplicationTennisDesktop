package com.example.helloword;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebServlet(name = "login", value = "/login")

public class Login extends HttpServlet {
//    private static final long serialVersionUID = 1L;
@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//        String login = request.getParameter( "txtLogin" );
//        String password = request.getParameter( "txtPassword" );
//        if ( login == null ) login = "";
//        if ( password == null ) password = "";
//
//        HttpSession session = request.getSession( true );
//        session.setAttribute( "login", login );
//        session.setAttribute( "password", password );

        this.getServletContext().getRequestDispatcher("/WEB-INF/Login.jsp").forward(request,response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String login = request.getParameter( "txtLogin" );
        String password = request.getParameter( "txtPassword" );

        HttpSession session = request.getSession( true );
        session.setAttribute( "login", login );
        session.setAttribute( "password", password );

        System.out.println( "in the doPost" );

        if ( login.equals( "bond" ) && password.equals( "007" ) ) {
            session.setAttribute( "isConnected", true );
            request.getRequestDispatcher( "/Connected.jsp" ).forward( request, response );
        } else {
            session.setAttribute( "isConnected", false );
            request.getRequestDispatcher( "/Login.jsp" ).forward( request, response );
        }
    }

}