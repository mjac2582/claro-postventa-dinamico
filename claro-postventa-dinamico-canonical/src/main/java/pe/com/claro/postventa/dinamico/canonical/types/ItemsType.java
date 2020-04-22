package pe.com.claro.postventa.dinamico.canonical.types;


public class ItemsType {
	
	private String label;
	
	private String name;
	
	private String active;
	
	private String groupLabel;
	
	private String defaultDuration;
	
	private LinksType links;
	
	public String getDefaultDuration() {
		return defaultDuration;
	}

	public void setDefaultDuration(String defaultDuration) {
		this.defaultDuration = defaultDuration;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getGroupLabel() {
		return groupLabel;
	}

	public void setGroupLabel(String groupLabel) {
		this.groupLabel = groupLabel;
	}

	public LinksType getLinks() {
		return links;
	}

	public void setLinks(LinksType links) {
		this.links = links;
	}


	
	

}
