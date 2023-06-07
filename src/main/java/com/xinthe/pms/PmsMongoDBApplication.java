package com.xinthe.pms;

import com.xinthe.pms.model.Project;
import com.xinthe.pms.repository.ProjectRepository;
import com.xinthe.pms.utils.HelperUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;


@SpringBootApplication
@EnableMongoRepositories
@EnableFeignClients
@EnableSwagger2
@ComponentScan("com.xinthe.pms")
public class PmsMongoDBApplication {

	private final Logger LOGGER = LoggerFactory.getLogger(getClass());

	public static void main(String[] args) {
		SpringApplication.run(PmsMongoDBApplication.class, args);
	}


	@Autowired
	private ProjectRepository projectRepository;


	@Bean
	CommandLineRunner runner() {
		return args -> {
			List<Project> pmsCollectionList = projectRepository.findAll();
				if (pmsCollectionList.size() == 0) {
					LOGGER.info("******* Inserting PMS Collection to DB *******");
					projectRepository.saveAll(HelperUtil.Project.get());
				} else {
					LOGGER.info("******* pmsCollectionList stored in DB Size :: {}", pmsCollectionList.size());
					LOGGER.info("******* pmsCollectionList stored in DB :: {}", pmsCollectionList);
				}
		};
	}

}
