package homepage

import (
	"boole.io/homepage/util"
)

func GetContaContacts() *Contacts {

	return &Contacts{
		email: NewUrl("xor_boole@mit.edu"),

		github: GHUrl("drXor"),

		irc: []string{"think", "irc.spi.gt"},
	}
}

func GetProjects() map[string]*Project {

	projs := make(map[string]*Project)

	projs["MayhemMultiverse"] = &Project{

		// A Minecraft multiplayer network with heavy
		// server-side customization.

		url: NewUrl("mayhem-multiverse.com"),

		// My position primarially involves developing
		// infrastructure, design of features, and
		// communicating with third-party developers.
		position: []string{"Lead Developer", "Founder"},

		skills: []string{
			"Java server-side development",
			"server distribution and communication",
			"gameplay design",
		},

		// Major infrastructure components I designed
		subprojects: []string{
			"intra-network RMI using messages",
			"modified world format for custom storage",
			"custom in-game GUI framework",
			"persistent item metadata",
		},
	}

	projs["Minecraft3DResourcePack"] = &Project{

		// An asset pack for Minecraft making use
		// of custom 3D models.

		url: GHUrl("drXor/1.8-Models"),

		skills: []string{
			"texture design", "GIMP",
			"simple modeling", "Minecraft JSON model format",
		},
	}

	projs["ScalaModelTools"] = &Project{

		// Command line tools for modifying JSON models
		// created as part of the 1.8-Models project.

		url: GHUrl("drXor/ScalaModelTools"),

		skills: []string{
			"3D geometry transformation",
		},
	}

	projs["ScalaNBT"] = &Project{

		// Lightweight Scala library for manipulating NBT
		// (Named Binary Tag) files, with simple syntax

		url: GHUrl("drXor/ScalaNBT"),

		skills: []string{
			"library design",
			"NBT manipulation",
		},
	}

	projs["brainscala"] = &Project{

		// Scala-based interpreter and compiler for the
		// brainf--k language.

		url: GHUrl("drXor/brainscala"),

		skills: []string{
			"language parsing",
			"code generation",
			"JNI", "C",
		},
	}

	projs["Pictures"] = &Project{

		// School project at MIT that creates
		// "word art" from images and text fetched
		// using Wikipedia's API

		url: GHUrl("drXor/Pictures"),

		skills: []string{
			"Wikipedia API",
			"Java Swing",
			"image processing",
		},
	}
	return projs
}
