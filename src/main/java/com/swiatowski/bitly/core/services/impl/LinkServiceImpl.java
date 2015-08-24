package com.swiatowski.bitly.core.services.impl;

import com.google.common.collect.Lists;
import com.swiatowski.bitly.core.models.entities.Link;
import com.swiatowski.bitly.core.repositories.LinkRepo;
import com.swiatowski.bitly.core.services.LinkService;
import com.swiatowski.bitly.core.services.exceptions.LinkExistsException;
import com.swiatowski.bitly.core.services.util.LinkList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Piotrek on 8/24/2015.
 */
@Service
@Transactional
public class LinkServiceImpl implements LinkService {

    @Autowired
    private LinkRepo linkRepo;

    @Override
    public Link createLink(String url) {
        Link link = linkRepo.findByName(url);
        if (link != null) {
            throw new LinkExistsException();
        }
        return linkRepo.createLink(url);
    }

    @Override
    public LinkList findAllLinks() {
        return new LinkList(Lists.newArrayList(linkRepo.findAllLinks()));
    }

    @Override
    public Link findLink(Long id) {
        return linkRepo.findLink(id);
    }

    @Override
    public Link deleteLink(Long id) {
        return linkRepo.deleteLink(id);
    }

    @Override
    public Link findByEncodeName(String encodeUrl) {
        return linkRepo.findByEncodeName(encodeUrl);
    }

}
