/**
 * Created by jzhangkun on 09/07/2017.
 */

import groovy.json.JsonSlurper;
context.setProperty("configItem", new ConfigItem(log, context, testRunner));

class ConfigItem {
    def log;
    def context;
    def testRunner;

    ConfigItem(log, context, testRunner) {
        this.log = log;
        this.context = context;
        this.testRunner = testRunner;
    }

    def jsonSlurper = new JsonSlurper();
    def result;

    def parse(response) {
        result = jsonSlurper.parseText(response);
    }

    def expect(attr, expected) {
        assert(result."${attr}" == expected);
    }

    def expectFirstName(expected) {
        assert(result.fname == expected);
    }

    def expectLastName(expected) {
        assert(result.lname == expected);
    }

    static void main(args) {
        ConfigItem ci = new ConfigItem("a", "b", "c");
        ci.parse("{\"fname\":\"zhang\", \"lname\": \"kun\"}");
        ci.expect("fname", "zhang");
        println("completed");
    }
}

