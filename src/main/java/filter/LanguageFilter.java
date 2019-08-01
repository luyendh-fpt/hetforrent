package filter;

import com.googlecode.objectify.ObjectifyService;
import entity.Article;
import entity.Category;
import entity.CrawlerSource;
import util.StringUtil;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Locale;

public class LanguageFilter implements Filter {

    private static String currentLanguage = Locale.getDefault().getLanguage();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Current lang: "+ currentLanguage);
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String language = (String) request.getSession().getAttribute("lang");
        System.out.println("lang: "+ language);
        if (language != null && !language.equals(currentLanguage)) {
            System.out.println("Change resource.");
            Locale.setDefault(new Locale(language));
            currentLanguage = language;
            StringUtil.changeLanguage(request);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
