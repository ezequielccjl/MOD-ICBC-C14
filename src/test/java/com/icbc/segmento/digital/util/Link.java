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
    public static final String LISTPRODUCTCARD = "https://mbr-channel-product-3-1-fbd.apps.ocp4-tst.intranet.local/channel-product/3.1/list-product-card";
    public static final String EDITCONTACTBLR = "https://blr-agenda-2-0-dev.apps.ocp4-tst.intranet.local/agenda/2.0/edit-contact";
    public static final String DELETECONTACTBLR = "https://blr-agenda-2-0-dev.apps.ocp4-tst.intranet.local/agenda/2.0/delete-contact";
    public static final String ADDCONTACTBLR = "https://blr-agenda-2-0-dev.apps.ocp4-tst.intranet.local/agenda/2.0/add-contact";
    public static final String LISTTWELVESTATEMENT = "https://blr-card-3-0-dev.apps.ocp4-tst.intranet.local/card/3.0/list-twelve-statement";
    public static final String EDITCONTACTMBR = "https://mbr-channel-agenda-1-0-dev.apps.ocp4-tst.intranet.local/channel-agenda/1.0/edit-contact";
    public static final String GETSECONDFACTORBLR = "https://blr-client-1-0-fbd.apps.ocp4-tst.intranet.local/client/1.0/get-second-factor";
    public static final String GETSECONDFACTORMBR = "https://mbr-channel-transfer-1-0-fbd.apps.ocp4-tst.intranet.local/channel-transfer/1.0/get-second-factor";
}
