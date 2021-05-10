package com.yc.bean;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author DELL
 */
@Data
@Entity
public class Resuser implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userid;
	@Column
	private String username;

	@Column
	private String pwd;
	@Column
	private String email;



}
