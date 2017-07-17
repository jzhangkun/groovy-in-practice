/**
 * Created by jzhangkun on 09/07/2017.
 */
import groovy.lang.Binding
import groovy.util.GroovyScriptEngine

def groovyUtils = new com.eviware.soapui.support.GroovyUtils( context );

// define location of script file relative to project file.
String projectPath = groovyUtils.getProjectPath()
log.info(orojectPath);
String newProjectPath = projectPath + "../src/groovy/com/kun"

// Create Groovy Script Engine to run Script.
GroovyScriptEngine gse = new GroovyScriptEngine(newProjectPath)

// Load the Groovy Script file
externalScript = gse.loadScriptByName("Hello.groovy")

// Create a runtime instance of script
instance = externalScript.newInstance()
log.info(instance)

// Sanity check
assert instance!= null

// run a method in external script
instance.foo()
