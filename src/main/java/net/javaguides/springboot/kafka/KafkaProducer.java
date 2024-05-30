package net.javaguides.springboot.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class KafkaProducer {
	public static final Logger LOGGER = LoggerFactory. getLogger(KafkaProducer.class);
	
	private KafkaTemplate<String, String> kafkaTemplate;

	public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) { //If we don't use Spring boot then we have to explicitly configure KafkaTemplate
		super();
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public void sendMessage(String message) {
		LOGGER.info(String.format("Message Sent : %s ", message));
		kafkaTemplate.send("javaguides", message);
	}
}
