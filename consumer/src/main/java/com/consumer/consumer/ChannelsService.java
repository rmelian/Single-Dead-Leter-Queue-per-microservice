package com.consumer.consumer;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author Raisel Melian raisel.melian@gmail.com
 */
public interface ChannelsService {


    String CONSUME_ORDER_CHANGE = "consumeOrderChange";

    @Input
    SubscribableChannel consumeOrderChange();


    String CONSUME_ORDER_STATUS_CHANGE = "consumeOrderStatusChange";

    @Input
    SubscribableChannel consumeOrderStatusChange();

}
