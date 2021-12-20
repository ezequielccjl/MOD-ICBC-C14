package com.icbc.segmento.digital.util;

import com.icbc.segmento.digital.util.url.Environment;
import com.icbc.segmento.digital.util.url.Url;

public class Link {
	
	
	//modificar clase url para adaptarlo a nuestros urls
    public static final String TRANSFERENCE = Url.UrlFactory.blr("channel-transfer-account", "get-destination-info", "1.0", Environment.FBD);

   
    //urls hardcodeados
    public static final String LOGIN = "https://mbrfbd.intranet.local/icbc/servlet/Login?klogonUserId=F27308585&klogonPass=prueba01&kdeviceId=";
    public static final String LISTPRODUCTS = "https://mbr-channel-product-3-0-fbd.apps.ocp4-tst.intranet.local/channel-product/3.0/list-products";
    public static final String LISTPRODUCTCARD = "https://mbr-channel-product-3-1-fbd.apps.ocp4-tst.intranet.local/channel-product/3.1/list-product-card";
    public static final String EDITCONTACTBLR = "https://blr-agenda-2-0-fbd.apps.ocp4-tst.intranet.local/agenda/2.0/edit-contact";
    public static final String DELETECONTACTBLR = "https://blr-agenda-2-0-fbd.apps.ocp4-tst.intranet.local/agenda/2.0/delete-contact";
    public static final String ADDCONTACTBLR = "https://blr-agenda-2-0-fbd.apps.ocp4-tst.intranet.local/agenda/2.0/add-contact";
    public static final String LISTTWELVESTATEMENTBLR = "https://blr-card-3-0-fbd.apps.ocp4-tst.intranet.local/card/3.0/list-twelve-statement";
    public static final String LISTTWELVESTATEMENTMBR = "https://mbr-channel-card-2-0-fbd.apps.ocp4-tst.intranet.local/channel-card/2.0/list-twelve-statement";
    public static final String EDITCONTACTMBR = "https://mbr-channel-agenda-1-0-fbd.apps.ocp4-tst.intranet.local/channel-agenda/1.0/edit-contact";
    public static final String GETSECONDFACTORBLR = "https://blr-client-1-0-fbd.apps.ocp4-tst.intranet.local/client/1.0/get-second-factor";
    public static final String GETSECONDFACTORMBR = "https://mbr-channel-transfer-1-0-fbd.apps.ocp4-tst.intranet.local/channel-transfer/1.0/get-second-factor";
    public static final String GENERATESECONDFACTORBLR = "https://blr-client-1-0-fbd.apps.ocp4-tst.intranet.local/client/1.0/generate-second-factor";
    public static final String DESTINATIONINFOMBR = "https://mbr-channel-transfer-account-1-0-fbd.apps.ocp4-tst.intranet.local/channel-transfer-account/1.0/destination-info-service";
    public static final String GETCLIENTDATAMBR = "https://mbrdev.intranet.local/mbr-server/channelclient/1.0/get-client-data";
    public static final String GETFAQCONTENTBLR = "https://blr-content-1-0-fbd.apps.ocp4-tst.intranet.local/content/1.0/get-faq-content";
    public static final String GETCONTACTCONTENTBLR = "https://blr-content-1-0-fbd.apps.ocp4-tst.intranet.local/content/1.0/get-contact-content";
    public static final String GETNEWCLIENTCONTENTBLR = "https://blr-content-1-0-fbd.apps.ocp4-tst.intranet.local/content/1.0/get-new-client-content";
    public static final String GETSEGCANALESCONTENTBLR = "https://blr-content-1-0-fbd.apps.ocp4-tst.intranet.local/content/1.0/get-seg-canales-content";
    public static final String GETLEGALCONTENTBLR = "https://blr-content-1-0-fbd.apps.ocp4-tst.intranet.local/content/1.0/get-legal-content";
    public static final String GETTYCCONTENTBLR = "https://blr-content-1-0-fbd.apps.ocp4-tst.intranet.local/content/1.0/get-ty-ccontent";
    public static final String GETPRIVACYPOLICIESCONTENTBLR = "https://blr-content-1-0-fbd.apps.ocp4-tst.intranet.local/content/1.0/get-privacy-policies";
    public static final String GETFAQCONTENTMBR = "https://mbr-channel-content-sessionless-1-0-fbd.apps.ocp4-tst.intranet.local/channel-content-sessionless/1.0/get-faq-content";
    public static final String GETSEGCANALESCONTENTMBR = "https://mbr-channel-content-sessionless-1-0-fbd.apps.ocp4-tst.intranet.local/channel-content-sessionless/1.0/get-seg-canales-content";
    public static final String GETLEGALCONTENTMBR = "https://mbr-channel-content-1-0-fbd.apps.ocp4-tst.intranet.local/channel-content/1.0/get-legal-content";
    public static final String GETTYCCONTENTMBR = "https://mbr-channel-content-sessionless-1-0-fbd.apps.ocp4-tst.intranet.local/channel-content-sessionless/1.0/get-ty-ccontent";
    public static final String GETCONTACTCONTENTMBR = "https://mbr-channel-content-sessionless-1-0-fbd.apps.ocp4-tst.intranet.local/channel-content-sessionless/1.0/get-contact-content";
    public static final String PAYMENTBLR = "https://blr-card-3-0-fbd.apps.ocp4-tst.intranet.local/card/3.0/payment";
    public static final String PAYMENTAVAILABLEMBR = "https://mbr-channel-card-2-0-fbd.apps.ocp4-tst.intranet.local/channel-card/2.0/payment-available";
    public static final String GETPRIVACYPOLICIESCONTENTMBR = "https://mbr-channel-content-sessionless-1-0-fbd.apps.ocp4-tst.intranet.local/channel-content-sessionless/1.0/get-privacy-policies";
    public static final String MODIFYUSERLOGONMBR = "https://mbr-channel-key-management-1-0-dev.apps.ocp4-tst.intranet.local/channel-key-management/1.0/modify-user-logon";
    public static final String MODIFYUSERLOGONBLR = "https://blr-key-management-1-0-dev.apps.ocp4-tst.intranet.local/key-management/1.0/modify-user-logon";
    public static final String APPLEPAYISENABLEDMBR = "https://mbr-channel-apple-pay-1-0-fbd.apps.ocp4-tst.intranet.local/channel-apple-pay/1.0/apple-pay-is-enabled";
    public static final String CANCELEDPRODUCTSBLR = "https://blr-home-product-1-0-fbd.apps.ocp4-tst.intranet.local/home-product/1.0/canceled-products";
    public static final String GETAVAILABLECARDBLR = "https://blr-home-product-1-0-fbd.apps.ocp4-tst.intranet.local/home-product/1.0/get-available-card";
    public static final String CANCELEDPRODUCTSMBR = "https://mbr-channel-home-product-1-0-fbd.apps.ocp4-tst.intranet.local/channel-home-product/1.0/canceled-products";
    public static final String MESSAGINGOPMBR = "https://mbr-channel-home-product-1-0-fbd.apps.ocp4-tst.intranet.local/channel-home-product/1.0/get-message?=";
    public static final String MESSAGINGOPBLR = "https://blr-home-product-1-0-fbd.apps.ocp4-tst.intranet.local/home-product/1.0/get-message";
    public static final String OWNTRANSFERBLR = "https://blr-transfer-1-0-fbd.apps.ocp4-tst.intranet.local/transfer/1.0/own-transfer";
    public static final String NEWGETCLIENTDATA = "https://mbr-channel-client-1-0-fbd.apps.ocp4-tst.intranet.local/channel-client/1.0/get-client-data";
    public static final String GETAVAILABLECARDMBR = "https://mbr-channel-home-product-1-0-fbd.apps.ocp4-tst.intranet.local/channel-home-product/1.0/get-available-card";
    public static final String LISTDEVICESMBR = "https://mbr-channel-user-devices-1-0-dev.apps.ocp4-tst.intranet.local/channel-user-devices/1.0/list-devices";
    public static final String LISTEXTRACTIONMBR = "https://mbr-channel-cardless-extraction-1-0-fbd.apps.ocp4-tst.intranet.local/channel-cardless-extraction/1.0/list-extraction";
    public static final String SERVICESHIERARCHYBLR = "https://blr-service-payment-1-0-dev.apps.ocp4-tst.intranet.local/service-payment/1.0/services-hierarchy";
    public static final String SERVICESHIERARCHYMBR = "https://mbr-channel-service-payment-1-0-dev.apps.ocp4-tst.intranet.local/channel-service-payment/1.0/services-hierarchy";
    public static final String CARDEXPENSESRECENTBLR = "https://blr-credit-card-purchases-1-0-fbd.apps.ocp4-tst.intranet.local/credit-card-purchases/1.0/card-expenses-recent";
    public static final String CARDEXPENSESRECENTMBR = "https://mbr-channel-credit-card-purchases-1-0-fbd.apps.ocp4-tst.intranet.local/channel-credit-card-purchases/1.0/card-expenses-recent";
}
