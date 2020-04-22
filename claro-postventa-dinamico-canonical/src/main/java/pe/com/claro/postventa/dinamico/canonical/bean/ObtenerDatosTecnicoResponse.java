package pe.com.claro.postventa.dinamico.canonical.bean;

import pe.com.claro.postventa.dinamico.canonical.bean.Inventories;
import pe.com.claro.postventa.dinamico.canonical.bean.Users;
import pe.com.claro.postventa.dinamico.canonical.bean.WorkSchedules;
import pe.com.claro.postventa.dinamico.canonical.bean.WorkSkills;
import pe.com.claro.postventa.dinamico.canonical.bean.WorkZones;
import pe.com.claro.postventa.dinamico.canonical.types.LinksType;

public class ObtenerDatosTecnicoResponse {
	
	private String resourceId;
	private String organization;
	private String resourceInternalId;
	private String parentResourceInternalId;
	private String status;
	private String parentResourceId;
	private String resourceType;
	private String name;
	private String language;
	private String languageISO;
	private String timeZoneDiff;
	private String timeZone;
	private String timeZoneIANA;
	private String dateFormat;
	private String timeFormat;
	private String durationStatisticsInitialRatio;
	private String XR_COMPANY_NAME;
	private Inventories inventories;
	private Users users;
	private WorkZones workZones;
	private WorkSkills workSkills;
	private WorkSchedules workSchedules;
	private LinksType[] links;
	private String resultCode;
	private String resultMessage;
	private String type;
	private String title;
	private String detail;
	public String getResourceId() {
		return resourceId;
	}
	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	public String getResourceInternalId() {
		return resourceInternalId;
	}
	public void setResourceInternalId(String resourceInternalId) {
		this.resourceInternalId = resourceInternalId;
	}
	public String getParentResourceInternalId() {
		return parentResourceInternalId;
	}
	public void setParentResourceInternalId(String parentResourceInternalId) {
		this.parentResourceInternalId = parentResourceInternalId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getParentResourceId() {
		return parentResourceId;
	}
	public void setParentResourceId(String parentResourceId) {
		this.parentResourceId = parentResourceId;
	}
	public String getResourceType() {
		return resourceType;
	}
	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getLanguageISO() {
		return languageISO;
	}
	public void setLanguageISO(String languageISO) {
		this.languageISO = languageISO;
	}
	public String getTimeZoneDiff() {
		return timeZoneDiff;
	}
	public void setTimeZoneDiff(String timeZoneDiff) {
		this.timeZoneDiff = timeZoneDiff;
	}
	public String getTimeZone() {
		return timeZone;
	}
	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}
	public String getTimeZoneIANA() {
		return timeZoneIANA;
	}
	public void setTimeZoneIANA(String timeZoneIANA) {
		this.timeZoneIANA = timeZoneIANA;
	}
	public String getDateFormat() {
		return dateFormat;
	}
	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}
	public String getTimeFormat() {
		return timeFormat;
	}
	public void setTimeFormat(String timeFormat) {
		this.timeFormat = timeFormat;
	}
	public String getDurationStatisticsInitialRatio() {
		return durationStatisticsInitialRatio;
	}
	public void setDurationStatisticsInitialRatio(String durationStatisticsInitialRatio) {
		this.durationStatisticsInitialRatio = durationStatisticsInitialRatio;
	}
	public String getXR_COMPANY_NAME() {
		return XR_COMPANY_NAME;
	}
	public void setXR_COMPANY_NAME(String xR_COMPANY_NAME) {
		XR_COMPANY_NAME = xR_COMPANY_NAME;
	}
	public Inventories getInventories() {
		return inventories;
	}
	public void setInventories(Inventories inventories) {
		this.inventories = inventories;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public WorkZones getWorkZones() {
		return workZones;
	}
	public void setWorkZones(WorkZones workZones) {
		this.workZones = workZones;
	}
	public WorkSkills getWorkSkills() {
		return workSkills;
	}
	public void setWorkSkills(WorkSkills workSkills) {
		this.workSkills = workSkills;
	}
	public WorkSchedules getWorkSchedules() {
		return workSchedules;
	}
	public void setWorkSchedules(WorkSchedules workSchedules) {
		this.workSchedules = workSchedules;
	}
	public LinksType[] getLinks() {
		return links;
	}
	public void setLinks(LinksType[] links) {
		this.links = links;
	}
	public String getResultCode() {
		return resultCode;
	}
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	public String getResultMessage() {
		return resultMessage;
	}
	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
}
