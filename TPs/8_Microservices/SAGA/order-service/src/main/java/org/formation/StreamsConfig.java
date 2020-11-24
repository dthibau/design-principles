package org.formation;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBinding(OrderStream.class)
public class StreamsConfig {

}
