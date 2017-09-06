package com.zxventures.geladinha

import akka.actor.ActorSystem
import akka.http.scaladsl.server.RouteConcatenation._
import com.zxventures.geladinha.components.healthCheck.HealthCheckRoute
import com.zxventures.geladinha.components.swagger.SwaggerRoute
import com.zxventures.geladinha.components.user.UserRoute
import org.slf4j.LoggerFactory

class MainRoute()(implicit system: ActorSystem) {
  val log = LoggerFactory.getLogger(this.getClass)

  val healthCheck = new HealthCheckRoute {
    override implicit def actorSystem: ActorSystem = system
  }
  val swagger = new SwaggerRoute

  val user = new UserRoute {
    override implicit def actorSystem: ActorSystem = system
  }

  val routes = swagger.routes ~ healthCheck.routes ~ user.routes
}
