package com.switchfully.eurder.repository;

import com.switchfully.eurder.entity.Eurder;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.time.*;
import java.util.*;

@Repository
public interface EurderRepository extends JpaRepository<Eurder, Long>  {
    List<Eurder> findAllByCustomerId(Long customerId);
    List<Eurder> findAllByEurderItemGroups_shippingDate(LocalDate shippingDate);

}
