package com.andrei.projectendava.dao;


import com.andrei.projectendava.entities.UserAccount;
import org.springframework.data.repository.CrudRepository;

public interface UserAccountRepository extends CrudRepository<UserAccount, Long> {

}
