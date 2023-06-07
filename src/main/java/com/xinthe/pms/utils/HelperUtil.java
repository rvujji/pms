package com.xinthe.pms.utils;

import com.xinthe.pms.model.Field;
import com.xinthe.pms.model.Project;
import com.xinthe.pms.model.Section;
import com.xinthe.pms.model.Validation;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.Supplier;

public class HelperUtil {

    private HelperUtil() {
    }

    public static Supplier<List<Project>> Project = () ->
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
                com.xinthe.pms.model.Project.builder().id("1").fProjectName("pms1").fCode("pms-001").fDescription("Project 1").fStartDate(new Date()).fEndDate(new Date()).fDomain("Project Management").fProgram("").fPortfolio("").fBudget("").fStatus("").fPriority("").fOwnerName("").fOwnerEmail("").fMethodology("").fCountry("IN").fState("AP").build(),
                com.xinthe.pms.model.Project.builder().id("2").fProjectName("pms2").fCode("pms-002").fDescription("Project 2").fStartDate(new Date()).fEndDate(new Date()).fDomain("Project Management").fProgram("").fPortfolio("").fBudget("").fStatus("").fPriority("").fOwnerName("").fOwnerEmail("").fMethodology("").fCountry("IN").fState("AP").build(),
                com.xinthe.pms.model.Project.builder().id("3").fProjectName("pms3").fCode("pms-003").fDescription("Project 3").fStartDate(new Date()).fEndDate(new Date()).fDomain("Project Management").fProgram("").fPortfolio("").fBudget("").fStatus("").fPriority("").fOwnerName("").fOwnerEmail("").fMethodology("").fCountry("IN").fState("AP").build());

    };


}
