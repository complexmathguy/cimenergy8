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
package com.occulue.europeanstandards.commongridmodelexchangestandard.geographicallocationprofile.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.geographicallocationprofile.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for GeographicalLocationVersion as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by GeographicalLocationVersionAggregate
 *
 * @author your_name_here
 */
@Component("geographicalLocationVersion-entity-projector")
public class GeographicalLocationVersionEntityProjector {

  // core constructor
  public GeographicalLocationVersionEntityProjector(
      GeographicalLocationVersionRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a GeographicalLocationVersion
   *
   * @param	entity GeographicalLocationVersion
   */
  public GeographicalLocationVersion create(GeographicalLocationVersion entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a GeographicalLocationVersion
   *
   * @param	entity GeographicalLocationVersion
   */
  public GeographicalLocationVersion update(GeographicalLocationVersion entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a GeographicalLocationVersion
   *
   * @param	id		UUID
   */
  public GeographicalLocationVersion delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    GeographicalLocationVersion entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a BaseUML
   *
   * @param	parentId	UUID
   * @param	assignment 	StringProxy
   * @return	GeographicalLocationVersion
   */
  public GeographicalLocationVersion assignBaseUML(UUID parentId, StringProxy assignment) {
    LOGGER.info("assigning BaseUML as " + assignment.toString());

    GeographicalLocationVersion parentEntity = repository.findById(parentId).get();
    assignment = StringProxyProjector.find(assignment.getStringProxyId());

    // ------------------------------------------
    // assign the BaseUML to the parent entity
    // ------------------------------------------
    parentEntity.setBaseUML(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the BaseUML
   *
   * @param	parentId		UUID
   * @return	GeographicalLocationVersion
   */
  public GeographicalLocationVersion unAssignBaseUML(UUID parentId) {
    GeographicalLocationVersion parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning BaseUML on " + parentEntity.toString());

    // ------------------------------------------
    // null out the BaseUML on the parent entithy
    // ------------------------------------------
    parentEntity.setBaseUML(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a BaseURI
   *
   * @param	parentId	UUID
   * @param	assignment 	StringProxy
   * @return	GeographicalLocationVersion
   */
  public GeographicalLocationVersion assignBaseURI(UUID parentId, StringProxy assignment) {
    LOGGER.info("assigning BaseURI as " + assignment.toString());

    GeographicalLocationVersion parentEntity = repository.findById(parentId).get();
    assignment = StringProxyProjector.find(assignment.getStringProxyId());

    // ------------------------------------------
    // assign the BaseURI to the parent entity
    // ------------------------------------------
    parentEntity.setBaseURI(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the BaseURI
   *
   * @param	parentId		UUID
   * @return	GeographicalLocationVersion
   */
  public GeographicalLocationVersion unAssignBaseURI(UUID parentId) {
    GeographicalLocationVersion parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning BaseURI on " + parentEntity.toString());

    // ------------------------------------------
    // null out the BaseURI on the parent entithy
    // ------------------------------------------
    parentEntity.setBaseURI(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Date
   *
   * @param	parentId	UUID
   * @param	assignment 	DateProxy
   * @return	GeographicalLocationVersion
   */
  public GeographicalLocationVersion assignDate(UUID parentId, DateProxy assignment) {
    LOGGER.info("assigning Date as " + assignment.toString());

    GeographicalLocationVersion parentEntity = repository.findById(parentId).get();
    assignment = DateProxyProjector.find(assignment.getDateProxyId());

    // ------------------------------------------
    // assign the Date to the parent entity
    // ------------------------------------------
    parentEntity.setDate(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Date
   *
   * @param	parentId		UUID
   * @return	GeographicalLocationVersion
   */
  public GeographicalLocationVersion unAssignDate(UUID parentId) {
    GeographicalLocationVersion parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Date on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Date on the parent entithy
    // ------------------------------------------
    parentEntity.setDate(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a DifferenceModelURI
   *
   * @param	parentId	UUID
   * @param	assignment 	StringProxy
   * @return	GeographicalLocationVersion
   */
  public GeographicalLocationVersion assignDifferenceModelURI(
      UUID parentId, StringProxy assignment) {
    LOGGER.info("assigning DifferenceModelURI as " + assignment.toString());

    GeographicalLocationVersion parentEntity = repository.findById(parentId).get();
    assignment = StringProxyProjector.find(assignment.getStringProxyId());

    // ------------------------------------------
    // assign the DifferenceModelURI to the parent entity
    // ------------------------------------------
    parentEntity.setDifferenceModelURI(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the DifferenceModelURI
   *
   * @param	parentId		UUID
   * @return	GeographicalLocationVersion
   */
  public GeographicalLocationVersion unAssignDifferenceModelURI(UUID parentId) {
    GeographicalLocationVersion parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning DifferenceModelURI on " + parentEntity.toString());

    // ------------------------------------------
    // null out the DifferenceModelURI on the parent entithy
    // ------------------------------------------
    parentEntity.setDifferenceModelURI(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a EntsoeUML
   *
   * @param	parentId	UUID
   * @param	assignment 	StringProxy
   * @return	GeographicalLocationVersion
   */
  public GeographicalLocationVersion assignEntsoeUML(UUID parentId, StringProxy assignment) {
    LOGGER.info("assigning EntsoeUML as " + assignment.toString());

    GeographicalLocationVersion parentEntity = repository.findById(parentId).get();
    assignment = StringProxyProjector.find(assignment.getStringProxyId());

    // ------------------------------------------
    // assign the EntsoeUML to the parent entity
    // ------------------------------------------
    parentEntity.setEntsoeUML(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the EntsoeUML
   *
   * @param	parentId		UUID
   * @return	GeographicalLocationVersion
   */
  public GeographicalLocationVersion unAssignEntsoeUML(UUID parentId) {
    GeographicalLocationVersion parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning EntsoeUML on " + parentEntity.toString());

    // ------------------------------------------
    // null out the EntsoeUML on the parent entithy
    // ------------------------------------------
    parentEntity.setEntsoeUML(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a EntsoeURI
   *
   * @param	parentId	UUID
   * @param	assignment 	StringProxy
   * @return	GeographicalLocationVersion
   */
  public GeographicalLocationVersion assignEntsoeURI(UUID parentId, StringProxy assignment) {
    LOGGER.info("assigning EntsoeURI as " + assignment.toString());

    GeographicalLocationVersion parentEntity = repository.findById(parentId).get();
    assignment = StringProxyProjector.find(assignment.getStringProxyId());

    // ------------------------------------------
    // assign the EntsoeURI to the parent entity
    // ------------------------------------------
    parentEntity.setEntsoeURI(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the EntsoeURI
   *
   * @param	parentId		UUID
   * @return	GeographicalLocationVersion
   */
  public GeographicalLocationVersion unAssignEntsoeURI(UUID parentId) {
    GeographicalLocationVersion parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning EntsoeURI on " + parentEntity.toString());

    // ------------------------------------------
    // null out the EntsoeURI on the parent entithy
    // ------------------------------------------
    parentEntity.setEntsoeURI(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a ModelDescriptionURI
   *
   * @param	parentId	UUID
   * @param	assignment 	StringProxy
   * @return	GeographicalLocationVersion
   */
  public GeographicalLocationVersion assignModelDescriptionURI(
      UUID parentId, StringProxy assignment) {
    LOGGER.info("assigning ModelDescriptionURI as " + assignment.toString());

    GeographicalLocationVersion parentEntity = repository.findById(parentId).get();
    assignment = StringProxyProjector.find(assignment.getStringProxyId());

    // ------------------------------------------
    // assign the ModelDescriptionURI to the parent entity
    // ------------------------------------------
    parentEntity.setModelDescriptionURI(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the ModelDescriptionURI
   *
   * @param	parentId		UUID
   * @return	GeographicalLocationVersion
   */
  public GeographicalLocationVersion unAssignModelDescriptionURI(UUID parentId) {
    GeographicalLocationVersion parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning ModelDescriptionURI on " + parentEntity.toString());

    // ------------------------------------------
    // null out the ModelDescriptionURI on the parent entithy
    // ------------------------------------------
    parentEntity.setModelDescriptionURI(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a NamespaceRDF
   *
   * @param	parentId	UUID
   * @param	assignment 	StringProxy
   * @return	GeographicalLocationVersion
   */
  public GeographicalLocationVersion assignNamespaceRDF(UUID parentId, StringProxy assignment) {
    LOGGER.info("assigning NamespaceRDF as " + assignment.toString());

    GeographicalLocationVersion parentEntity = repository.findById(parentId).get();
    assignment = StringProxyProjector.find(assignment.getStringProxyId());

    // ------------------------------------------
    // assign the NamespaceRDF to the parent entity
    // ------------------------------------------
    parentEntity.setNamespaceRDF(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the NamespaceRDF
   *
   * @param	parentId		UUID
   * @return	GeographicalLocationVersion
   */
  public GeographicalLocationVersion unAssignNamespaceRDF(UUID parentId) {
    GeographicalLocationVersion parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning NamespaceRDF on " + parentEntity.toString());

    // ------------------------------------------
    // null out the NamespaceRDF on the parent entithy
    // ------------------------------------------
    parentEntity.setNamespaceRDF(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a NamespaceUML
   *
   * @param	parentId	UUID
   * @param	assignment 	StringProxy
   * @return	GeographicalLocationVersion
   */
  public GeographicalLocationVersion assignNamespaceUML(UUID parentId, StringProxy assignment) {
    LOGGER.info("assigning NamespaceUML as " + assignment.toString());

    GeographicalLocationVersion parentEntity = repository.findById(parentId).get();
    assignment = StringProxyProjector.find(assignment.getStringProxyId());

    // ------------------------------------------
    // assign the NamespaceUML to the parent entity
    // ------------------------------------------
    parentEntity.setNamespaceUML(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the NamespaceUML
   *
   * @param	parentId		UUID
   * @return	GeographicalLocationVersion
   */
  public GeographicalLocationVersion unAssignNamespaceUML(UUID parentId) {
    GeographicalLocationVersion parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning NamespaceUML on " + parentEntity.toString());

    // ------------------------------------------
    // null out the NamespaceUML on the parent entithy
    // ------------------------------------------
    parentEntity.setNamespaceUML(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a ShortName
   *
   * @param	parentId	UUID
   * @param	assignment 	StringProxy
   * @return	GeographicalLocationVersion
   */
  public GeographicalLocationVersion assignShortName(UUID parentId, StringProxy assignment) {
    LOGGER.info("assigning ShortName as " + assignment.toString());

    GeographicalLocationVersion parentEntity = repository.findById(parentId).get();
    assignment = StringProxyProjector.find(assignment.getStringProxyId());

    // ------------------------------------------
    // assign the ShortName to the parent entity
    // ------------------------------------------
    parentEntity.setShortName(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the ShortName
   *
   * @param	parentId		UUID
   * @return	GeographicalLocationVersion
   */
  public GeographicalLocationVersion unAssignShortName(UUID parentId) {
    GeographicalLocationVersion parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning ShortName on " + parentEntity.toString());

    // ------------------------------------------
    // null out the ShortName on the parent entithy
    // ------------------------------------------
    parentEntity.setShortName(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the GeographicalLocationVersion via an FindGeographicalLocationVersionQuery
   *
   * @return query FindGeographicalLocationVersionQuery
   */
  @SuppressWarnings("unused")
  public GeographicalLocationVersion find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(
          Level.WARNING, "Failed to find a GeographicalLocationVersion - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all GeographicalLocationVersions
   *
   * @param query FindAllGeographicalLocationVersionQuery
   * @return List<GeographicalLocationVersion>
   */
  @SuppressWarnings("unused")
  public List<GeographicalLocationVersion> findAll(FindAllGeographicalLocationVersionQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(
          Level.WARNING, "Failed to find all GeographicalLocationVersion - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final GeographicalLocationVersionRepository repository;

  @Autowired
  @Qualifier(value = "stringProxy-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile
          .StringProxyEntityProjector
      StringProxyProjector;

  @Autowired
  @Qualifier(value = "dateProxy-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile
          .DateProxyEntityProjector
      DateProxyProjector;

  private static final Logger LOGGER =
      Logger.getLogger(GeographicalLocationVersionEntityProjector.class.getName());
}
