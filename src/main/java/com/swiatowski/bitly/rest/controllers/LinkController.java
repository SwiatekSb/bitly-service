package com.swiatowski.bitly.rest.controllers;

import com.swiatowski.bitly.core.models.entities.Link;
import com.swiatowski.bitly.core.services.LinkService;
import com.swiatowski.bitly.core.services.LinkValidationService;
import com.swiatowski.bitly.core.services.exceptions.LinkBadUrlException;
import com.swiatowski.bitly.core.services.exceptions.LinkExistsException;
import com.swiatowski.bitly.rest.resources.LinkListResource;
import com.swiatowski.bitly.rest.resources.LinkResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Piotrek on 8/24/2015.
 */
@RestController
@RequestMapping(value = "/rest/link")
public class LinkController {

    private LinkService linkService;
    private LinkValidationService linkValidationService;

    @Autowired
    public LinkController(LinkService linkService, LinkValidationService linkValidationService) {
        this.linkService = linkService;
        this.linkValidationService = linkValidationService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<LinkResource> createLink(@RequestBody String url) {
        try {
            linkValidationService.validateUrl(url);
            return new ResponseEntity<LinkResource>(new LinkResource(linkService.createLink(url)), HttpStatus.CREATED);
        } catch (LinkExistsException e) {
            return new ResponseEntity<LinkResource>(HttpStatus.CONFLICT);
        } catch (LinkBadUrlException e) {
            return new ResponseEntity<LinkResource>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<LinkListResource> getAllLinks() {
        return new ResponseEntity<LinkListResource>(new LinkListResource(linkService.findAllLinks()), HttpStatus.OK);
    }

    @RequestMapping(value = "/{linkId}", method = RequestMethod.DELETE)
    public ResponseEntity<LinkResource> deleteLink(
            @PathVariable Long linkId) {
        Link link = linkService.deleteLink(linkId);
        if (link != null) {
            LinkResource res = new LinkResource(link);
            return new ResponseEntity<LinkResource>(res, HttpStatus.OK);
        } else {
            return new ResponseEntity<LinkResource>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/{linkId}", method = RequestMethod.GET)
    public ResponseEntity<LinkResource> getLinkById(@PathVariable Long linkId) {
        Link link = linkService.findLink(linkId);
        if (link != null) {
            return new ResponseEntity<LinkResource>(new LinkResource(link), HttpStatus.OK);
        } else {
            return new ResponseEntity<LinkResource>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/encode/{encodeUrl}", method = RequestMethod.GET)
    public ResponseEntity<LinkResource> getLinkByEncodeUrl(@PathVariable String encodeUrl) {
        Link link = linkService.findByEncodeName(encodeUrl);
        if (link != null) {
            return new ResponseEntity<LinkResource>(new LinkResource(link), HttpStatus.OK);
        } else {
            return new ResponseEntity<LinkResource>(HttpStatus.NOT_FOUND);
        }
    }

}
