// default package
// Generated 24/12/2016 10:08:45 AM by Hibernate Tools 5.1.0.Alpha1
package co.srsp.hibernate.orm;

import javax.persistence.Entity;

/**
 * Authorities generated by hbm2java
 */
@Entity
public class Authorities implements java.io.Serializable {

	private Integer idauthorities;
	private String username;
	private String authority;

	public Authorities() {
	}

	public Authorities(String username, String authority) {
		this.username = username;
		this.authority = authority;
	}

	public Integer getIdauthorities() {
		return this.idauthorities;
	}

	public void setIdauthorities(Integer idauthorities) {
		this.idauthorities = idauthorities;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAuthority() {
		return this.authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

}
