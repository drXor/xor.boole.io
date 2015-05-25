#include "io/boole/xor/homepage.h"

Contacts get_contacts() {

    return (Contacts) {
        .email = url->new("xor_boole@mit.edu"),

        .github = url->gh("drXor"),

        .irc = { "#think", "irc.spi.gt" }
    }   
}

Project projects[] = {

    (Project) {
        /* A Minecraft multiplayer network 
         with heavy server-side customization. */
        .name = "Mayhem Multiverse",

        .url = url->new("mayhem-multiverse.com"),

        /* My position primarially involves developing 
         infrastructure, design of features, and 
         communicating with third-party developers. */
        .position = { "Lead Developer", "Founder" },

        .skills = {
            "Java server-side development",
            "server distribution and communication",
            "gameplay design"
        },

        /* Major infrastructure components I designed */
        .subprojects = {
            "intra-network RMI using messages",
            "modified world format for custom storage",
            "custom in-game GUI framework",
            "persistent item metadata"
        }
    },

    (Project) {
        /* An asset pack for Minecraft making use
         of custom 3D models. */
        .name = "Minecraft 3D Resource Pack",

        .url = url->gh("drXor/1.8-Models"),

        .skills = {
            "texture design", "GIMP",
            "simple modeling", "Minecraft JSON model format"
        },

        .subprojects = {
            (Project) {
                /* Command line tools for modifying JSON models
                 created as part of the 1.8-Models project. */
                .name = "ScalaModelTools",

                .url = url->gh("drXor/ScalaModelTools"),

                .skills = { "3D geometry transformation" }
            }
        }
    },

    (Project) {
        /* Lightweight Scala library for manipulating NBT
         (Named Binary Tag) files, with simple syntax */
        .name = "ScalaNBT",

        .url = url->gh("drXor/ScalaNBT"),

        .skills = {
            "library design",
            "NBT manipulation"
        }
    },

    (Project) {
        /* Scala-based interpreter and compiler for 
         the brainf--k language. */
        .name = "brainscala",

        .url = url->gh("drXor/brainscala"),

        .skills = {
            "language parsing",
            "code generation",
            "JNI", "C"
        }
    },

    (Project) {

        /* School project at MIT that creates "word art" 
         from images and text fetched using Wikipedia's API */

        .name = "Pictures",

        .url = url->gh("drXor/Pictures"),

        .skills = {
            "Wikipedia API",
            "Java Swing",
            "image processing"
        }
    }
};