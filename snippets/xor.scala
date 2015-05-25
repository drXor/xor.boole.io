package io.boole.xor.homepage
import homepage.util._

def contacts = Map(

  "email"  -> "xor_boole@mit.edu".url

  "github" -> "drXor".github

  "irc"    -> ("#think" -> "irc.spi.gt")
)

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
    val position = "Lead Developer" :: "Founder" :: Nil

    val skills = 
      "Java server-side development" ::
      "server distribution and communication" ::
      "gameplay design" :: Nil
    /**
     * Major infrastructure components I designed
     */
    val subprojects = 
      "intra-network RMI using messages" ::
      "modified world format for custom storage" ::
      "custom in-game GUI framework" ::
      "persistent item metadata" :: Nil
  }

  object Minecraft3DResourcePack extends Project {

    /**
     *  An asset pack for Minecraft making use
     *  of custom 3D models.
     */

    val url = "drXor/1.8-Models".github

    val skills = 
     "texture design" using "GIMP" ::
     "simple modeling" using "Minecraft JSON model format" :: Nil

    object ScalaModelTools extends Project {

      /**
       *  Command line tools for modifying JSON models
       *  created as part of the 1.8-Models project.
       */

      val url = "drXor/ScalaModelTools".github

      val skills = "3D geometry transformation" :: Nil
    }
  }

  object ScalaNBT extends Project {

    /**
     *  Lightweight Scala library for manipulating NBT
     *  (Named Binary Tag) files, with simple syntax
     */

    val url = "drXor/ScalaNBT".github

    val skills = 
      "library design" ::
      "NBT manipulation" :: Nil
  }

  object brainscala extends Project {

    /**
     *  Scala-based interpreter and compiler for the
     *  brainf--k language.
     */

    val url = "drXor/brainscala".github

    val skills = 
      "language parsing" ::
      "code generation" ::
      "JNI" :: "C" :: Nil
  }

  object Pictures extends Project {

    /**
     *  School project at MIT that creates
     *  "word art" from images and text fetched
     *  using Wikipedia's API
     */

    val url = "drXor/Pictures".github

    val skills = 
      "Wikipedia API" ::
      "Java Swing" ::
      "image processing" :: Nil
  }
}