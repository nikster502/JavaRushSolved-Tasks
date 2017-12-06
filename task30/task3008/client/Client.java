package com.javarush.task.task30.task3008.client;
import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;
import java.net.Socket;

public class Client {
    protected Connection connection;
    private volatile boolean clientConnected;
    public static void main(String[]args) {
            Client client = new Client();
            client.run();
    }

    public class SocketThread extends Thread{
protected void processIncomingMessage(String message){
ConsoleHelper.writeMessage(message);
}
protected void informAboutAddingNewUser(String userName){
    ConsoleHelper.writeMessage(userName+ " присоединился к чату");
}
protected void informAboutDeletingNewUser(String userName){
    ConsoleHelper.writeMessage(userName+ " покинул чат");
}
protected void notifyConnectionStatusChanged(boolean clientConnected){
    Client.this.clientConnected = clientConnected;
    synchronized (Client.this) {
        Client.this.notify();
    }
}

        protected void clientHandshake() throws IOException, ClassNotFoundException{
while (true){
    Message message = connection.receive();
    if (message.getType()==MessageType.NAME_REQUEST){
        String clientName = getUserName();
        connection.send( new Message(MessageType.USER_NAME,clientName));
    }
    else if(message.getType()==MessageType.NAME_ACCEPTED){
        notifyConnectionStatusChanged(true);
        return;
    }
    else{
        throw new IOException("Unexpected MessageType");
    }
}
        }
        protected void clientMainLoop() throws IOException, ClassNotFoundException{

            while (!Thread.currentThread().isInterrupted()){
                Message message = connection.receive();

                if (message.getType()== MessageType.TEXT){
                    processIncomingMessage(message.getData());
                }
                else if (message.getType()== MessageType.USER_ADDED){
                    informAboutAddingNewUser(message.getData());
                }
                else if (message.getType()== MessageType.USER_REMOVED){
                    informAboutDeletingNewUser(message.getData());
                }
                else{
                    throw new IOException("Unexpected MessageType");
                }
        }
    }

    public void run(){
String  ip = getServerAddress();
int port = getServerPort();
        try {
            Socket socket = new Socket(ip,port);
            Client.this.connection = new Connection(socket);

            clientHandshake();
            clientMainLoop();
        } catch (IOException e) {
            e.printStackTrace();
            notifyConnectionStatusChanged(false);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            notifyConnectionStatusChanged(false);
        }
    }
    }
    public void run() {
        SocketThread socketThread = getSocketThread();

        socketThread.setDaemon(true);

        socketThread.start();

        synchronized (this){
            try {
                this.wait();
            } catch (InterruptedException e) {
                ConsoleHelper.writeMessage("Выход из программы по ошибке.");
                return;
            }
        }
        if (clientConnected){
            ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду ‘exit’.");
        }
        else{
            ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
        }
        while (clientConnected) {
            String text = ConsoleHelper.readString();
            if (text.toLowerCase().equals("exit")){
                break;
            }
            if (shouldSendTextFromConsole() == true) {
                    sendTextMessage(text);

            }
        }
    }



   protected int getServerPort() {
        ConsoleHelper.writeMessage("Введите порт сервера:");
        return ConsoleHelper.readInt();
    }
    protected String getUserName() {
        ConsoleHelper.writeMessage("Введите имя пользователя:");
        return ConsoleHelper.readString();
    }
   protected boolean shouldSendTextFromConsole(){
        return true;
    }
   protected SocketThread getSocketThread(){
        return  new SocketThread();
    }
    protected void sendTextMessage(String text){
        try {
            connection.send(new Message(MessageType.TEXT,text));
        } catch (IOException e) {
            ConsoleHelper.writeMessage("Ошибка при отправке сообщения. Соединение будет закрыто.");
            clientConnected =false;
        }
    }
    protected String getServerAddress() {
        ConsoleHelper.writeMessage("Введите адрес сервера:");
        return ConsoleHelper.readString();
    }
}
