package com.jade.uitil;

public class PriceUtils {
	
	public static String getPayPrice(String price, String number){
		String[] pn = price.split("-");
		String cr = pn[0];
		String pr = pn[1];
		String[] crs = cr.split(",");
		String[] prs = pr.split(",");
		for(int i = 0;i<crs.length;i++){
			if(i+1==crs.length){
				if(Integer.parseInt(crs[i])<Integer.parseInt(number)){
					return prs[i];
				}
			}else{
				if(Integer.parseInt(crs[i])<Integer.parseInt(number)&&Integer.parseInt(number)<=Integer.parseInt(crs[i+1])){
					return prs[i];
				}
			}
		}
		return getOnePrice(price);
	} 
	
	public static String getOnePrice(String price){
		String[] pn = price.split("-");
		String pr = pn[1];
		String[] prs = pr.split(",");
		return prs[0];
	} 
	
}
