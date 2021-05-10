package com.yc.bean;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author DELL
 */
@Entity
@Data
public class Resfood implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer fid;
	@Column
	private String fname;
	@Column
	private BigDecimal normprice;
	@Column
	private BigDecimal realprice;
	@Column
	private String detail;
	@Column
	private String fphoto;


}
