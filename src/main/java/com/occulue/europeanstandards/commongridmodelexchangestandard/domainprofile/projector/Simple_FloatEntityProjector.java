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
 * Projector for Simple_Float as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by Simple_FloatAggregate
 *
 * @author your_name_here
 */
@Component("simple_Float-entity-projector")
public class Simple_FloatEntityProjector {

  // core constructor
  public Simple_FloatEntityProjector(Simple_FloatRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a Simple_Float
   *
   * @param	entity Simple_Float
   */
  public Simple_Float create(Simple_Float entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a Simple_Float
   *
   * @param	entity Simple_Float
   */
  public Simple_Float update(Simple_Float entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a Simple_Float
   *
   * @param	id		UUID
   */
  public Simple_Float delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    Simple_Float entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Value
   *
   * @param	parentId	UUID
   * @param	assignment 	FloatProxy
   * @return	Simple_Float
   */
  public Simple_Float assignValue(UUID parentId, FloatProxy assignment) {
    LOGGER.info("assigning Value as " + assignment.toString());

    Simple_Float parentEntity = repository.findById(parentId).get();
    assignment = FloatProxyProjector.find(assignment.getFloatProxyId());

    // ------------------------------------------
    // assign the Value to the parent entity
    // ------------------------------------------
    parentEntity.setValue(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Value
   *
   * @param	parentId		UUID
   * @return	Simple_Float
   */
  public Simple_Float unAssignValue(UUID parentId) {
    Simple_Float parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Value on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Value on the parent entithy
    // ------------------------------------------
    parentEntity.setValue(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the Simple_Float via an FindSimple_FloatQuery
   *
   * @return query FindSimple_FloatQuery
   */
  @SuppressWarnings("unused")
  public Simple_Float find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a Simple_Float - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all Simple_Floats
   *
   * @param query FindAllSimple_FloatQuery
   * @return List<Simple_Float>
   */
  @SuppressWarnings("unused")
  public List<Simple_Float> findAll(FindAllSimple_FloatQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all Simple_Float - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final Simple_FloatRepository repository;

  @Autowired
  @Qualifier(value = "floatProxy-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile
          .FloatProxyEntityProjector
      FloatProxyProjector;

  @Autowired
  @Qualifier(value = "vsConverter-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc
          .VsConverterEntityProjector
      VsConverterProjector;

  @Autowired
  @Qualifier(value = "analogControl-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas
          .AnalogControlEntityProjector
      AnalogControlProjector;

  @Autowired
  @Qualifier(value = "setPoint-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas
          .SetPointEntityProjector
      SetPointProjector;

  @Autowired
  @Qualifier(value = "generatingUnit-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.production
          .GeneratingUnitEntityProjector
      GeneratingUnitProjector;

  @Autowired
  @Qualifier(value = "curveData-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.core
          .CurveDataEntityProjector
      CurveDataProjector;

  @Autowired
  @Qualifier(value = "regularTimePoint-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.core
          .RegularTimePointEntityProjector
      RegularTimePointProjector;

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
  @Qualifier(value = "rotatingMachine-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires
          .RotatingMachineEntityProjector
      RotatingMachineProjector;

  @Autowired
  @Qualifier(value = "synchronousMachine-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires
          .SynchronousMachineEntityProjector
      SynchronousMachineProjector;

  @Autowired
  @Qualifier(value = "tapChangerTablePoint-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires
          .TapChangerTablePointEntityProjector
      TapChangerTablePointProjector;

  @Autowired
  @Qualifier(value = "loadResponseCharacteristic-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.loadmodel
          .LoadResponseCharacteristicEntityProjector
      LoadResponseCharacteristicProjector;

  @Autowired
  @Qualifier(value = "svShuntCompensatorSections-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.statevariablesprofile.statevariables
          .SvShuntCompensatorSectionsEntityProjector
      SvShuntCompensatorSectionsProjector;

  @Autowired
  @Qualifier(value = "svTapStep-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.statevariablesprofile.statevariables
          .SvTapStepEntityProjector
      SvTapStepProjector;

  @Autowired
  @Qualifier(value = "rotatingMachineDynamics-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .RotatingMachineDynamicsEntityProjector
      RotatingMachineDynamicsProjector;

  @Autowired
  @Qualifier(value = "synchronousMachineDetailed-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .synchronousmachinedynamics.SynchronousMachineDetailedEntityProjector
      SynchronousMachineDetailedProjector;

  @Autowired
  @Qualifier(value = "synchronousMachineTimeConstantReactance-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .synchronousmachinedynamics.SynchronousMachineTimeConstantReactanceEntityProjector
      SynchronousMachineTimeConstantReactanceProjector;

  @Autowired
  @Qualifier(value = "govHydroIEEE2-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .turbinegovernordynamics.GovHydroIEEE2EntityProjector
      GovHydroIEEE2Projector;

  @Autowired
  @Qualifier(value = "govSteamIEEE1-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .turbinegovernordynamics.GovSteamIEEE1EntityProjector
      GovSteamIEEE1Projector;

  @Autowired
  @Qualifier(value = "govCT1-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .turbinegovernordynamics.GovCT1EntityProjector
      GovCT1Projector;

  @Autowired
  @Qualifier(value = "govGAST1-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .turbinegovernordynamics.GovGAST1EntityProjector
      GovGAST1Projector;

  @Autowired
  @Qualifier(value = "govGAST2-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .turbinegovernordynamics.GovGAST2EntityProjector
      GovGAST2Projector;

  @Autowired
  @Qualifier(value = "govGAST3-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .turbinegovernordynamics.GovGAST3EntityProjector
      GovGAST3Projector;

  @Autowired
  @Qualifier(value = "govHydro1-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .turbinegovernordynamics.GovHydro1EntityProjector
      GovHydro1Projector;

  @Autowired
  @Qualifier(value = "govHydro3-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .turbinegovernordynamics.GovHydro3EntityProjector
      GovHydro3Projector;

  @Autowired
  @Qualifier(value = "govHydro4-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .turbinegovernordynamics.GovHydro4EntityProjector
      GovHydro4Projector;

  @Autowired
  @Qualifier(value = "govHydroFrancis-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .turbinegovernordynamics.GovHydroFrancisEntityProjector
      GovHydroFrancisProjector;

  @Autowired
  @Qualifier(value = "govHydroPID2-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .turbinegovernordynamics.GovHydroPID2EntityProjector
      GovHydroPID2Projector;

  @Autowired
  @Qualifier(value = "govHydroWEH-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .turbinegovernordynamics.GovHydroWEHEntityProjector
      GovHydroWEHProjector;

  @Autowired
  @Qualifier(value = "govSteam2-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .turbinegovernordynamics.GovSteam2EntityProjector
      GovSteam2Projector;

  @Autowired
  @Qualifier(value = "govSteamEU-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .turbinegovernordynamics.GovSteamEUEntityProjector
      GovSteamEUProjector;

  @Autowired
  @Qualifier(value = "govSteamFV4-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .turbinegovernordynamics.GovSteamFV4EntityProjector
      GovSteamFV4Projector;

  @Autowired
  @Qualifier(value = "mechLoad1-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .mechanicalloaddynamics.MechLoad1EntityProjector
      MechLoad1Projector;

  @Autowired
  @Qualifier(value = "excIEEEAC1A-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .excitationsystemdynamics.ExcIEEEAC1AEntityProjector
      ExcIEEEAC1AProjector;

  @Autowired
  @Qualifier(value = "excIEEEAC5A-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .excitationsystemdynamics.ExcIEEEAC5AEntityProjector
      ExcIEEEAC5AProjector;

  @Autowired
  @Qualifier(value = "excANS-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .excitationsystemdynamics.ExcANSEntityProjector
      ExcANSProjector;

  @Autowired
  @Qualifier(value = "excAVR1-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .excitationsystemdynamics.ExcAVR1EntityProjector
      ExcAVR1Projector;

  @Autowired
  @Qualifier(value = "excAVR4-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .excitationsystemdynamics.ExcAVR4EntityProjector
      ExcAVR4Projector;

  @Autowired
  @Qualifier(value = "excSCRX-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .excitationsystemdynamics.ExcSCRXEntityProjector
      ExcSCRXProjector;

  @Autowired
  @Qualifier(value = "overexcLimIEEE-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .overexcitationlimiterdynamics.OverexcLimIEEEEntityProjector
      OverexcLimIEEEProjector;

  @Autowired
  @Qualifier(value = "pssIEEE4B-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .powersystemstabilizerdynamics.PssIEEE4BEntityProjector
      PssIEEE4BProjector;

  @Autowired
  @Qualifier(value = "pss1-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .powersystemstabilizerdynamics.Pss1EntityProjector
      Pss1Projector;

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
  @Qualifier(value = "pFVArType1IEEEVArController-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .pfvarcontrollertype1dynamics.PFVArType1IEEEVArControllerEntityProjector
      PFVArType1IEEEVArControllerProjector;

  @Autowired
  @Qualifier(value = "vAdjIEEE-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .voltageadjusterdynamics.VAdjIEEEEntityProjector
      VAdjIEEEProjector;

  @Autowired
  @Qualifier(value = "pFVArType2IEEEPFController-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .pfvarcontrollertype2dynamics.PFVArType2IEEEPFControllerEntityProjector
      PFVArType2IEEEPFControllerProjector;

  @Autowired
  @Qualifier(value = "windContPType3IEC-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .winddynamics.WindContPType3IECEntityProjector
      WindContPType3IECProjector;

  @Autowired
  @Qualifier(value = "windContPitchAngleIEC-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .winddynamics.WindContPitchAngleIECEntityProjector
      WindContPitchAngleIECProjector;

  @Autowired
  @Qualifier(value = "windContRotorRIEC-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .winddynamics.WindContRotorRIECEntityProjector
      WindContRotorRIECProjector;

  @Autowired
  @Qualifier(value = "windDynamicsLookupTable-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .winddynamics.WindDynamicsLookupTableEntityProjector
      WindDynamicsLookupTableProjector;

  @Autowired
  @Qualifier(value = "windGenTurbineType3aIEC-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .winddynamics.WindGenTurbineType3aIECEntityProjector
      WindGenTurbineType3aIECProjector;

  @Autowired
  @Qualifier(value = "windGenTurbineType3bIEC-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .winddynamics.WindGenTurbineType3bIECEntityProjector
      WindGenTurbineType3bIECProjector;

  @Autowired
  @Qualifier(value = "windPitchContEmulIEC-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .winddynamics.WindPitchContEmulIECEntityProjector
      WindPitchContEmulIECProjector;

  @Autowired
  @Qualifier(value = "windPlantFreqPcontrolIEC-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .winddynamics.WindPlantFreqPcontrolIECEntityProjector
      WindPlantFreqPcontrolIECProjector;

  @Autowired
  @Qualifier(value = "windPlantReactiveControlIEC-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .winddynamics.WindPlantReactiveControlIECEntityProjector
      WindPlantReactiveControlIECProjector;

  @Autowired
  @Qualifier(value = "loadComposite-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .loaddynamics.LoadCompositeEntityProjector
      LoadCompositeProjector;

  @Autowired
  @Qualifier(value = "loadGenericNonLinear-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .loaddynamics.LoadGenericNonLinearEntityProjector
      LoadGenericNonLinearProjector;

  @Autowired
  @Qualifier(value = "loadStatic-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .loaddynamics.LoadStaticEntityProjector
      LoadStaticProjector;

  @Autowired
  @Qualifier(value = "loadMotor-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .loaddynamics.LoadMotorEntityProjector
      LoadMotorProjector;

  @Autowired
  @Qualifier(value = "proprietaryParameterDynamics-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.userdefinedmodels
          .ProprietaryParameterDynamicsEntityProjector
      ProprietaryParameterDynamicsProjector;

  @Autowired
  @Qualifier(value = "diagram-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.diagramlayoutprofile.diagramlayout
          .DiagramEntityProjector
      DiagramProjector;

  @Autowired
  @Qualifier(value = "diagramObject-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.diagramlayoutprofile.diagramlayout
          .DiagramObjectEntityProjector
      DiagramObjectProjector;

  @Autowired
  @Qualifier(value = "diagramObjectPoint-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.diagramlayoutprofile.diagramlayout
          .DiagramObjectPointEntityProjector
      DiagramObjectPointProjector;

  private static final Logger LOGGER =
      Logger.getLogger(Simple_FloatEntityProjector.class.getName());
}
