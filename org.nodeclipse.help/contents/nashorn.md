

# Nashorn

## Links

Main blog <https://blogs.oracle.com/nashorn/> by Jim Laskey

Sources: <http://hg.openjdk.java.net/nashorn/jdk8/nashorn>

- <http://insin-notes.readthedocs.org/en/latest/JavaOne2012/nashorn_node_jpa_persistence_bof.html>
 references Node.jar project (implementation of Node.js on JVM). However there are no more news, and the projects 
 is closed-sourced in Oracle.

	- Node.jar, Akhil Arora
	- JPA & Node.jar, Doug Clarke


- [Java Platform, Standard Edition Nashorn User's Guide](http://download.java.net/jdk8/docs/technotes/guides/scripting/nashorn/)


- [Java Scripting Programmer's Guide](http://hg.openjdk.java.net/nashorn/jdk8/nashorn/raw-file/29b2b2ed954c/docs/JavaScriptingProgrammersGuide.html)


Old and excited blog post: <http://kaeff.net/posts/why-ruby-and-nodejs-folks-should-care-about-project-nashorn.html>

If you use JavaFX inside JavaScript, you should use SDK, not just JRE.

## Java 8 script utils 

Java 8 goes with 2 utils: `jjs` for running JavaScript on Nashorn engine
 and `jrunscript` for running any script engine

### `jjs` command line util

<pre><code>
C:\Program Files\Java\jdk1.8.0\bin>jjs.exe -v

nashorn 1.8.0


C:\Program Files\Java\jdk1.8.0\bin>jjs.exe -h

jjs [<options>] <files> [-- <arguments>]
        -D (-Dname=value. Set a system property. This option can be repeated.)

        -cp, -classpath (-cp path. Specify where to find user class files.)

        -doe, -dump-on-error (Dump a stack trace on errors.)
                param: [true|false]   default: false

        -fv, -fullversion (Print full version info of Nashorn.)
                param: [true|false]   default: false

        -fx (Launch script as an fx application.)
                param: [true|false]   default: false

        -h, -help (Print help for command line flags.)
                param: [true|false]   default: false

        -scripting (Enable scripting features.)
                param: [true|false]   default: false

        -strict (Run scripts in strict mode.)
                param: [true|false]   default: false

        -t, -timezone (Set timezone for script execution.)
                param: <timezone>   default: Asia/Shanghai

        -v, -version (Print version info of Nashorn.)
                param: [true|false]   default: false
</code></pre>
	
### `jrunscript` command line util	
	
<pre><code>
C:\Program Files\Java\jdk1.8.0\bin>jrunscript.exe  -h
Usage: jrunscript [options] [arguments...]

where [options] include:
  -classpath <path>    Specify where to find user class files
  -cp <path>           Specify where to find user class files
  -D<name>=<value>     Set a system property
  -J<flag>             Pass <flag> directly to the runtime system
  -l <language>        Use specified scripting language
  -e <script>          Evaluate given script
  -encoding <encoding> Specify character encoding used by script files
  -f <script file>     Evaluate given script file
  -f -                 Interactive mode, read script from standard input
                       If this is used, this should be the last -f option
  -help                Print this usage message and exit
  -?                   Print this usage message and exit
  -q                   List all scripting engines available and exit

If [arguments..] are present and if no -e or -f option is used, then first
argument is script file and the rest of the arguments, if any, are passed
as script arguments. If [arguments..] and -e or -f option is used, then all
[arguments..] are passed as script arguments. If [arguments..], -e, -f are
missing, then interactive mode is used.

C:\Program Files\Java\jdk1.8.0\bin>jrunscript.exe  -q
Language ECMAScript ECMA - 262 Edition 5.1 implemention "Oracle Nashorn" 1.8.0
</code></pre>

### Examples

#### Using threads in JavaScript

From <http://www.infoq.com/articles/nashorn>

```javascript
// this is how we get access to Java class Thread 
var Thread = Java.type("java.lang.Thread"); 

// subclass with our run method 
var MyThread = Java.extend(Thread, { 
    run: function() { 
        print("Run in separate thread"); 
    } 
}); 
var th = new MyThread(); 
th.start(); 
th.join(); 
```

More

```javascript
var r = new java.lang.Runnable({
    run: function() {
        print("running...\n");
    }
});
```

#### Lambdas

Compare

```javascript
var jsArray = [4,1,3,2]; 
jsArray.forEach(function(el) { print(el) } ); 
```

and the same with Java Collections and lambda usage [1](http://stackoverflow.com/questions/23100392/java-lang-classcastexception-jdk-nashorn-internal-objects-nativearray-cannot-be):

```javascript
var jsArray = [1,2,3,4];
var list = Java.to(jsArray, Java.type('java.util.List'));
list.forEach(function(el) { print(el) } ); 
```

#### Scripting

From <https://blogs.oracle.com/nashorn/entry/csi_nashorn_shell_scripting_in>

```javascript
#!/usr/bin/jjs
# This script hunts down the change set associated with a
# source file and a line number.
#

// Report proper command usage.
function usage() {
    error(<<EOS);
usage: suspect javaFileName lineNumber
    javaFileName - name of file in local mercurial repository
    lineNumber   - file line number
EOS
}

// Provide meaningful names for arguments.
var fileName   = $ARG[0];
var lineNumber = $ARG[1];

// If arguments are missing, report proper usage.
if (!fileName || !lineNumber) {
    usage();
}
```

### Contribute

<a href="https://github.com/Nodeclipse/nodeclipse-1/blob/master/org.nodeclipse.help/contents/nashorn.md" target="_blank">Edit online on GitHub</a>
	