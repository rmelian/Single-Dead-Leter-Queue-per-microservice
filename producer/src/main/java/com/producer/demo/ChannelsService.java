package com.producer.demo;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author Raisel Melian raisel.melian@gmail.com
 */
public interface ChannelsService {

    String output = "order";

    @Input
    MessageChannel order();

}
