/**
 * 
 */
package com.nilanet.apps.home.mgmt.rest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nilanet.apps.home.mgmt.data.TripRepository;
import com.nilanet.apps.home.mgmt.model.Trip;

/**
 * Aug 18, 2016
 * <p>
 * Description:
 * Exposes a JAX-RS service for managing the Trip domain object.
 * </p>
 * 
 * @author gradhakr
 * 
 * <p>
 * Notes:
 * </p>
 */
@Path("/trips")
@RequestScoped
public class TripService {
	@Inject
    private Logger log;

    @Inject
    private Validator validator;
    
    @Inject
    private TripRepository repository;
    
	@Inject
	private EntityManager em;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Trip> getAllTrips() {
		log.info("Retrieving all trips");
		
		List<Trip> results =
			em.createQuery(
			"select t from Trip t order by t.name").getResultList();
		return results;
	}
	
	@GET
	@Path("/{id:[0-9][0-9]*}")
	@Produces(MediaType.APPLICATION_JSON)
	public Trip lookupTripById(@PathParam("id") long id) {
		log.info("Retrieving Trip by ID=" + id);
		
		Trip trip = repository.findById(id);
		if (trip == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
		return trip;
	}

	/**
     * Creates a new trip from the values provided. Performs validation, and will return a JAX-RS response with either 200 ok,
     * or with a map of fields, and related errors.
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createTrip(Trip trip) {
    	log.info("Creating new=" + trip.toString());
    	
        Response.ResponseBuilder builder = null;

        try {
            // Validates trip using bean validation
            validateTrip(trip);

            repository.saveTrip(trip);

            // Create an "ok" response
            builder = Response.ok();
        } catch (ConstraintViolationException ce) {
            // Handle bean validation issues
            builder = createViolationResponse(ce.getConstraintViolations());
        } catch (Exception e) {
            // Handle generic exceptions
            Map<String, String> responseObj = new HashMap<String, String>();
            responseObj.put("error", e.getMessage());
            builder = Response.status(Response.Status.BAD_REQUEST).entity(responseObj);
        }

        return builder.build();
    }
    
    /**
     * <p>
     * Validates the given Trip variable and throws validation exceptions based on the type of error. If the error is standard
     * bean validation errors then it will throw a ConstraintValidationException with the set of the constraints violated.
     * </p>
     * 
     * 
     * @param trip Trip to be validated
     * @throws ConstraintViolationException If Bean Validation errors exist
     */
    private void validateTrip(Trip trip) throws ConstraintViolationException {
        // Create a bean validator and check for issues.
        Set<ConstraintViolation<Trip>> violations = validator.validate(trip);

        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(new HashSet<ConstraintViolation<?>>(violations));
        }
    }
    
    /**
     * Creates a JAX-RS "Bad Request" response including a map of all violation fields, and their message. This can then be used
     * by clients to show violations.
     * 
     * @param violations A set of violations that needs to be reported
     * @return JAX-RS response containing all violations
     */
    private Response.ResponseBuilder createViolationResponse(Set<ConstraintViolation<?>> violations) {
        log.info("Validation completed. violations found=" + violations.size());

        Map<String, String> responseObj = new HashMap<String, String>();

        for (ConstraintViolation<?> violation : violations) {
            responseObj.put(violation.getPropertyPath().toString(), violation.getMessage());
        }

        return Response.status(Response.Status.BAD_REQUEST).entity(responseObj);
    }
}
