package com.zxventures.geladinha.infrastructure.test

import akka.actor.ActorSystem
import akka.testkit.{ImplicitSender, TestKit}

class ActorSpec extends TestKit(ActorSystem("MyTestSystem")) with ImplicitSender with UnitSpec {
  override def afterAll () = TestKit.shutdownActorSystem(system)
}
