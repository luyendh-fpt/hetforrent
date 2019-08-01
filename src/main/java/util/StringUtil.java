package util;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ResourceBundle;

public class StringUtil {

    private static ResourceBundle resourceBundle = ResourceBundle.getBundle("language");

    public static String convertInputStreamToString(InputStream inputStream) throws IOException {
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length;
        while ((length = inputStream.read(buffer)) != -1) {
            result.write(buffer, 0, length);
        }
        return result.toString(StandardCharsets.UTF_8.name());
    }

    public static String getBundle(String key) {
        return resourceBundle.getString(key);
    }

    public static void changeLanguage(HttpServletRequest request) {
        resourceBundle = ResourceBundle.getBundle("language");
        ServletContext context = request.getSession().getServletContext();
        context.setAttribute("bundle", resourceBundle);
    }
}
