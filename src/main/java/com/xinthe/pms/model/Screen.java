package com.xinthe.pms.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Screen implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private String screenId;
	private String projectId;
	private String screenLabelId;
	private String viewTemplateId;
	private Date createdDate;
	private Date updatedDate;
	private String createdBy;
	private String updatedBy;
	private List<Section> sections;
	private boolean showOnWeb;
	private boolean showOnMobile;
}

