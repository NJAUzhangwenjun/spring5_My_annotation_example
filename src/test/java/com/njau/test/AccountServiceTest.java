package com.njau.test;

import com.njau.domain.Account.Account;
import com.njau.service.AccountService;
import config.SpringConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author 张文军
 * @Description:
 * @Company:南京农业大学工学院
 * @version:1.0
 * @date 2019/7/150:57
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountServiceTest {

	@Autowired
	AccountService accountService = null;

	@Test
	public void testfindAll() {
		List<Account> allAccount = accountService.findAllAccount();
		for (Account account : allAccount) {
			System.out.println(account);
		}
	}

	@Test
	public void testfindOne() {
		Account account = accountService.findAccountById(1);
		System.out.println(account);
	}

	@Test
	public void testSave() {
		Account account = new Account();
		account.setName("zhangwenjun");
		account.setMoney(123.123f);
		accountService.saveAccount(account);
	}

	@Test
	public void testUpdate() {
		Account account = accountService.findAccountById(1);
		account.setName("六四");
		accountService.updateAccount(account);
	}

	@Test
	public void testDelete() {
		accountService.deleteAccountById(4);
	}

/*	*//**
	 * @Description: 从容器中获取对象的方法
	 * @Param:[]
	 * @return: com.njau.service.AccountService
	 * @Author: 张文军
	 * @Date: 2019/7/15
	 *//*
	private AccountService getAccountService() {
		//ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
		AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
		return accountService;
	}*/
}
