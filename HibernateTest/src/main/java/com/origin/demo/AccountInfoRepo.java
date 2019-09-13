package com.origin.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AccountInfoRepo extends JpaRepository<AccountInfo, Integer>{

}
