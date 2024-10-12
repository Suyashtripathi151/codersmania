package com.jestersClub.codersMania.repositories;

import com.jestersClub.codersMania.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
@Repository
public interface UserRepository extends JpaRepository<Users,String>  {
    Users findByEmail(String email);

    @Modifying
    @Transactional
    @Query("UPDATE Users u SET u.isVerified = true WHERE u.email = :email")
    void updateIsVerifiedByEmail(String email);
}
