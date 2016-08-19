package com.nilanet.apps.home.mgmt.model;

import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.validation.constraints.Size;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;

@Entity
@Table(name = "Trips")
public class Trip implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

	@Column(length = 50, nullable = false)
	@Size(min = 5, max = 50, message = "Size of the name field should contain 5 to 50 characters")
	private String name; // Short name for the trip

	@Column(length = 500, name = "descr", nullable = false)
	@Size(min = 5, max = 500, message = "Description field should contain between 5 and 500 (max) characters.")
	private String description; // Trip description

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date tdate; // Trip date

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date edate; // Trip end date

	@Column(length = 100, nullable = false)
	@Size(min = 4, max = 100, message = "Source location field should contain 4 to 100 characters")
	private String sloc; // Trip start location

	@Column(length = 100, nullable = false)
	@Size(min = 4, max = 100, message = "Destination location field should contain 4 to 100 characters")
	private String dloc; // Trip end location

	@Column(nullable = false)
	private Integer miles; // Trip miles

	@Column(length = 50, name = "vehi")
	@Max(value = 50, message = "Vehicle field cannot contain more than 50 characters!")
	private String vehicle; // Vehicle used in the trip

	@Column(length = 100)
	private String rmap; // Trip route map co-ordinates, URL...

	@Column(length = 500)
	private String tinfo; // Trip info.

	@Column(length = 255, name = "attends", nullable = false)
	@Size(min = 4, max = 255, message = "Attendees field should contain 4 to 255 characters")
	private String attendees; // Attendee names, count....

	@Column(length = 100)
	private String mitem; // Trip images location (URL)

	@Column(length = 50, nullable = false)
	private String cuser; // Trip record created by

	@Column(length = 50, nullable = false)
	private String muser; // Trip record modified by

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date cdate; // Trip record create date

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date mdate; // Trip record modify date

	@Column(length = 25, nullable = false)
	@Size(min = 5, max = 50, message = "Activity type field must contain between 5 to 50 characters (max)")
	private String atype; // Activity type - cycling, running, touring ...

	public Long getId() {
		return this.id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Trip)) {
			return false;
		}
		Trip other = (Trip) obj;
		if (id != null) {
			if (!id.equals(other.id)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getTdate() {
		return tdate;
	}

	public void setTdate(Date tdate) {
		this.tdate = tdate;
	}

	public Date getEdate() {
		return edate;
	}

	public void setEdate(Date edate) {
		this.edate = edate;
	}

	public String getSloc() {
		return sloc;
	}

	public void setSloc(String sloc) {
		this.sloc = sloc;
	}

	public String getDloc() {
		return dloc;
	}

	public void setDloc(String dloc) {
		this.dloc = dloc;
	}

	public Integer getMiles() {
		return miles;
	}

	public void setMiles(Integer miles) {
		this.miles = miles;
	}

	public String getVehicle() {
		return vehicle;
	}

	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}

	public String getRmap() {
		return rmap;
	}

	public void setRmap(String rmap) {
		this.rmap = rmap;
	}

	public String getTinfo() {
		return tinfo;
	}

	public void setTinfo(String tinfo) {
		this.tinfo = tinfo;
	}

	public String getAttendees() {
		return attendees;
	}

	public void setAttendees(String attendees) {
		this.attendees = attendees;
	}

	public String getMitem() {
		return mitem;
	}

	public void setMitem(String mitem) {
		this.mitem = mitem;
	}

	public String getCuser() {
		return cuser;
	}

	public void setCuser(String cuser) {
		this.cuser = cuser;
	}

	public String getMuser() {
		return muser;
	}

	public void setMuser(String muser) {
		this.muser = muser;
	}

	public Date getCdate() {
		return cdate;
	}

	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}

	public Date getMdate() {
		return mdate;
	}

	public void setMdate(Date mdate) {
		this.mdate = mdate;
	}

	public String getAtype() {
		return atype;
	}

	public void setAtype(String atype) {
		this.atype = atype;
	}

	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		if (name != null && !name.trim().isEmpty())
			result += "name: " + name;
		if (description != null && !description.trim().isEmpty())
			result += ", description: " + description;
		if (sloc != null && !sloc.trim().isEmpty())
			result += ", sloc: " + sloc;
		if (dloc != null && !dloc.trim().isEmpty())
			result += ", dloc: " + dloc;
		if (miles != null)
			result += ", miles: " + miles;
		if (vehicle != null && !vehicle.trim().isEmpty())
			result += ", vehicle: " + vehicle;
		if (rmap != null && !rmap.trim().isEmpty())
			result += ", rmap: " + rmap;
		if (tinfo != null && !tinfo.trim().isEmpty())
			result += ", tinfo: " + tinfo;
		if (attendees != null && !attendees.trim().isEmpty())
			result += ", attendees: " + attendees;
		if (mitem != null && !mitem.trim().isEmpty())
			result += ", mitem: " + mitem;
		if (cuser != null && !cuser.trim().isEmpty())
			result += ", cuser: " + cuser;
		if (muser != null && !muser.trim().isEmpty())
			result += ", muser: " + muser;
		if (atype != null && !atype.trim().isEmpty())
			result += ", atype: " + atype;
		return result;
	}
}