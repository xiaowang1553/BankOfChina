package com.javen.dao;
import com.javen.bean.Account;
import com.javen.bean.User;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Insert;


public interface IAccountDao {
   @Select("select * from account where id=#{id} and type=#{type} and accountNum=#{accountNum}")
   Account selectAccount(@Param("id")String id,@Param("type")String type,@Param("accountNum")Integer accountNum);
   @Insert("insert into account(id,type,bankType,deposit,leftTransfer,isLost,accountNum,isFrozen,password) values(#{id},#{type},#{bankType},#{deposit},#{leftTransfer},#{isLost},#{accountNum},#{isFrozen},#{password})")
   void insertAccount(Account account); 
   @Update("update account set lastLogin=#{lastLogin},leftTransfer=#{leftTransfer} where id=#{id} and accountNum=#{accountNum}")
	void updateByAccountNum(Account account);
   @Update("update account set deposit=deposit-#{amount},leftTransfer=leftTransfer-#{amount} where accountNum=#{accountNum}")
   void accountWithdraw(@Param("amount")Double amount,@Param("accountNum")Integer accountNum);
}
