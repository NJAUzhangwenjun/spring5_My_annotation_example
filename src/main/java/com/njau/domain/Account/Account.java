package com.njau.domain.Account;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 张文军
 * @Description:账户实体类
 * @Company:南京农业大学工学院
 * @version:1.0
 * @date 2019/7/1422:29
 */
@Data
public class Account implements Serializable {
	private Integer id;
	private String name;
	private Float money;

	public Account(Integer id, String name, Float money) {
		this.id = id;
		this.name = name;
		this.money = money;
	}

	public Account() {
	}
}
