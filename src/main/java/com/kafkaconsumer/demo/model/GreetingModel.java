package com.kafkaconsumer.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GreetingModel {
	private String id;
	private String message;
	private Double balance;
}
