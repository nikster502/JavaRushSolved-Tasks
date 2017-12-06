package com.javarush.task.task30.task3008.client;

/**
 * Created by nik on 17.07.2017.
 */
public class ClientGuiController extends Client {
    private ClientGuiModel model;
    private ClientGuiView view;
    //21.7.
    public static void main(String[] args) {
        ClientGuiController controller = new ClientGuiController();
        controller.run();
    }
    public ClientGuiModel getModel(){
        return model;
    }
    @Override
    protected String getUserName() {
        return view.getUserName();
    }

    @Override
    protected int getServerPort() {
        return view.getServerPort();
    }

    @Override
    protected String getServerAddress() {
        return view.getServerAddress();
    }

    @Override
    public void run() {
        SocketThread socketThread = getSocketThread();
        socketThread.run();
    }

    @Override
    protected SocketThread getSocketThread() {
        return new GuiSocketThread();
    }

    public ClientGuiController() {
        model = new ClientGuiModel();
        view = new ClientGuiView(this);
    }

    public class GuiSocketThread extends SocketThread {
        @Override
        protected void processIncomingMessage(String message) {
            model.setNewMessage(message);
            view.refreshMessages();
        }

        @Override
        protected void informAboutAddingNewUser(String userName) {
            model.addUser(userName);
            view.refreshUsers();
        }

        @Override
        protected void informAboutDeletingNewUser(String userName) {
            model.deleteUser(userName);
            view.refreshUsers();
        }

        @Override
        protected void notifyConnectionStatusChanged(boolean clientConnected) {
            view.notifyConnectionStatusChanged(clientConnected);
        }
    }

}