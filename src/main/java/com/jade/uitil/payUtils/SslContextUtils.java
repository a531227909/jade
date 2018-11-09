package com.jade.uitil.payUtils;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class SslContextUtils {
	private TrustManager trustAllManager;
	SSLContext sslcontext;
	HostnameVerifier allHostsValid;

	public SslContextUtils() {
		initContext();
	}

	private void initContext() {
		trustAllManager = new X509TrustManager() {

			public void checkClientTrusted(java.security.cert.X509Certificate[] arg0, String arg1) {
			}

			public void checkServerTrusted(java.security.cert.X509Certificate[] arg0, String arg1) {
			}

			public java.security.cert.X509Certificate[] getAcceptedIssuers() {
				return null;
			}

		};
		try {
			sslcontext = SSLContext.getInstance("TLS");
			sslcontext.init(null, new TrustManager[] { trustAllManager }, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		allHostsValid = new HostnameVerifier() {
			public boolean verify(String hostname, SSLSession session) {
				return true;
			}
		};
	}
	
	public void initHttpsConnect(HttpsURLConnection httpsConn) {
		httpsConn.setSSLSocketFactory(sslcontext.getSocketFactory());
		httpsConn.setHostnameVerifier(allHostsValid);
	}
	
}