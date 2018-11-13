package httpclient.test;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

public class HttpClientTest {

	@Test
	public void httpClient() throws Exception {
		CloseableHttpClient client = HttpClients.createDefault();
		String url = "https://www.jd.com";
		HttpGet get = new HttpGet(url);
		CloseableHttpResponse response = client.execute(get);
		HttpEntity entity = response.getEntity();
		String body = EntityUtils.toString(entity);
		File file = new File("d://jd.html");
		FileOutputStream out = new FileOutputStream(file);
		out.write(body.getBytes());
	}
}
