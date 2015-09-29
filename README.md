# security-poc
POC of Spring Security usage with these features:
- based on Spring Boot 1.3 & Java 8
- authentication (different profiles) & authorization
- JSP + JSTL
- Apache Tiles (templating)
- (currently) no testing

POC contains several Spring profiles to demonstrate several different configuration options (see table bellow).

Profile name | Type | Note
------------- | ------------- | -------------
IN_MEMORY | **In-Memory** | Default profile
JDBC | JDBC  | via jdbcAuthentication method (maven dependencies for embbeded DB)
USER_DETAIL_SERVICE | JDBC  | via User Detail Service (maven dependencies for embbeded DB)
APACHE_DS | LDAP  | with Apache DS (maven dependencies for Apache DS)
ACTIVE_DIRECTORY | Authentication provider | with Active Directory

Profile usage:
> java spring-boot:run --spring.profiles.active=JDBC
