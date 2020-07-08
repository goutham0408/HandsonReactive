package com.bezkoder.spring.data.cassandra.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoggingController {
    Logger logger = LoggerFactory.getLogger(LoggingController.class);
    
    @RequestMapping("/")
    public String index() {
    	for(int i=0;i<100;i++) {
        logger.trace("A TRACE Message");
        logger.debug("A DEBUG Message");
        logger.info("An INFO Message");
        logger.warn("A WARN Message");
        logger.error("An ERROR Message");
    	}
        return "Goutham! Check out the Logs to see the output...";
    }

}
