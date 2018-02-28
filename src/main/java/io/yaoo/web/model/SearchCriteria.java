package io.yaoo.web.model;

/**
 * 搜索条件业务bean
 */
public class SearchCriteria {

	String username;
	String email;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "SearchCriteria [username=" + username + ", email=" + email + "]";
	}

}
