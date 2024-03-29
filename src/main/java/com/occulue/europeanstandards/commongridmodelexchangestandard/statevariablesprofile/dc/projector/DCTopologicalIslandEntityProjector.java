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
package com.occulue.europeanstandards.commongridmodelexchangestandard.statevariablesprofile.dc.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.statevariablesprofile.dc.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for DCTopologicalIsland as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by DCTopologicalIslandAggregate
 *
 * @author your_name_here
 */
@Component("dCTopologicalIsland-entity-projector")
public class DCTopologicalIslandEntityProjector {

  // core constructor
  public DCTopologicalIslandEntityProjector(DCTopologicalIslandRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a DCTopologicalIsland
   *
   * @param	entity DCTopologicalIsland
   */
  public DCTopologicalIsland create(DCTopologicalIsland entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a DCTopologicalIsland
   *
   * @param	entity DCTopologicalIsland
   */
  public DCTopologicalIsland update(DCTopologicalIsland entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a DCTopologicalIsland
   *
   * @param	id		UUID
   */
  public DCTopologicalIsland delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    DCTopologicalIsland entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a DCTopologicalIsland
   *
   * @param	parentId	UUID
   * @param	assignment 	DCTopologicalIsland
   * @return	DCTopologicalIsland
   */
  public DCTopologicalIsland assignDCTopologicalIsland(
      UUID parentId, DCTopologicalIsland assignment) {
    LOGGER.info("assigning DCTopologicalIsland as " + assignment.toString());

    DCTopologicalIsland parentEntity = repository.findById(parentId).get();
    assignment = DCTopologicalIslandProjector.find(assignment.getDCTopologicalIslandId());

    // ------------------------------------------
    // assign the DCTopologicalIsland to the parent entity
    // ------------------------------------------
    parentEntity.setDCTopologicalIsland(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the DCTopologicalIsland
   *
   * @param	parentId		UUID
   * @return	DCTopologicalIsland
   */
  public DCTopologicalIsland unAssignDCTopologicalIsland(UUID parentId) {
    DCTopologicalIsland parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning DCTopologicalIsland on " + parentEntity.toString());

    // ------------------------------------------
    // null out the DCTopologicalIsland on the parent entithy
    // ------------------------------------------
    parentEntity.setDCTopologicalIsland(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the DCTopologicalIsland via an FindDCTopologicalIslandQuery
   *
   * @return query FindDCTopologicalIslandQuery
   */
  @SuppressWarnings("unused")
  public DCTopologicalIsland find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a DCTopologicalIsland - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all DCTopologicalIslands
   *
   * @param query FindAllDCTopologicalIslandQuery
   * @return List<DCTopologicalIsland>
   */
  @SuppressWarnings("unused")
  public List<DCTopologicalIsland> findAll(FindAllDCTopologicalIslandQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all DCTopologicalIsland - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final DCTopologicalIslandRepository repository;

  @Autowired
  @Qualifier(value = "dCTopologicalIsland-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.statevariablesprofile.dc
          .DCTopologicalIslandEntityProjector
      DCTopologicalIslandProjector;

  private static final Logger LOGGER =
      Logger.getLogger(DCTopologicalIslandEntityProjector.class.getName());
}
