package com.swiatowski.bitly.rest.resources;


import com.swiatowski.bitly.core.models.entities.Link;
import org.springframework.hateoas.ResourceSupport;

/**
 * Created by Piotrek on 8/24/2015.
 */
public class LinkResource extends ResourceSupport {
    private String url;
    private String encodeUrl;

    public LinkResource(Link link) {
        this.url = link.getUrl();
        this.encodeUrl = link.getEncodeUrl();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getEncodeUrl() {
        return encodeUrl;
    }

    public void setEncodeUrl(String encodeUrl) {
        this.encodeUrl = encodeUrl;
    }
}
