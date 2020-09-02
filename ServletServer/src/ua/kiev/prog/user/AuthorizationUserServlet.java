package ua.kiev.prog.user;

import ua.kiev.prog.AddServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.nio.charset.StandardCharsets.*;
import static javax.servlet.http.HttpServletResponse.*;

public class AuthorizationUserServlet extends HttpServlet {

    private UserList userList = UserList.getInstance();
    AddServlet addServlet = new AddServlet();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        byte[] buf = addServlet.requestBodyToArray(request);
        String bufStr = new String(buf, UTF_8);

        User user = User.fromJSON(bufStr);
        addUser(request, response, user);
    }

    private User getUserFromList(User user) {
        for (User userFromList : userList.getList()) {
            if (userFromList.getLogin().equals(user.getLogin())
                    || userFromList.getPassword().equals(user.getPassword())) {
                return userFromList;
            }
        }
        return null;
    }

    private void addUser(HttpServletRequest request,
                         HttpServletResponse response,
                         User user) {

        boolean newUser = Boolean.parseBoolean(request.getParameter("newUser"));

        if (newUser) {
            if (getUserFromList(user) == null) {
                userList.add(user);
            } else response.setStatus(SC_BAD_REQUEST);
        }
    }
}
