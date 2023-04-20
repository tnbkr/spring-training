package com.tunebaker;

public class ConsoleEventLogger implements EventLogger{
    @Override
    public void logEvent(Event event){
        System.out.println(event);
    }
}
