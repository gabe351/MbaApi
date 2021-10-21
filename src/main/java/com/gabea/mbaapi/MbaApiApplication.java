package com.gabea.mbaapi;

import com.gabea.mbaapi.model.Payment;
import com.gabea.mbaapi.model.User;
import com.gabea.mbaapi.model.enums.InstrumentEnum;
import com.gabea.mbaapi.model.enums.SituationEnum;
import com.gabea.mbaapi.model.enums.UserTypeEnum;
import com.gabea.mbaapi.repository.PaymentRepository;
import com.gabea.mbaapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class MbaApiApplication  {

    public static void main(String[] args) {
        SpringApplication.run(MbaApiApplication.class, args);
    }
}
