/**
 * ***************************************************************************** Turnstone Biologics
 * Confidential
 *
 * <p>2018 Turnstone Biologics All Rights Reserved.
 *
 * <p>This file is subject to the terms and conditions defined in file 'license.txt', which is part
 * of this source code package.
 *
 * <p>Contributors : Turnstone Biologics - General Release
 * ****************************************************************************
 */
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for EarthFaultCompensator as outlined for the CQRS pattern. All event handling and
 * query handling related to EarthFaultCompensator are invoked here and dispersed as an event to be
 * handled elsewhere.
 *
 * <p>Commands are handled by EarthFaultCompensatorAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("earthFaultCompensator")
@Component("earthFaultCompensator-projector")
public class EarthFaultCompensatorProjector extends EarthFaultCompensatorEntityProjector {

  // core constructor
  public EarthFaultCompensatorProjector(
      EarthFaultCompensatorRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateEarthFaultCompensatorEvent
   */
  @EventHandler(payloadType = CreateEarthFaultCompensatorEvent.class)
  public void handle(CreateEarthFaultCompensatorEvent event) {
    LOGGER.info("handling CreateEarthFaultCompensatorEvent - " + event);
    EarthFaultCompensator entity = new EarthFaultCompensator();
    entity.setEarthFaultCompensatorId(event.getEarthFaultCompensatorId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEarthFaultCompensator(entity);
  }

  /*
   * @param	event UpdateEarthFaultCompensatorEvent
   */
  @EventHandler(payloadType = UpdateEarthFaultCompensatorEvent.class)
  public void handle(UpdateEarthFaultCompensatorEvent event) {
    LOGGER.info("handling UpdateEarthFaultCompensatorEvent - " + event);

    EarthFaultCompensator entity = new EarthFaultCompensator();
    entity.setEarthFaultCompensatorId(event.getEarthFaultCompensatorId());
    entity.setR(event.getR());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEarthFaultCompensator(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEarthFaultCompensator(entity);
  }

  /*
   * @param	event DeleteEarthFaultCompensatorEvent
   */
  @EventHandler(payloadType = DeleteEarthFaultCompensatorEvent.class)
  public void handle(DeleteEarthFaultCompensatorEvent event) {
    LOGGER.info("handling DeleteEarthFaultCompensatorEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    EarthFaultCompensator entity = delete(event.getEarthFaultCompensatorId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEarthFaultCompensator(entity);
  }

  /*
   * @param	event AssignRToEarthFaultCompensatorEvent
   */
  @EventHandler(payloadType = AssignRToEarthFaultCompensatorEvent.class)
  public void handle(AssignRToEarthFaultCompensatorEvent event) {
    LOGGER.info("handling AssignRToEarthFaultCompensatorEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    EarthFaultCompensator entity =
        assignR(event.getEarthFaultCompensatorId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEarthFaultCompensator(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEarthFaultCompensator(entity);
  }

  /*
   * @param	event UnAssignRFromEarthFaultCompensatorEvent
   */
  @EventHandler(payloadType = UnAssignRFromEarthFaultCompensatorEvent.class)
  public void handle(UnAssignRFromEarthFaultCompensatorEvent event) {
    LOGGER.info("handling UnAssignRFromEarthFaultCompensatorEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    EarthFaultCompensator entity = unAssignR(event.getEarthFaultCompensatorId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEarthFaultCompensator(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEarthFaultCompensator(entity);
  }

  /**
   * Method to retrieve the EarthFaultCompensator via an EarthFaultCompensatorPrimaryKey.
   *
   * @param id Long
   * @return EarthFaultCompensator
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public EarthFaultCompensator handle(FindEarthFaultCompensatorQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getEarthFaultCompensatorId());
  }

  /**
   * Method to retrieve a collection of all EarthFaultCompensators
   *
   * @param query FindAllEarthFaultCompensatorQuery
   * @return List<EarthFaultCompensator>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<EarthFaultCompensator> handle(FindAllEarthFaultCompensatorQuery query)
      throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindEarthFaultCompensator, but only if the id matches
   *
   * @param entity EarthFaultCompensator
   */
  protected void emitFindEarthFaultCompensator(EarthFaultCompensator entity) {
    LOGGER.info("handling emitFindEarthFaultCompensator");

    queryUpdateEmitter.emit(
        FindEarthFaultCompensatorQuery.class,
        query ->
            query
                .getFilter()
                .getEarthFaultCompensatorId()
                .equals(entity.getEarthFaultCompensatorId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllEarthFaultCompensator
   *
   * @param entity EarthFaultCompensator
   */
  protected void emitFindAllEarthFaultCompensator(EarthFaultCompensator entity) {
    LOGGER.info("handling emitFindAllEarthFaultCompensator");

    queryUpdateEmitter.emit(FindAllEarthFaultCompensatorQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER =
      Logger.getLogger(EarthFaultCompensatorProjector.class.getName());
}
