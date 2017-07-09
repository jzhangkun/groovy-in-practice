/**
 * Created by jzhangkun on 09/07/2017.
 */

correlationID = context.expand('${=java.util.UUID.randomUUID()}')
testRunner.testCase.setPropertyValue("correlationID", correlationID)
log.info("correlationID="+testRunner.testCase.getPropertyValue("correlationID"))

startTime = context.expand('${=System.currentTimeMillis()}')
testRunner.testCase.setPropertyValue("startTime", startTime)
log.info("startTime="+testRunner.testCase.getPropertyValue("startTime"))

currentTime = context.expand('${=Calendar.getInstance().getTime()}')
testRunner.testCase.setPropertyValue("currentTime", currentTime)
log.info("currentTime="+testRunner.testCase.getPropertyValue("currentTime"))

isoDate = context.expand('${=new java.text.SimpleDateFormat("yyyy-mm-dd").format(Calendar.getInstance().getTime())}')
testRunner.testCase.setPropertyValue("isoDate", isoDate)
log.info("isoDate="+testRunner.testCase.getPropertyValue("isoDate"))

currentLocale = context.expand('${=Locale.getDefault()}')
testRunner.testCase.setPropertyValue("currentLocale", currentLocale)
log.info("currentLocale="+testRunner.testCase.getPropertyValue("currentLocale"))

systemProperty = context.expand('${=System.getProperty("soapui.home")}')
testRunner.testCase.setPropertyValue("systemProperty", systemProperty)
log.info("systemProperty="+testRunner.testCase.getPropertyValue("systemProperty"))
