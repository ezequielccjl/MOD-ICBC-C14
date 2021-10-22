package com.icbc.segmento.digital.util;

import com.icbc.segmento.digital.util.url.Environment;
import com.icbc.segmento.digital.util.url.Url;

public class Link {
	
	
	//modificar clase url para adaptarlo a nuestros urls
    public static final String TRANSFERENCE = Url.UrlFactory.blr("channel-transfer-account", "get-destination-info", "1.0", Environment.FBD);

   
    //urls hardcodeados
    //MBR
    public static final String LOGIN = "https://mbrdev.intranet.local/icbc/servlet/Login?klogonUserId=F27308585&klogonPass=prueba01&kdeviceId=";
    public static final String LISTPRODUCTS = "https://mbr-channel-product-3-0-dev.apps.ocp4-tst.intranet.local/channel-product/3.0/list-products";
    public static final String LISTPRODUCTCARD = "https://mbr-channel-product-3-1-dev.apps.ocp4-tst.intranet.local/channel-product/3.1/list-product-card";
}
