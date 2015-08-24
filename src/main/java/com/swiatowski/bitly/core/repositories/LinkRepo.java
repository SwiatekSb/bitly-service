package com.swiatowski.bitly.core.repositories;

import com.swiatowski.bitly.core.models.entities.Link;

import java.util.List;

/**
 * Created by Piotrek on 8/24/2015.
 */
public interface LinkRepo {

    Link createLink(String url);

    List<Link> findAllLinks();

    Link findLink(Long id);

    Link deleteLink(Long id);

    Link findByEncodeName(String encodeUrl);

    Link findByName(String url);

}
