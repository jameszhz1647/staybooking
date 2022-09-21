package com.jameszhz.staybooking.repository;

import com.jameszhz.staybooking.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {   //JpaRepository 等同于 hibernate.sessionFactory,
                                                                        // 但已经实现了简单的CRUD， No More DAO Implementations

}
