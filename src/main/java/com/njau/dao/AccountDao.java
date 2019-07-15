package com.njau.dao;

import com.njau.domain.Account.Account;

import java.util.List;

/**
 * @author 张文军
 * @Description:账户持久层接口
 * @Company:南京农业大学工学院
 * @version:1.0
 * @date 2019/7/1422:43
 */

public interface AccountDao {
	/**
	 * @return 查询所有
	 */
	List<Account> findAllAccount();

	/**
	 * @param accountId 根据Id查询
	 * @return
	 */
	Account findAccountById(Integer accountId);

	/**
	 * @param account 保存账户
	 * @return
	 */
	void saveAccount(Account account);

	/**
	 * @param account 更新账户
	 * @return
	 */
	void updateAccount(Account account);

	/**
	 * @param accountId 删除账户
	 */
	void deleteAccountById(Integer accountId);
}
