package com.example.chat_backend.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker // Enable WebSocket message handling, backed by a message broker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // Register a websocket endpoint that the clients will use to connect to our websocket server
        registry.addEndpoint("/ws").setAllowedOriginPatterns("*").withSockJS(); // SockJS is used to enable fallback options for browsers that don't support websocket
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // Configure the message broker
        registry.setApplicationDestinationPrefixes("/app");
        // Enable a simple memory-based message broker to carry the messages back to the client on destinations prefixed with /chatroom
        registry.enableSimpleBroker("/chatroom","/user");
        // Use the /user prefix to define user destinations
        registry.setUserDestinationPrefix("/user");
    }

}
