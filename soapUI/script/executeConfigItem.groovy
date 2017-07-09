/**
 * Created by jzhangkun on 09/07/2017.
 */

scripts = testRunner.testCase.testSuite.project.testSuites["Script Library"];
scripts.testCases["Core"].testSteps["initConfigItem"].run(testRunner, context);

def ci = context.configItem;
ci.parse('{\"fname\":\"kun\", \"lname\": \"zhang\"}');
ci.expect("fname", "kun");
ci.expectLastName("zhang");
log.info(ci.result);

