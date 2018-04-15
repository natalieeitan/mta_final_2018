<web-app>

    <servlet>
        <servlet-name>user</servlet-name>
        <servlet-class>UserServlet</servlet-class>
    </servlet>

    <servlet-mapping>
        <servlet-name>user</servlet-name>
        <url-pattern>/servlet/user</url-pattern>
    </servlet-mapping>

    <welcome-file-list>
        <welcome-file>register.html</welcome-file>
    </welcome-file-list>

</web-app>