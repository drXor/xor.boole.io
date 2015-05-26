package io.boole.xor.homepage
import homepage.util.*

fun getContacts(): Map<String, Any> = mapOf()

  "email"  to "xor_boole@mit.edu".asUrl(),

  "github" to "drXor".asGithub(),

  "irc"    to ("#think" to "irc.spi.gt")
()

object projects {

  object MayhemMultiverse : Project {

    /**
     *  A Minecraft multiplayer network with heavy
     *  server-side customization.
     */

    val url = "mayhem-multiverse.com".asUrl()

    /**
     *  My position primarially involves developing 
     *  infrastructure, design of features, and 
     *  communicating with third-party developers.
     */
    val position = listOf("Lead Developer", "Founder")

    val skills = listOf(
      "Java server-side development",
      "server distribution and communication",
      "gameplay design"
    )
    /**
     * Major infrastructure components I designed
     */
    val subprojects = listOf(
      "intra-network RMI using messages",
      "modified world format for custom storage",
      "custom in-game GUI framework",
      "persistent item metadata"
    )
  }

  object Minecraft3DResourcePack : Project {

    /**
     *  An asset pack for Minecraft making use
     *  of custom 3D models.
     */

    val url = "drXor/1.8-Models".asGithub()

    val skills = listOf(
     "texture design" using "GIMP",
     "simple modeling" using "Minecraft JSON model format"
    )

    object ScalaModelTools : Project {

      /**
       *  Command line tools for modifying JSON models
       *  created as part of the 1.8-Models project.
       */

      val url = "drXor/ScalaModelTools".asGithub()

      val skills = listOf("3D geometry transformation")
    }
  }

  object ScalaNBT : Project {

    /**
     *  Lightweight Scala library for manipulating NBT
     *  (Named Binary Tag) files, with simple syntax
     */

    val url = "drXor/ScalaNBT".asGithub()

    val skills = listOf(
      "library design",
      "NBT manipulation"
    )
  }

  object brainscala : Project {

    /**
     *  Scala-based interpreter and compiler for the
     *  brainf--k language.
     */

    val url = "drXor/brainscala".asGithub()

    val skills = listOf(
      "language parsing",
      "code generation",
      "JNI", "C"
    )
  }

  object Pictures : Project {

    /**
     *  School project at MIT that creates
     *  "word art" from images and text fetched
     *  using Wikipedia's API
     */

    val url = "drXor/Pictures".asGithub()

    val skills = listOf(
      "Wikipedia API",
      "Java Swing",
      "image processing"
    )
  }
}