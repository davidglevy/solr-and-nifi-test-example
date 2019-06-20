package com.cloudera.demo;

import java.util.Calendar;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Item {

	private String id;
	
	private String name;
	
	private String manu;
	
	@JsonProperty("manu_id_s")
	private String manuIdS;
	
	/**
	 * Category e.g. electronics, music
	 */
	private List<String> cat;

	private List<String> features;

	private List<String> includes;
	
	private Float weight;
	
	private Float price;
	
	private Integer popularity;

	private boolean inStock;

	private List<Float> store;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getManu() {
		return manu;
	}

	public void setManu(String manu) {
		this.manu = manu;
	}

	public String getManuIdS() {
		return manuIdS;
	}

	public void setManuIdS(String manuIdS) {
		this.manuIdS = manuIdS;
	}

	public List<String> getCat() {
		return cat;
	}

	public void setCat(List<String> cat) {
		this.cat = cat;
	}

	public List<String> getFeatures() {
		return features;
	}

	public void setFeatures(List<String> features) {
		this.features = features;
	}

	public List<String> getIncludes() {
		return includes;
	}

	public void setIncludes(List<String> includes) {
		this.includes = includes;
	}

	public Float getWeight() {
		return weight;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Integer getPopularity() {
		return popularity;
	}

	public void setPopularity(Integer popularity) {
		this.popularity = popularity;
	}

	public boolean isInStock() {
		return inStock;
	}

	public void setInStock(boolean inStock) {
		this.inStock = inStock;
	}

	public List<Float> getStore() {
		return store;
	}

	public void setStore(List<Float> store) {
		this.store = store;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	//  "manufacturedate_dt":"2005-10-12T08:00:00Z",
//  "manu_str":["Apple Computer Inc."],
//  "_version_":1636728779207344128,
//  "cat_str":["electronics",
//    "music"],
//  "name_str":["Apple 60 GB iPod with Video Playback Black"],
//  "includes_str":["earbud headphones, USB cable"],
//  "features_str":["2.5-inch, 320x240 color TFT LCD display with LED backlight",
//    "Notes, Calendar, Phone book, Hold button, Date display, Photo wallet, Built-in games, JPEG photo playback, Upgradeable firmware, USB 2.0 compatibility, Playback speed control, Rechargeable capability, Battery level indication",
//    "Plays AAC, MP3, WAV, AIFF, Audible, Apple Lossless, H.264 video",
//    "Stores up to 15,000 songs, 25,000 photos, or 150 hours of video",
//    "Up to 20 hours of battery life",
//    "iTunes, Podcasts, Audiobooks"],
//  "store_str":["37.7752,-100.0232"]},

	
}
