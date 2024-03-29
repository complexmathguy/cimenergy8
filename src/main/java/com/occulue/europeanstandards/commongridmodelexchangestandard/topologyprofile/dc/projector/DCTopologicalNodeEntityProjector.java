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
package com.occulue.europeanstandards.commongridmodelexchangestandard.topologyprofile.dc.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.topologyprofile.dc.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for DCTopologicalNode as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by DCTopologicalNodeAggregate
 *
 * @author your_name_here
 */
@Component("dCTopologicalNode-entity-projector")
public class DCTopologicalNodeEntityProjector {

  // core constructor
  public DCTopologicalNodeEntityProjector(DCTopologicalNodeRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a DCTopologicalNode
   *
   * @param	entity DCTopologicalNode
   */
  public DCTopologicalNode create(DCTopologicalNode entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a DCTopologicalNode
   *
   * @param	entity DCTopologicalNode
   */
  public DCTopologicalNode update(DCTopologicalNode entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a DCTopologicalNode
   *
   * @param	id		UUID
   */
  public DCTopologicalNode delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    DCTopologicalNode entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Add to the DCTopologicalNode
   *
   * @param	parentID	UUID
   * @param	addTo		childType
   * @return	DCTopologicalNode
   */
  public DCTopologicalNode addToDCTopologicalNode(UUID parentId, DCTopologicalNode addTo) {
    LOGGER.info("handling AssignDCTopologicalNodeToDCTopologicalNodeEvent - ");

    DCTopologicalNode parentEntity = repository.findById(parentId).get();
    DCTopologicalNode child = DCTopologicalNodeProjector.find(addTo.getDCTopologicalNodeId());

    parentEntity.getDCTopologicalNode().add(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Remove from the DCTopologicalNode
   *
   * @param	parentID	UUID
   * @param	removeFrom	childType
   * @return	DCTopologicalNode
   */
  public DCTopologicalNode removeFromDCTopologicalNode(
      UUID parentId, DCTopologicalNode removeFrom) {
    LOGGER.info("handling RemoveDCTopologicalNodeFromDCTopologicalNodeEvent ");

    DCTopologicalNode parentEntity = repository.findById(parentId).get();
    DCTopologicalNode child = DCTopologicalNodeProjector.find(removeFrom.getDCTopologicalNodeId());

    parentEntity.getDCTopologicalNode().remove(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    update(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the DCTopologicalNode via an FindDCTopologicalNodeQuery
   *
   * @return query FindDCTopologicalNodeQuery
   */
  @SuppressWarnings("unused")
  public DCTopologicalNode find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a DCTopologicalNode - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all DCTopologicalNodes
   *
   * @param query FindAllDCTopologicalNodeQuery
   * @return List<DCTopologicalNode>
   */
  @SuppressWarnings("unused")
  public List<DCTopologicalNode> findAll(FindAllDCTopologicalNodeQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all DCTopologicalNode - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final DCTopologicalNodeRepository repository;

  @Autowired
  @Qualifier(value = "dCTopologicalNode-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.topologyprofile.dc
          .DCTopologicalNodeEntityProjector
      DCTopologicalNodeProjector;

  private static final Logger LOGGER =
      Logger.getLogger(DCTopologicalNodeEntityProjector.class.getName());
}
