package util.url;

public class Url {

	
	public Url(String serviceName, String operationName, String version, Environment environment) {
		super();
		this.serviceName = serviceName;
		this.operationName = operationName;
		this.version = version;
		this.environment = environment;
	}

	private final static String TEMPLATE = "https://mds-${serviceName}${versionDash}-${environment}.apps.ocp4-tst.intranet.local/${serviceName}/${version}/${operationName}";
	private String serviceName;
	private String operationName;
	private String version;
	private Environment environment;
	
	public String get() {
		String versionDash = this.version.replace('.', '-');
		return TEMPLATE.replace("${serviceName}", this.serviceName)
				.replace("${operationName}", this.operationName)
				.replace("${versionDash}", versionDash)
				.replace("${version}", this.version)
				.replace("${environment}", this.environment.getText());

	}
	
	public static class UrlFactory {
		public static String load(String serviceName, String operationName, String version, Environment environment) {
			Url url = new Url(serviceName, operationName, version, environment);
			return url.get();
		}
	}
}


