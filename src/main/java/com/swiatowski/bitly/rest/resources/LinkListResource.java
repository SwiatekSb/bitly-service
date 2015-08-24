package com.swiatowski.bitly.rest.resources;

import com.swiatowski.bitly.core.models.entities.Link;
import com.swiatowski.bitly.core.services.util.LinkList;
import org.springframework.hateoas.ResourceSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Piotrek on 8/24/2015.
 */
public class LinkListResource extends ResourceSupport {

    private List<Link> linkList = new ArrayList();

    public LinkListResource(LinkList allLinks) {
        this.linkList = allLinks.getLinkList();
    }

    public List<Link> getLinkList() {
        return linkList;
    }

    public void setLinkList(List<Link> linkList) {
        this.linkList = linkList;
    }
}
