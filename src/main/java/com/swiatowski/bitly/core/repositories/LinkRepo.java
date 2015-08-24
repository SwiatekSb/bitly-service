package com.swiatowski.bitly.core.repositories;

import com.swiatowski.bitly.core.models.entities.Link;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Piotrek on 8/24/2015.
 */
@Repository
public interface LinkRepo extends CrudRepository<Link, Long> {
}
