package com.heynas;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * <p> Description:  SocketServer </p>
 * <pre> </pre>
 *
 * Copyright: © 2012-2017 Heynas Studio. All rights reserved.
 *
 * @author William
 * @version 1.0
 */
@ServerEndpoint("/getServer")
public class SocketServer {
    @OnOpen
    public void onOpen(Session session) {
        final RemoteEndpoint.Basic basic = session.getBasicRemote();
        System.out.println("pathParams:" + session.getPathParameters());
        System.out.println("requestParams" + session.getRequestParameterMap());
        try {
            basic.sendText("open success on server");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @OnMessage
    public String onMessage(Session session, String message) {
        final RemoteEndpoint.Basic basic = session.getBasicRemote();
        return "Got you msg !" + message;
    }

    @OnError
    public void onError(Throwable throwable, Session session) {
        System.out.print("onError" + throwable.toString());
    }

    @OnClose
    public void onClose(Session session) {
        System.out.print("onClose ");
    }
}
