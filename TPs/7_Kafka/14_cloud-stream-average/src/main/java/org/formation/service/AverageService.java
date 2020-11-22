package org.formation.service;

import java.util.logging.Logger;

import org.formation.AverageStream;
import org.formation.model.Position;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;


@Service
public class AverageService {
    private final AverageStream averagesStream;

    Logger log = Logger.getLogger(AverageService.class.getName());
    
    public AverageService(AverageStream averagesStream) {
        this.averagesStream = averagesStream;
    }

    public void sendAverage(final Position averagePosition) {
        log.info("Sending average " + averagePosition);
        
       // A compléter

    }
}
