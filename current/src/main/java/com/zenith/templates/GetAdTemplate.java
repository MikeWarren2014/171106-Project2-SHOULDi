package com.zenith.templates;

/**
 *Template to return an advertisement
 * @author Caleb Schumake and Xavier Garibay
 */
public class GetAdTemplate extends PostTemplate{
	private int ad_id;
	private String image;
	private String url;
	public GetAdTemplate(int ad_id, String image, String url) {
		super();
		this.ad_id = ad_id;
		this.image = image;
		this.url = url;
	}
	
	/**
	 * @return - advertisement id
	 */
	public int getAd_id() {
		return ad_id;
	}
	
	/**
	 * @param - advertisement id to set
	 */
	public void setAd_id(int ad_id) {
		this.ad_id = ad_id;
	}
	
	/**
	 * @return - advertisement image
	 */
	public String getImage() {
		return image;
	}
	
	/**
	 * @param - advertisement image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}
	
	/**
	 * @return - advertisement url
	 */
	public String getUrl() {
		return url;
	}
	
	/**
	 * @param - advertisement url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	
}
