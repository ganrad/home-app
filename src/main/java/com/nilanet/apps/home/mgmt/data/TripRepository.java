/**
 * 
 */
package com.nilanet.apps.home.mgmt.data;

import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.nilanet.apps.home.mgmt.model.Trip;

/**
 * Aug 18, 2016
 * <p>
 * Description:
 * DAO for Trip entity.
 * </p>
 *
 * @author gradhakr
 * 
 * <p>Notes:</p>
 */

@Stateless
public class TripRepository {
	@Inject
    private Logger log;
	
	@Inject
    private EntityManager em;
	
	public Trip findById(Long id) {		
		Trip trip = em.find(Trip.class, id);
		if ( trip != null )
			log.info("Retrieved trip=" + trip.getName());
		
		return(trip);
    }
	
	public void saveTrip(Trip trip) throws Exception {
        log.info("Saving new trip=" + trip.getName());
        em.persist(trip);
    }
}
