package com.njau.dao.impl;

import com.njau.dao.AccountDao;
import com.njau.domain.Account.Account;
import lombok.Data;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * @author 张文军
 * @Description:账户持久层实现类
 * @Company:南京农业大学工学院
 * @version:1.0
 * @date 2019/7/1422:45
 */

@Data
@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {

	@Autowired
	private QueryRunner runner;

	@Override
	public List<Account> findAllAccount() {
		List<Account> accountList = null;
		try {
			accountList = runner.query("select * from account", new BeanListHandler<Account>(Account.class));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return accountList;
	}

	@Override
	public Account findAccountById(Integer accountId) {
		try {
			return runner.query("select * from account where id = ? ",new BeanHandler<Account>(Account.class),accountId);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void saveAccount(Account account) {
		try {
			 runner.update("insert into account(name,money) values(?,?)",account.getName(),account.getMoney());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void updateAccount(Account account) {
		try {
			runner.update("update account set name =?,money=? where id =?",account.getName(),account.getMoney(),account.getId());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void deleteAccountById(Integer accountId) {
		try {
			runner.update("delete from account where id =?",accountId);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
