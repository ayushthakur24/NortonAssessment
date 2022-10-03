package com.nortonassessment.helper;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import javax.net.ssl.HttpsURLConnection;

public class RemoteDownloadFile {

	public void remoteDownloadFile(HttpsURLConnection connection) throws IOException {
		InputStream is = connection.getInputStream();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String line = br.readLine();
		
		//downloding the JSON file from the URL to the working directory
		FileOutputStream fo = new FileOutputStream("C:\\Users\\at382\\eclipse-workspace\\NortonAssessment2\\ExoplanetList.json");
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fo));
		
		while(line!=null) {
			bw.write(line);
			bw.newLine();
			line = br.readLine();
		}
		
	}

}
