package com.swiatowski.bitly.core.services.util;

import com.swiatowski.bitly.core.models.entities.Link;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Piotrek on 8/24/2015.
 */
public class LinkList {

    private List<Link> linkList;

    public LinkList() {
        linkList = new ArrayList();
    }

    public List<Link> getLinkList() {
        return linkList;
    }

    public void setLinkList(List<Link> linkList) {
        this.linkList = linkList;
    }

}
