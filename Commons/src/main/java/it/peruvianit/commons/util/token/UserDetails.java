package it.peruvianit.commons.util.token;

public class UserDetails {
	private String username;
	private String ipAddress;
	private String macAddress;
	
	private Integer id;
	private String browser;
	private String browserType;
	private String browserVersion;
	private String nameOperatingSystem;
	private String deviceType;
	private String manufacter;
	
	public UserDetails(){}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getIpAddress() {
		return ipAddress;
	}
	
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	
	public String getMacAddress() {
		return macAddress;
	}
	
	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public String getBrowserType() {
		return browserType;
	}

	public void setBrowserType(String browserType) {
		this.browserType = browserType;
	}

	public String getBrowserVersion() {
		return browserVersion;
	}

	public void setBrowserVersion(String browserVersion) {
		this.browserVersion = browserVersion;
	}

	public String getNameOperatingSystem() {
		return nameOperatingSystem;
	}

	public void setNameOperatingSystem(String nameOperatingSystem) {
		this.nameOperatingSystem = nameOperatingSystem;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public String getManufacter() {
		return manufacter;
	}

	public void setManufacter(String manufacter) {
		this.manufacter = manufacter;
	}	
}
