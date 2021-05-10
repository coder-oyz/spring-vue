package com.yc.bean;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author DELL
 */
@Entity
@Data
public class Resorder implements Serializable {
	private static final long serialVersionUID = -2016543110735258001L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer roid;
	@Column
	private Integer userid;
	@Column
	private String address;
	@Column
	private String tel;
	@Column
	private Timestamp ordertime;
	@Column
	private Timestamp deliverytime;
	@Column
	private String ps;
	@Column
	private Integer status;
	@Transient
	private String deliverytimeString;

	public Timestamp getDeliveryTime()  {
		Date d = null;
		if(deliverytimeString!=null){
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			try {
				d = df.parse(deliverytimeString);
			} catch (ParseException e) {
				e.printStackTrace();
			}

		}else {
			d =new Date();
		}
		deliverytime = new Timestamp(d.getTime());
		return this.deliverytime;
	}


}
