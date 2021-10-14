package com.icbc.segmento.digital.util.url;

public class Url {

	

	public Url(String serviceName, String operationName, String version, Environment environment) {
		super();
		this.serviceName = serviceName;
		this.operationName = operationName;
		this.version = version;
		this.environment = environment;
	}

	private final static String templateMDS = "https://mds-${serviceName}-${versionDash}-${environment}.apps.ocp4-tst.intranet.local/${serviceName}/${version}/${operationName}";
	private final static String templateBLR = "https://blr-${serviceName}-${versionDash}-${environment}.apps.ocp4-tst.intranet.local/${serviceName}/${version}/${operationName}";
	private String serviceName;
	private String operationName;
	private String version;
	private Environment environment;
	
	public String getMDS() {
		String versionDash = this.version.replace('.', '-');
		return templateMDS.replace("${serviceName}", this.serviceName)
					   .replace("${operationName}", this.operationName)
					   .replace("${versionDash}", versionDash)
					   .replace("${version}", this.version)
					   .replace("${environment}", this.environment.getText());
	}
	
	public String getBLR() {
		String versionDash = this.version.replace('.', '-');
		return templateBLR.replace("${serviceName}", this.serviceName)
					      .replace("${operationName}", this.operationName)
					      .replace("${versionDash}", versionDash)
					      .replace("${version}", this.version)
					      .replace("${environment}", this.environment.getText());
	}
	
	public static class UrlFactory {
		public static String mds(String serviceName, String operationName, String version, Environment environment) {
			Url url = new Url(serviceName, operationName, version, environment);
			return url.getMDS();
		}
		
		public static String blr(String serviceName, String operationName, String version, Environment environment) {
			Url url = new Url(serviceName, operationName, version, environment);
			return url.getBLR();
		}
	}
}


