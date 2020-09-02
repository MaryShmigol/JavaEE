package ua.kiev.prog;

import javax.servlet.http.HttpServlet;

public class PrivateChatServlet extends HttpServlet {

    private MessageList messageList = MessageList.getInstance();


}
