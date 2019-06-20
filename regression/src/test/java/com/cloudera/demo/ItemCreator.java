package com.cloudera.demo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ItemCreator {

	String idPrefix = null;
	
	int sequence = 1;
	
	public ItemCreator() {
		Date date = new Date();
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH-MM-SS");
		
		idPrefix = formatter.format(date);
		
	}
	
	public Item createNext() {
		Item item = new Item();
		item.setId(idPrefix + "-" + sequence++);
		item.setName("Item-" + sequence);
		return item;
	}
	
//    "name":["Apple 60 GB iPod with Video Playback Black"],
//    "manu":["Apple Computer Inc."],
//    "manu_id_s":"apple",
//    "cat":["electronics",
//      "music"],
//    "features":["iTunes, Podcasts, Audiobooks",
//      "Stores up to 15,000 songs, 25,000 photos, or 150 hours of video",
//      "2.5-inch, 320x240 color TFT LCD display with LED backlight",
//      "Up to 20 hours of battery life",
//      "Plays AAC, MP3, WAV, AIFF, Audible, Apple Lossless, H.264 video",
//      "Notes, Calendar, Phone book, Hold button, Date display, Photo wallet, Built-in games, JPEG photo playback, Upgradeable firmware, USB 2.0 compatibility, Playback speed control, Rechargeable capability, Battery level indication"],
//    "includes":["earbud headphones, USB cable"],
//    "weight":[5.5],
//    "price":[399.0],
//    "popularity":[10],
//    "inStock":[true],
//    "store":["37.7752,-100.0232"],
//    "manufacturedate_dt":"2005-10-12T08:00:00Z",
//    "manu_str":["Apple Computer Inc."],
//    "_version_":1636728779207344128,
//    "cat_str":["electronics",
//      "music"],
//    "name_str":["Apple 60 GB iPod with Video Playback Black"],
//    "includes_str":["earbud headphones, USB cable"],
//    "features_str":["2.5-inch, 320x240 color TFT LCD display with LED backlight",
//      "Notes, Calendar, Phone book, Hold button, Date display, Photo wallet, Built-in games, JPEG photo playback, Upgradeable firmware, USB 2.0 compatibility, Playback speed control, Rechargeable capability, Battery level indication",
//      "Plays AAC, MP3, WAV, AIFF, Audible, Apple Lossless, H.264 video",
//      "Stores up to 15,000 songs, 25,000 photos, or 150 hours of video",
//      "Up to 20 hours of battery life",
//      "iTunes, Podcasts, Audiobooks"],
//    "store_str":["37.7752,-100.0232"]},

	
}
