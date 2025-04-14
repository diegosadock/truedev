package br.com.sadock.ecommerce.security;

public class ECToken {
	private String token;
	
	public ECToken() {}

	public ECToken(String token) {
		super();
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	

}
