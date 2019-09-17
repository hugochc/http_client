package br.com.xpto.httpclient;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import br.com.xpto.httpclient.model.Task;

/**
 * Hello world!
 *
 */
public class App {
	
	public static void main(String[] args) {
		
		HttpClient client = HttpClients.createDefault();

		HttpGet requestGet = new HttpGet("https://jsonplaceholder.typicode.com/todos");

		try {
			HttpResponse response = client.execute(requestGet);

			StatusLine statusLine = response.getStatusLine();
			if (statusLine.getStatusCode() == HttpStatus.SC_OK) {

				HttpEntity entity = response.getEntity();
				
				String json = EntityUtils.toString(entity);
				
				Gson gson = new Gson();
				Type collectionType = new TypeToken<List<Task>>(){}.getType();
				List<Task> taskList = gson.fromJson(json, collectionType);
				
				System.out.println(taskList);
			}

		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
