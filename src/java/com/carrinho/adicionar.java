/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carrinho;

import com.bean.Produto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author bcustodio
 */
@WebServlet(name = "adicionar", urlPatterns = {"/adicionar"})
public class adicionar extends HttpServlet {
    @Override
    protected void service (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        HttpSession session = req.getSession();
        List carrinho = (List) session.getAttribute("carrinho");
        
        Produto produto = new Produto();
        
        if (carrinho == null) {
            List car = (List) produto.incluirCarrinho(carrinho);
            
            car.add(req.getParameter("idCliente"));
            
            session.setAttribute("carrinho", car);
            
            RequestDispatcher rd = req.getRequestDispatcher("/testecar.jsp");
            rd.forward(req,resp);
        } else {
            carrinho.add("<br>");
            carrinho.add(req.getParameter("idCliente"));
            
            session.setAttribute("carrinho", carrinho);

            RequestDispatcher rd = req.getRequestDispatcher("/testecar.jsp");
            rd.forward(req,resp);
        }
    }
}
