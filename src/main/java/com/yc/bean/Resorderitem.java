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
public class Resorderitem implements Serializable {

	private static final long serialVersionUID = 4415732811555252222L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer roiid ;
	@Column
	private Integer roid ;
	@Column
	private Integer fid ;
	@Column
	private BigDecimal dealprice ;
	@Column
	private Integer num ;

	
	
}
