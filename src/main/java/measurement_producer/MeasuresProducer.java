package measurement_producer;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;

import java.util.List;

public class MeasuresProducer {
    private final static String QUEUE_NAME = "get_measurements";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            List<Message> messageList = GetMeasures.getMeasures();
            for(Message message: messageList){
                channel.basicPublish("", QUEUE_NAME, null, message.toString().getBytes());
                System.out.println(" [x] Sent '" + message + "'");
            }
        }
    }
}

