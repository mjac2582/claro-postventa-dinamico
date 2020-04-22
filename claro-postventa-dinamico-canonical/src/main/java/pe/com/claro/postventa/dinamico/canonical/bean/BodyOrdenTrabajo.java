package pe.com.claro.postventa.dinamico.canonical.bean;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import pe.com.claro.postventa.dinamico.canonical.types.ItemsOrdenTrabajoType;
@JsonIgnoreProperties(ignoreUnknown = true)
public class BodyOrdenTrabajo {
	@JsonProperty("items")
	private List<ItemsOrdenTrabajoType> items;
	
	@JsonProperty("activityId")
	private String activityId;
	
	@JsonProperty("XA_Department")
	private String XA_Department;
	
	@JsonProperty("XA_Province")
	private String XA_Province;
	
	@JsonProperty("stateProvince")
	private String stateProvince;
	
	@JsonProperty("streetAddress")
	private String streetAddress;
	
	@JsonProperty("XA_Reference")
	private String XA_Reference;
	
	@JsonProperty("startTime")
	private String startTime;
	
	@JsonProperty("endTime")
	private String endTime;
	
	@JsonProperty("XA_Contact_Phones")
	private String XA_Contact_Phones;
	
	@JsonProperty("XA_Contact_Name")
	private String XA_Contact_Name;
	
	@JsonProperty("XA_Zone_Type")
	private String XA_Zone_Type;
	
	@JsonProperty("workZone")
	private String workZone;
	
	@JsonProperty("XA_Zone")
	private String XA_Zone;
	
	@JsonProperty("latitude")
	private String latitude;
	
	@JsonProperty("longitude")
	private String longitude;
	
	@JsonProperty("positionInRoute")
	private int positionInRoute;
	
	@JsonProperty("slaWindowStart")
	private String slaWindowStart;
	
	@JsonProperty("slaWindowEnd")
	private String slaWindowEnd;
	
	@JsonProperty("XA_Map")
	private String XA_Map;

	public List<ItemsOrdenTrabajoType> getItems() {
		return items;
	}

	public void setItems(List<ItemsOrdenTrabajoType> items) {
		this.items = items;
	}

	public String getActivityId() {
		return activityId;
	}

	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}

	public String getXA_Department() {
		return XA_Department;
	}

	public void setXA_Department(String xA_Department) {
		XA_Department = xA_Department;
	}

	public String getXA_Province() {
		return XA_Province;
	}

	public void setXA_Province(String xA_Province) {
		XA_Province = xA_Province;
	}

	public String getStateProvince() {
		return stateProvince;
	}

	public void setStateProvince(String stateProvince) {
		this.stateProvince = stateProvince;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getXA_Reference() {
		return XA_Reference;
	}

	public void setXA_Reference(String xA_Reference) {
		XA_Reference = xA_Reference;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getXA_Contact_Phones() {
		return XA_Contact_Phones;
	}

	public void setXA_Contact_Phones(String xA_Contact_Phones) {
		XA_Contact_Phones = xA_Contact_Phones;
	}

	public String getXA_Contact_Name() {
		return XA_Contact_Name;
	}

	public void setXA_Contact_Name(String xA_Contact_Name) {
		XA_Contact_Name = xA_Contact_Name;
	}

	public String getXA_Zone_Type() {
		return XA_Zone_Type;
	}

	public void setXA_Zone_Type(String xA_Zone_Type) {
		XA_Zone_Type = xA_Zone_Type;
	}

	public String getWorkZone() {
		return workZone;
	}

	public void setWorkZone(String workZone) {
		this.workZone = workZone;
	}

	public String getXA_Zone() {
		return XA_Zone;
	}

	public void setXA_Zone(String xA_Zone) {
		XA_Zone = xA_Zone;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public int getPositionInRoute() {
		return positionInRoute;
	}

	public void setPositionInRoute(int positionInRoute) {
		this.positionInRoute = positionInRoute;
	}

	public String getSlaWindowStart() {
		return slaWindowStart;
	}

	public void setSlaWindowStart(String slaWindowStart) {
		this.slaWindowStart = slaWindowStart;
	}

	public String getSlaWindowEnd() {
		return slaWindowEnd;
	}

	public void setSlaWindowEnd(String slaWindowEnd) {
		this.slaWindowEnd = slaWindowEnd;
	}

	public String getXA_Map() {
		return XA_Map;
	}

	public void setXA_Map(String xA_Map) {
		XA_Map = xA_Map;
	}
	
	
	
}
