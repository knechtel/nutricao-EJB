package br.com.nutricao.bean;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
@NamedQueries({
	@NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
	@NamedQuery(name = "Usuario.findAllByTipo", query = "SELECT u FROM Usuario u WHERE u.tipo = :tipo"),
	@NamedQuery(name = "Usuario.findByLoginAndPassword", query = "SELECT u FROM Usuario u WHERE u.email LIKE :email "
				+ " AND u.senha LIKE :senha")
})
public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public static final Integer TIPO_NORMAL = 0;
	public static final Integer TIPO_ADMIN = 1;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	private String nome;
	
	private String email;
	
	@Column(length = 64)
	private String senha;
	
	private Integer tipo;
	
	public Usuario() {
		this.tipo = TIPO_NORMAL;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return senha;
	}

	public void setPassword(String password) {
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return;
		}
		md.update(password.getBytes());

		byte byteData[] = md.digest();

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		}
		
		this.senha = sb.toString();
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

}
