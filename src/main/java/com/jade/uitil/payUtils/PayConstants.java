package com.jade.uitil.payUtils;

/**
 * 常量
 */
public class PayConstants {

    /**
     * 二维码 直接返回
     */
    public static final String QRCode = "QRCode";
    /**
     * 链接地址 重定向
     */
    public static final String LinkUrl = "LinkUrl";
    /**
     * html源码 直接输出
     */
    public static final String Html = "Html";

    /**
     * 默认商户APP_ID
     */
 //  public static final String DEFAULT_APP_ID = "in4040bbdce30f492ab17ac8012ed5cc5c";
    /**
     * 默认商户密钥APP_SECRET
     */
 //   public static final String DEFAULT_APP_SECRET = "5546087d83b3488caf1e6d0199886fca";


    public static final String FAIL = "FAIL";
    public static final String SUCCESS = "SUCCESS";
    public static final String HMACSHA256 = "HMAC-SHA256";
    public static final String MD5 = "MD5";

    /**
     * API地址
     */
    public static final String DOMAIN_API = "pay.v6pay.com";
    /**
     * 请求接口地址
     */
    public static final String PAY_URL_SUFFIX = "/pay/unified/order";
    public static final String PAY_CUSTOM_URL_SUFFIX = "/pay/unified/order/custom";
    /**
     * 查询接口地址
     */
    public static final String QUERY_URL_SUFFIX = "/pay/query/order";


    /**
     * *************************充值渠道*************************************
     */
    /**
     * 微信扫码
     */
    public static final int WxScan = 2;

    /**
     * 支付宝扫码
     *
     * @return
     */
    public static final int AliScan = 4;
    /**
     * 快捷支付
     */
    public static final int QuickPay = 5;

    /**
     * QQ扫码
     *
     * @return
     */
    public static final int QQScan = 6;

    /**
     * 微信公众号支付
     *
     * @return
     */
    public static final int WxSubPay = 7;

    /**
     * 网关支付
     *
     * @return
     */
    public static final int GatewayPay = 8;

    /**
     * 银联扫码
     *
     * @return
     */
    public static final int UnionPay = 9;

    /**
     * 京东支付
     *
     * @return
     */
    public static final int JdPay = 10;

    /**
     * 微信浏览器内 微信H5内支付
     */
    public static final int WxHtmlInPay = 11;

    /**
     * 微信浏览器外 微信H5
     */
    public static final int WxHtmlOutPay = 12;

    /**
     * 百度钱包
     */
    public static final int BaiDuPay = 14;

    /**
     * 通联H5
     *
     * @return
     */
    public static final int AllInPay = 15;

    /**
     * 京东H5
     *
     * @return
     */
    public static final int JdH5Pay = 17;

    /**
     * 支付宝H5
     *
     * @return
     */
    public static final int AliH5 = 20;

    /**
     * QQH5
     *
     * @return
     */
    public static final int QQH5 = 21;

}

