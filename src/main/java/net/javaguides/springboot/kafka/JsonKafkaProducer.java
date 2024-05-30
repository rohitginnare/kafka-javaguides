package net.javaguides.springboot.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.model.User;

@Service
public class JsonKafkaProducer {
	private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);
	KafkaTemplate<String, User> kafkaTemplate;
	
	public JsonKafkaProducer(KafkaTemplate<String, User> kafkaTemplate) {
		super();
		this.kafkaTemplate = kafkaTemplate;
	}

	public void sendMessage(User data) {
		LOGGER.info(String.format("Message Sent : %s", data.toString()));
		Message<User> message = MessageBuilder
				.withPayload(data)
				.setHeader(KafkaHeaders.TOPIC, "javaguides_json")
				.build();
		
		kafkaTemplate.send(message);
	}
}