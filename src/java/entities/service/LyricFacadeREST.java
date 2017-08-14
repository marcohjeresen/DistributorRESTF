/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.service;

import entities.Lyric;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author markh
 */
@Stateless
@Path("entities.lyric")
public class LyricFacadeREST extends AbstractFacade<Lyric> {

    @PersistenceContext(unitName = "DistributorRESTFPU")
    private EntityManager em;

    public LyricFacadeREST() {
        super(Lyric.class);
    }


    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Lyric entity) {
        super.create(entity);
    }
    
    
    @GET
    @Path("/findById/{id}")
    @Produces({"application/xml", "application/json"})
    public Lyric findById(@PathParam("id") Integer id) {
        return super.find(id);
    }

    
    @GET
    @Path("/searchLyric/{title}")
    @Produces({"application/xml", "application/json"})
    public List<Lyric> searchTitle(@PathParam("title") String title) {
        List<Lyric> fullList = super.findAll();
        List<Lyric> editList = fullList;
        for (int i = 0; i < fullList.size(); i++) {
            String listTitle = fullList.get(i).getLyTitle();
            if (!listTitle.contains(title)) {
                editList.remove(i);
                i--;
            }
        } 
        return editList;
    }




    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
