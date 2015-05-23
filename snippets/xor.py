# from io.boole.xor import __the_whole_site__

from io.boole.xor.homepage import *

contacts = {

  'email': url('xor_boole@mit.edu'),

  'github': url.gh('drXor'),

  'irc': ('#think', 'irc.spi.gt')

}

projects = {

  'MayhemMultiverse': {

    """
    A Minecraft multiplayer network with heavy
    server-side customization.
    """

    url: url('mayhem-multiverse.com'),

    """
    My position primarially involves developing 
    infrastructure, design of features, and 
    communicating with third-party developers.
    """
    position: ("Lead Developer", "Founder"),

    skills: [
      'Java server-side development',
      'server distribution and communication',
      'gameplay design'
    ],
    """
    Major infrastructure components I designed
    """
    subprojects: [
      'intra-network RMI using messages',
      'modified world format for custom storage',
      'custom in-game GUI framework',
      'persistent item metadata'
    ]
  },

  'Minecraft3DResourcePack': {

    """
    An asset pack for Minecraft making use
    of custom 3D models.
    """

    url: url.gh('drXor/1.8-Models'),

    skills: [
     'texture design', 'GIMP',
     'simple modeling', 'Minecraft JSON model format'
    ],

    ScalaModelTools: {

      """
      Command line tools for modifying JSON models
      created as part of the 1.8-Models project.
      """

      url: url.gh('drXor/ScalaModelTools'),

      skills: [ '3D geometry transformation' ]
    }
  },

  'ScalaNBT': {

    """
    Lightweight Scala library for manipulating NBT
    (Named Binary Tag) files, with simple syntax
    """

    url = url.gh('drXor/ScalaNBT'),

    skills: [
      'library design',
      'NBT manipulation'
    ]
  },

  'brainscala': {

    """
    Scala-based interpreter and compiler for the
    brainf--k language.
    """

    url: url.gh('drXor/brainscala'),

    skills: [
      'language parsing',
      'code generation',
      'JNI', 'C'
    ]
  },

  'Pictures': {

    """
    School project at MIT that creates
    "word art" from images and text fetched
    using Wikipedia's API
    """

    url: url.gh('drXor/Pictures'),

    skills: [
      'Wikipedia API',
      'Java Swing',
      'image processing'
    ]
  }
}