# Creando un proyecto usando Primefaces

Usaremos:

- JSP
- JSF
- Primefaces
- Beans
- JPA
- Hibernate
- Mysql

Estrutura.

![img](https://i.imgur.com/Yp3UbJy.png)

<br>
<br>
<hr>
<br>
<br>

## Paso 1: Crear un Dynamic Web Project

El proyecto tiene que empezar como un Dynamic Web Project, en el siguiente paso lo convertiremos a Maven.

Al crear el proyecto hay que tener en cuenta 2 cosas:

- El nombre del proyecto sera **Java-Primefaces**
- En la última pestaña de la configuración hay que marcar web.xml para que cree el archivo de forma automatica.

<br>
<br>
<hr>
<br>
<br>

## Paso 2: Convertiendo a Maven

```
(Project window) **Java-Primefaces** → Configure → Convert to Maven project.
```

Cambia la version a 0.0.1 y finalizar.

Para ver los cambios reflejados tenemeos que hacer un _Full publish_ al proyecto.

```
(Server window) **Java-Primefaces** → Full publish
```

Ahora la url para acceder a la web a cambiado a: `localhost:8080/Java-Primefaces-0.0.1/`

<br>
<br>
<hr>
<br>
<br>

## Paso 3: Installar dependencias

Necesitamos añadir las depencias que vamos a usar en el proyecto para que Maven las pueda descargar e installar, para ello vamos a añadirlas a **pom.xml** situado en el root del proyecto.

### Añadiendo depencias a pom.xml

Vamos a añadir las depencias de primefaces, omnifaces y slf4j (logs), para ello hay que poner las siguientes lineas encima del tag `<build>`.

```xml
<dependencies>
    <dependency>
        <groupId>javax</groupId>
        <artifactId>javaee-api</artifactId>
        <version>8.0</version>
        <scope>provided</scope>
    </dependency>
    <dependency>
        <groupId>org.slf4j</groupId>
        <artifactId>slf4j-api</artifactId>
        <version>1.7.36</version>
    </dependency>
    <dependency>
        <groupId>org.primefaces</groupId>
        <artifactId>primefaces</artifactId>
        <version>7.0</version>
    </dependency>
    <dependency>
        <groupId>org.omnifaces</groupId>
        <artifactId>omnifaces</artifactId>
        <version>3.12</version>
    </dependency>
</dependencies>
```

Esto debería instalar Primefaces para poder testear que todo esta funcionando.

pom.xml completo:

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>Java-Primefaces</groupId>
  <artifactId>Java-Primefaces</artifactId>
  <version>0.0.1</version>
  <packaging>war</packaging>
  <name>Java-Primefaces</name>
  <description>Java primefaces project</description>
    <dependencies>
    	<dependency>
            <groupId>javax</groupId>
            <artifactId>javaee-api</artifactId>
            <version>8.0</version>
            <scope>provided</scope>
        </dependency>
		<dependency>
		    <groupId>org.slf4j</groupId>
		    <artifactId>slf4j-api</artifactId>
		    <version>1.7.36</version>
		</dependency>
		<dependency>
			<groupId>org.primefaces</groupId>
			<artifactId>primefaces</artifactId>
			<version>7.0</version>
		</dependency>

		<dependency>
    		<groupId>org.omnifaces</groupId>
    		<artifactId>omnifaces</artifactId>
    		<version>3.12</version>
		</dependency>

  </dependencies>
  <build>
    <plugins>
      <plugin>
        <artifactId>maven-compiler-plugin</artifactId>
        <version>3.8.1</version>
        <configuration>
          <release>16</release>
        </configuration>
      </plugin>
      <plugin>
        <artifactId>maven-war-plugin</artifactId>
        <version>3.2.3</version>
      </plugin>
    </plugins>
  </build>
</project>
```

### Instalando dependencias

Vamos a instalar las depencias que hemos añadido al pom.xml, para ello:

```
(Project window) **Java-Primefaces** → Run As → Maven Clean
(Project window) **Java-Primefaces** → Run As → Maven Install
```

Con esto se instalarán y compilarán los paquetes que necesitamos.

Si tienes un fallo en la compilación revisa la versión de Java que usa el projecto y Eclipse.

<br>
<br>
<hr>
<br>
<br>

## Paso 4: Creando un JSF simple

Creamos un index.xhtml en la carpeta de webapp

(Si no te sale la opción de crear un xhtml puedes crear un archivo (file) y ponerle de nombre de index.xhtml)

Para comprobar que está funcionando vamos a crear un xhtml demo usando Primefaces

```xhtml
<!DOCTYPE html>
<html
  xmlns="http://www.w3.org/1999/xhtml"
  xmlns:h="http://xmlns.jcp.org/jsf/html"
  xmlns:f="http://xmlns.jcp.org/jsf/core"
  xmlns:jsf="http://xmlns.jcp.org/jsf"
  xmlns:ui="http://xmlns.jcp.org/jsf/facelets"
  xmlns:p="http://primefaces.org/ui"
>
  <f:view contentType="text/html;charset=UTF-8" encoding="UTF-8">
    <h:head> </h:head>
    <h:body>
      <p:textEditor />
    </h:body>
  </f:view>
</html>
```

Deberíamos ver un editor en `http://localhost:8080/Java-Primefaces-0.0.1/index.xhtml`

Nota: Si quiere hacer que se acceda directamente desde el root (/Java-Primefaces-0.0.1/) entonces debes añadir index.xhtml al Welcome del archivo web.xml que hemos creado en el paso 1.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://xmlns.jcp.org/xml/ns/javaee" xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd" id="WebApp_ID" version="4.0">
  <display-name>Java-Primefaces</display-name>
  <welcome-file-list>
    <welcome-file>index.html</welcome-file>
    <welcome-file>index.xhtml</welcome-file>
    <welcome-file>index.jsp</welcome-file>
    <welcome-file>index.htm</welcome-file>
    <welcome-file>default.html</welcome-file>
    <welcome-file>default.jsp</welcome-file>
    <welcome-file>default.htm</welcome-file>
  </welcome-file-list>
</web-app>
```

<br>

![img](https://i.imgur.com/Wrpz31d.png)
<br>
<br>

<hr>
<br>
<br>

## Paso 5: Creando un bean simple para usarlo en la JSF

Vamos a crear un package para juntar todos las clases llamado Tutorial.

```
(Project window) **Java-Primefaces** → new → create other → package
```

Dentro de Tutorial vamos a tener una carpeta **bean** y un **service**, vamos a tener esta estructura al final de este paso.

![img](https://i.imgur.com/kVjold7.png)

### Creando el bean

Para crear el bean vamos a crear una clase llamada MyBean por ejemplo que se accederá desde la JSF

```java
@Named("dtBasicView")
@ViewScoped
public class MyBean implements Serializable {

}
```

@Named es como se va a llamar a la case desde la JSF
@ViewScope es el tipo tiempo de vida

Vamos a añadir un par de atributos necesarios para mostrar la tabla y poder hacer un CRUD a la base de datos

```java
private List<Employee> employees;
private Employee emp;

@Inject
private EmployeeService service;
```

**employees** va a ser la lista donde guardemos los empleados almacenados en la BBDD.
**emp** va a ser la variable que modifiquemos en el input de la JSF.
**service** injectamos el servicio que vamos a usar para controlar el bean.

Nota: a efectos prácticos el @Inject lo que hace es construirnos el service con lo que necesitamos antes de que arranque la aplicación web.

Continuamos con los métodos que vamos a necesitar

```java
  @PostConstruct
  public void init() {
    employees = service.getEmployees();
    emp = new Employee();
  }

  public List<Employee> getEmployees(){
    return employees;
  }

  public void setService(EmployeeService service) {
      this.service = service;
  }

  public Employee getEmp() {
      return emp;
  }

  public void setEmp(Employee emp) {
      this.emp = emp;
  }

	public void addEmployee() {
		service.addEmployee(new Employee(emp));
	}
```

Resultado final:

```java
package Tutorial.bean;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ConversationScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import Tutorial.service.EmployeeService;

@Named("dtBasicView")
@ViewScoped
public class MyBean implements Serializable {

  private List<Employee> employees;
  private Employee emp;

  @Inject
  private EmployeeService service;

  @PostConstruct
  public void init() {
    employees = service.getEmployees();
    emp = new Employee();
  }

  public List<Employee> getEmployees(){
    return employees;
  }

  public void setService(EmployeeService service) {
      this.service = service;
  }

  public Employee getEmp() {
      return emp;
  }

  public void setEmp(Employee emp) {
      this.emp = emp;
  }

	public void addEmployee() {
		service.addEmployee(new Employee(emp));
	}
}
```

### Creando el service

Vamos a crear un services dummy para testear que todo funciona hasta ahora, para ello vamos a obviar la conexión a la base de datos y vamos a crear los empleados desde el service en vez de cogerlos de la base de datos

```java
package Tutorial.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import Tutorial.bean.Employee;

@Named
@ApplicationScoped
public class EmployeeService {
    private final static String[] firstName;
    private final static String[] lastName;
    private final static int INIT_EMPLOYEES = 10;
    private static List<Employee> employees;

    static {
    	firstName = new String[10];
    	firstName[0] = "Jose";
    	firstName[1] = "David";
    	firstName[2] = "Pepe";
    	firstName[3] = "Diego";
    	firstName[4] = "Ana";
    	firstName[5] = "Bea";
    	firstName[6] = "Susana";
      firstName[7] = "Gustavo";
      firstName[8] = "Juan";
      firstName[9] = "Elena";

      lastName = new String[10];
      lastName[0] = "Yannick";
      lastName[1] = "Uncio";
      lastName[2] = "Noah";
      lastName[3] = "Sevi";
      lastName[4] = "Marin";
      lastName[5] = "Albert";
      lastName[6] = "Garcia";
      lastName[7] = "Sanchez";
      lastName[8] = "Gomez";
      lastName[9] = "Illana";
    }
}
```

Vamos a usar un array de posibles nombres y apellidos para generar combinaciones de forma aleatoria

```java
public EmployeeService() {
  // create random list of employees
  employees = new ArrayList<Employee>();
    for (int i=0; i < INIT_EMPLOYEES ; i++){
        employees.add(new Employee(getRandomId(), getRandomFirstName(), getRandomLastName()));
    }
}

public List<Employee> getEmployees() {
  return employees;
}

private int getRandomId() {
    return (int) (Math.random() * 1000);
}

private String getRandomFirstName() {
    return firstName[(int) (Math.random() * 10)];
}

private String getRandomLastName() {
    return lastName[(int) (Math.random() * 10)];
}

public void addEmployee(Employee emp) {
  emp.setId(getRandomId());
  employees.add(emp);
}
```

Creamos el constructor rellenando la la lista de empleados, hacemos un par de funciones auxiliares ayudar a coger elementos aleatoriamente y creamos la funcion que añadirá empleados a la BBDD (a la lista local de empleados de momento).

### Creando el JavaBean

Por último necesitamos el JavaBean que va a almacenar la información del empleado.

Para los empleados solo vamos a necesitar su id, su nombre y apellidos.

```java
package Tutorial.bean;

public class Employee {
	private int id;
	private String firstName;
	private String lastName;
}
```

Para los metodos vamos a necesitar los constructores, los seters y los getters 

```java
public Employee() {
  id = -1;
  firstName = "";
  lastName = "";
}

public Employee(int id, String firstName, String lastName) {
  this.id = id;
  this.firstName = firstName;
  this.lastName = lastName;
}

public Employee(Employee e) {
  this.id = e.id;
  this.firstName = e.firstName;
  this.lastName = e.lastName;
}

public int getId() {
  return id;
}

public void setId(int id) {
  this.id = id;
}

public String getFirstName() {
  return firstName;
}

public void setFirstName(String firstName) {
  this.firstName = firstName;
}

public String getLastName() {
  return lastName;
}

public void setLastName(String lastName) {
  this.lastName = lastName;
}

public String toString() {
  return "[ " + id + " ]: " + firstName + ", " + lastName;
}
```

### Modificando la JSF

Ya tenemos todo el sistema montado pero falta mostrarselo al usuario, para ello vamos a modificar el index.xhtml con el siguiente código:

```xhtml
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://xmlns.jcp.org/jsf/html"
      xmlns:f="http://xmlns.jcp.org/jsf/core"
      xmlns:jsf="http://xmlns.jcp.org/jsf"
      xmlns:ui="http://xmlns.jcp.org/jsf/facelets"
      xmlns:p="http://primefaces.org/ui">

    <f:view contentType="text/html;charset=UTF-8" encoding="UTF-8">
        <h:head>

        </h:head>
        <h:body>
            <p:dataTable id="employee-table" var="employee" value="#{dtBasicView.employees}">
			    <p:column headerText="Id">
			        <h:outputText value="#{employee.id}" />
			    </p:column>
			 
			    <p:column headerText="FirstName">
			        <h:outputText value="#{employee.firstName}" />
			    </p:column>
			 
			    <p:column headerText="LastName">
			        <h:outputText value="#{employee.lastName}" />
			    </p:column>
			</p:dataTable>
			<br />
			<br />
			<br />
			<h:form>
			   <span class="ui-float-label">
			       <p:inputText id="float-input-firstName" value="#{dtBasicView.emp.firstName}" />
			       <p:outputLabel for="@previous" value="fistName" />
			   </span>
			   <span class="ui-float-label">
			       <p:inputText id="float-input-lastName" value="#{dtBasicView.emp.lastName}" />
			       <p:outputLabel for="@previous" value="lastName" />
			   </span>
			   <p:commandButton value="Run" icon="pi pi-star" action="#{dtBasicView.addEmployee()}" update=":employee-table"></p:commandButton>
		   </h:form>
        </h:body>
    </f:view>

</html>
```

Con esto debería ser suficiente para ver aparecer una tabla con los datos de los empleados y poder añadir más a traves del formulario