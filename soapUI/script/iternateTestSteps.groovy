/**
 * Created by jzhangkun on 09/07/2017.
 */
def project = context.testCase.testSuite.project
def testSuiteList = project.getTestSuiteList()

testSuiteList.each
        {
            if (!it.isDisabled())
            {
                def testSuite = it

                if (testSuite.name.contains("(TARGET)"))
                {
                    def testCaseList = testSuite.getTestCaseList()

                    testCaseList.each
                            {
                                if (!it.isDisabled())
                                {
                                    def testCase = it

                                    def testStepList = testCase.getTestStepList()

                                    testStepList.each
                                            {
                                                if (!it.isDisabled())
                                                {
                                                    def testStep = it

                                                    if (testStep instanceof  com.eviware.soapui.impl.wsdl.teststeps.RestTestRequestStep)
                                                    {
                                                        if( testStep.getAssertionCount() != 5)
                                                        {
                                                            log.info(testSuite.name+"."+testCase.name+"."+testStep.name+"="+ testStep.getAssertionCount())

                                                            def assertionList = testStep.getAssertionList()

                                                            assertionList.each
                                                                    {
                                                                        def assertion = it
                                                                        log.info(testSuite.name+"."+testCase.name+"."+testStep.name+"."+assertion.name)
                                                                    }
                                                        }
                                                    }
                                                }
                                            }
                                }
                            }
                }
            }
        }
