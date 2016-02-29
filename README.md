### Mlogger - custom logger for Mule ESB

### Mule supported versions
Mule 3.7.3

### Installation

* Checkout the repo
* Run `mvn install`
* Add this to a app pom.xml file
```xml
<dependency>
    <groupId>com.myplay.esb.connectors</groupId>
    <artifactId>mlogger</artifactId>
    <version>1.0.0</version>
</dependency>
```

### Usage example

```xml
<mlogger:log level="INFO" message="Optional message" doc:name="Logging">
    <mlogger:entry>
        <mlogger:entry key="query" value-ref="#[message.inboundProperties['http.query.params']['query']]" />
        <mlogger:entry key="payload" value-ref="#[payload]" />
    </mlogger:entry>
</mlogger:log>
```

It logs

```
INFO  2016-02-29 11:18:41,188 [[app].HTTP_Listener_Configuration.worker.01] com.myplay.esb.connectors.mlogger.MloggerConnector: Optional message message_id="18b00110-df00-11e5-b49c-985aebd2b5df" query="one" payload="{\"one\": \"1\", \"two\": \"2\"}"
```
