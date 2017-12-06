package com.javarush.task.task30.task3008.client;


import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class BotClient extends Client {

    public static void main(String [] args){
        BotClient botClient = new BotClient();
        botClient.run();
    }
    @Override
    protected String getUserName() {
        String botName = "date_bot_" + ((int)(Math.random()*100));
        return botName;
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    public class BotSocketThread extends  SocketThread{
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message){
            ConsoleHelper.writeMessage(message);
String[] messagePart = message.split(": ");
if (messagePart.length ==2) {
    String simpleDateFormat = null;
    String messageAuthor = messagePart[0];
    switch (messagePart[1].toLowerCase()) {

        case "дата":
            simpleDateFormat = "d.MM.YYYY";
            break;
        case "день":
            simpleDateFormat = "d";
            break;
        case "месяц":
            simpleDateFormat = "MMMM";
            break;
        case "год":
            simpleDateFormat = "YYYY";
            break;
        case "время":
            simpleDateFormat = "H:mm:ss";
            break;
        case "час":
            simpleDateFormat = "H";
            break;
        case "минуты":
            simpleDateFormat = "m";
            break;
        case "секунды":
            simpleDateFormat = "s";
            break;
    }

    if (simpleDateFormat != null) {
        String reply = String.format("Информация для %s: %s",
                messageAuthor,
                new SimpleDateFormat(simpleDateFormat).format(Calendar.getInstance().getTime())
        );

            sendTextMessage(reply);

    }
}
        }
    }
}
