### Mplog - custom logger for Mule ESB

### Mule supported versions
Mule 3.7.3

### Installation

* Checkout the repo
* Run `mvn install`
* Add this to a app pom.xml file
```xml
<dependency>
    <groupId>com.myplay.mule.connectors</groupId>
    <artifactId>mplog</artifactId>
    <version>1.0.0</version>
</dependency>
```

### Usage example

Add the namespace an the schema location to the root element of your config:
```xml
<mule xmlns:mplog="http://www.mulesoft.org/schema/mule/mplog"
    ...
    xsi:schemaLocation="... http://www.mulesoft.org/schema/mule/mplog http://www.mulesoft.org/schema/mule/mplog/current/mule-mplog.xsd">
```

You log using this elements:
```xml
<mplog:log level="INFO" message="Optional message" doc:name="Logging">
    <mplog:entry>
        <mplog:entry key="query" value-ref="#[message.inboundProperties['http.query.params']['query']]" />
        <mplog:entry key="payload" value-ref="#[payload]" />
    </mplog:entry>
</mplog:log>
```

It logs

```
INFO  2016-02-29 11:18:41,188 [[app].HTTP_Listener_Configuration.worker.01] com.myplay.esb.connectors.mplog.MplogConnector: Optional message message_id="18b00110-df00-11e5-b49c-985aebd2b5df" query="one" payload="{\"one\": \"1\", \"two\": \"2\"}"
```
