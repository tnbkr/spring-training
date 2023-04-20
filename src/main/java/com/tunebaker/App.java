package com.tunebaker;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class App {
    private Client client;
    private ConsoleEventLogger eventLogger;

    public App(Client client, ConsoleEventLogger eventLogger) {
        this.client = client;
        this.eventLogger = eventLogger;
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/camel-context.xml");
        App app = context.getBean("app", App.class);
        /*app.logEvent("Some message for user 1");
        app.logEvent("Some message for user 2");*/

    }

    private void logEvent(String msg){
        String message = msg.replaceAll(client.getId(), client.getFullName());
        eventLogger.logEvent(message);
    }
}
