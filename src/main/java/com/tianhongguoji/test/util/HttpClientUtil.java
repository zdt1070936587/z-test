package com.tianhongguoji.test.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.config.RequestConfig.Builder;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.activation.MimetypesFileTypeMap;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


public class HttpClientUtil {

	private final static Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);

	public static String doGet(String url, Map<String, Object> headers, Map<String, Object> querys) throws Exception {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		Builder builder = RequestConfig.custom().setConnectionRequestTimeout(6000).setConnectTimeout(6000);
		RequestConfig config = builder.build();
		CloseableHttpResponse response = null;
		try {
			HttpGet httpGet = new HttpGet(buildUrl(url, querys));
			httpGet.setConfig(config);
			if (headers != null && !headers.isEmpty()) {
				for (Entry<String, Object> e : headers.entrySet()) {
					httpGet.addHeader(e.getKey(), e.getValue().toString());
				}
			}

			response = httpclient.execute(httpGet);
			if (null != response) {
				InputStream inputStream = response.getEntity().getContent();
				return convertStreamToString(inputStream);
			}
		} catch (Exception e) {
			logger.error("######【" + url + "】请求异常!", e);
		} finally {
			if (response != null) {
				try {
					response.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (httpclient != null) {
				try {
					httpclient.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}


	public static String doPost(String url, Map<String, Object> headers, Map<String, Object> querys, Map<String, Object> bodys) {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		try {
			HttpPost httpPost = new HttpPost(buildUrl(url, querys));
			if (headers != null && !headers.isEmpty()) {
				for (Entry<String, Object> e : headers.entrySet()) {
					httpPost.addHeader(e.getKey(), e.getValue().toString());
				}
			}

			if (bodys != null) {
				List<NameValuePair> nameValuePairList = new ArrayList<NameValuePair>();
				for (String key : bodys.keySet()) {
					nameValuePairList.add(new BasicNameValuePair(key, bodys.get(key).toString()));
				}
				UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(nameValuePairList, "UTF-8");
				formEntity.setContentType("application/x-www-form-urlencoded; charset=UTF-8");
				httpPost.setEntity(formEntity);
			}

			response = httpclient.execute(httpPost);
			if (null != response) {
				InputStream inputStream = response.getEntity().getContent();
				return convertStreamToString(inputStream);
			}
		} catch (Exception e) {
			logger.error("######【" + url + "】请求异常!", e);
		} finally {
			if (response != null) {
				try {
					response.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (httpclient != null) {
				try {
					httpclient.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}


	public static String upload(String url, Map<String, Object> headers, Map<String, Object> querys, Map<String, Object> bodys, Map<String, File> files) {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		try {
			HttpPost httpPost = new HttpPost(buildUrl(url, querys));
			if (headers != null && !headers.isEmpty()) {
				for (Entry<String, Object> e : headers.entrySet()) {
					httpPost.addHeader(e.getKey(), e.getValue().toString());
				}
			}

			MultipartEntityBuilder reqEntity = MultipartEntityBuilder.create();
			if (files != null) {
				for (Entry<String, File> en : files.entrySet()) {
					// reqEntity.addBinaryBody(en.getKey(), en.getValue());
					reqEntity.addPart(en.getKey(), new FileBody(en.getValue(), ContentType.MULTIPART_FORM_DATA));
				}
			}
			if (bodys != null) {
				for (Entry<String, Object> key : bodys.entrySet()) {
					// reqEntity.addPart(key, new
					// StringBody(bodys.get(key).toString(),
					// ContentType.MULTIPART_FORM_DATA));
					// builder.addTextBody(p.getName(), p.getValue(),
					// ContentType.TEXT_PLAIN.withCharset("UTF-8"));
					reqEntity.addTextBody(key.getKey(), (String) key.getValue(), ContentType.TEXT_PLAIN.withCharset("UTF-8"));
				}
			}
			httpPost.setEntity(reqEntity.build());
			response = httpclient.execute(httpPost);
			if (null != response) {
				InputStream inputStream = response.getEntity().getContent();
				return convertStreamToString(inputStream);
			}
		} catch (Exception e) {
			logger.error("######【" + url + "】请求异常!", e);
		} finally {
			if (response != null) {
				try {
					response.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (httpclient != null) {
				try {
					httpclient.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}


	public static String uploadByInput(String url, Map<String, Object> headers, Map<String, Object> querys, Map<String, Object> bodys, Map<String, InputStream> files) {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		try {
			HttpPost httpPost = new HttpPost(buildUrl(url, querys));
			if (headers != null && !headers.isEmpty()) {
				for (Entry<String, Object> e : headers.entrySet()) {
					httpPost.addHeader(e.getKey(), e.getValue().toString());
				}
			}
			MultipartEntityBuilder reqEntity = MultipartEntityBuilder.create();
			if (files != null) {
				for (Entry<String, InputStream> en : files.entrySet()) {
					// reqEntity.addPart(en.getKey(), new
					// InputStreamBody(en.getValue(),
					// ContentType.MULTIPART_FORM_DATA));
					reqEntity.addBinaryBody(en.getKey(), en.getValue(), ContentType.MULTIPART_FORM_DATA, en.getKey());
				}
			}

			if (bodys != null) {
				for (Entry<String, Object> key : bodys.entrySet()) {
					reqEntity.addTextBody(key.getKey(), (String) key.getValue(), ContentType.MULTIPART_FORM_DATA.withCharset("UTF-8"));
				}
			}
			httpPost.setEntity(reqEntity.build());
			response = httpclient.execute(httpPost);
			if (null != response) {
				InputStream inputStream = response.getEntity().getContent();
				return convertStreamToString(inputStream);
			}
		} catch (Exception e) {
			logger.error("######【" + url + "】请求异常!", e);
		} finally {
			if (response != null) {
				try {
					response.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (httpclient != null) {
				try {
					httpclient.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}


	public static String doPost(String url, Map<String, Object> headers, Map<String, Object> querys, String body) {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		try {
			HttpPost httpPost = new HttpPost(buildUrl(url, querys));
			if (headers != null && !headers.isEmpty()) {
				for (Entry<String, Object> e : headers.entrySet()) {
					httpPost.addHeader(e.getKey(), e.getValue().toString());
				}
			}

			if (StringUtils.isNotBlank(body)) {
				httpPost.setEntity(new StringEntity(body, "UTF-8"));
			}

			response = httpclient.execute(httpPost);
			if (null != response) {
				InputStream inputStream = response.getEntity().getContent();
				return convertStreamToString(inputStream);
			}
		} catch (Exception e) {
			logger.error("######【" + url + "】请求异常!", e);
		} finally {
			if (response != null) {
				try {
					response.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	public static String doPostJson(String url, Map<String, Object> headers, Map<String, Object> querys, String jsonStr) {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		try {
			HttpPost httpPost = new HttpPost(buildUrl(url, querys));
			if (headers != null && !headers.isEmpty()) {
				for (Entry<String, Object> e : headers.entrySet()) {
					httpPost.addHeader(e.getKey(), e.getValue().toString());
				}
			}

			if (StringUtils.isNotBlank(jsonStr)) {
				StringEntity entity = new StringEntity(jsonStr, "UTF-8");// 解决中文乱码问题
				entity.setContentEncoding("UTF-8");
				entity.setContentType("application/json;charset=UTF-8");
				httpPost.setEntity(entity);
			}

			response = httpclient.execute(httpPost);
			logger.info("############ 请求返回值：" + response.getStatusLine().getStatusCode());
			if (null != response) {
				InputStream inputStream = response.getEntity().getContent();
				return convertStreamToString(inputStream);
			}
		} catch (Exception e) {
			logger.error("######【" + url + "】请求异常!", e);
		} finally {
			if (response != null) {
				try {
					response.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (httpclient != null) {
				try {
					httpclient.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	public static String getUrl(String url,Map<String, Object> querys) throws UnsupportedEncodingException {
		return buildUrl(url,querys);
	}

	private static String buildUrl(String url, Map<String, Object> querys) throws UnsupportedEncodingException {
		StringBuilder sbUrl = new StringBuilder(url);
		if (null != querys) {
			StringBuilder sbQuery = new StringBuilder();
			for (Entry<String, Object> query : querys.entrySet()) {
				if (0 < sbQuery.length()) {
					sbQuery.append("&");
				}
				if (StringUtils.isBlank(query.getKey()) && query.getValue() != null) {
					sbQuery.append(query.getValue());
				}
				if (!StringUtils.isBlank(query.getKey())) {
					sbQuery.append(query.getKey());
					if (query.getValue() != null) {
						sbQuery.append("=");
						sbQuery.append(URLEncoder.encode(query.getValue().toString(), "UTF-8"));
					}
				}
			}
			if (0 < sbQuery.length()) {
				sbUrl.append("?").append(sbQuery);
			}
		}

		return sbUrl.toString();
	}

	private static String convertStreamToString(InputStream is) throws UnsupportedEncodingException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		StringBuilder sb = new StringBuilder();

		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("######请求结果处理流转String异常!", e);
		} finally {
			try {
				is.close();
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}

    public static String formUpload(String urlStr, Map<String, String> textMap,Map<String, String> fileMap) {  
        String res = "";  
        HttpURLConnection conn = null;  
        String BOUNDARY = "---------------------------123821742118716"; //boundary就是request头和上传文件内容的分隔符  
        try {  
            URL url = new URL(urlStr);  
            conn = (HttpURLConnection) url.openConnection();  
            conn.setConnectTimeout(5000);  
            conn.setReadTimeout(30000);  
            conn.setDoOutput(true);  
            conn.setDoInput(true);  
            conn.setUseCaches(false);  
            conn.setRequestMethod("POST");  
            conn.setRequestProperty("Connection", "Keep-Alive");  
            conn.setRequestProperty("User-Agent",  
                            "Mozilla/5.0 (Windows; U; Windows NT 6.1; zh-CN; rv:1.9.2.6)");  
            conn.setRequestProperty("Content-Type",  
                    "multipart/form-data; boundary=" + BOUNDARY);  
            OutputStream out = new DataOutputStream(conn.getOutputStream());  
            // text  
            if (textMap != null) {  
                StringBuffer strBuf = new StringBuffer();  
                Iterator iter = textMap.entrySet().iterator();  
                while (iter.hasNext()) {  
                    Entry entry = (Entry) iter.next();
                    String inputName = (String) entry.getKey();  
                    String inputValue = (String) entry.getValue();  
                    if (inputValue == null) {  
                        continue;  
                    }  
                    strBuf.append("\r\n").append("--").append(BOUNDARY).append(  
                            "\r\n");  
                    strBuf.append("Content-Disposition: form-data; name=\""  
                            + inputName + "\"\r\n\r\n");  
                    strBuf.append(inputValue);  
                }  
                out.write(strBuf.toString().getBytes());  
            }  
  
            // file  
            if (fileMap != null) {  
                Iterator iter = fileMap.entrySet().iterator();  
                while (iter.hasNext()) {  
                    Entry entry = (Entry) iter.next();
                    String inputName = (String) entry.getKey();  
                    String inputValue = (String) entry.getValue();  
                    if (inputValue == null) {  
                        continue;  
                    }  
                    File file = new File(inputValue);  
                    String filename = file.getName();  
                    String contentType = new MimetypesFileTypeMap().getContentType(file);
                    if (filename.endsWith(".png")) {  
                        contentType = "image/png";  
                    }  
                    if (contentType == null || contentType.equals("")) {  
                        contentType = "application/octet-stream";  
                    }  
  
                    StringBuffer strBuf = new StringBuffer();  
                    strBuf.append("\r\n").append("--").append(BOUNDARY).append(  
                            "\r\n");  
                    strBuf.append("Content-Disposition: form-data; name=\""  
                            + inputName + "\"; filename=\"" + filename  
                            + "\"\r\n");  
                    strBuf.append("Content-Type:" + contentType + "\r\n\r\n");  
                    out.write(strBuf.toString().getBytes());  
                    DataInputStream in = new DataInputStream(  
                            new FileInputStream(file));  
                    int bytes = 0;  
                    byte[] bufferOut = new byte[1024];  
                    while ((bytes = in.read(bufferOut)) != -1) {  
                        out.write(bufferOut, 0, bytes);  
                    }  
                    in.close();  
                }  
            }  
  
            byte[] endData = ("\r\n--" + BOUNDARY + "--\r\n").getBytes();  
            out.write(endData);  
            out.flush();  
            out.close();  
            // 读取返回数据  
            StringBuffer strBuf = new StringBuffer();  
            BufferedReader reader = new BufferedReader(new InputStreamReader(  
                    conn.getInputStream()));  
            String line = null;  
            while ((line = reader.readLine()) != null) {  
                strBuf.append(line).append("\n");  
            }  
            res = strBuf.toString();  
            reader.close();  
            reader = null;  
        } catch (Exception e) {  
            System.out.println("发送POST请求出错。" + urlStr);  
            e.printStackTrace();  
        } finally {  
            if (conn != null) {  
                conn.disconnect();  
                conn = null;  
            }  
        }  
        return res;  
    }
}
