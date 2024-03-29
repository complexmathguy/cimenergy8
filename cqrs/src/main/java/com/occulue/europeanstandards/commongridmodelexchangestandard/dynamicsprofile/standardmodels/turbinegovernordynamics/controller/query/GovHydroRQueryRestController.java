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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.turbinegovernordynamics.controller.query;

import com.occulue.api.*;
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
 * Implements Spring Controller query CQRS processing for entity GovHydroR.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GovHydroR")
public class GovHydroRQueryRestController extends BaseSpringRestController {

  /**
   * Handles loading a GovHydroR using a UUID
   *
   * @param UUID govHydroRId
   * @return GovHydroR
   */
  @GetMapping("/load")
  public GovHydroR load(@RequestParam(required = true) UUID govHydroRId) {
    GovHydroR entity = null;

    try {
      entity =
          GovHydroRBusinessDelegate.getGovHydroRInstance()
              .getGovHydroR(new GovHydroRFetchOneSummary(govHydroRId));
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load GovHydroR using Id " + govHydroRId);
      return null;
    }

    return entity;
  }

  /**
   * Handles loading all GovHydroR business objects
   *
   * @return Set<GovHydroR>
   */
  @GetMapping("/")
  public List<GovHydroR> loadAll() {
    List<GovHydroR> govHydroRList = null;

    try {
      // load the GovHydroR
      govHydroRList = GovHydroRBusinessDelegate.getGovHydroRInstance().getAllGovHydroR();

      if (govHydroRList != null) LOGGER.log(Level.INFO, "successfully loaded all GovHydroRs");
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load all GovHydroRs ", exc);
      return null;
    }

    return govHydroRList;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected GovHydroR govHydroR = null;
  private static final Logger LOGGER =
      Logger.getLogger(GovHydroRQueryRestController.class.getName());
}
