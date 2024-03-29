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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.userdefinedmodels.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.userdefinedmodels.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for ExcitationSystemUserDefined as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by ExcitationSystemUserDefinedAggregate
 *
 * @author your_name_here
 */
@Component("excitationSystemUserDefined-entity-projector")
public class ExcitationSystemUserDefinedEntityProjector {

  // core constructor
  public ExcitationSystemUserDefinedEntityProjector(
      ExcitationSystemUserDefinedRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a ExcitationSystemUserDefined
   *
   * @param	entity ExcitationSystemUserDefined
   */
  public ExcitationSystemUserDefined create(ExcitationSystemUserDefined entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a ExcitationSystemUserDefined
   *
   * @param	entity ExcitationSystemUserDefined
   */
  public ExcitationSystemUserDefined update(ExcitationSystemUserDefined entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a ExcitationSystemUserDefined
   *
   * @param	id		UUID
   */
  public ExcitationSystemUserDefined delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    ExcitationSystemUserDefined entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Proprietary
   *
   * @param	parentId	UUID
   * @param	assignment 	BooleanProxy
   * @return	ExcitationSystemUserDefined
   */
  public ExcitationSystemUserDefined assignProprietary(UUID parentId, BooleanProxy assignment) {
    LOGGER.info("assigning Proprietary as " + assignment.toString());

    ExcitationSystemUserDefined parentEntity = repository.findById(parentId).get();
    assignment = BooleanProxyProjector.find(assignment.getBooleanProxyId());

    // ------------------------------------------
    // assign the Proprietary to the parent entity
    // ------------------------------------------
    parentEntity.setProprietary(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Proprietary
   *
   * @param	parentId		UUID
   * @return	ExcitationSystemUserDefined
   */
  public ExcitationSystemUserDefined unAssignProprietary(UUID parentId) {
    ExcitationSystemUserDefined parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Proprietary on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Proprietary on the parent entithy
    // ------------------------------------------
    parentEntity.setProprietary(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the ExcitationSystemUserDefined via an FindExcitationSystemUserDefinedQuery
   *
   * @return query FindExcitationSystemUserDefinedQuery
   */
  @SuppressWarnings("unused")
  public ExcitationSystemUserDefined find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(
          Level.WARNING, "Failed to find a ExcitationSystemUserDefined - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all ExcitationSystemUserDefineds
   *
   * @param query FindAllExcitationSystemUserDefinedQuery
   * @return List<ExcitationSystemUserDefined>
   */
  @SuppressWarnings("unused")
  public List<ExcitationSystemUserDefined> findAll(FindAllExcitationSystemUserDefinedQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(
          Level.WARNING, "Failed to find all ExcitationSystemUserDefined - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final ExcitationSystemUserDefinedRepository repository;

  @Autowired
  @Qualifier(value = "booleanProxy-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile
          .BooleanProxyEntityProjector
      BooleanProxyProjector;

  private static final Logger LOGGER =
      Logger.getLogger(ExcitationSystemUserDefinedEntityProjector.class.getName());
}
