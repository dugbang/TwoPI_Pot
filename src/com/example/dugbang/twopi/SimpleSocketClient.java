package com.example.dugbang.twopi;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by dugbang on 2017-10-28.
 */

public class SimpleSocketClient {
    private static int PORT = 8888;
    private static Socket socket;
    private static String address;

    public SimpleSocketClient(String address) {
    	this.address = address;
    }

    public static void send(String str) {
        try {
//            socket = new Socket("localhost", PORT);
//          socket = new Socket("192.168.0.37", PORT);
            socket = new Socket(address, PORT);
            OutputStream o_stream = socket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(o_stream);
            dos.writeUTF(str);
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    public static void main(String[] args) {
    /*
        send("Ŭ���̾�Ʈ �Ʒ�;�ӾƤ�; �޽����Դϴ�.");
        System.out.println("���α׷� ����");

        open();
        send("Ŭ���̾�Ʈ���� (...�ȵ���̵� ��Ʃ���...) ������ �޽����Դϴ�.");

        try {
//          ���� ����
            socket = new Socket("localhost", PORT);
            System.out.println("console> PORT(" + PORT + ") �� ������ �õ��մϴ�.");

            OutputStream o_stream = socket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(o_stream);
            dos.writeUTF("Ŭ���̾�Ʈ���� (�ȵ���̵� ��Ʃ���) ������ �޽����Դϴ�.");

//          ���� ����
            socket.close();
//          ���α׷� ����
            System.exit(0);

//        ����ó��
        } catch (Exception e) {
            e.printStackTrace();
        }
    */
    }
}
