Title:  Nodeclipse Help - Run/Debug with Monitor


## Run/Debug with Monitor

https://github.com/Nodeclipse/nodeclipse-1/issues/57
running app.js with node-dev, forever, supervisor, nodemon etc

Select monitor

- https://www.npmjs.org/package/forever 
- https://www.npmjs.org/package/nodemon 
- https://www.npmjs.org/package/node-dev 
- https://www.npmjs.org/package/supervisor

They all have similar command line

forever [action] [options] SCRIPT [script-options]   
nodemon [your node app]   
node-dev foo.js   
supervisor [options] <program>  

Below are some remarks about GitHub stars:

- [forever](https://github.com/nodejitsu/forever) - 2700 stars
- [node-dev](https://github.com/fgnass/node-dev) - 380 stars (doesn't require any configuration)
- [nodemon](https://github.com/remy/nodemon) 1500 stars - support running .coffee
- [supervisor](https://github.com/isaacs/node-supervisor) 1100 stars 


After installing with `npm install * -g`, browse for CLI file

e.g. `C:\Users\weibl\AppData\Roaming\npm\node_modules\forever\bin\forever`

Configure path to your source file monitor in Preferences -> Nodeclipse -> Node monitor path



### Contribute

<a href="https://github.com/Nodeclipse/nodeclipse-1/blob/master/org.nodeclipse.help/contents/monitor.md" target="_blank">Edit online on GitHub</a>

