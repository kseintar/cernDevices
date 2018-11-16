package com.cern.devices;

import com.cern.devices.dao.DeviceRepository;
import com.cern.devices.dao.UserRepository;
import com.cern.devices.entity.Device;
import com.cern.devices.entity.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Timestamp;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner loadData(UserRepository repository, DeviceRepository deviceRepository) {
		return args -> {
            repository.save(new User("Konstantinos","Seintaridis","seinta","123"));

            deviceRepository.save(new Device("YGPS.QS30","Acquisition",1f,new Timestamp(System.currentTimeMillis()),"acq1"));

			deviceRepository.save(new Device("XT00.RQ.1400","MEAS.I",0.f,new Timestamp(System.currentTimeMillis()),"value"));


		};
	}

}
