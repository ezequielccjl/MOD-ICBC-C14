package util;

import util.url.Environment;
import util.url.Url.UrlFactory;

public class Link {
	
	public static final String LIST_PRODUCTS = UrlFactory.load("channel-product", "list-products", "2.0", Environment.FBD);
    public static final String TRANSFERENCE = UrlFactory.load("channel-transfer-account", "get-destination-info", "1.0", Environment.FBD);
    
    
}
