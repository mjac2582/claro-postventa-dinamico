package pe.com.claro.postventa.dinamico.canonical.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemsOrdenTrabajoType {

	@JsonProperty("activityId")
	private String activityId;

	@JsonProperty("date")
	private String date;

	@JsonProperty("apptNumber")
	private String apptNumber;

	@JsonProperty("status")
	private String status;

	@JsonProperty("activityType")
	private String activityType;

	@JsonProperty("timeSlot")
	private String timeSlot;

	@JsonProperty("XA_WorkOrderSubtype")
	private String XA_WorkOrderSubtype;

	@JsonProperty("XA_SOT_ID")
	private String XA_SOT_ID;
	
	/******************************************************************************/
	
	
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

	public String getActivityId() {
		return activityId;
	}

	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}

	public String getDate() {
		return date;
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

	public void setDate(String date) {
		this.date = date;
	}

	public String getApptNumber() {
		return apptNumber;
	}

	public void setApptNumber(String apptNumber) {
		this.apptNumber = apptNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getActivityType() {
		return activityType;
	}

	public void setActivityType(String activityType) {
		this.activityType = activityType;
	}

	public String getTimeSlot() {
		return timeSlot;
	}

	public void setTimeSlot(String timeSlot) {
		this.timeSlot = timeSlot;
	}

	public String getXA_WorkOrderSubtype() {
		return XA_WorkOrderSubtype;
	}

	public void setXA_WorkOrderSubtype(String xA_WorkOrderSubtype) {
		XA_WorkOrderSubtype = xA_WorkOrderSubtype;
	}

	public String getXA_SOT_ID() {
		return XA_SOT_ID;
	}

	public void setXA_SOT_ID(String xA_SOT_ID) {
		XA_SOT_ID = xA_SOT_ID;
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
