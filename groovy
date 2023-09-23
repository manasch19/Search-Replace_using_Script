import java.util.Properties;
import com.boomi.execution.ExecutionUtil;
import java.io.InputStream;

 
logger = ExecutionUtil.getBaseLogger();
String stringToReplace = ExecutionUtil.getDynamicProcessProperty("MAXIMO_REST_INTERFACE_NAME");
logger.info("MAXIMO_REST_INTERFACE_NAME" + stringToReplace);
String stringToSearch = "MIMERIDIUMWS";

for( int i = 0; i < dataContext.getDataCount(); i++ ) {

  InputStream is = dataContext.getStream(i);

  Properties props = dataContext.getProperties(i);

  String dataText = is.text;
  String newDataText = dataText.replace(stringToSearch,stringToReplace);

  InputStream stream = new ByteArrayInputStream(newDataText.getBytes('UTF-8'));

  dataContext.storeStream(stream, props);

}
