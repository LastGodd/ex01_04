package org.zerock.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class Restaurant {
	
	@Autowired
	private Restaurant restaurant;
	
}
