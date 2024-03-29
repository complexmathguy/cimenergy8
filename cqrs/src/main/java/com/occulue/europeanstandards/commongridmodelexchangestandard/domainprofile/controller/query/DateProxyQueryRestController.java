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
package com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.controller.query;

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
 * Implements Spring Controller query CQRS processing for entity DateProxy.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/DateProxy")
public class DateProxyQueryRestController extends BaseSpringRestController {

  /**
   * Handles loading a DateProxy using a UUID
   *
   * @param UUID dateProxyId
   * @return DateProxy
   */
  @GetMapping("/load")
  public DateProxy load(@RequestParam(required = true) UUID dateProxyId) {
    DateProxy entity = null;

    try {
      entity =
          DateProxyBusinessDelegate.getDateProxyInstance()
              .getDateProxy(new DateProxyFetchOneSummary(dateProxyId));
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load DateProxy using Id " + dateProxyId);
      return null;
    }

    return entity;
  }

  /**
   * Handles loading all DateProxy business objects
   *
   * @return Set<DateProxy>
   */
  @GetMapping("/")
  public List<DateProxy> loadAll() {
    List<DateProxy> dateProxyList = null;

    try {
      // load the DateProxy
      dateProxyList = DateProxyBusinessDelegate.getDateProxyInstance().getAllDateProxy();

      if (dateProxyList != null) LOGGER.log(Level.INFO, "successfully loaded all DateProxys");
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load all DateProxys ", exc);
      return null;
    }

    return dateProxyList;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected DateProxy dateProxy = null;
  private static final Logger LOGGER =
      Logger.getLogger(DateProxyQueryRestController.class.getName());
}
