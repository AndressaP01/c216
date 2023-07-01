package br.inatel.labs.labmqtt.client;

import java.util.UUID;

import org.eclipse.paho.client.mqttv3.MqttClient;

public class SensorTemperaturaSubscriber {

	
	public static void main(String[] args) {
		
		
		String subscriberId = UUID.randomUUID().toString();
		MqttClient subscriber = new MqttClient( MyConstants.URI_BROKER, subscriberId);
		
		MqttConnectOptions options = new MqttConnectOptions();
		options.setAutomaticReconnect(true);
		options.setCleanSession(true);
		options.setConnectionTimeout(10);
		subscriber.connect(options);
		
		subscriber.subscribe(MyConstants.TOPIC_1, (topic, msg) -> {
        byte[] payload = msg.getPayload();
	    System.out.println( "Payload recebido: " + payload );
	    System.out.println( "Topico recebido: " + topic );
		
	}
	
	
	
}
