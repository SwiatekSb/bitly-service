package com.swiatowski.bitly.rest.controllers;

import com.swiatowski.bitly.core.models.entities.Link;
import com.swiatowski.bitly.core.services.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Piotrek on 8/24/2015.
 */
@Controller
public class RedirectController {

    private LinkService linkService;

    @Autowired
    public RedirectController(LinkService linkService) {
        this.linkService = linkService;
    }

    @RequestMapping(value = "/{encodeUrl}", method = RequestMethod.GET)
    @ResponseBody
    public void sendRedirect(@PathVariable String encodeUrl, HttpServletResponse httpServletResponse) throws IOException {
        Link link = linkService.findByEncodeName(encodeUrl);
        if (link != null) {
            String url = link.getUrl();
            httpServletResponse.sendRedirect(url);
        } else {
            httpServletResponse.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

}
