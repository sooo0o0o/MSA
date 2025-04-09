package kr.co.tkdenddl1324.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "my-topic-01", groupId = "group-my-topic-01")
    public void topic01Consume(ConsumerRecord<String, String> record) {
        log.info("Topic01Consume....");

        log.info(record.key()+"-"+record.value());
    }

    @KafkaListener(topics = "my-topic-02", groupId = "group-my-topic-02")
    public void topic02Consume(ConsumerRecord<String, String> record) {
        log.info("Topic02Consume....");

        log.info(record.key()+"-"+record.value());
    }

    @KafkaListener(topics = "my-topic-03", groupId = "group-my-topic-03")
    public void topic03Consume1(ConsumerRecord<String, String> record) {
        log.info("Topic03Consume....");

        log.info(record.key()+"-"+record.value());
    }
    @KafkaListener(topics = "my-topic-03", groupId = "group-my-topic-03")
    public void topic03Consume2(ConsumerRecord<String, String> record) {
        log.info("Topic03Consume....");

        log.info(record.key()+"-"+record.value());
    }
    @KafkaListener(topics = "my-topic-03", groupId = "group-my-topic-03")
    public void topic03Consume3(ConsumerRecord<String, String> record) {
        log.info("Topic03Consume....");

        log.info(record.key()+"-"+record.value());
    }



}
