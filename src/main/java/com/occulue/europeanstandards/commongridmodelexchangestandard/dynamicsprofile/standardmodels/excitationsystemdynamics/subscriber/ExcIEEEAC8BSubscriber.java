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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.excitationsystemdynamics.subscriber;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.exception.*;
import com.occulue.subscriber.*;
import java.util.*;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.SubscriptionQueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.stereotype.Component;

/**
 * Subscriber for ExcIEEEAC8B related events. .
 *
 * @author your_name_here
 */
@Component("excIEEEAC8B-subscriber")
public class ExcIEEEAC8BSubscriber extends BaseSubscriber {

  public ExcIEEEAC8BSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<ExcIEEEAC8B>, ExcIEEEAC8B> excIEEEAC8BSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllExcIEEEAC8BQuery(),
        ResponseTypes.multipleInstancesOf(ExcIEEEAC8B.class),
        ResponseTypes.instanceOf(ExcIEEEAC8B.class));
  }

  public SubscriptionQueryResult<ExcIEEEAC8B, ExcIEEEAC8B> excIEEEAC8BSubscribe(
      @DestinationVariable UUID excIEEEAC8BId) {
    return queryGateway.subscriptionQuery(
        new FindExcIEEEAC8BQuery(new LoadExcIEEEAC8BFilter(excIEEEAC8BId)),
        ResponseTypes.instanceOf(ExcIEEEAC8B.class),
        ResponseTypes.instanceOf(ExcIEEEAC8B.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
