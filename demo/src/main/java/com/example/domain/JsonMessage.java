package com.example.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;
/**
 * @author sheamus
 * @date 2018/9/11.
 */
@Data
public class JsonMessage implements Serializable {
	private String responseCode;
	private String errorMessage;
	private Map data;
}
