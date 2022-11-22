package Logico;

public class Usuario {

	private String tipo;
	private String userId;
	private String password;
	
	
	public Usuario(String tipo, String userId, String password) {
		super();
		this.tipo = tipo;
		this.userId = userId;
		this.password = password;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
