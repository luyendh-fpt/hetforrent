package admin;

import com.google.gson.Gson;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.Ref;
import dto.ArticleDto;
import entity.Article;
import entity.Category;
import util.StringUtil;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.NumberFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.googlecode.objectify.ObjectifyService.ofy;

public class ArticleController extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(ArticleController.class.getSimpleName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        sendSimpleMail(req.getParameter("email"));
//        resp.setContentType("application/json");
//        resp.setCharacterEncoding("UTF-8");
//        System.out.println(StringUtil.getBundle("hello"));
//        resp.getWriter().println(StringUtil.getBundle("hello"));
//        req.setAttribute("categories", ofy().load().type(Category.class).list());
//        req.getRequestDispatcher("/admin/article/form.jsp").forward(req, resp);
//        final String username = "";
//        final String password = "";
//
//        Properties prop = new Properties();
//        prop.put("mail.smtp.host", "smtp.gmail.com");
//        prop.put("mail.smtp.port", "587");
//        prop.put("mail.smtp.auth", "true");
//        prop.put("mail.smtp.starttls.enable", "true"); //TLS
//
//        Session session = Session.getInstance(prop,
//                new javax.mail.Authenticator() {
//                    protected PasswordAuthentication getPasswordAuthentication() {
//                        return new PasswordAuthentication(username, password);
//                    }
//                });
//
//        try {
//
//            MimeMessage message = new MimeMessage(session);
//            message.setFrom(new InternetAddress(username, "Hello World"));
//            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(req.getParameter("email"), false));
//            message.setReplyTo(InternetAddress.parse(username, false));
//            message.setSubject("Testing Gmail TLS", "UTF-8");
//            message.setContent("<b>Dear Mail Crawler</b>", "text/html; charset=utf-8");
//            message.setSentDate(new Date());
//            System.out.println("Message is ready");
//            Transport.send(message);
//            System.out.println("Done");
//        } catch (Exception e) {
//            LOGGER.log(Level.SEVERE, "Error when send mail!", e);
//        }
    }

    private void sendSimpleMail(String to) {
        // [START simple_example]
        Properties props = new Properties();
        Session session = Session.getDefaultInstance(props, null);

        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("luyendh@fpt.edu.vn", "Example.com Admin"));
            msg.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(to, "Mr. User"));
            msg.setSubject("Your Example.com account has been activated");
            msg.setText("This is a test");
            Transport.send(msg);
        } catch (AddressException e) {
            // ...
        } catch (MessagingException e) {
            // ...
        } catch (UnsupportedEncodingException e) {
            // ...
        }
        // [END simple_example]
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getParameter("url");
        String title = req.getParameter("title");
        String description = req.getParameter("description");
        String content = req.getParameter("content");
        String strCategoryId = req.getParameter("categoryId");
//        long categoryId = 0;
//        try {
//            categoryId = Long.parseLong(strCategoryId);
//        } catch (NumberFormatException ex) {
//            LOGGER.warning("Can not parse categoryId.");
//            LOGGER.warning(ex.getMessage());
//        }
        Article article = Article.Builder.anArticle()
                .withUrl(url)
                .withTitle(title)
                .withDescription(description)
                .withContent(content)
                .withCategory(Ref.create(Key.create(Category.class, strCategoryId)))
                .build();
        ofy().save().entity(article).now();
        resp.getWriter().println("Okie");
    }
}
