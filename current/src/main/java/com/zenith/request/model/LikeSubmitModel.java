package com.zenith.request.model;

import javax.xml.bind.annotation.XmlRootElement;
/**
*Model used submiting likes
*@author Xavier Garibay and Caleb Schumake
*/
@XmlRootElement
public class LikeSubmitModel {
	String comment;
	int like; 
    String token; 
}
