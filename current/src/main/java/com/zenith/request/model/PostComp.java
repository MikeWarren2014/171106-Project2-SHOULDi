package com.zenith.request.model;

import java.util.Comparator;

import com.zenith.Beans.PostBean;

public class PostComp implements Comparator<PostBean>{

	public int compare(PostBean o1, PostBean o2) {
		return o1.getOccasion().compareTo(o2.getOccasion());
	}

}
