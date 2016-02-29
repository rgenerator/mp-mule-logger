package com.myplay.esb.connectors.mlogger;

import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.Required;
import org.mule.api.MuleEvent;
import org.mule.api.annotations.Connector;
import org.mule.api.annotations.Processor;
import org.mule.api.annotations.param.Default;
import org.mule.api.annotations.param.Payload;

@Connector(name="mlogger", friendlyName="Mlogger", schemaVersion = "1.0")
public class MloggerConnector {

	private Logger logger = Logger.getLogger(MloggerConnector.class);

	@Processor
	public String log(
			@Required String level,
			@Default("") String message,
			MuleEvent muleEvent,
			@Payload String payload,
			Map<String, String> entry) throws Exception {

		LogMessageBuilder builder = new LogMessageBuilder();	

		if (message != null && !message.isEmpty()) {
			builder.addText(message);
		}

		builder.addPair("message_id", muleEvent.getMessage().getUniqueId());

		for (Map.Entry<String, String> e : entry.entrySet()) {
			builder.addPair(e.getKey(), e.getValue());
		}

		switch (level) {
			case "DEBUG":
                logger.debug(builder.build());
				break;
			case "INFO":
                logger.info(builder.build());
				break;
			case "WARN":
                logger.warn(builder.build());
				break;
            case "ERROR":
                logger.error(builder.build());
                break;
            default:
            	throw new IllegalArgumentException("Log level can be BEBUG, INFO, WARN or ERROR, but \"" + level + "\" passed.");
		}

		return payload;
	}
}
