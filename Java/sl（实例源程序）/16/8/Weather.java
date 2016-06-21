package com.mingrisoft;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Weather extends Thread { // �����ࡣ����Ϊ���߳�ִ�г���
    String weather = "��ĿԤ�����˵��д�����ᣬ������";
    int port = 9898; // ����˿�
    InetAddress iaddress = null; // ����InetAddress����
    MulticastSocket socket = null; // �������㲥�׽���
    
    Weather() { // ���췽��
        try {
            iaddress = InetAddress.getByName("224.255.10.0"); // ʵ����InetAddress��ָ����ַ
            socket = new MulticastSocket(port); // ʵ�������㲥�׽���
            socket.setTimeToLive(1); // ָ�����ͷ�Χ�Ǳ�������
            socket.joinGroup(iaddress); // ����㲥��
        } catch (Exception e) {
            e.printStackTrace(); // ����쳣��Ϣ
        }
    }
    
    public void run() { // run()����
        while (true) {
            DatagramPacket packet = null; // ����DatagramPacket����
            byte data[] = weather.getBytes(); // �����ֽ�����
            packet = new DatagramPacket(data, data.length, iaddress, port); // �����ݴ��
            System.out.println(new String(data)); // ���㲥��Ϣ���
            try {
                socket.send(packet); // ��������
                sleep(3000); // �߳�����
            } catch (Exception e) {
                e.printStackTrace(); // ����쳣��Ϣ
            }
        }
    }
    
    public static void main(String[] args) { // ������
        Weather w = new Weather(); // �����������
        w.start(); // �����߳�
    }
}
