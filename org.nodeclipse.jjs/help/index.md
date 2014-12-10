

## Nashorn Examples

- fxhelloworld.js

```js
function start(stage) {
    stage.title = "Hello World!";
    var button = new Button();
    button.text = "Say 'Hello World'";
    button.onAction = function() print("Hello World!");
    var root = new StackPane();
    root.children.add(button);
    stage.scene = new Scene(root, 300, 250);
    stage.show();
}
load("fxinit.js");
```

- javaextend.js

```js
// http://hg.openjdk.java.net/nashorn/jdk8/nashorn/raw-file/29b2b2ed954c/docs/JavaScriptingProgrammersGuide.html#jsextendconcrete

/**
 * Results: 
size invoked!
add(i, e) invoked!

 */

var ArrayList = Java.type("java.util.ArrayList")
var ArrayListExtender = Java.extend(ArrayList)
var printSizeInvokedArrayList = new ArrayListExtender() {
    size: function() { print("size invoked!"); }
}
var printAddInvokedArrayList = new ArrayListExtender() {
    add: function(x, y) {
        if(typeof(y) === "undefined") {
            print("add(e) invoked!");
        } else {
            print("add(i, e) invoked!");
        }
    }
};
printSizeInvokedArrayList.size();
printAddInvokedArrayList.add(33, 33);
```

- fxinit.js

```js
GLOBAL = this;
javafx = Packages.javafx;
com.sun.javafx.application.LauncherImpl.launchApplication(
(Java.extend(javafx.application.Application, {
    init: function() {
        // FX packages and classes must be defined here because they may not be
        // viable until launch time.
        Stage          = javafx.stage.Stage;
        scene          = javafx.scene;
        Scene          = scene.Scene;
        Group          = scene.Group;
        chart          = scene.chart;
        control        = scene.control;
        Button         = control.Button;
        StackPane      = scene.layout.StackPane;
        FXCollections  = javafx.collections.FXCollections;
        ObservableList = javafx.collections.ObservableList;
        Chart          = chart.Chart;
        CategoryAxis   = chart.CategoryAxis;
        NumberAxis     = chart.NumberAxis;
        BarChart       = chart.BarChart;
        XYChart        = chart.XYChart;
        Series         = chart.XYChart$Series;
        Data           = chart.XYChart$Data;
        TreeView       = control.TreeView;
        TreeItem       = control.TreeItem;
        if (GLOBAL.init) {
            init();
        }
    },
    start: function(stage) {
        if (GLOBAL.start) {
            start(stage);
        }
    },
    stop: function() {
        if (GLOBAL.stop) {
            stop();
        }
    }
})).class, new (Java.type("java.lang.String[]"))(0));
```
