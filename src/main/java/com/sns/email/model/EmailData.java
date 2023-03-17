package com.sns.email.model;

public class EmailData {
    private String Account_Name;
    private String Event_Name;
    private String Event_Start_Date;
    private String Event_End_Date;
    private String Event_Type;
    private String Event_TimeZone;
    
    
	@Override
	public String toString() {
		return "EmailData [Account_Name=" + Account_Name + ", Event_Name=" + Event_Name + ", Event_Start_Date="
				+ Event_Start_Date + ", Event_End_Date=" + Event_End_Date + ", Event_Type=" + Event_Type
				+ ", Event_TimeZone=" + Event_TimeZone + "]";
	}
	public EmailData(String account_Name, String event_Name, String event_Start_Date, String event_End_Date,
			String event_Type, String event_TimeZone) {
		super();
		Account_Name = account_Name;
		Event_Name = event_Name;
		Event_Start_Date = event_Start_Date;
		Event_End_Date = event_End_Date;
		Event_Type = event_Type;
		Event_TimeZone = event_TimeZone;
	}
	public EmailData() {
		
	}
	public String getAccount_Name() {
		return Account_Name;
	}
	public void setAccount_Name(String account_Name) {
		Account_Name = account_Name;
	}
	public String getEvent_Name() {
		return Event_Name;
	}
	public void setEvent_Name(String event_Name) {
		Event_Name = event_Name;
	}
	public String getEvent_Start_Date() {
		return Event_Start_Date;
	}
	public void setEvent_Start_Date(String event_Start_Date) {
		Event_Start_Date = event_Start_Date;
	}
	public String getEvent_End_Date() {
		return Event_End_Date;
	}
	public void setEvent_End_Date(String event_End_Date) {
		Event_End_Date = event_End_Date;
	}
	public String getEvent_Type() {
		return Event_Type;
	}
	public void setEvent_Type(String event_Type) {
		Event_Type = event_Type;
	}
	public String getEvent_TimeZone() {
		return Event_TimeZone;
	}
	public void setEvent_TimeZone(String event_TimeZone) {
		Event_TimeZone = event_TimeZone;
	}
    
    
}
