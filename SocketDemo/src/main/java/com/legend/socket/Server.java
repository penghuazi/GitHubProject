package com.legend.socket;

/**
 * Created by dell-pc on 2017/9/3.
 */
//import com.legend.dao.AmmeterDeviceMapper;
//import com.legend.dao.AmmeterWorkingInfoMapper;
import com.legend.dao.domain.AmmeterDevice;
import com.legend.service.AmmeterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

@Component
public class Server {
    public static final int SOCKET_PORT  =20177;//监听的端口号
    private final static Logger logger = LoggerFactory.getLogger(Server.class);

    @Autowired
    private  AmmeterService ammeterService;

//    @Autowired
//    private AmmeterWorkingInfoMapper ammeterWorkingInfoMapper;
//    @Autowired
//    private AmmeterDeviceMapper ammeterDeviceMapper;

//    static {
//        System.out.println("Socket 服务器启动...\n"+SOCKET_PORT);
//        new Thread(()->
//        {
//                Server server = new Server();
//                server.init(ammeterService);
//
//        }).start();
//    }
    @Autowired
    private void startServer(){
            System.out.println("Socket 服务器启动...\n"+SOCKET_PORT);
            new Thread(()->
            {
                Server server = new Server();
                server.init(ammeterService);

            }).start();
    }

//    public static void main(String[] args) {
//        System.out.println("服务器启动...\n");
//        Server server = new Server();
//        server.init(new AmmeterService());
//    }

    public void init(AmmeterService ammeterService) {
        try {
            ServerSocket serverSocket = new ServerSocket(SOCKET_PORT);
            while (true) {
                // 一旦有堵塞, 则表示服务器与客户端获得了连接
                Socket client = serverSocket.accept();
                System.out.println("=======================");
                // 处理这次连接
                new HandlerThread(client,ammeterService);
            }
        } catch (Exception e) {
            System.out.println("服务器异常: " + e.getMessage());
        }
    }

    private class HandlerThread implements Runnable {
        private Socket socket;
        private AmmeterService service;
        public HandlerThread(Socket client,AmmeterService ammeterService) {
            socket = client;
            service = ammeterService;
            new Thread(this).start();
        }

        public void run() {
            try {
                System.out.println("Ip:"+socket.getInetAddress()+"");
                logger.info("Ip2:"+socket.getInetAddress().getHostAddress());
                // 读取客户端数据
                DataInputStream input = new DataInputStream(socket.getInputStream());
                String clientInputStr = input.readUTF();//这里要注意和客户端输出流的写方法对应,否则会抛 EOFException
                // 处理客户端数据
                System.out.println("客户端发过来的内容:" + clientInputStr);
                AmmeterDevice device = new AmmeterDevice();
                device.setInputMsg(clientInputStr);
                device.setAddress(socket.getInetAddress().getHostAddress());
                //更新客户端的推送信息进数据库
                String response =service.updateAmmeterDevice(device);
                // 向客户端回复信息
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                out.writeUTF(response);
                out.close();
                input.close();
                logger.info("线程操作结束"+clientInputStr);
            } catch (Exception e) {
                System.out.println("服务器 run 异常: " + e.getMessage());
            } finally {
                if (socket != null) {
                    try {
                        socket.close();
                        logger.info("线程操作结束----关闭socket");
                    } catch (Exception e) {
                        socket = null;
                        System.out.println("服务端 finally 异常:" + e.getMessage());
                    }
                }
            }
        }
    }
}
