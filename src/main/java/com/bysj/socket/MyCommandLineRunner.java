package com.bysj.socket;

import com.corundumstudio.socketio.SocketIOServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 描述:
 *
 * @author liuchong
 */
@Component
@Order(value = 1)
public class MyCommandLineRunner implements CommandLineRunner {

    private final SocketIOServer server;

    @Autowired
    public MyCommandLineRunner(SocketIOServer socketIOServer) {
        this.server = socketIOServer;
    }

    @Override
    public void run(String... args) throws Exception {
        server.start();
        System.out.println("socket.io 启动成功");
    }
}
