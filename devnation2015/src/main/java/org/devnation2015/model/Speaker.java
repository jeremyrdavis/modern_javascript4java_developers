package org.devnation2015.model;

import javax.persistence.Entity;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Version;

import java.lang.Override;

import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Speaker implements Serializable {

	private static final long serialVersionUID = 8241752106353722748L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	@Version
	@Column(name = "version")
	private int version;

	@Column
	private String firstname;

	@Column
	private String lastname;

	@Column(length = 2000)
	private String bio;

	@Column
	private String twitter;

	public Speaker(Long id, int version, String firstname, String lastname,
			String bio, String twitter) {
		super();
		this.id = id;
		this.version = version;
		this.firstname = firstname;
		this.lastname = lastname;
		this.bio = bio;
		this.twitter = twitter;
	}
	
	public Speaker(){};

	public Long getId() {
		return this.id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(final int version) {
		this.version = version;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Speaker)) {
			return false;
		}
		Speaker other = (Speaker) obj;
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

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		if (firstname != null && !firstname.trim().isEmpty())
			result += "firstname: " + firstname;
		if (lastname != null && !lastname.trim().isEmpty())
			result += ", lastname: " + lastname;
		if (bio != null && !bio.trim().isEmpty())
			result += ", bio: " + bio;
		if (twitter != null && !twitter.trim().isEmpty())
			result += ", twitter: " + twitter;
		return result;
	}
}