package com.bysj.socket;
import java.util.Date;
import java.util.HashMap;
import java.util.Objects;

import com.bysj.common.utils.DateUtils;
import com.bysj.common.utils.SpringUtils;
import com.bysj.dao.ChatRecordDao;
import com.bysj.entity.ChatRecord;
import com.bysj.entity.User;
import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.ConnectListener;
import com.corundumstudio.socketio.listener.DataListener;
import com.corundumstudio.socketio.listener.DisconnectListener;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.ContextLoader;

import javax.annotation.Resource;
import javax.websocket.server.ServerEndpoint;

/**
 * 描述:
 *
 * @author liuchong
 */
public class SocketListener implements ConnectListener, DisconnectListener, DataListener<SocketObject> {

    @Resource
    private ChatRecordDao chatRecordDao;


    private SocketIOServer server;

    public SocketListener(SocketIOServer server) {
        this.server = server;
    }



    @Override
    public void onConnect(SocketIOClient socketIOClient) {
        Integer clientSize = server.getAllClients().size();

        System.out.println("刚连上一个客户端，总共有" + clientSize + "客户端连接成功");
    }


    @Override
    public void onDisconnect(SocketIOClient socketIOClient) {
        Integer clientSize = server.getAllClients().size();
        System.out.println("刚离开一个客户端，总共有" + clientSize + "客户端连接成功");
    }

    @Override
    public void onData(SocketIOClient socketIOClient, SocketObject socketObject, AckRequest ackRequest) throws Exception {
        System.out.println( "发送：" + socketObject.getMessage());
        System.out.println(socketIOClient.getSessionId());

//        saveCharRecord(socketObject);

        SocketResponse socketResponse = new SocketResponse();
        socketResponse.setUserName(String.valueOf(socketObject.getUserId()));
        socketResponse.setSendTime(DateUtils.getDataString(new Date(), DateUtils.WHOLE_FORMAT));
        socketResponse.setMessage(socketObject.getMessage());

        this.server.getBroadcastOperations().sendEvent("chateEvent", socketResponse);
    }

    private void saveCharRecord(SocketObject socketObject) throws Exception {
        ChatRecord chatRecord = new ChatRecord();
        chatRecord.setContent(socketObject.getMessage());
        chatRecord.setTeamId(socketObject.getTeamId());
        chatRecord.setGmtCreate(new Date());
        chatRecord.setUserCreate(socketObject.getUserId());
        chatRecordDao.insert(chatRecord);
    }
}
