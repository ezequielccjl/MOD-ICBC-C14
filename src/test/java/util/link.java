package util;

import util.url.Environment;
import util.url.Url.UrlFactory;

public class link {
	
    public static final String transfer = UrlFactory.load("channel-transfer-account", "get-destination-info", "1.0", Environment.FBD);

}
