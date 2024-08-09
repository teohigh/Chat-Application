package com.example.chat_backend.configuration;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)
public class WebSocketEventListener {
    SimpMessageSendingOperations messagingTemplate;

     @EventListener // this annotation is used to listen to the events
     public void handleWebSocketConnectListener(SessionConnectedEvent event) {
         // Log a message when a new web socket connection is established
            log.info("Received a new web socket connection");
     }

     @EventListener
     public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
         // Log a message when a web socket connection is closed
            log.info("Web socket connection closed");

     }
}
