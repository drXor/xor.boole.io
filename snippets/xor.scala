package io.boole.xor.homepage
import homepage.util._

object Contacts {

  val email = "xor_boole@mit.edu".url

  val github = "drXor".github

  val irc = "#think" -> "irc.spi.gt"

}

package projects {

  object MayhemMultiverse extends Project {

    /**
     *  A Minecraft multiplayer network with heavy
     *  server-side customization.
     */

    val url = "mayhem-multiverse.com".url

    /**
     *  My position primarially involves developing 
     *  infrastructure, design of features, and 
     *  communicating with third-party developers.
     */
    val position = "Lead Developer" &amp; "Founder"

    val skills = List(
      "Java server-side development",
      "server distribution and communication",
      "gameplay design"
    )
    /**
     * Major infrastructure components I designed
     */
    val subprojects = List(
      "intra-network RMI using messages",
      "modified world format for custom storage",
      "custom in-game GUI framework",
      "persistent item metadata"
    )
  }

  object Minecraft3DResourcePack extends Project {

    /**
     *  An asset pack for Minecraft making use
     *  of custom 3D models.
     */

    val url = "drXor/1.8-Models".github

    val skills = List(
     "texture design" using "GIMP",
     "simple modeling" using "Minecraft JSON model format"
    )

    object ScalaModelTools extends Project {

      /**
       *  Command line tools for modifying JSON models
       *  created as part of the 1.8-Models project.
       */

      val url = "drXor/ScalaModelTools".github

      val skills = List(
        "3D geometry transformation"
      )
    }
  }

  object ScalaNBT extends Project {

    /**
     *  Lightweight Scala library for manipulating NBT
     *  (Named Binary Tag) files, with simple syntax
     */

    val url = "drXor/ScalaNBT".github

    val skills = List(
      "library design",
      "NBT manipulation"
    )
  }

  object brainscala extends Project {

    /**
     *  Scala-based interpreter and compiler for the
     *  brainf--k language.
     */

    val url = "drXor/brainscala".github

    val skills = List(
      "language parsing",
      "code generation",
      "JNI", "C"
    )
  }

  object Pictures extends Project {

    /**
     *  School project at MIT that creates
     *  "word art" from images and text fetched
     *  using Wikipedia's API
     */

    val url = "drXor/Pictures".github

    val skills = List(
      "Wikipedia API",
      "Java Swing",
      "image processing"
    )
  }
}