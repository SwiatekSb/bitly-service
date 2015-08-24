package com.swiatowski.bitly.core.services;

import com.swiatowski.bitly.core.models.entities.Link;
import com.swiatowski.bitly.core.services.util.LinkList;

/**
 * Created by Piotrek on 8/24/2015.
 */
public interface LinkService {

    Link createLink(String url);

    LinkList findAllLinks();

    Link findLink(Long id);

    Link deleteLink(Long id);

    Link findByEncodeName(String encodeUrl);

}
