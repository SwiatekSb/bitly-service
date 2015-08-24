package com.swiatowski.bitly.core.repositories.jpa;

import com.swiatowski.bitly.core.models.entities.Link;
import com.swiatowski.bitly.core.repositories.LinkRepo;
import com.swiatowski.bitly.core.services.util.EncodeUrlHelper;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Piotrek on 8/24/2015.
 */
@Repository
public class JpaLinkRepo implements LinkRepo {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Link createLink(String url) {
        Link link = new Link();
        link.setUrl(url);
        em.persist(link);

        Link newLink = addEncodeUrl(url);

        em.persist(newLink);
        return newLink;
    }

    @Override
    public List<Link> findAllLinks() {
        Query query = em.createQuery("SELECT l from Link l");
        return query.getResultList();
    }

    @Override
    public Link findByName(String url) {
        Query query = em.createQuery("SELECT l FROM Link l where l.url=?1");
        query.setParameter(1, url);

        return getLinkFromQuery(query);
    }

    @Override
    public Link findLink(Long id) {
        Link link = em.find(Link.class, id);
        return link;
    }

    @Override
    public Link deleteLink(Long id) {
        Link link = em.find(Link.class, id);
        em.remove(link);
        return link;
    }

    @Override
    public Link findByEncodeName(String encodeUrl) {
        Query query = em.createQuery("SELECT l FROM Link l where l.encodeUrl=?1");
        query.setParameter(1, encodeUrl);

        return getLinkFromQuery(query);
    }

    private Link getLinkFromQuery(Query query) {
        List<Link> resultList = query.getResultList();
        if (resultList.isEmpty()) {
            return null;
        } else {
            return resultList.get(0);
        }
    }

    private Link addEncodeUrl(String url) {
        Link link = findByName(url);
        link.setEncodeUrl(EncodeUrlHelper.encode(link.getId()));
        return link;
    }

}
