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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.controller.query;

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
 * Implements Spring Controller query CQRS processing for entity CsConverter.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/CsConverter")
public class CsConverterQueryRestController extends BaseSpringRestController {

  /**
   * Handles loading a CsConverter using a UUID
   *
   * @param UUID csConverterId
   * @return CsConverter
   */
  @GetMapping("/load")
  public CsConverter load(@RequestParam(required = true) UUID csConverterId) {
    CsConverter entity = null;

    try {
      entity =
          CsConverterBusinessDelegate.getCsConverterInstance()
              .getCsConverter(new CsConverterFetchOneSummary(csConverterId));
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load CsConverter using Id " + csConverterId);
      return null;
    }

    return entity;
  }

  /**
   * Handles loading all CsConverter business objects
   *
   * @return Set<CsConverter>
   */
  @GetMapping("/")
  public List<CsConverter> loadAll() {
    List<CsConverter> csConverterList = null;

    try {
      // load the CsConverter
      csConverterList = CsConverterBusinessDelegate.getCsConverterInstance().getAllCsConverter();

      if (csConverterList != null) LOGGER.log(Level.INFO, "successfully loaded all CsConverters");
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load all CsConverters ", exc);
      return null;
    }

    return csConverterList;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected CsConverter csConverter = null;
  private static final Logger LOGGER =
      Logger.getLogger(CsConverterQueryRestController.class.getName());
}
