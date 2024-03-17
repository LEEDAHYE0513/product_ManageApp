package com.ssg.product_manageapp.config;

import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapper {

    @Bean
    public org.modelmapper.ModelMapper getMapper(){
        org.modelmapper.ModelMapper modelMapper = new org.modelmapper.ModelMapper();
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper;
    }

}
