package com.xinthe.pms.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Field implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private String labelName;
	private String labelValue;
	private boolean showOnWeb;
	private boolean showOnMobile;
	private Date createdDate;
	private Date updatedDate;
	private String createdBy;
	private String updatedBy;
	private List<Validation> validation;
}


