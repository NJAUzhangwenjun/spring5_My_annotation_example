package com.njau.service.impl;

import com.njau.dao.AccountDao;
import com.njau.domain.Account.Account;
import com.njau.service.AccountService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 张文军
 * @Description:账户业务层实现类
 * @Company:南京农业大学工学院
 * @version:1.0
 * @date 2019/7/1422:27
 */

@Data
@Service("accountService")
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountDao accountDao;

	@Override
	public List<Account> findAllAccount() {
		return accountDao.findAllAccount();
	}

	@Override
	public Account findAccountById(Integer accountId) {
		return accountDao.findAccountById(accountId);
	}

	@Override
	public void saveAccount(Account account) {
		accountDao.saveAccount(account);
	}

	@Override
	public void updateAccount(Account account) {
		accountDao.updateAccount(account);
	}

	@Override
	public void deleteAccountById(Integer accountId) {
		accountDao.deleteAccountById(accountId);
	}
}
