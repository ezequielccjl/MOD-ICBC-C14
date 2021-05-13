package com.icbc.segmento.digital.util;

import com.icbc.segmento.digital.util.url.Environment;
import com.icbc.segmento.digital.util.url.Url;

public class Link {
	
    public static final String TRANSFERENCE = Url.UrlFactory.load("channel-transfer-account", "get-destination-info", "1.0", Environment.FBD);

}
