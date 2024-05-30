package net.javaguides.springboot.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
	public NewTopic javaGuidesTopic() {
		return TopicBuilder.name("javaguides")
//				.partitions(10) // we use default provided by Kafka
				.build();
	}

	public NewTopic javaGuidesJsonTopic() {
		return TopicBuilder.name("javaguides_json")
				.build();
	}
}
