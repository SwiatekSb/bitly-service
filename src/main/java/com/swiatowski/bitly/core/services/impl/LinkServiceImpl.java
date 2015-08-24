package com.swiatowski.bitly.core.services.impl;

import com.swiatowski.bitly.core.models.entities.Link;
import com.swiatowski.bitly.core.services.LinkService;
import com.swiatowski.bitly.core.services.util.LinkList;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Piotrek on 8/24/2015.
 */
@Service
@Transactional
public class LinkServiceImpl implements LinkService {

    @Override
    public Link createLink(Link data) {
        return null;
    }

    @Override
    public LinkList findAllLinks() {
        return null;
    }

    @Override
    public Link findByName(String url) {
        return null;
    }

    @Override
    public Link findByEncodeName(String encodeUrl) {
        return null;
    }
}
