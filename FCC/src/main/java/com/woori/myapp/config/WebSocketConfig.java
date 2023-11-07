package com.woori.myapp.config;
 
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;


import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
  
@Configuration 
@EnableWebSocketMessageBroker  //소켓을 사용하겠다. 
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer{
	//기본설정을 담당한다. 
	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		//topic 은 한명이 message 를 발행했을 때 해당 토픽을 구독하고 있는 n명에게 메세지를 뿌려야 하는 경우에 사용
		// /queue 는 한명이 message 를 발행했을 때 발행한 한 명에게 다시 정보를 보내는 경우에 사용합니다. 저는
		
		//전체에게 보낸다 
		registry.enableSimpleBroker("/topic");
		registry.setApplicationDestinationPrefixes("/app"); //html문서의 자바스크립트
	}
	
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/aaawebsocket");
	}

}




