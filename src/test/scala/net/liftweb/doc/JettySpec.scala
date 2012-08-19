package net.liftweb.doc

import org.scalatest._

import org.eclipse.jetty._
import server.{Connector,Server}
import server.nio._
import webapp.WebAppContext

trait JettySpec extends FunSpec {
  
  private val serverThread = new Thread() {
    private val server = new Server
    
    override def run() {
      
      val scc = new SelectChannelConnector
      scc.setPort(8080)
      server.setConnectors(Array(scc))

      val context = new WebAppContext()
      context.setServer(server)
      context.setContextPath("/")
      context.setWar("src/main/webapp")

      server.setHandler(context)
      server.setStopAtShutdown(true)
      server.start()
      server.join()
    }
    
    def done() {
      server.stop()
    }
    
    def isStarted = server.isStarted()
    def getHost = {
      val conn = server.getConnectors()(0)
      "http://localhost:" + conn.getLocalPort + "/"
    }
  }
  
  lazy val host = serverThread.getHost

  override def run(testName: Option[String], args: Args) {
    serverThread.start()
    while (!serverThread.isStarted)
      Thread.sleep(10)
    
    try super.run(testName, args)
    finally serverThread.done()
  }
}