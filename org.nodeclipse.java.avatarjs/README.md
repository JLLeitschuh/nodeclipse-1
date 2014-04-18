
# org.nodeclipse.java.avatarjs

Quick and dirty idea/code to launch .js with java 8 and Avatar.js lib  
Not yet finished, reason:  
running with Java/Avatar.js is launching like `java -Djava.library.path=lib -jar lib/avatar-js.jar helloWorld.js`
- libs maybe missing or in other folder, 
- embedding not released binaries in Eclipse plugin seems bad idea (also there are native lib for every OS)
- would require searching for project root (Node can actually run from any folder)


## Usage

Read at <>

Read also built-in <kbd>F1</kbd>
 and [Online Help](https://github.com/Nodeclipse/nodeclipse-1/tree/master/org.nodeclipse.help/contents#intro)

### Links

- http://www.infoq.com/articles/nashorn
- https://blogs.oracle.com/theaquarium/entry/project_avatar_is_open_source
- https://avatar.java.net/
- http://blog.jonasbandi.net/2014/03/running-nodejs-applications-on-jvm-with.html
- http://strongloop.com/strongblog/how-to-run-node-js-on-the-jvm-with-avatar-js-and-loopback/

## Developing

Depends on `.ui` and `.common`

`Import-Package: org.nodeclipse.debug.launch` in MANIFEST.MF is  for `org.nodeclipse.debug.launch.LaunchConfigurationEnvironmentTab`

org.nodeclipse.debug.util is for in org.nodeclipse.phantomjs.launch.LaunchConfigurationDelegate

TODO copy that Class or make .debug module general (not Node.js related)
