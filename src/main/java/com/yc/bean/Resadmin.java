package com.yc.bean;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Data
public class Resadmin implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer raid;
	@Column
	private String raname;
	@Column
	private String rapwd;

}
