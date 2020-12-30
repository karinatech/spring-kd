package com.orm.repo;

import com.orm.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressReepo extends JpaRepository<Address,Long> {
}
