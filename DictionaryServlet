package edu.cs.mum;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@WebServlet(
        name = "onlineDictionaryServlet",
        urlPatterns = {"/online/servlet/servlet"}
)
public class DictServlet  extends HttpServlet {
    ObjectMapper mapper = new ObjectMapper();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String searchWord = req.getParameter("q");
        List<Dictionary> dictionary = getDictionary(searchWord);
        String jsonObject = mapper.writeValueAsString(dictionary);
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        out.print(jsonObject);
        out.flush();
    }

    private List<Dictionary> getDictionary(String searchWord){
        List<Dictionary> dictionaries = new ArrayList<Dictionary>();
        Connection con = (Connection) getServletContext().getAttribute("DBConnection");
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement("select * from entries  where word=? OR wordtype=? OR definition=?");
            ps.setString(1,searchWord);
            ps.setString(2,searchWord);
            ps.setString(3,searchWord);
            rs = ps.executeQuery();

            while (rs.next()) {
                Dictionary dictionary = new Dictionary(rs.getString("word"),
                        rs.getString("wordtype"), rs.getString("definition"));

                System.out.println(dictionary);
                dictionaries.add(dictionary);
            }
        }catch (Exception ex){
            System.out.println(ex);
        }
        return dictionaries;
    }
}
