package admin;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.Ref;
import entity.Article;
import entity.Category;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

import static com.googlecode.objectify.ObjectifyService.ofy;

public class ListArticleController extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(ListArticleController.class.getSimpleName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("articles", ofy().load().type(Article.class)
                .filter("category", Ref.create(Key.create(Category.class, 1564492405495L)))
                .list());
        req.getRequestDispatcher("/admin/article/list.jsp").forward(req, resp);
    }
}
