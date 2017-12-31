package com.zenith.request.model;

/**
*Model used in requesting posts with a gender specified
*@author Xavier Garibay and Caleb Schumake
*/
public class GenderedGetModel {
	
	private String token; 
	private String gender;
	

    /**
     * @return the token
     */
    public String getToken() {
        return token;
    }

    /**
     * @param token the token to set
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * @return - gender
     */
	public String getGender() {
		return gender;
	}
	
	/**
	 * @param - gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
    
}
