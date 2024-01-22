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
package com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for BooleanProxy as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by BooleanProxyAggregate
 *
 * @author your_name_here
 */
@Component("booleanProxy-entity-projector")
public class BooleanProxyEntityProjector {

  // core constructor
  public BooleanProxyEntityProjector(BooleanProxyRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a BooleanProxy
   *
   * @param	entity BooleanProxy
   */
  public BooleanProxy create(BooleanProxy entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a BooleanProxy
   *
   * @param	entity BooleanProxy
   */
  public BooleanProxy update(BooleanProxy entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a BooleanProxy
   *
   * @param	id		UUID
   */
  public BooleanProxy delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    BooleanProxy entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /**
   * Method to retrieve the BooleanProxy via an FindBooleanProxyQuery
   *
   * @return query FindBooleanProxyQuery
   */
  @SuppressWarnings("unused")
  public BooleanProxy find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a BooleanProxy - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all BooleanProxys
   *
   * @param query FindAllBooleanProxyQuery
   * @return List<BooleanProxy>
   */
  @SuppressWarnings("unused")
  public List<BooleanProxy> findAll(FindAllBooleanProxyQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all BooleanProxy - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final BooleanProxyRepository repository;

  @Autowired
  @Qualifier(value = "boundaryExtensions-entity-projector")
  com.occulue.europeanstandards.extension.BoundaryExtensionsEntityProjector
      BoundaryExtensionsProjector;

  @Autowired
  @Qualifier(value = "analog-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas
          .AnalogEntityProjector
      AnalogProjector;

  @Autowired
  @Qualifier(value = "control-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas
          .ControlEntityProjector
      ControlProjector;

  @Autowired
  @Qualifier(value = "limitSet-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas
          .LimitSetEntityProjector
      LimitSetProjector;

  @Autowired
  @Qualifier(value = "quality61850-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas
          .Quality61850EntityProjector
      Quality61850Projector;

  @Autowired
  @Qualifier(value = "asynchronousMachine-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires
          .AsynchronousMachineEntityProjector
      AsynchronousMachineProjector;

  @Autowired
  @Qualifier(value = "externalNetworkInjection-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires
          .ExternalNetworkInjectionEntityProjector
      ExternalNetworkInjectionProjector;

  @Autowired
  @Qualifier(value = "powerTransformer-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires
          .PowerTransformerEntityProjector
      PowerTransformerProjector;

  @Autowired
  @Qualifier(value = "seriesCompensator-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires
          .SeriesCompensatorEntityProjector
      SeriesCompensatorProjector;

  @Autowired
  @Qualifier(value = "shuntCompensator-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires
          .ShuntCompensatorEntityProjector
      ShuntCompensatorProjector;

  @Autowired
  @Qualifier(value = "switchProxy-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires
          .SwitchProxyEntityProjector
      SwitchProxyProjector;

  @Autowired
  @Qualifier(value = "synchronousMachine-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires
          .SynchronousMachineEntityProjector
      SynchronousMachineProjector;

  @Autowired
  @Qualifier(value = "tapChanger-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires
          .TapChangerEntityProjector
      TapChangerProjector;

  @Autowired
  @Qualifier(value = "loadResponseCharacteristic-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.loadmodel
          .LoadResponseCharacteristicEntityProjector
      LoadResponseCharacteristicProjector;

  @Autowired
  @Qualifier(value = "equivalentInjection-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.equivalents
          .EquivalentInjectionEntityProjector
      EquivalentInjectionProjector;

  @Autowired
  @Qualifier(value = "switchIt-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.steadystatehypothesisprofile.wires
          .SwitchItEntityProjector
      SwitchItProjector;

  @Autowired
  @Qualifier(value = "svStatus-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.statevariablesprofile.statevariables
          .SvStatusEntityProjector
      SvStatusProjector;

  @Autowired
  @Qualifier(value = "dynamicsFunctionBlock-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .DynamicsFunctionBlockEntityProjector
      DynamicsFunctionBlockProjector;

  @Autowired
  @Qualifier(value = "govCT1-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .turbinegovernordynamics.GovCT1EntityProjector
      GovCT1Projector;

  @Autowired
  @Qualifier(value = "govGAST2-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .turbinegovernordynamics.GovGAST2EntityProjector
      GovGAST2Projector;

  @Autowired
  @Qualifier(value = "govHydro3-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .turbinegovernordynamics.GovHydro3EntityProjector
      GovHydro3Projector;

  @Autowired
  @Qualifier(value = "govHydroDD-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .turbinegovernordynamics.GovHydroDDEntityProjector
      GovHydroDDProjector;

  @Autowired
  @Qualifier(value = "govHydroFrancis-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .turbinegovernordynamics.GovHydroFrancisEntityProjector
      GovHydroFrancisProjector;

  @Autowired
  @Qualifier(value = "govHydroPelton-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .turbinegovernordynamics.GovHydroPeltonEntityProjector
      GovHydroPeltonProjector;

  @Autowired
  @Qualifier(value = "govHydroPID2-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .turbinegovernordynamics.GovHydroPID2EntityProjector
      GovHydroPID2Projector;

  @Autowired
  @Qualifier(value = "govSteam1-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .turbinegovernordynamics.GovSteam1EntityProjector
      GovSteam1Projector;

  @Autowired
  @Qualifier(value = "turbLCFB1-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .turbineloadcontrollerdynamics.TurbLCFB1EntityProjector
      TurbLCFB1Projector;

  @Autowired
  @Qualifier(value = "excIEEEDC1A-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .excitationsystemdynamics.ExcIEEEDC1AEntityProjector
      ExcIEEEDC1AProjector;

  @Autowired
  @Qualifier(value = "excIEEEDC4B-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .excitationsystemdynamics.ExcIEEEDC4BEntityProjector
      ExcIEEEDC4BProjector;

  @Autowired
  @Qualifier(value = "excIEEEST1A-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .excitationsystemdynamics.ExcIEEEST1AEntityProjector
      ExcIEEEST1AProjector;

  @Autowired
  @Qualifier(value = "excAC1A-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .excitationsystemdynamics.ExcAC1AEntityProjector
      ExcAC1AProjector;

  @Autowired
  @Qualifier(value = "excAC2A-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .excitationsystemdynamics.ExcAC2AEntityProjector
      ExcAC2AProjector;

  @Autowired
  @Qualifier(value = "excAC8B-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .excitationsystemdynamics.ExcAC8BEntityProjector
      ExcAC8BProjector;

  @Autowired
  @Qualifier(value = "excAVR4-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .excitationsystemdynamics.ExcAVR4EntityProjector
      ExcAVR4Projector;

  @Autowired
  @Qualifier(value = "excBBC-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .excitationsystemdynamics.ExcBBCEntityProjector
      ExcBBCProjector;

  @Autowired
  @Qualifier(value = "excDC2A-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .excitationsystemdynamics.ExcDC2AEntityProjector
      ExcDC2AProjector;

  @Autowired
  @Qualifier(value = "excDC3A-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .excitationsystemdynamics.ExcDC3AEntityProjector
      ExcDC3AProjector;

  @Autowired
  @Qualifier(value = "excDC3A1-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .excitationsystemdynamics.ExcDC3A1EntityProjector
      ExcDC3A1Projector;

  @Autowired
  @Qualifier(value = "excSCRX-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .excitationsystemdynamics.ExcSCRXEntityProjector
      ExcSCRXProjector;

  @Autowired
  @Qualifier(value = "excSK-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .excitationsystemdynamics.ExcSKEntityProjector
      ExcSKProjector;

  @Autowired
  @Qualifier(value = "excST4B-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .excitationsystemdynamics.ExcST4BEntityProjector
      ExcST4BProjector;

  @Autowired
  @Qualifier(value = "excST6B-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .excitationsystemdynamics.ExcST6BEntityProjector
      ExcST6BProjector;

  @Autowired
  @Qualifier(value = "overexcLimX2-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .overexcitationlimiterdynamics.OverexcLimX2EntityProjector
      OverexcLimX2Projector;

  @Autowired
  @Qualifier(value = "pss1-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .powersystemstabilizerdynamics.Pss1EntityProjector
      Pss1Projector;

  @Autowired
  @Qualifier(value = "pss1A-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .powersystemstabilizerdynamics.Pss1AEntityProjector
      Pss1AProjector;

  @Autowired
  @Qualifier(value = "pss5-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .powersystemstabilizerdynamics.Pss5EntityProjector
      Pss5Projector;

  @Autowired
  @Qualifier(value = "pssPTIST3-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .powersystemstabilizerdynamics.PssPTIST3EntityProjector
      PssPTIST3Projector;

  @Autowired
  @Qualifier(value = "pFVArType1IEEEPFController-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .pfvarcontrollertype1dynamics.PFVArType1IEEEPFControllerEntityProjector
      PFVArType1IEEEPFControllerProjector;

  @Autowired
  @Qualifier(value = "pFVArType2IEEEPFController-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .pfvarcontrollertype2dynamics.PFVArType2IEEEPFControllerEntityProjector
      PFVArType2IEEEPFControllerProjector;

  @Autowired
  @Qualifier(value = "pFVArType2Common1-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .pfvarcontrollertype2dynamics.PFVArType2Common1EntityProjector
      PFVArType2Common1Projector;

  @Autowired
  @Qualifier(value = "windContCurrLimIEC-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .winddynamics.WindContCurrLimIECEntityProjector
      WindContCurrLimIECProjector;

  @Autowired
  @Qualifier(value = "windContPType3IEC-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .winddynamics.WindContPType3IECEntityProjector
      WindContPType3IECProjector;

  @Autowired
  @Qualifier(value = "windGenTurbineType3bIEC-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .winddynamics.WindGenTurbineType3bIECEntityProjector
      WindGenTurbineType3bIECProjector;

  @Autowired
  @Qualifier(value = "windPlantReactiveControlIEC-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .winddynamics.WindPlantReactiveControlIECEntityProjector
      WindPlantReactiveControlIECProjector;

  @Autowired
  @Qualifier(value = "windPlantUserDefined-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.userdefinedmodels
          .WindPlantUserDefinedEntityProjector
      WindPlantUserDefinedProjector;

  @Autowired
  @Qualifier(value = "proprietaryParameterDynamics-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.userdefinedmodels
          .ProprietaryParameterDynamicsEntityProjector
      ProprietaryParameterDynamicsProjector;

  @Autowired
  @Qualifier(value = "diagramObject-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.diagramlayoutprofile.diagramlayout
          .DiagramObjectEntityProjector
      DiagramObjectProjector;

  private static final Logger LOGGER =
      Logger.getLogger(BooleanProxyEntityProjector.class.getName());
}
