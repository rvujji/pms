package com.xinthe.pms.model;

import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Content implements Serializable {
	private String _id;
	private String labelName;
	private String labelValue;
	private List<String> args;
}


