package com.example.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.SwingWorker;

import com.google.gson.Gson;

public class API<T> {
	public void get(String source, Class<T> t, APIResult<T> result) {
		Runnable r = () -> {
			try {
				Gson gson = new Gson();
				URL url = new URL(source);
				HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				connection.setRequestMethod("GET");
				if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
					BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
					String readLine = null;
					StringBuffer response = new StringBuffer();
					while ((readLine = reader.readLine()) != null) {
						response.append(readLine);
					}
					reader.close();
					System.out.println(response.toString());
					result.onResult(gson.fromJson(response.toString(), t));
				} else {
					result.onError(new Exception("Failed to connect server."));
				}
			} catch (Exception e) {
				result.onError(e);
			}
		};
		new Thread(r).start();

	}

	public void post(String source, Class<T> t, Object params, APIResult<T> result) {
		Runnable r = () -> {
			try {
				Gson gson = new Gson();
				URL url = new URL(source);
				HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
				connection.setDoOutput(true);
				connection.setDoInput(true);
				connection.setRequestMethod("POST");
				OutputStream os = connection.getOutputStream();
				byte[] input = gson.toJson(params).getBytes("utf-8");
				os.write(input, 0, input.length);
				if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
					BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
					StringBuffer response = new StringBuffer();
					String readLine = null;
					while ((readLine = reader.readLine()) != null) {
						response.append(readLine);
					}
					reader.close();
					result.onResult(gson.fromJson(response.toString(), t));
				} else {
					result.onError(new Exception("Failed to connect server."));
				}
			} catch (Exception e) {
				result.onError(e);
			}
		};
		new Thread(r).start();
	}

}