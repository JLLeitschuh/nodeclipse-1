
## de.akquinet.javascript.archetypes are not updated for 2 years

mvn archetype:generate -DgroupId=com.mycompany.app -DartifactId=my-maven-js -DarchetypeArtifactId=javascript-quickstart

mvn archetype:generate -DarchetypeGroupId=de.akquinet.javascript.archetypes -DarchetypeArtifactId=javascript-quickstart -DgroupId=com.mycompany.app -DartifactId=my-maven-js
 
mvn archetype:generate -DarchetypeGroupId=de.akquinet.javascript.archetypes -DarchetypeArtifactId=javascript-quickstart -Dversion=0.1.0-SNAPSHOT -DgroupId=com.mycompany.app -DartifactId=my-maven-js-m2e -DinteractiveMode=false 
TODO
maven new de.akquinet.javascript.archetypes:javascript-quickstart my-maven-js-m2e

mvn archetype:generate -DarchetypeGroupId=de.akquinet.javascript.archetypes -DarchetypeArtifactId=javascript-jqueryplugin -Dversion=0.1.0-SNAPSHOT -DgroupId=com.mycompany.app -DartifactId=my-maven-jquery-m2e -DinteractiveMode=false 

## jasmine-maven-plugin path

Archetype is old. jasmine-maven-plugin version should be 1.3.1.4
See <http://searls.github.io/jasmine-maven-plugin/>

        <plugins>
            <plugin>
                <groupId>com.github.searls</groupId>
                <artifactId>jasmine-maven-plugin</artifactId>
                <version>1.3.1.4</version>
                <executions>
                    <execution>
                        <goals>
                            <goal>generateManualRunner</goal>
                            <goal>resources</goal>
                            <goal>testResources</goal>
                            <goal>test</goal>
                            <goal>preparePackage</goal>
                        </goals>
                    </execution>
                </executions>
                <configuration>
                    <jsSrcDir>src/main/javascript</jsSrcDir>
                    <jsTestSrcDir>src/test/javascript</jsTestSrcDir>
                </configuration>
            </plugin>

mvn archetype:generate -DarchetypeGroupId=com.github.searls -DarchetypeArtifactId=jasmine-archetype -DarchetypeVersion=RELEASE -DgroupId=com.acme -DartifactId=my-jasmine-project -Dversion=0.0.1-SNAPSHOT

Other links  
- http://blog.inflinx.com/2010/04/16/creating-maven-archetypes-spring-mvc-example/