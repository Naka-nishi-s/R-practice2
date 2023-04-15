package com.example.demo.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="User")
public class User {
	
	//モデルの定義
	
	@Id
	private Integer id;
	private String name;
	private String email;
	
	
	// 値を返す用の関数
	public Integer getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String gatEmail() {
		return email;
	}
	

}
