package com.example.dugbang.twopi;


import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

/** 
 * Created by dugbang on 2017-10-28.
 */

public class SimpleSockterServer {
    static final int PORT = 8888;
    private static ServerSocket serverSocket;
    private static Socket socket;

    public static void main(String[] args) throws IOException {
        try {
            serverSocket = new ServerSocket(PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("console> ���� : Ŭ���̾�Ʈ�� ������ ��ٸ��ϴ�.");
        
//        StateRule stateRule = new StateRule();

//          ���� ������ ����� ������ ���ѷ���
        while(true) {
            System.out.println(getTime() + " �����û�� ��ٸ��ϴ�.");

            try {
                socket = serverSocket.accept();
                //System.out.println("console> ���� " + socket.getInetAddress() + " Ŭ���̾�Ʈ�� " +
                //        socket.getLocalPort() + " ��Ʈ�� ����Ǿ����ϴ�.");

                InputStream i_stream = socket.getInputStream();
                DataInputStream dis = new DataInputStream(i_stream);
                
                String line = dis.readUTF();
                int pos = line.indexOf(",");
                int blockId = Integer.parseInt(line.substring(pos+1));

                System.out.println("console> ���� response : " + line);
                System.out.println("blockId : " + blockId);
                
//                System.out.println(stateRule.insertBlock(blockId));
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                socket.close();
            }
        }
    }

    private static String getTime() {
        SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd_HH.mm.ss");
        return f.format(new Date());
    }
}
