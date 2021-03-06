<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd" >
<suite name="Test suite">

    <test name="Login">
        <parameter name="reportName" value="login"/>
        <classes>
            <class name="com.automation.pages.NewLoginTests"/>
        </classes>
    </test>

    <test name="Calendar events">
        <parameter name="reportName" value="calendarEvents"/>
        <classes>
            <class name="com.automation.tests.activities.NewCalenderEventsTests"/>
        </classes>
    </test>

</suite>