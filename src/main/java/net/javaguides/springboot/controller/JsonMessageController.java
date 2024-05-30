package net.javaguides.springboot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.kafka.JsonKafkaProducer;
import net.javaguides.springboot.model.User;

@RestController
@RequestMapping("api/v1/kafka")
public class JsonMessageController {
	private JsonKafkaProducer kafkaProducer;

	public JsonMessageController(JsonKafkaProducer kafkaProducer) { // we don't need to use @Autowired, if we have only one constructor in spring bean
		super();
		this.kafkaProducer = kafkaProducer;
	}
	
	
//	http://localhost:8080/api/v1/kafka/publish
	@PostMapping("/publish")
	public ResponseEntity<String> publish(@RequestBody User data){
		kafkaProducer.sendMessage(data);
		return ResponseEntity.ok("JSON Message sent to Kafka topic successfully");
	}
	
}
