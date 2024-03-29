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
package com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.controller.command;

import com.occulue.api.*;
import com.occulue.command.*;
import com.occulue.controller.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.web.bind.annotation.*;

/**
 * Implements Spring Controller command CQRS processing for entity VolumeFlowRate.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/VolumeFlowRate")
public class VolumeFlowRateCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a VolumeFlowRate. if not key provided, calls create, otherwise calls save
   *
   * @param VolumeFlowRate volumeFlowRate
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateVolumeFlowRateCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          VolumeFlowRateBusinessDelegate.getVolumeFlowRateInstance().createVolumeFlowRate(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a VolumeFlowRate. if no key provided, calls create, otherwise calls save
   *
   * @param VolumeFlowRate volumeFlowRate
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateVolumeFlowRateCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateVolumeFlowRateCommand
      // -----------------------------------------------
      completableFuture =
          VolumeFlowRateBusinessDelegate.getVolumeFlowRateInstance().updateVolumeFlowRate(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "VolumeFlowRateController:update() - successfully update VolumeFlowRate - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a VolumeFlowRate entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID volumeFlowRateId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteVolumeFlowRateCommand command = new DeleteVolumeFlowRateCommand(volumeFlowRateId);

    try {
      VolumeFlowRateBusinessDelegate delegate =
          VolumeFlowRateBusinessDelegate.getVolumeFlowRateInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted VolumeFlowRate with key " + command.getVolumeFlowRateId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Value on VolumeFlowRate
   *
   * @param command AssignValueToVolumeFlowRateCommand
   */
  @PutMapping("/assignValue")
  public void assignValue(@RequestBody AssignValueToVolumeFlowRateCommand command) {
    try {
      VolumeFlowRateBusinessDelegate.getVolumeFlowRateInstance().assignValue(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Value", exc);
    }
  }

  /**
   * unassign Value on VolumeFlowRate
   *
   * @param command UnAssignValueFromVolumeFlowRateCommand
   */
  @PutMapping("/unAssignValue")
  public void unAssignValue(
      @RequestBody(required = true) UnAssignValueFromVolumeFlowRateCommand command) {
    try {
      VolumeFlowRateBusinessDelegate.getVolumeFlowRateInstance().unAssignValue(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Value", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected VolumeFlowRate volumeFlowRate = null;
  private static final Logger LOGGER =
      Logger.getLogger(VolumeFlowRateCommandRestController.class.getName());
}
