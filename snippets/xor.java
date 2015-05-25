package io.boole.xor.homepage;
import static io.boole.xor.homepage.Util.*;
import java.net.URL;
import java.util.*;

public final class Homepage {

  public static Map<String, Object> getContacts() throws Exception {

    Map<String, Object> contacts = new HashMap<>();

    contacts.put("email",  new URL("xor_boole@mit.edu"));

    contacts.put("github", toGithub("drXor"));

    contacts.put("irc",    new String[] { "#think", "irc.spi.gt" });

    return contacts;
  }

  public static final class Projects {

    public static final class MayhemMultiverse implements Project {

      /**
       *  A Minecraft multiplayer network with heavy
       *  server-side customization.
       */

      @Override
      public static URL getURL() throws Exception {
        return new URL("mayhem-multiverse.com");
      } 
      /**
       *  My position primarially involves developing 
       *  infrastructure, design of features, and 
       *  communicating with third-party developers.
       */
      public static final String[] position = { "Lead Developer", "Founder" };

      @Override 
      public static String[] getSkills() { 
        return new String[] {
          "Java server-side development",
          "server distribution and communication",
          "gameplay design"
        };
      }
      /**
       * Major infrastructure components I designed
       */
      public static final String[] subprojects = {
        "intra-network RMI using messages",
        "modified world format for custom storage",
        "custom in-game GUI framework",
        "persistent item metadata"
      };
    }

    public static final class Minecraft3DResourcePack implements Project {

      /**
       *  An asset pack for Minecraft making use
       *  of custom 3D models.
       */

      @Override
      public static URL getURL() throws Exception {
        return toGithub("drXor/1.8-Models");
      }

      @Override 
      public static String[] getSkills() {  
        return new String[] {
          "texture design", "GIMP",
          "simple modeling", "Minecraft JSON model format"
        };
      }

      public static final class ScalaModelTools implements Project {

        /**
         *  Command line tools for modifying JSON models
         *  created as part of the 1.8-Models project.
         */

        @Override
        public static URL getURL() throws Exception {
          return toGithub("drXor/ScalaNBT");
        }

        @Override 
        public static String[] getSkills() {  
          return new String[] { "3D geometry transformation" };
        }
      }
    }

    public static final class ScalaNBT implements Project {

      /**
       *  Lightweight Scala library for manipulating NBT
       *  (Named Binary Tag) files, with simple syntax
       */

      @Override
      public static URL getURL() throws Exception {
        return toGithub("drXor/ScalaNBT");
      }

      @Override 
      public static String[] getSkills() {  
        return new String[] { 
          "library design",
          "NBT manipulation"
        };
      }
    }

    public static final class brainscala implements Project {

      /**
       *  Scala-based interpreter and compiler for the
       *  brainf--k language.
       */

      @Override
      public static URL getURL() throws Exception {
        return toGithub("drXor/brainscala");
      }

      @Override 
      public static String[] getSkills() {  
        return new String[] { 
          "language parsing",
          "code generation",
          "JNI", "C"
        };
      }
    }

    public static final class Pictures implements Project {

      /**
       *  School project at MIT that creates
       *  "word art" from images and text fetched
       *  using Wikipedia's API
       */

      @Override
      public static URL getURL() throws Exception {
        return toGithub("drXor/Pictures");
      }

      @Override 
      public static String[] getSkills() {  
        return new String[] { 
          "Wikipedia API",
          "Java Swing",
          "image processing"
        };
      }
    }
  }
}