package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by nik on 16.07.2017.
 */
public class Server {
  final private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();
    public static void sendBroadcastMessage(Message message){
for (String k: connectionMap.keySet()){
    try {
connectionMap.get(k).send(message);
}
        catch (IOException e){
        }
}
    }
    public static void main(String[] args) throws IOException {
        ConsoleHelper consoleHelper = new ConsoleHelper();
try( ServerSocket serverSocket = new ServerSocket(consoleHelper.readInt())) {
    System.out.println("Сервер запущен");
    while (true){
        new Handler(serverSocket.accept()).start();
    }
}catch (Exception e){
    System.out.println(e);
}


    }

    private static class Handler extends Thread {
        private Socket socket;
      public Handler(Socket socket){
          super();
            this.socket = socket;

        }

        @Override
        public void run() {
            ConsoleHelper.writeMessage("Установлено соединение с удаленным клиентом с адресом: " +
                    socket.getRemoteSocketAddress());
            Connection connection= null;
            String userName = null;

            try {

                connection = new Connection(socket);

                userName= serverHandshake(connection);

                sendBroadcastMessage(new Message(MessageType.USER_ADDED,userName));

                sendListOfUsers(connection,userName);

                serverMainLoop(connection,userName);


            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(userName!=null){
                connectionMap.remove(userName);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED,userName));
            }
            ConsoleHelper.writeMessage(String.format("Соеденение с удаленным адремом(%s) закрыто", socket.getRemoteSocketAddress()));
        }
        private void sendListOfUsers(Connection connection, String userName)throws IOException{
            for (String k : connectionMap.keySet()){
                if (!k.equals(userName)){
                    connection.send(new Message(MessageType.USER_ADDED, k));
                }
            }
        }
        private   void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException{
            while (true) {
                Message message = connection.receive();
                if (message.getType() == MessageType.TEXT){
                    String m = userName+": " + message.getData();
                    sendBroadcastMessage(new Message(MessageType.TEXT,m));
                }
                else ConsoleHelper.writeMessage("Ошибка! Недопустимый тип сообщения от клиента: "+userName);
            }

        }
        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException{
            while (true){
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message message = connection.receive();

                if (message.getType().equals(MessageType.USER_NAME)){
                    String  name = message.getData();

                    if (!name.isEmpty()&& connectionMap.get(name)==null){
                        connectionMap.put(name,connection);
                        connection.send(new Message(MessageType.NAME_ACCEPTED));
                        return name;
                    }
                }}
        }
    }
    }

