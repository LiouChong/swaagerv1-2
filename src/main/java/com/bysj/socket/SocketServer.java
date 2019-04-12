package com.bysj.socket;

import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketConfig;
import com.corundumstudio.socketio.SocketIOServer;

/**
 * 描述:
 *
 * @author liuchong
 */
public class SocketServer {
    public static void main(String[] args) {
        // 设置链接地址和端口
        Configuration config = new Configuration();
        config.setHostname("10.240.17.37");
        config.setPort(Integer.parseInt("8998"));

        SocketIOServer server = new SocketIOServer(config);

        SocketListener socketListener = new SocketListener(server);

        // 客户端连接上时触发
        server.addConnectListener(socketListener);

        server.addEventListener("chateEvent", SocketObject.class, socketListener);

        server.addDisconnectListener(socketListener);

        server.start();
    }


}
