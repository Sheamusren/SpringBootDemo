package com.example.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author sheamus
 * @date 2018/9/11.
 */
@Setter
@Getter
@ToString
public class User {
	private Integer uid;
	private String username;
	private String password;
}
