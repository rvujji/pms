package com.xinthe.pms.utils;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.Supplier;

import com.xinthe.pms.model.*;

public class HelperUtil {

    private HelperUtil() {
    }

	public static Supplier<List<PmsCollection>> pmsCollection = () ->
	{
		Field field1 = Field.builder()
				.id("123")
				.labelName("Label1")
				.labelValue("Value1")
				.showOnWeb(true)
				.showOnMobile(false)
				.createdDate(new Date())
				.updatedDate(new Date())
				.createdBy("User1")
				.updatedBy("User1")
				.validation(Arrays.asList(new Validation())).build();

		Field field2 = Field.builder()
				.id("456")
				.labelName("Label2")
				.labelValue("Value2")
				.showOnWeb(true)
				.showOnMobile(false)
				.createdDate(new Date())
				.updatedDate(new Date())
				.createdBy("User2")
				.updatedBy("User2")
				.validation(Arrays.asList(new Validation())).build();

		List<Field> fieldList = Arrays.asList(field1, field2);
		Section section1 = Section.builder().id("1").sectionLabelId("Label1")
				.createdDate(new Date()).updatedDate(new Date())
				.createdBy("User1").updatedBy("User1")
				.fields(fieldList).build();

		Section section2 = Section.builder().id("2").sectionLabelId("Label2")
				.createdDate(new Date()).updatedDate(new Date())
				.createdBy("User2").updatedBy("User2")
				.fields(fieldList).build();

		List<Section> sectionList = Arrays.asList(section1, section2);
			return Arrays.asList(

					PmsCollection.builder().id("1").name("Binay").description("Label1").createdDate(new Date()).updatedDate(new Date())
							.createdBy("User1").updatedBy("User1")
							.showOnWeb(true).showOnMobile(false).build(),

					PmsCollection.builder().id("2").name("John").description("Label2").createdDate(new Date()).updatedDate(new Date())
							.createdBy("User2").updatedBy("User2")
							.showOnWeb(true).showOnMobile(false).build());
	};
}
