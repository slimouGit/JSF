1. new Jave EE Project 
- Web Application/JSF/Primefaces

2. Add Frameworks Support
- Maven

3. Complete POM
- dependencies:
<dependencies>
        <!-- https://mvnrepository.com/artifact/javax.faces/javax.faces-api -->
        <dependency>
            <groupId>javax.faces</groupId>
            <artifactId>javax.faces-api</artifactId>
            <version>2.2</version>
            <scope>provided</scope>
        </dependency>

        <!-- Import the CDI API, we use provided scope as the API is included in
			JBoss WildFly -->
        <dependency>
            <groupId>javax.enterprise</groupId>
            <artifactId>cdi-api</artifactId>
            <version>2.0</version>
            <scope>provided</scope>
        </dependency>

        <!-- https://mvnrepository.com/artifact/javax/javaee-api -->
        <dependency>
            <groupId>javax</groupId>
            <artifactId>javaee-api</artifactId>
            <version>7.0</version>
            <scope>provided</scope>
        </dependency>
        <!-- https://mvnrepository.com/artifact/org.primefaces/primefaces -->
        <dependency>
            <groupId>org.primefaces</groupId>
            <artifactId>primefaces</artifactId>
            <version>6.1</version>
        </dependency>

        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-api</artifactId>
            <version>1.7.25</version>
            <scope>provided</scope>
        </dependency>
    </dependencies>

4. Update dependencies
- POM/Maven/Reimport

5. Edit configurations
- JBoss Server (local)
- Application Server (Wilfly folder)
- URL: http://localhost:8080/Dummy_Project_war_exploded/index.xhtml
- Deployments, add war exploded

6. Filesystem
- web/content/index.xhtml (change in 5. URL too)
- web/resources
- web/resources/components
- web/resources/css
- web/template
- main/resources/messages.properties (file)

7. edit web.xml

<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
         version="4.0">
    <servlet>
        <servlet-name>Faces Servlet</servlet-name>
        <servlet-class>javax.faces.webapp.FacesServlet</servlet-class>
        <load-on-startup>1</load-on-startup>
    </servlet>
    <servlet-mapping>
        <servlet-name>Faces Servlet</servlet-name>
        <url-pattern>*.xhtml</url-pattern>
    </servlet-mapping>
    <context-param>
        <param-name>primefaces.THEME</param-name>
        <param-value>omega</param-value>
    </context-param>
    <welcome-file-list>
        <welcome-file>/content/index.xhtml</welcome-file>
    </welcome-file-list>
</web-app>

8. edit faces-config.xml
- to add
<application>
        <resource-bundle>
            <base-name>messages</base-name>
            <var>msg</var>
        </resource-bundle>
    </application>

9. Primefaces configuration IntelliJ
- File/Project Structure/Artifacts/ add everything with Primefaces

10. plain xhtml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://xmlns.jcp.org/jsf/html"
      xmlns:ui="http://xmlns.jcp.org/jsf/facelets"
      xmlns:f="http://xmlns.jcp.org/jsf/core"
      xmlns:p="http://primefaces.org/ui"
>
<h:head>
   <title>DummyProject</title>
   <f:metadata>
   </f:metadata>
</h:head>
<f:view>
   <p:outputLabel value="Dummy Project"/>
</f:view>
</html>

11. add Bean
- src/main/java/de/DummyProject.java

package de;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class DummyProject implements Serializable {
    private String projectTitle;
    @PostConstruct
    public void init() {
        this.projectTitle = "Dummy Project";
    }
    public String getProjectTitle() {
        return projectTitle;
    }
}

12. add message Properties
- main/resources/messages.properties
- headline.PROJECT_NAME = Welcome to Dummy Project

13. add composite components
- web/resources/components/...
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns:composite="http://xmlns.jcp.org/jsf/composite"
      xmlns:p="http://primefaces.org/ui"
>

<composite:interface>
    <composite:attribute name="labelValue"/>
</composite:interface>

<composite:implementation>
    <p:outputLabel value="#{cc.attrs.labelValue}"/>
</composite:implementation>

</html>

