package zyj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer { // ������MyTcp
    private BufferedReader reader; // ����BufferedReader����
    private ServerSocket server; // ����ServerSocket����
    private Socket socket; // ����Socket����socket
    
    void getserver() {
        try {
            server = new ServerSocket(8998); // ʵ����Socket����
            System.out.println("�������׽����Ѿ������ɹ�"); // �����Ϣ
            while (true) { // ����׽���������״̬
                System.out.println("�ȴ��ͻ���������"); // �����Ϣ
                socket = server.accept(); // ʵ����Socket����
                reader = new BufferedReader(new InputStreamReader(socket
                        .getInputStream())); // ʵ����BufferedReader����
                getClientMessage(); // ����getClientMessage()����
            }
        } catch (Exception e) {
            e.printStackTrace(); // ����쳣��Ϣ
        }
    }
    
    private void getClientMessage() {
        try {
            while (true) { // ����׽���������״̬
                System.out.println("�ͻ���:" + reader.readLine()); // ��ÿͻ�����Ϣ
            }
        } catch (Exception e) {
            e.printStackTrace(); // ����쳣��Ϣ
        }
        try {
            if (reader != null) {
                reader.close(); // �ر���
            }
            if (socket != null) {
                socket.close(); // �ر��׽���
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) { // ������
        MyServer tcp = new MyServer(); // �����������
        tcp.getserver(); // ���÷���
    }
}

