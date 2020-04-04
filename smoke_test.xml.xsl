<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd" >
<suite name="Smoke">
    <test name="Smoke test">
        <!--        represents extent report name-->
        <parameter name="reportName" value="smoke"/>
        <classes>
            <class name="com.automation.pages.NewLoginTests">
                <methods>
                    <!--                    remove loginWithDDT method from test execution list-->
                    <exclude name="loginWithDDT"/>
                </methods>
            </class>
        </classes>
    </test>
</suite>









