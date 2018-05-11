package lv.va.sludinajumuportals.dao;

import java.util.List;
import lv.va.sludinajumuportals.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepository extends CrudRepository<User, Long>{
    public List<User> findByUserName(String name, String surename);
}