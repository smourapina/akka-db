package com.akkadb

import akka.actor.Actor
import akka.event.Logging

import scala.collection.mutable.HashMap

class AkkaDb extends Actor {

  val map = new HashMap[String, Object]
  val log = Logging(context.system, this)

  override def receive = {
    case SetRequest(key, value) => {
      log.info("received message SetRequest with key: {}, value: {}", key, value)
      map.put(key, value)
    }
    case message => log.info("received unknown message; {}", message)
    }
}
