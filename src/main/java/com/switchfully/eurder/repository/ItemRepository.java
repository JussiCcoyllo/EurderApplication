package com.switchfully.eurder.repository;

import com.switchfully.eurder.entity.Item;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

}
