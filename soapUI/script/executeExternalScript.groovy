/**
 * Created by jzhangkun on 09/07/2017.
 */

import groovy.lang.Binding
import groovy.util.GroovyScriptEngine

def groovyUtils = new com.eviware.soapui.support.GroovyUtils( context )

log.info(groovyUtils)

//log.info(groovyUtils.getProjectPath)

// define location of script file relative to project file.
String projectPath = groovyUtils.getProjectPath() + "/groovy/";
log.info(orojectPath);

// Create Groovy Script Engine to run Script.
GroovyScriptEngine gse = new GroovyScriptEngine(projectPath)

// Load the Groovy Script file
externalScript = gse.loadScriptByName("Utility.groovy")

// Create a runtime instance of script
instance = externalScript.newInstance()

// Sanity check
assert instance!= null

// run a method in external script
instance.foo()
