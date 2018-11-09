package com.jade.uitil.payUtils;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.BasicHttpClientConnectionManager;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.*;
import java.awt.*;
import java.net.URI;
import java.security.MessageDigest;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;


public class PayUtil {

    private static Logger logger = LoggerFactory.getLogger(PayUtil.class);

    /**
     * 判断签名是否正确，必须包含sign字段，否则返回false
     *
     * @param sign       签名
     * @param appId      商户APP_ID
     * @param nonceStr   32位随机字符串
     * @param outTradeNo 商户订单号
     * @param signType   签名类型 MD5 或 HMAC-SHA256
     * @param totalFee   订单金额，单位为分,必须为整数（订单查询接口中默认为0）
     * @param key        商户密钥APP_SECRET
     * @return 签名是否正确
     * @throws Exception
     */
    public static boolean isSignatureValid(final String sign, final String appId, final String nonceStr, final String outTradeNo, final String signType, final Long totalFee, final String key) throws Exception {
        return generateSignature(appId, nonceStr, outTradeNo, signType, totalFee, key).equals(sign);
    }

    /**
     * 生成签名
     * 签名生成的通用步骤如下：
     * 第一步，设所有发送或者接收到的数据为集合M，将集合M内非空参数值的参数按照参数名ASCII码从小到大排序（字典序），使用URL键值对的格式（即key1=value1&key2=value2…）拼接成字符串stringA。
     * 特别注意以下重要规则：
     * ◆ 参数名ASCII码从小到大排序（字典序）；
     * ◆ 如果参数的值为空不参与签名；
     * ◆ 参数名区分大小写；
     * ◆ 验证调用返回或微信主动通知签名时，传送的sign参数不参与签名，将生成的签名与该sign值作校验。
     * ◆ 微信接口可能增加字段，验证签名时必须支持增加的扩展字段
     * 第二步，在stringA最后拼接上key得到stringSignTemp字符串，并对stringSignTemp进行MD5运算，再将得到的字符串所有字符转换为【大写】，得到sign值signValue。
     * app_id nonce_str out_trade_no sign_type total_fee version + key
     * 去掉payType+total_fee 有的前面没有这两个字段
     * version 版本号，固定为4.0
     *
     * @param appId      商户APP_ID
     * @param nonceStr   32位随机字符串
     * @param outTradeNo 商户订单号
     * @param signType   签名类型 MD5 或 HMAC-SHA256
     * @param totalFee   订单金额，单位为分,必须为整数（订单查询接口中默认为0）
     * @param key        商户密钥APP_SECRET
     * @return 签名
     * @throws Exception
     */
    public static String generateSignature(final String appId, final String nonceStr, final String outTradeNo, final String signType, final Long totalFee, final String key) throws Exception {
        if (StringUtils.isBlank(appId) || StringUtils.isBlank(nonceStr) || StringUtils.isBlank(outTradeNo) || StringUtils.isBlank(signType) || null == totalFee || StringUtils.isBlank(key)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("app_id").append("=").append(appId.trim()).append("&")
                .append("nonce_str").append("=").append(nonceStr.trim()).append("&")
                .append("out_trade_no").append("=").append(outTradeNo.trim()).append("&")
                .append("sign_type").append("=").append(signType.trim()).append("&")
                .append("total_fee").append("=").append(totalFee).append("&")
                .append("version").append("=").append("4.1").append("&")
                .append("key=").append(key);
        logger.info("生成的签名：" + sb.toString());
        String sign = "";
        if (PayConstants.MD5.equals(signType)) {
            sign = MD5(sb.toString());
        } else if (PayConstants.HMACSHA256.equals(signType)) {
            sign = HMACSHA256(sb.toString(), key);
        }
        return sign.toUpperCase();
    }


    /**
     * 生成 MD5
     *
     * @param data 待处理数据
     * @return MD5结果
     */
    public static String MD5(String data) throws Exception {
        java.security.MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] array = md.digest(data.getBytes("UTF-8"));
        StringBuilder sb = new StringBuilder();
        for (byte item : array) {
            sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, 3));
        }
        return sb.toString().toUpperCase();
    }

    /**
     * 生成 HMACSHA256
     *
     * @param data 待处理数据
     * @param key  密钥
     * @return 加密结果
     * @throws Exception
     */
    public static String HMACSHA256(String data, String key) throws Exception {
        Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
        SecretKeySpec secret_key = new SecretKeySpec(key.getBytes("UTF-8"), "HmacSHA256");
        sha256_HMAC.init(secret_key);
        byte[] array = sha256_HMAC.doFinal(data.getBytes("UTF-8"));
        StringBuilder sb = new StringBuilder();
        for (byte item : array) {
            sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, 3));
        }
        return sb.toString().toUpperCase();
    }


    /**
     * 获取当前时间戳，单位秒
     *
     * @return
     */
    public static String getCurrentTime() {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        return df.format(new Date());
    }

    /**
     * 生成 uuid， 即用来标识一笔单，也用做 nonce_str
     *
     * @return
     */
    public static String generateUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "").substring(0, 32);
    }


    /**
     * 请求，只请求一次，不做重试
     *
     * @param domain
     * @param urlSuffix
     * @param data
     * @param connectTimeoutMs
     * @param readTimeoutMs
     * @return
     * @throws Exception
     */
    public static String requestOnce(final String domain, String urlSuffix, String data, int connectTimeoutMs, int readTimeoutMs) throws Exception {
        HttpClientBuilder builder = HttpClientBuilder.create();
        SSLConnectionSocketFactory sslConnSocketFactory = new SSLConnectionSocketFactory(new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
            public boolean isTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
                return true;
            }
        }).build());
        builder.setSSLSocketFactory(sslConnSocketFactory);
        Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create().register("https", sslConnSocketFactory).build();
        builder.setConnectionManager(new BasicHttpClientConnectionManager(registry));
        HttpClient httpClient = builder.build();

        String url = "https://" + domain + urlSuffix;
        HttpPost httpPost = new HttpPost(url);

        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(readTimeoutMs).setConnectTimeout(connectTimeoutMs).build();
        httpPost.setConfig(requestConfig);

        StringEntity postEntity = new StringEntity(data, "UTF-8");
        httpPost.addHeader("Content-Type", "application/json");
        httpPost.setEntity(postEntity);
        HttpResponse response = httpClient.execute(httpPost);
        /**
         * 这里方便做模拟 正式环境需自行处理或删除
         * ------------------------------ start -----------------------------------------
         */
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_MOVED_TEMPORARILY) {
            String redirectUrl = response.getLastHeader("Location").getValue();
            logger.info("重定向地址：" + redirectUrl);
            openBrowser(redirectUrl);
        }
        /**
         * ------------------------------  end  -----------------------------------------
         */

        HttpEntity httpEntity = response.getEntity();
        return EntityUtils.toString(httpEntity, "UTF-8");

    }


    /**
     * 用来打开系统默认浏览器浏览指定的URL
     */
    public static void openBrowser(String url) {
        if (!Desktop.isDesktopSupported()) {
            JOptionPane.showMessageDialog(null, "浏览器设置不支持，请手动输入链接：\n " + url);
            return;
        }
        Desktop desktop = Desktop.getDesktop();
        try {
            desktop.browse(new URI(url));
        } catch (Exception e) {
            logger.error("浏览器打开[" + url + "]失败", e);
        }
    }

}
