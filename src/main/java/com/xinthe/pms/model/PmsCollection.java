package com.xinthe.pms.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PmsCollection implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private String name;
	private String description;
	private String locale;
	private Date createdDate;
	private Date updatedDate;
	private String createdBy;
	private String updatedBy;
	private List<Screen> screens;
	private boolean showOnWeb;
	private boolean showOnMobile;
}

