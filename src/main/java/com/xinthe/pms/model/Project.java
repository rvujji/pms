package com.xinthe.pms.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
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
public class Project implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private String fProjectName;
	private String fCode;
	private String fDescription;
	private Date fStartDate;
	private Date fEndDate;
	private String fDomain;
	private String fProgram;
	private String fPortfolio;
	private String fBudget;
	private String fStatus;
	private String fPriority;
	private String fOwnerName;
	private String fOwnerEmail;
	private String fMethodology;
	private String fCountry;
	private String fState;
	private Date createdDate;
	private Date updatedDate;
	private String createdBy;
	private String updatedBy;
	private List<Screen> screens;
	private boolean showOnWeb;
	private boolean showOnMobile;
}

