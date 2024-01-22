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
 * Projector for WindPlantUserDefined as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by WindPlantUserDefinedAggregate
 *
 * @author your_name_here
 */
@Component("windPlantUserDefined-entity-projector")
public class WindPlantUserDefinedEntityProjector {

  // core constructor
  public WindPlantUserDefinedEntityProjector(WindPlantUserDefinedRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a WindPlantUserDefined
   *
   * @param	entity WindPlantUserDefined
   */
  public WindPlantUserDefined create(WindPlantUserDefined entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a WindPlantUserDefined
   *
   * @param	entity WindPlantUserDefined
   */
  public WindPlantUserDefined update(WindPlantUserDefined entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a WindPlantUserDefined
   *
   * @param	id		UUID
   */
  public WindPlantUserDefined delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    WindPlantUserDefined entity = repository.findById(id).get();

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
   * @return	WindPlantUserDefined
   */
  public WindPlantUserDefined assignProprietary(UUID parentId, BooleanProxy assignment) {
    LOGGER.info("assigning Proprietary as " + assignment.toString());

    WindPlantUserDefined parentEntity = repository.findById(parentId).get();
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
   * @return	WindPlantUserDefined
   */
  public WindPlantUserDefined unAssignProprietary(UUID parentId) {
    WindPlantUserDefined parentEntity = repository.findById(parentId).get();

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
   * Method to retrieve the WindPlantUserDefined via an FindWindPlantUserDefinedQuery
   *
   * @return query FindWindPlantUserDefinedQuery
   */
  @SuppressWarnings("unused")
  public WindPlantUserDefined find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a WindPlantUserDefined - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all WindPlantUserDefineds
   *
   * @param query FindAllWindPlantUserDefinedQuery
   * @return List<WindPlantUserDefined>
   */
  @SuppressWarnings("unused")
  public List<WindPlantUserDefined> findAll(FindAllWindPlantUserDefinedQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all WindPlantUserDefined - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final WindPlantUserDefinedRepository repository;

  @Autowired
  @Qualifier(value = "booleanProxy-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile
          .BooleanProxyEntityProjector
      BooleanProxyProjector;

  private static final Logger LOGGER =
      Logger.getLogger(WindPlantUserDefinedEntityProjector.class.getName());
}
