package com.bysj.socket;

import com.bysj.common.utils.DateUtils;
import com.bysj.dao.ChatRecordDao;
import com.bysj.entity.ChatRecord;
import com.bysj.entity.User;
import com.bysj.entity.vo.request.SocketRequest;
import com.bysj.entity.vo.response.SocketResponse;
import com.bysj.service.IChatRecordService;
import com.bysj.service.IUserService;
import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.OnConnect;
import com.corundumstudio.socketio.annotation.OnDisconnect;
import com.corundumstudio.socketio.annotation.OnEvent;
import org.apache.shiro.authz.UnauthenticatedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

/**
 * 描述:
 *
 * @author liuchong
 */
@Component
public class MessageEventHandler {
    public static SocketIOServer socketIOServer;
    public static IChatRecordService chatRecordService;
    public static IUserService userService;
    static ArrayList<UUID> listClient = new ArrayList<>();

    static final int limitSeconds = 60;

    @Autowired
    public MessageEventHandler(SocketIOServer server, IChatRecordService service, IUserService userService) {
        socketIOServer = server;
        chatRecordService = service;
        MessageEventHandler.userService = userService;
    }

    @OnConnect
    public void onConnect(SocketIOClient client) {
        listClient.add(client.getSessionId());
        System.out.println("客户端：" + client.getSessionId());
    }

    @OnDisconnect
    public void onDisConnect(SocketIOClient client) {
        System.out.println("客户端：" + client.getSessionId() + "断开连接");
    }

    @OnEvent(value = "chateEvent")
    public void onEvent(SocketIOClient client, AckRequest request, SocketRequest data) throws Exception {
        User user = userService.getById(data.getUserId());
        SocketResponse socketResponse = new SocketResponse();
        socketResponse.setUserName(user.getNickname());
        socketResponse.setSendTime(DateUtils.getDataString(new Date(), DateUtils.WHOLE_FORMAT));
        socketResponse.setMessage(data.getMessage());
        saveChatRecord(data);

        socketIOServer.getBroadcastOperations().sendEvent("chateEvent", socketResponse);
    }

    private void saveChatRecord(SocketRequest request) throws Exception {
        ChatRecord chatRecord = new ChatRecord();
        chatRecord.setContent(request.getMessage());
        chatRecord.setTeamId(request.getTeamId());
        chatRecord.setGmtCreate(new Date());
        chatRecord.setUserCreate(request.getUserId());

        chatRecordService.save(chatRecord);
    }
}
