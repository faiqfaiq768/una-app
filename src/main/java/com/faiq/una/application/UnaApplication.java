package com.faiq.una.application;

import com.faiq.una.persistence.entity.MasterJenisAsuransi;
import com.faiq.una.persistence.entity.MasterJenisKelamin;
import com.faiq.una.persistence.repository.MasterJenisAsuransiRepository;
import com.faiq.una.persistence.repository.MasterJenisKelaminRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.sql.Timestamp;

@SpringBootApplication
@ComponentScan("com.faiq.una")
@EntityScan({"com.faiq.una.persistence"})
@EnableJpaRepositories({"com.faiq.una.persistence"})
public class UnaApplication {

	public static void main(String[] args) {
		SpringApplication.run(UnaApplication.class, args);
	}

}
