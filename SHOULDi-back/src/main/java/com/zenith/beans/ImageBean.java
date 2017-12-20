/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zenith.beans;
import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

public class ImageBean {
	@Id //designates as primary key
	@Column(name="IMAGE_ID")
	@SequenceGenerator(sequenceName="IMAGE_SEQ", name="IMAGE_SEQ")
	@GeneratedValue(generator="IMAGE_SEQ", strategy=GenerationType.SEQUENCE)
	private int image_id;
	@Column(name="IMAGE_FILE_NAME")
	private String image_file_name;
	@Column(name="FILE_DATA")
	private Blob file_data; //definitely might change depending on storage implementation
	
	
	
	public int getImage_id() {
		return image_id;
	}



	public void setImage_id(int image_id) {
		this.image_id = image_id;
	}



	public String getImage_file_name() {
		return image_file_name;
	}



	public void setImage_file_name(String image_file_name) {
		this.image_file_name = image_file_name;
	}



	public Blob getFile_data() {
		return file_data;
	}



	public void setFile_data(Blob file_data) {
		this.file_data = file_data;
	}



	public ImageBean() {
		super();
	}


	public ImageBean(String image_file_name, Blob file_data) {
		super();
		this.image_file_name = image_file_name;
		this.file_data = file_data;
	}


	public ImageBean(int image_id, String image_file_name, Blob file_data) {
		super();
		this.image_id = image_id;
		this.image_file_name = image_file_name;
		this.file_data = file_data;
	}
	
}
